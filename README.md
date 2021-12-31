# CPU internals:

## Status
The cpu status has 2 parameters (1 bit)

- A: 1 if the cmp result is _equal_
- B: 1 if the cmp result is _greater than_

## Registers
a, b, c, d = 8 bit 0x01

Program counter = 16 bit

Stack pointer = 16 bit

## Instructions
- lda [value] : loads value in a register (0x01) (0x02)

- ldb [value] : loads value in b register (0x03) (0x04)

- ldc [value] : loads value in c register (0x05) (0x06)

- ldd [value] : loads value in d register (0x07) (0x08)

- jmp [value] : sets the program counter to the given value (0x09)

- cmp [a, b] : compares the two values and set the processor status (0x10) (0x11) (0x12) (0x13)

- jeq [value] : sets the program counter to the given value if the A cpu status is 1 (0x14)
- jne [value] : sets the program counter to the given value if the A cpu status is 0 (0x15)
- jgt [value] : sets the program counter to the given value if the B cpu status is 1 (0x16)
- jng [value] : sets the program counter to the given value if the B cpu status is 0 (0x17)

- mov [address, value] : insert the given value to the specified address (0x18) (0x19) (0x20) (0x21)

# Emulator:

## Memory
- 32K with 16 bit for accessing