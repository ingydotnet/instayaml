SHELL := bash

STEPS := $(wildcard step*)
RUN-STEPS := $(STEPS:%=run-%)
CLEAN-STEPS := $(STEPS:%=clean-%)


default:

run: $(RUN-STEPS)

clean: $(CLEAN-STEPS)


run-%: %
	$(call line,$<)
	-make --no-print-directory -C $< run
	@echo

clean-%: %
	make -C $< clean


define line
@printf '=== %s ' $1
@printf '%.0s=' {1..70}
@echo
@echo
endef
