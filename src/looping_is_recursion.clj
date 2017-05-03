(ns looping-is-recursion)

(defn power [base exp]
  (loop [res 1
         n base
         k exp]
    (if (<= k 0)
      res
      (recur (* res n) n (dec k)))))

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
  (loop [i 0
         s a-seq]
    (cond
      (empty? s) nil
      (pred (first s)) i
      :else (recur (inc i) (rest s)))))

(defn avg [a-seq]
  (loop [sum 0
         count 0
         s a-seq]
    (if (empty? s)
      (if (= count 0)
        0
        (/ sum count))
      (recur (+ sum (first s)) (inc count) (rest s)))))

;; From structured-data
(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)))

(defn parity [a-seq]
  (loop [parities #{}
         s a-seq]
    (if (empty? s)
      parities
      (recur (toggle parities (first s)) (rest s)))))

(defn fast-fibo [n]
  (if (= n 0)
    0
    ;; Not quite sure why this works..
    (loop [f_n-1 1
           f_n-2 0
           n n]
      (if (<= n 2)
        (+ f_n-1 f_n-2)
        (recur (+ f_n-1 f_n-2) f_n-1 (dec n))))))

(defn cut-at-repetition [a-seq]
  (loop [seen #{}
         cut []
         a-seq a-seq]
    (if (or (empty? a-seq) (contains? seen (first a-seq)))
      cut
      (recur (conj seen (first a-seq)) (conj cut (first a-seq)) (rest a-seq)))))

