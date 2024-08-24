-module(prime).
-export([find_primes/0]).

% Entry function to start finding primes
prime(N, PrimeCounter) when is_integer(N), is_integer(PrimeCounter) -> 
    if
        PrimeCounter == 1000 ->
            io:fwrite("Found 1000 primes~n"),
            ok;
        true ->
            case is_prime(N, 2) of
                true ->
                    io:fwrite("~p~n", [N]),
                    prime(N + 1, PrimeCounter + 1);
                false ->
                    prime(N + 1, PrimeCounter)
            end
    end.

% Function to check if a number N is prime
is_prime(N, I) when is_integer(N), is_integer(I), N > 1 ->
    if
        I * I > N ->
            true;
        N rem I == 0 ->
            false;
        true ->
            is_prime(N, I + 1)
    end.

find_primes() -> prime(2,0).