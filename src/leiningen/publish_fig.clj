(ns leiningen.publish-fig
  (:require leiningen.jar clojure.java.io)
  (:use clojure.java.shell))

(defn publish-fig [project & args]
  (leiningen.jar/jar project)
  (when-not (.exists (clojure.java.io/file "package.fig"))
    (spit "package.fig" (str "resource \"" (:jar-name project) "\"\n\nconfig default\n"
                             "  append CLASSPATH=@/" (:jar-name project) "\n"
                             "  append SOURCEPATH=@/" (:jar-name project) "\n"
                             "end"))
    )
  (let [response (apply sh "fig" "--publish" (str (:name project) "/" (:version project)) args)]
    (println "OUT:" (:out response))
    (println "ERR:" (:err response))))


