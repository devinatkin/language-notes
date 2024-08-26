Module Module1

    Sub Main()
        Dim frequency As Integer = 37
        Do
            frequency += 100
            Console.Beep(frequency, 1)
            If frequency > 1100 Then
                Do
                    frequency -= 100
                    Console.Beep(frequency, 1)
                    If frequency < 100 Then
                        Exit Do

                    End If
                Loop
            End If
        Loop
    End Sub

End Module
