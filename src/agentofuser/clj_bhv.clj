(ns agentofuser.clj-bhv
  (:import BHV))

(defn bhv-rand []
  (BHV/rand))

(defn bhv-active [bhv-instance]
  (.active bhv-instance))

(defn bhv-xor [bhv-instance1 bhv-instance2]
  (.xor bhv-instance1 bhv-instance2))
