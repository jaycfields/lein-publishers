(ns leiningen.publish-fig
  (:require leiningen.jar)
  (:use clojure.java.shell))

(defn publish-fig [project & args]
  (leiningen.jar/jar project)
  (let [response (apply sh "fig" "--publish" (str (:name project) "/" (:version project)) args)]
    (println "OUT:" (:out response))
    (println "ERR:" (:err response))))


