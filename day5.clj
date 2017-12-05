(def input-text (slurp "./day5.txt"))

(defn run-jumps [input]
  (loop [vec' (vec (map #(Integer/parseInt %) (clojure.string/split-lines input)))
         pos 0
         jumps 0]
    ; (println jumps vec' pos (nth vec' pos nil))
    (if (nil? (nth vec' pos nil))
      jumps
      (recur (update vec' pos inc)
             (+ pos (nth vec' pos))
             (inc jumps)))))

; (run-jumps "0
; 3
; 0
; 1
; -3")

; (0) 3  0  1  -3  - before we have taken any steps.
; (1) 3  0  1  -3  - jump with offset 0 (that is, don't jump at all). Fortunately, the instruction is then incremented to 1.
;  2 (3) 0  1  -3  - step forward because of the instruction we just modified. The first instruction is incremented again, now to 2.
;  2  4  0  1 (-3) - jump all the way to the end; leave a 4 behind.
;  2 (4) 0  1  -2  - go back to where we just were; increment -3 to -2.
;  2  5  0  1  -2  - jump 4 steps forward, escaping the maze.
; In this example, the exit is reached in 5 steps.

(println "Star-1" (run-jumps input-text))



(defn run-jumps-2 [input]
  (loop [vec' (vec (map #(Integer/parseInt %) (clojure.string/split-lines input)))
         pos 0
         jumps 0]
    ; (println jumps vec' pos (nth vec' pos nil))
    (if (nil? (nth vec' pos nil))
      jumps
      (let [offset (nth vec' pos)]
        (recur (if (<= 3 offset)
                (update vec' pos dec)
                (update vec' pos inc))
              (+ pos offset)
              (inc jumps))))))

; (run-jumps-2 "0
; 3
; 0
; 1
; -3")

(println "Star-2" (run-jumps-2 input-text))
