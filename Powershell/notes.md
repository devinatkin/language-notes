# Powershell Notes

```
Write-Output "Test"
```

Powershell Notes for whipping up useful scripts.


```
Add-Type -AssemblyName System.Windows.Forms

$form = New-Object System.Windows.Forms.Form
$form.Text = "Powershell Window"
$form.Size = New-Object System.Drawing.Size(300,300)
$form.MaximizeBox = $false
$form.MinimizeBox = $false

$button = New-Object System.Windows.Forms.Button 
$button.Text = "Click Me"
$button.Location = New-Object System.Drawing.Point(5,10)

$button.Add_Click({
    [System.Windows.Forms.MessageBox]::Show("Window Creating Powershell Example")
})

$form.Controls.Add($button)

$form.ShowDialog()
```

Creating windows within powershell scripts is likely a great way to demostrate results when the code runs too fast to actually verify the results directly. I used to use a powershell script to handle burning DVDs. If I were writing it today I'd make a final pop up to say the state of the various burns.