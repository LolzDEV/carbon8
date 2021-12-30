package com.carbon8.cpu;

public class Cpu {
    public static final int MEMORY_SIZE = Short.MAX_VALUE;

    short PC = 0x0000;
    public byte[] registers = new byte[4];
    byte[] memory = new byte[MEMORY_SIZE];
    short SP = 0x0000;

    public void loadInMemory(Program program) {
        for (int i=0; i < program.data.size(); i++) {
            this.memory[i] = program.data.get(i);
        }
    }

    public void run() {
        while (PC != MEMORY_SIZE) {
            byte value = getOpcode();
            this.execute(value);
        }
    }

    public byte getOpcode() {
        return this.memory[PC];
    }

    public void execute(byte opcode) {
        switch (opcode) {
            case 0x01 -> {
                this.PC ++;
                byte value = getOpcode();
                this.registers[0] = value;
            }

            case 0x02 -> {
                this.PC ++;
                byte value = getOpcode();
                switch (value) {
                    case 0x01 -> this.registers[0] = this.registers[1];
                    case 0x02 -> this.registers[0] = this.registers[2];
                    case 0x03 -> this.registers[0] = this.registers[3];
                }
            }

            case 0x03 -> {
                this.PC ++;
                byte value = getOpcode();
                this.registers[1] = value;
            }

            case 0x04 -> {
                this.PC ++;
                byte value = getOpcode();
                switch (value) {
                    case 0x00 -> this.registers[1] = this.registers[0];
                    case 0x02 -> this.registers[1] = this.registers[2];
                    case 0x03 -> this.registers[1] = this.registers[3];
                }
            }

            case 0x05 -> {
                this.PC ++;
                byte value = getOpcode();
                this.registers[2] = value;
            }

            case 0x06 -> {
                this.PC ++;
                byte value = getOpcode();
                switch (value) {
                    case 0x00 -> this.registers[2] = this.registers[0];
                    case 0x01 -> this.registers[2] = this.registers[1];
                    case 0x03 -> this.registers[2] = this.registers[3];
                }
            }

            case 0x07 -> {
                this.PC ++;
                byte value = getOpcode();
                this.registers[3] = value;
            }

            case 0x08 -> {
                this.PC ++;
                byte value = getOpcode();
                switch (value) {
                    case 0x00 -> this.registers[3] = this.registers[0];
                    case 0x01 -> this.registers[3] = this.registers[1];
                    case 0x02 -> this.registers[3] = this.registers[2];
                }
            }
        }

        this.PC++;
    }

}
