(ns looping-is-recursion)

(defn power [base exp]
  (let [p (fn [res n k]
            (if (<= k 0)
              res
              (recur (* res n) n (dec k))))]
    (p 1 base exp)))

(defn one-or-less? [coll]
  (or (empty? coll) (empty? (rest coll))))

(defn last-element [a-seq]
  (if (one-or-less? a-seq)
    (first a-seq)
    (recur (rest a-seq))))

(defn seq= [seq1 seq2]
  (cond
    (empty? seq1) (empty? seq2)
    (empty? seq2) (empty? seq1)
    (= (first seq1) (first seq2)) (recur (rest seq1) (rest seq2))
    :else false))

(defn find-first-index [pred a-seq]
  ":(")

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

