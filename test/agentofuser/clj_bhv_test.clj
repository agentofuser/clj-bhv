(ns agentofuser.clj-bhv-test
  (:require [clojure.test :refer :all]
            [agentofuser.clj-bhv :refer :all]))

(defn print-bhv-state [bhv-instance]
  (println "BHV Active bits:" (.active bhv-instance)))

(deftest bhv-xor-test
  (testing "XOR operations with BHV"
    (let [x (bhv-rand)
          y (bhv-rand)
          z (bhv-xor x y)]
      (println "Active bits of Z:" (bhv-active z))
      (is (= 0 (bhv-active (bhv-xor (bhv-xor x z) y)))
          "XORing x with z and then y should result in a BHV with 0 active bits."))))

(comment
  ;; To run the tests manually in the REPL
  (run-tests 'agentofuser.clj-bhv-test))
