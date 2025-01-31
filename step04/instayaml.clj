(require '[babashka.pods :as pods])
(pods/load-pod 'org.babashka/instaparse "0.0.4")

(ns noob.instayaml
  (:require [pod.babashka.instaparse :as insta]
            [clj-yaml.core :as yaml]
            [clojure.walk :as walk]
            [clojure.pprint :as pp]
            [clojure.java.io :as io]))

(defn vector-to-map [data]
  (walk/postwalk
   (fn [x]
     (if (and (vector? x) (keyword? (first x)))
       {(first x) (if (= 2 (count x)) (second x) (vec (rest x)))}
       x))
   data))

(defn vector-to-yaml-string [parsed-result]
  (yaml/generate-string (vector-to-map parsed-result) :dumper-options {:flow-style :block}))

(defn instayaml [expr input]
  (let [parsed (insta/parse (insta/parser expr) input)]
    (vector-to-yaml-string parsed)))

(defn instayaml-to-file [expr input filename]
  (with-open [writer (io/writer filename)]
    (.write writer (instayaml expr input))))

(print (instayaml
    "Lambda  = Params <'=>'> Expression
    Params   = <'('> VarList <')'>
    <VarList>  = Var (<','> Var)*
    Expression = Term (Op Term)*
    Term    = Var | Number | '(' Expression ')'
    Op       = '*' | '/' | '+' | '-' | '>' | '<' | '==' | '&&' | '||'
    <Var>      = #'[a-zA-Z_][a-zA-Z0-9_]*'
    Number   = #'[0-9]+'"

    "(foo,bar,zyx)=>foo+bar>zyx"))


(instayaml-to-file "S = VAL | EXPR | PAR
                   PAR = <'('> S <')'>
                   <EXPR> = S OP S
                   <VAL> = #'[0-9]+'
                   OP = '+' | '-' | '*' | '/'"

                   "1+(5/3)*2"

                   "output.yaml")
