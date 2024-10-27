# prime.exs

defmodule PrimeFinder do
  def is_prime(2), do: true
  def is_prime(n) when n<= 1, do: false
  def is_prime(n) do
    range = 2..trunc(:math.sqrt(n))
    Enum.all?(range, fn i-> rem(n,i) != 0 end)
  end

  def find_first_n_primes(n) do
    Stream.iterate(2,&(&1 + 1))     # Start an infinite sequence from 2 upwards
    |> Stream.filter(&is_prime/1)   # Filter to just primes
    |> Enum.take(n)                 # Take the first n primes
  end
end


IO.puts("Prime Number Finder in Elixir")
PrimeFinder.find_first_n_primes(1000)
|> Enum.each(&IO.puts(&1))
