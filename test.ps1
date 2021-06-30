Set-Location out\production\blackjack\

$tests = @('sam1.txt', 'sam2.txt', 'sam3.txt', 'sam4.txt', 'dealer1.txt', 'dealer2.txt', 'dealer3.txt', 'dealer4.txt')

for ($i = 0; $i -lt 8; $i++) {
    Write-Host "`n"$tests[$i] "results:"
    $path = ("C:\repos\blackjack\decks\" + $tests[$i])
    java Main $path
}

Set-Location ..\..\..