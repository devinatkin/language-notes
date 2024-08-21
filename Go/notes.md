# Go Notes
```
go run .\Go\hello.go

```
Run the hello world. 

```
go build .\Go\hello.go
```

Build the hello world app.

The go.mod file allows for using multiple different go files and helps keep a project sorted. 

```
func is_prime(n int) bool {
	var i int = 2
	if n < 2 {
		return false
	}
	for i*i <= n {
		if n%i == 0 {
			return false
		}
		i++
	}
	return true
}
```

This chunk of example code shows how exactly to setup returns and variables.