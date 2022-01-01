:loop
lda 0F
ldb a
mov a 0F
cmp 2F 0F
jeq :loop
jne :end
:end
ldc 0E