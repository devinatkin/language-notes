# F# Notes 

F# Code really wants to be executed from within the dotnet framework proper; however, I was able to get the hello world going using
```
    dotnet fsi .\Program.fs
```

```
let isPrime n : bool =
    let mutable i = 2
    if n < 2 then
        false
    else
        let mutable isPrime = true
        while (i*i) <= n && isPrime do
            if n%i = 0 then
                isPrime <- false
            else
                i <- i+1
        isPrime

```

F# is an interesting functional programming language. I can see why it's so strongly intended for mathmatical operations because the while setup of the language is so strongly setup for that type of operation. 