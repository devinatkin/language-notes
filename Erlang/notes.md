# Erlang Notes
Start the shell with 
```
erl
```

Run the code with 
```
hello:hello_world().
```

```
-module(prime).
-export([prime/2]).

prime(N, PrimeCounter) -> 
    if
        PrimeCounter == 1000 ->
            io:fwrite("Found 1000 primes~n"),
            ok;
        true ->
            case is_prime(N,2) of
                true ->
                    io:fwrite("~p~n",[N]),
                    prime(N+1, PrimeCounter + 1);
                false ->
                    prime(N+1, PrimeCounter)
            end
    end.

is_prime(i,n) ->
    if
        (i*i) > n ->
            true;
        i rem n == 0 ->
            false;
        true ->
            is_prime(i,n+1)
    end.
```

Prime Number Finder revealed some of the difficult parts of the erlang language. 