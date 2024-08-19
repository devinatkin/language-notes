       IDENTIFICATION DIVISION.
       PROGRAM-ID. PRIME.

       ENVIRONMENT DIVISION.

       DATA DIVISION.
       WORKING-STORAGE SECTION.
       01 N PIC 9(5) VALUE 1.
       01 I PIC 9(5) VALUE 1.
       01 PRIME_COUNT PIC 9(5) VALUE 1.
       01 IS_PRIME PIC 9(5) VALUE 1.
       01 REMAINDER_VAL PIC 9(5).

       PROCEDURE DIVISION.

           DISPLAY "Find the First 100 Prime Numbers".

           PERFORM UNTIL PRIME_COUNT > 100
               PERFORM CHECK-PRIME
                   IF IS_PRIME = 1
                       DISPLAY N
                       ADD 1 TO PRIME_COUNT
                   END-IF
               ADD 1 TO N
           END-PERFORM

           STOP RUN.

       CHECK-PRIME SECTION.
           MOVE 1 TO IS_PRIME
           PERFORM VARYING I FROM 2 BY 1 UNTIL I > N / 2

               COMPUTE REMAINDER_VAL = FUNCTION MOD(N I)
               
               IF REMAINDER_VAL = 0
                   MOVE 0 TO IS_PRIME
                   EXIT SECTION
               END-IF

           END-PERFORM
           EXIT.
