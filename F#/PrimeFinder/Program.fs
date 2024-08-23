// For more information see https://aka.ms/fsharp-console-apps
printfn "Finding the first 1000 Prime Numbers"

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

let mutable prime_count = 0
let mutable i = 0

while prime_count < 1000 do
    if isPrime i then
        prime_count <- prime_count + 1
        printfn "%d" i
    i <- i + 1