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