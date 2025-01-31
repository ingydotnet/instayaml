step05
======

## Task

Convert `instayaml.clj` to YS (`instayaml.ys`).


## What

**NOTE**: This currently fails because of a problem in YS wrt Pods.
Working on a fix...


We can do this today with YS and pod-babashka-instaparse.

We really want to be able to use any Clojure module from [Clojars](
https://clojars.org/) or GitHub.

It seems like [instaparse](https://github.com/Engelberg/instaparse) isn't the
right candidate to drive this because of [limitations](
https://github.com/babashka/babashka?tab=readme-ov-file#differences-with-clojure).

