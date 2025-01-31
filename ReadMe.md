instayaml
=========

Convert [this Clojure](https://github.com/yaml/yamlscript/issues/216) to YS


## About

@amiika provided an example Clojure program showing off the usage of
[instaparse](https://github.com/Engelberg/instaparse) and writing parse ASTs
to YAML.

The idea was to add instaparse support to YS.

The best way to do this would be to have YS support using *any* Clojure
library.
This is something that YS is currently working on but it's not all there just
yet.

This example program is a great way to help us finish the work.

The result might look like:

```yaml
!yamlscript/v0

use instaparse::core: :mvn 'instaparse/instaparse@1.5.0'

grammar =: |
  Lambda = Params <'=>'> Expression
  Params = <'('> VarList <')'>
  <VarList> = Var (<','> Var)*
  Expression = Term (Op Term)*
  Term   = Var | Number | '(' Expression ')'
  Op     = '*' | '/' | '+' | '-' | '>' | '<' | '==' | '&&' | '||'
  <Var>  = #'[a-zA-Z_][a-zA-Z0-9_]*'
  Number = #'[0-9]+'

defn instayaml(grammar input): ...

main(file):
  say:
    instayaml grammar: file:read
```


## Getting There

This repo will have a series of steps in directories `step01`, `step02`, etc.

Each step will have a `ReadMe.md` to explain the step, and a `Makefile` that
supports `make run` to run the demo tasks for that step.


## Steps

* [step01](step01) - Run the original code with Clojure (`clj`)
* [step02](step02) - Run with Babashka (`bb`) (Fails due to limits of bb)
* [step03](step03) - Use with bb and the alternative instaparse-bb
* [step04](step04) - Use bb without the `bb.edn` file
* [step05](step05) - Convert `instayaml.bb` to `instayaml.ys` (Fails atm)


## Make

To run all the steps demos:
```
$ make run
```

To clean all the generated files:

```
$ make clean
```
