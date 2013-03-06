(defproject com.andrewmcveigh/lein-artifact "0.1.0-SNAPSHOT"
  :description "Leiningen plugin to build/install artifacts configured by
               project.clj.
               Useful when using lein-ring, libs and parent-sub projects."
  :url "https://github.com/andrewmcveigh/lein-artifact"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :eval-in-leiningen true
  :dependencies [[lein-ring "0.8.3"]])
