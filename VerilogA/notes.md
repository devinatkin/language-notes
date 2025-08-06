# Verilog A Notes
Verilog A is the analog version of the Verilog programming language. It exists to allow for quick simulations based on group features. For instance, if simulating an RC filter one can simulate an Resistor and a Capacitor. Or one can simulate an RC filter with specific passing parameters. Verilog A allows the freedom to essentially choose the important details and then verify your results further in the design process by ensuring that your models match the performance of the more complete spice models produced down the line.

## How to Run The Code

```
openvaf rc_filter.va
```
This compiles the Verilog A and outputs a osdi file which represents the compiled model. This can then be used in various simulators. (I'm using ngspice)

```
ngspice test_rc.spice
```

This runs the actual simulation. It comes after the Verilog A has been compiled to an osdi file. 