# Perl Notes
```
perl hello.pl

```

Perl is not a compiled language, but is instead like python an interpretted language. Just run it with the perl interpretter. 
Perl is good for text processing problems. 

```
sub is_prime{
    my ($n) = @_;
    if ($n < 2){
        return 0;
    }

    my $counter = 2;
    while($counter * $counter <= $n){
        if ($n % $counter == 0){
            return 0;
        }
        $counter = $counter + 1;
    }
    return 1;
}
```
Perl is interesting as the function passing is handled in a very stack kind of way. it means that more complicated functions will rely on clear documentation to actually let the user know what is going on.