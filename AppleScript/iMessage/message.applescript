set targetNumber to text returned of (display dialog "Enter phone number:" default answer "")

tell application "Messages"
	set targetService to first service whose service type = iMessage
	set targetBuddy to buddy targetNumber of targetService

	repeat
		set currentTime to time string of (current date)
		send ("Current time: " & currentTime) to targetBuddy
		delay 10
	end repeat
end tell
