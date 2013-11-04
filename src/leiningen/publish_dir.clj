(ns leiningen.publish-dir
  (:require clojure.java.io)
  (:use clojure.java.shell))

(defn publish-dir
  [{:keys [name src-root lib-dir] :or {src-root "../" lib-dir "/lib/jars/"}} & args]
  (println "cp" (str "target/" name ".jar") (str src-root (first args) lib-dir))
  (let [response (sh "cp" (str "target/" name ".jar") (str src-root (first args) lib-dir))]
    (println "OUT:" (:out response))
    (println "ERR:" (:err response))))
