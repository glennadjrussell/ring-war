(ns ring-war.core-test
  (:require [clojure.test :refer :all]
            [ring-war.core :refer :all]
            [ring.adapter.jetty :as jetty]))

(deftest test-war
  (testing "Ensuring a webapp gets created with a handler"
    (let [webapp (handle-war "/Users/glenn_adj_russell/repos/glennadjrussell/ring-war/resources/birt.war")]
      (is (not (nil? webapp))))))

(deftest test-deploy
  (testing "Ensuring a webapp gets deployed"
    (let [webapp (handle-war "/Users/glenn_adj_russell/repos/glennadjrussell/ring-war/resources/birt.war")]
      (is (not (nil? webapp))
      (jetty/run-jetty webapp {:port 3030 :configurator server-config})))))
