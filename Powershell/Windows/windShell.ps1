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