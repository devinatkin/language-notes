print("Finding the first 1000 prime numbers")

function isPrime(n)
    if n < 2 then
        return false
    end
    
    local i = 2
    
    while i * i <= n do
        if n % i == 0 then
            return false
        end
        i = i + 1
    end

    return true
end

local prime_count = 0
local i = 1
while prime_count < 1000 do
    if isPrime(i) then
        prime_count = prime_count + 1
        print(i)
    end
    i = i + 1
end