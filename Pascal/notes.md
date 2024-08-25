# Pascal Notes
The basic program structure is:

```
program Hello;
begin
    writeln('Hello World from Pascal');
end.
```

Pascal functions,
```
function IsPrime(n: integer): boolean;
var
    i: integer;
begin
    i:= 2;
    if n < 2 then
    begin
        IsPrime:= false;
        exit;
    end;

    while (i*i) <= n do
    begin
        if (n mod i) = 0 then
        begin
            IsPrime:= false;
            exit;
        end;
        i:= i + 1;
    end;
    IsPrime:= true;
end;

```

Pascal syntax wraps things in begin and end instead of {} like in languages like C. 
## Delphi Notes
- Delphi is an extension of Pascal. It adds: Rapid Application Development (RAD), Object-Oriented Programming (OOP), Component-Based Development, Cross-Platform Development, and Database Connectivity to raw Pascal programming while maintaining backwards compatibility with Object Pascal. 

- RAD is a graphical UI design system which has cross compatibility between windows, mac, android, and ios. 

- There is a Delphi IDE available [https://www.embarcadero.com/products/delphi/starter/free-download](https://www.embarcadero.com/products/delphi/starter/free-download)