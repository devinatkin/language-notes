#!/usr/bin/perl

# Following the guidance of https://perlmonks.org/ to learn another little slice of perl programming

# Chomp removes input line seperators from a string, it returns the number of characters removed

use warnings;
print("Perl Notes on Language Handling\n\n");

print "first we'll look at the chomp command\n";

$a = "Language Notes Are Here";
$b = chomp($a);
print "$b characters were removed \n";
print $a;
print "\n\n";
# This will print the same thing twice as the newline gets removed
$a = "Language Notes are Here\n";
$b = chomp($a);
print "$b characters were removed \n";
print $a;

print "\n\n";

print "Then we want to look at chop command\n";

$a = "Language Notes Are Here";
$b = chop($a);

print "The last character of this is removed: $a\n";
print "That removed character is as expected: $b\n";
