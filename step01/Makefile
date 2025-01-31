SHELL := bash

default:

run:
	clj -M instayaml.clj
	@echo
	cat output.yaml

clean:
	$(RM) output.yaml
	$(RM) -r .cpcache
