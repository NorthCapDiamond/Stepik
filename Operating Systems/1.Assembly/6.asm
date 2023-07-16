min:
    mov %rdi, %rax
    cmp %rdi, %rsi
    jge .rsi_is_greater
    mov %rsi, %rax
.rsi_is_greater:
    ret