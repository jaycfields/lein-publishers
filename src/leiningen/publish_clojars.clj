(ns leiningen.publish-clojars
  (:require leiningen.jar)
  (:use clojure.java.shell))

(defn publish-clojars [project & args]
  (leiningen.clean/clean project)
  (leiningen.jar/jar project)
  (leiningen.pom/pom project)
  (let [response (sh "scp" "pom.xml" (str (:jar-name project)) "clojars@clojars.org:")]
    (println "OUT:" (:out response))
    (println "ERR:" (:err response))))
