(ns ring-war.core
  (:import [org.eclipse.jetty.server.handler 
            AbstractHandler
            HandlerCollection]
           [org.eclipse.jetty.webapp WebAppContext]))

(defn handle-war [war]
  "Creates a handler for a WAR file, creating a web application context for an archived web application"
  {:pre (not (nil? war))}
  (let [webapp (WebAppContext.)]
    (.setContextPath webapp "/")
    (.setWar webapp war) webapp))

(defn server-config [server]
  (.setHandler server (handle-war "/Users/glenn_adj_russell/repos/glennadjrussell/ring-war/resources/birt.war"))
  (println "Server config called"))

(defn handler-collection [& handlers]
  {:pre (seq?)}
  (let [col (HandlerCollection.)]
    (.setHandlers col handlers)
    col))

