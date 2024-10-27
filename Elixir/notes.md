# Elixir Notes

## Install 

```
sudo apt install elixir
```

## Run As Script

```
elxir hello.exs
```

# Functions

Functions must be defined within modules 

```
defmodule MathOperations do
  def add(a, b) do
    a + b
  end
end
```
This would mean that the function can be accessed at MathOperations.add(3,5) returning 8.

```
defmodule Greeter do
  def greet("morning"), do: "Good morning!"
  def greet("evening"), do: "Good evening!"
  def greet(_time), do: "Hello!"
end
```
Functions can also be overloaded with different input patterns meaning that for things like the prime number finder the prime function can be defined as the different states of 1, 2, and then other number checks. 

Functions defined with defp will be private to within a given module. Anonymous functions are small and don't need to be in a module. They are used for very short operations. 

Elixir Prefers recursion over looping. Tail Recursion should be used to implement loop like structures for the case of memory efficiency and avoiding stack overflow issues that might otherwise occur with very large layers of recursive functions.