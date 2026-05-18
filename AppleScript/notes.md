# AppleScript Notes
https://developer.apple.com/library/archive/documentation/AppleScript/Conceptual/AppleScriptLangGuide/introduction/ASLR_intro.html

Apple Script is essentially a specialized scripting language for controlling applications on Apple Machines. 

To run apple script from the command line use osascript as shown. 
```
osascript main.applescript
```

To Display a Dialog box display dialog "Hello world from Apple Script!". This pops up a dialog box with Ok and Cancel options.

## Applescript Commands

```
set targetNumber to text returned of (display dialog "Enter phone number:" default answer "")
```
Taking an input value from the user.

```
tell application "Messages"

end tell
```
Tell is to interact with a specific application. The elements within the tell segment will interact with the Messages app in this case. 

