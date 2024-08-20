# Lua Notes

```
lua hello.lua
```
Run Lua Scripts with the lua command (Easy install on Ubuntu)

```
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
```

Lua functions are defined like this with the inputs at the top. Honestly it's a simple clean syntax and I can't help but feel I should do more with this particular language.