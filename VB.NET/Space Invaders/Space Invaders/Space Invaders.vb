Public Class frmSpaceInvaders
    Private paddlevolocity As Integer = 20
    Private activerocket As Boolean = False
    Private rocketfired As Boolean = False
    Private bulletvolocity As Integer = 20
    Private numcolumns As Integer = 5
    Private numrows As Integer = 6
    Private AlienDirection As Integer = 4
    Private AlienDirectionSwitch As Boolean = False
    Private ShootProb As Double = 0.001
    Declare Function GetAsyncKeyState Lib "user32" Alias "GetAsyncKeyState" (ByVal vkey As Long) As Integer
    Private SuperShootProb As Double = 0.01
    Private score As Integer = 0
    Private RocketImage As System.Drawing.Bitmap = My.Resources.Rocket
    Private FireImage As System.Drawing.Bitmap = My.Resources.Flame
    Private AlienImage As System.Drawing.Bitmap = My.Resources.Alien
    Private ExplodeImage As System.Drawing.Bitmap = My.Resources.Explosion
    Private PaddleImage As System.Drawing.Bitmap = My.Resources.Paddle

 
    Private Sub Transparency()
        ExplodeImage.MakeTransparent(Color.White)
        RocketImage.MakeTransparent(Color.White)
        FireImage.MakeTransparent(Color.White)
        AlienImage.MakeTransparent(Color.White)
        PaddleImage.MakeTransparent(Color.White)
        picturePaddle.Image = PaddleImage
    End Sub
    Private Sub frmSpaceInvaders_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Me.Show()
        MakeAliens()
        Transparency()
        Dim SoundEffects As New System.Threading.Thread(AddressOf Module1.Main)
        SoundEffects.Start()
        Do

            System.Threading.Thread.Sleep(10)
            PaddleMove()
            MakeRocket()
            MoveRocket()
            EndingCode()
            DissipateExplosion()
            MoveAliens()
            AliensCommandShoot()
            AlienFireMove()
            WinnerCheck()
            ScreenWrapping()
        Loop
    End Sub
    Private Function KeyIsPressed(ByVal key As Keys) As Boolean
        Dim keycode As Integer = CType(key, Long)
        Return (IIf(GetAsyncKeyState(keycode) <> 0, True, False))
    End Function
    Private Sub PaddleMove()
        'Paddle Left
        Application.DoEvents()
        If KeyIsPressed(Keys.Left) = True Then
            picturePaddle.Left -= paddlevolocity
        End If
        'Paddle Right
        If KeyIsPressed(Keys.Right) = True Then
            picturePaddle.Left += paddlevolocity
        End If
    End Sub
    Private Sub MakeRocket()
        'Make Rocket
        If KeyIsPressed(Keys.Space) = True Then


            If rocketfired = False Then
                rocketfired = True
                Dim rocket As New PictureBox
                Dim centerpaddle As Drawing.Point
                centerpaddle.Y = picturePaddle.Location.Y
                centerpaddle.X = picturePaddle.Location.X + 43.5
                rocket.Image = RocketImage
                rocket.SizeMode = PictureBoxSizeMode.StretchImage
                rocket.Visible = True

                Dim rocketsize As System.Drawing.Size
                rocketsize.Width = 10
                rocketsize.Height = 20
                rocket.Size = (rocketsize)
                rocket.BringToFront()
                rocket.Location = centerpaddle
                rocket.Tag = "ROCKET,,"
                Controls.Add(rocket)
                activerocket = True
            End If
        End If
    End Sub
    Private Sub MoveRocket()
        'Rocket Move
        For Each rocket As PictureBox In Me.Controls
            If CStr(rocket.Tag) = "ROCKET,," Then
                Application.DoEvents()
                rocket.Top -= bulletvolocity
                rocket.BringToFront()
                rocket.BringToFront()
                If rocket.Top <= -rocket.Height Then
                    Controls.Remove(rocket)
                    score -= 50
                    Me.Text = "Space Invaders, Score:" & score
                    rocketfired = False
                End If
                For Each alien As PictureBox In Me.Controls
                    If alien.Tag = "Alien,," Then
                        If rocket.Top <= alien.Bottom Then
                            If rocket.Top >= alien.Top Then
                                If rocket.Left >= alien.Left Then
                                    If rocket.Right <= alien.Right Then
                                        Controls.Remove(rocket)
                                        alien.Image = ExplodeImage
                                        alien.Height *= 2
                                        alien.Width *= 2
                                        rocketfired = False
                                        score += 100
                                        Me.Text = "Space Invaders, Score:" & score
                                        alien.Tag = "Alien,Exploshion,20"

                                    End If
                                End If
                            End If
                        End If
                    End If
                Next
            End If
        Next
    End Sub
    Private Sub ScreenWrapping()
        'Screen Wrapping Left
        If picturePaddle.Left >= Me.Right Then
            picturePaddle.Left = Me.Left - picturePaddle.Width
        End If
        'Screen Wrapping Right
        If picturePaddle.Left <= Me.Left - (2 * picturePaddle.Width) Then
            picturePaddle.Left = Me.Right - picturePaddle.Width
        End If
    End Sub
    Private Sub DissipateExplosion()
        ' Remove an exploshion
        For Each explosion As PictureBox In Me.Controls
            Dim sections() As String
            Dim TagReader As New System.IO.StringReader(explosion.Tag)
            Dim WholeTag As String
            WholeTag = explosion.Tag
            sections = WholeTag.Split(",")
            If sections(2) <> "" Then
                Dim ExplodeDisipate As Integer = Val(sections(2))
                If sections(1) = "Exploshion" Then
                    ExplodeDisipate -= 1

                    If ExplodeDisipate = 0 Then
                        Controls.Remove(explosion)
                    Else
                        explosion.Tag = sections(0) & ",Exploshion," & ExplodeDisipate
                    End If
                End If
            End If



        Next
    End Sub
    Private Sub EndingCode()
        'Makes stuff end
        If Me.Visible = False Then End
    End Sub
    Private Sub MakeAliens()
        'Make Aliens
        Dim CounterTwo As Integer
        Dim CounterOne As Integer
        For CounterOne = 1 To numrows
            For CounterTwo = 1 To numcolumns

                Dim aliens As New PictureBox
                aliens.Image = AlienImage
                aliens.Width = 50
                aliens.Height = 20
                aliens.Name = "picAlien"
                aliens.Tag = "Alien,,"
                Dim Column As Integer = (CounterTwo * Me.Height / (numcolumns + 1)) - 100
                Dim Row As Integer = 1 + (CounterOne * 100)
                aliens.Top = Column
                aliens.Left = Row
                aliens.Visible = True

                aliens.SizeMode = PictureBoxSizeMode.StretchImage
                Me.Controls.Add(aliens)
            Next
        Next
    End Sub
    Private Sub MoveAliens()
        ' Makes the Aliens Move
        For Each Alien As PictureBox In Me.Controls
            If Alien.Tag = "Alien,," Then
                Alien.BringToFront()
                Alien.Left += AlienDirection
                If Alien.Left <= 0 Then
                    AlienDirectionSwitch = True
                End If
                If Alien.Left + (2 * Alien.Width) >= Me.Right Then
                    AlienDirectionSwitch = True
                End If
            End If

        Next
        If AlienDirectionSwitch = True Then
            AlienDirectionSwitch = False
            For Each Picture As PictureBox In Me.Controls
                If Picture.Tag = "Alien,," Then
                    Picture.Top += 5
                End If
            Next
            AlienDirection = -AlienDirection
        End If

    End Sub
    Private Sub AliensCommandShoot()
        'Command the Aliens fire
        For Each Alien As PictureBox In Me.Controls
            If Alien.Tag = "Alien,," Then
                Dim Command As Boolean = False
                Dim num As Integer
                num = Rnd()
                If Rnd() < ShootProb Then
                    If AlienFire(Alien) = True Then

                    End If
                End If
            End If
        Next

    End Sub
    Private Function AlienFire(ByVal Alien As PictureBox) As Boolean
        'Make The Alien's Fire
        Dim fire As New PictureBox
        fire.Image = FireImage
        fire.SizeMode = PictureBoxSizeMode.StretchImage
        fire.Width = 10
        fire.Height = 20
        fire.BringToFront()
        fire.Visible = True
        fire.Left = Alien.Left + Alien.Width / 2
        fire.Top = Alien.Top
        fire.Tag = "AlienFire,,"
        fire.Name = "PicAlienFire"
        Me.Controls.Add(fire)

        Return True
    End Function
    Private Sub AlienFireMove()
        For Each fire As PictureBox In Me.Controls
            If fire.Tag = "AlienFire,," Then
                If fire.Top >= Me.Bottom Then
                    Me.Controls.Remove(fire)
                End If
                fire.Top += 10
                fire.BringToFront()
                If fire.Bottom >= picturePaddle.Top Then
                    If fire.Left >= picturePaddle.Left Then
                        If fire.Right <= picturePaddle.Right Then
                            If fire.Top <= picturePaddle.Bottom Then
                                picturePaddle.Image = ExplodeImage

                                picturePaddle.Tag = "Paddle,Exploshion,20"
                                picturePaddle.Name = "PaddleExploded"
                                If MsgBox("YOU LOSE", MsgBoxStyle.OkOnly, "LOSER") = MsgBoxResult.Ok Then
                                    End
                                
                                End If

                            End If
                        End If
                    End If
                End If
            End If

        Next
    End Sub
    Private Sub WinnerCheck()
        For Each item As PictureBox In Me.Controls
            If item.Tag = "Alien,," Then
                Exit Sub
            End If
        Next

        If MsgBox("YOU WIN WITH " & score & " POINTS", MsgBoxStyle.OkOnly, "Winner") = MsgBoxResult.Ok Then
            ShootProb *= 1.5
            MakeAliens()
        End If
    End Sub
  
End Class
