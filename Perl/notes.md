# Perl Notes
```
perl hello.pl

```

Perl is not a compiled language, but is instead like python an interpretted language. Just run it with the perl interpretter. 
Perl is good for text processing problems in general.
It is substantially less popular than python; however, it has a large legacy codebase making it worthy of learning. 

My current learning resource is https://perlmonks.org/

I asked chatGPT to give me a Perl vs. Python Table 

| Feature                    | Perl                                 | Python                              |
|----------------------------|--------------------------------------|-------------------------------------|
| **Release Year**           | 1987                                | 1991                               |
| **Philosophy**             | "There's more than one way to do it"| "There should be one—and preferably only one—obvious way to do it" |
| **Syntax Style**           | Compact and flexible, often uses symbols (e.g., `$`, `@`, `%`) | Clean, readable, and indentation-based |
| **Primary Use Cases**      | Text processing, system scripting, web development | General-purpose programming, web development, data analysis, AI |
| **Regular Expressions**    | Built-in and highly powerful        | Built-in module (`re`), less concise than Perl |
| **Object-Oriented Support**| Available but not as intuitive      | Strong and easy-to-use             |
| **Community Size**         | Smaller but established             | Large and actively growing         |
| **Learning Curve**         | Steeper due to syntax complexity    | Relatively easier for beginners    |
| **Performance**            | Fast for text manipulation          | Generally slower, but highly optimized libraries available |
| **Library Ecosystem**      | CPAN: Comprehensive Perl Archive Network | PyPI: Python Package Index, extensive and versatile |
| **Popularity**             | Declining but still used in legacy systems | Increasingly popular across many domains |
| **Integration with Other Tools** | Strong, particularly in Unix environments | Strong, supported by many modern tools |
| **Community Standards**    | Less standardized, encourages flexibility | Strong coding standards (PEP 8)    |
| **Dynamic Typing**         | Yes                                 | Yes                                |
| **Multi-Paradigm Support** | Procedural, functional, object-oriented | Procedural, functional, object-oriented |
| **Documentation**          | Comprehensive but less beginner-friendly | Comprehensive and beginner-friendly |
| **Notable Weaknesses**     | Hard-to-read code, especially for large projects | Performance can be a bottleneck in CPU-bound tasks |
| **Future Outlook**         | Stable but less active development  | Thriving with frequent updates and innovations |


## Function Syntax

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
Perl is interesting as the function passing is handled in a very stack kind of way. 
It means that more complicated functions will rely on clear documentation to actually let the user know what is going on.

## Chop and Chomp

Two Perl Built in functions for string manipulation. 
Chop --> Removes Characters at the end of a string which correspond to line seperator characters. Returns how many characters it removed.
Chomp --> Removes Characters at the end of strings regardless and returns what the character was.