SHELL := bash

export PATH := $(shell pwd):$(PATH)

default:

run:
	instayaml grammar1.ip \
	  <<<'(foo,bar,zyx)=>foo+bar>zyx'
	instayaml grammar2.ip \
	  output.yaml \
	  <<<'1+(5/3)*2'
	cat output.yaml

clean:
	$(RM) output.yaml
