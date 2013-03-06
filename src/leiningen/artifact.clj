(ns leiningen.artifact
  (:use 
    [leiningen.jar :only (jar)]
    [leiningen.ring.war :only (war)]
    [leiningen.ring.uberwar :only (uberwar)]))

(defn artifact
  "I don't do a lot."
  [project & args]
  (if-let [artifact (-> project :ring :artifact)]
    (let [project (update-in project
                             [:ring :web-xml]
                             (partial str (:name project) \/))]
      (case artifact
        :war (apply war project args)
        :uberwar (apply uberwar project args)
        (println "Ring artifact type not found in :ring map
                 E.G., :ring {:artifact :war}")))
    (apply install project args)))
