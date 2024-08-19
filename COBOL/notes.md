# COBOL Notes
```
cobc -x -o hello hello.cob
./hello
```
COBOL forces its code to be aligned according to specfic rules.
- Columns 1-6: Sequence numbers (optional)
- Column 7: Indicator area (used for comments, continuation, etc.)
- Columns 8-11: Area A (division headers, section headers, etc.)
- Columns 12-72: Area B (statements, etc.)

COBOL is really picky about the formatting. 

Functions are defined as additional sections called paragraphs. 
```
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
```

EXIT leaves the function early. 
Variables are treated essentially like registers. 