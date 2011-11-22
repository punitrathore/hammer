(ns hammer.core
  (:require [clojure.string :as str]))

(defn convert-split-string [split-string]
  (map
   #(if (even? (first %)) (str "(str " "\""(second %)""\"\ ")" ) (second %))
   (map vector (iterate inc 0) split-string)))

(defn split-template-into-array [template]
  (str/split template #"%%"))

(defn read-template [path]
  (slurp path))

(defn eval-template [template]
  (let [split-template (split-template-into-array template)]
    (str/join (map #(if (odd? %1)
                      (eval (read-string %2))
                      %2)
                   (range 0 (count split-template)) split-template))))

(defn convert-hammer-template-to-html [path]
  (let [template (read-template path)]
    (eval-template template)))
