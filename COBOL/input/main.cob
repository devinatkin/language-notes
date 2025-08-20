       identification division.
       program-id . MAIN.
       environment division.
       data division.
       working-storage section.
           01 first-number pic s9(9) comp-5.
           01 second-number pic s9(9) comp-5.
           01 result pic s9(9) comp-5.
       procedure division.
           display "Enter a first number:"
           accept first-number.
           display "Enter a second number:"
           accept second-number.
           add first-number to second-number giving result.
           display "The sum is: " result.
           stop run.
