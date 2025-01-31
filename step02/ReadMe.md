step02
======

## Task

Run the example code in https://github.com/yaml/yamlscript/issues/216 using
[Babashka](https://github.com/babashka/babashka)'s `bb`.

YS is built using the same technology as `bb`.

For the most part, whatever `bb` can do, `ys` should be able to do.


## What

Renamed `deps.edn` to `bb.edn`.

Running this results in an error because instaparse uses deftype and deftype
is one of the very few Clojure things that bb doesn't support.
