#!/usr/bin/perl
use strict;
use warnings;

use Path::Tiny;

# Take user input for the directory path 
print "Enter directory path: ";
chomp(my $input_dir = <STDIN>);

# Validate and sanitize the input
my $dir = path($input_dir);

# Create an iterator for the directory
my $iter = $dir->iterator;

# Go through everything in the directory and print the filenames
while (my $file = $iter->()) {
    next if $file->is_dir();

    print "Found file: $file\n";

}