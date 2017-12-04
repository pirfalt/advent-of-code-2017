(def input (slurp "./day4.txt"))

(defn star-1 [input]
 (->> (clojure.string/split-lines input)
   (map (fn [line] (apply distinct? (clojure.string/split line #" "))))
   (filter true?)
   (count)))

(defn star-2 [input]
 (->> (clojure.string/split-lines input)
  (map (fn [line]
        (->> (clojure.string/split line #" ")
         (map sort)
         (apply distinct?))))
  (filter true?)
  (count)))

(println "star-1" (star-1 input))
(println "star-2" (star-2 input))
