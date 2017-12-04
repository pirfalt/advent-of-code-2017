(require '[clojure.string :as s])

(def input (slurp "./day2.txt"))

(defn create-row [line] (map #(Integer/parseInt %) (s/split line #"\t")))

(defn row-difference [row]
  (let [max (apply max row)
        min (apply min row)
        difference (- max min)]
    difference))

(println "Star 1:"
   (->>
    (s/split-lines input)
    (map (comp row-difference create-row))
    (apply +)))



(defn row-div-when [row]
  (remove nil?
    (for [x row
          y row
          :when (not= x y)]
     (if (= 0 (mod x y))
        (/ x y)
        nil))))

(println "Star 2:"
  (->>
    (s/split-lines input)
    (map create-row)
    (mapcat row-div-when)
    (apply +)))
