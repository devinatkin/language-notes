<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmSpaceInvaders
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.picturePaddle = New System.Windows.Forms.PictureBox
        CType(Me.picturePaddle, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'picturePaddle
        '
        Me.picturePaddle.Anchor = System.Windows.Forms.AnchorStyles.Bottom
        Me.picturePaddle.BackColor = System.Drawing.Color.Transparent
        Me.picturePaddle.Image = Global.Space_Invaders.My.Resources.Resources.Paddle
        Me.picturePaddle.Location = New System.Drawing.Point(209, 242)
        Me.picturePaddle.Name = "picturePaddle"
        Me.picturePaddle.Size = New System.Drawing.Size(73, 24)
        Me.picturePaddle.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.picturePaddle.TabIndex = 0
        Me.picturePaddle.TabStop = False
        Me.picturePaddle.Tag = "paddle,,"
        '
        'frmSpaceInvaders
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.Black
        Me.ClientSize = New System.Drawing.Size(641, 266)
        Me.Controls.Add(Me.picturePaddle)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow
        Me.MaximizeBox = False
        Me.Name = "frmSpaceInvaders"
        Me.Tag = ""
        Me.Text = "Space Invaders, Score:000"
        Me.WindowState = System.Windows.Forms.FormWindowState.Maximized
        CType(Me.picturePaddle, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents picturePaddle As System.Windows.Forms.PictureBox

End Class
