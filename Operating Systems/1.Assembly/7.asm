pow:
	cmp $1, %rdi
	jz .x_is_one
	cmp $1, %rsi
	jz .n_is_one
	cmp $0, %rsi
	jz .n_is_zero
	cmp $0, %rdi
	jz .x_is_zero


	mov %rsi, %rax
	mov $2, %r8
	xor %rdx, %rdx
	div %r8
	cmp $0, %rdx
	jz .n_is_even
	jnz .n_is_odd
    ret


.x_is_one:
	mov $1, %rax
ret

.n_is_one:
	mov %rdi, %rax
ret

.n_is_zero:
	mov $1, %rax
ret

.x_is_zero:
	xor %rax, %rax
ret


.n_is_even:
	mov %rsi, %rax
	mov $2, %r8
	xor %rdx, %rdx
	div %r8
	mov %rax, %rcx
	mov $1, %rax
	push %rax
	jmp .loop1
ret


.n_is_odd:
	sub $1, %rsi
    mov %rsi, %rax
	mov $2, %r8
	xor %rdx, %rdx
	div %r8
	mov %rax, %rcx
	push %rdi
	mov $1, %rax
	jmp .loop1
ret


.loop1:
	xor %rdx, %rdx
	mul %rdi
	dec %rcx
	jnz .loop1
	xor %rdx, %rdx
	mul %rax
	pop %r8
	xor %rdx, %rdx
	mul %r8
ret