program main;

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

var
    prime_count: integer;
    i: integer;
begin
    prime_count:= 0;
    i:= 1;
    writeln('Finding the first 1000 Prime Numbers!');

    while prime_count < 1000 do 
    begin
        if IsPrime(i) then
        begin
            writeln(i);
            prime_count := prime_count + 1;
        end;
    i := i + 1;
    end;
end.