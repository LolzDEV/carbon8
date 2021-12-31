package com.carbon8.cpu;

import java.util.Arrays;
import java.util.BitSet;

public class Cpu {
    public static final int MEMORY_SIZE = Short.MAX_VALUE;

    short PC = 0x0000;
    public byte[] registers = new byte[4];
    public byte[] component = new byte[4];
    public byte[] memory = new byte[MEMORY_SIZE];
    short SP = 0x0000;
    public BitSet status = new BitSet(); // 0: A, 1: B

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

            case 0x09 -> {
                this.PC ++;
                byte firstByte = getOpcode();
                this.PC ++;
                byte secondByte = getOpcode();
                this.PC = (short) ((firstByte << 8) | (secondByte & 0xFF));
            }

            case 0x10 -> {
                this.PC ++;
                byte a = getOpcode();
                this.PC ++;
                byte b = getOpcode();
                this.status.set(0, a == b);
                this.status.set(1, a > b);
            }

            case 0x11 -> {
                this.PC ++;
                byte a = getOpcode();
                a = this.registers[a];
                this.PC ++;
                byte b = getOpcode();
                this.status.set(0, a == b);
                this.status.set(1, a > b);
            }

            case 0x12 -> {
                this.PC ++;
                byte a = getOpcode();
                this.PC ++;
                byte b = getOpcode();
                b = this.registers[b];
                this.status.set(0, a == b);
                this.status.set(1, a > b);
            }

            case 0x13 -> {
                this.PC ++;
                byte a = getOpcode();
                a = this.registers[a];
                this.PC ++;
                byte b = getOpcode();
                b = this.registers[b];
                this.status.set(0, a == b);
                this.status.set(1, a > b);
            }
            case 0x14 -> {
                this.PC ++;
                byte firstByte = getOpcode();
                this.PC ++;
                byte secondByte = getOpcode();
                if (this.status.get(0)) {
                    this.PC = (short) ((firstByte << 8) | (secondByte & 0xFF));
                } else {
                    this.PC ++;
                }
            }
            case 0x15 -> {
                this.PC ++;
                byte firstByte = getOpcode();
                this.PC ++;
                byte secondByte = getOpcode();
                if (!this.status.get(0)) {
                    this.PC = (short) ((firstByte << 8) | (secondByte & 0xFF));
                } else {
                    this.PC ++;
                }
            }
            case 0x16 -> {
                this.PC ++;
                byte firstByte = getOpcode();
                this.PC ++;
                byte secondByte = getOpcode();
                if (this.status.get(1)) {
                    this.PC = (short) ((firstByte << 8) | (secondByte & 0xFF));
                } else {
                    this.PC ++;
                }
            }
            case 0x17 -> {
                this.PC ++;
                byte firstByte = getOpcode();
                this.PC ++;
                byte secondByte = getOpcode();
                if (!this.status.get(1)) {
                    this.PC = (short) ((firstByte << 8) | (secondByte & 0xFF));
                } else {
                    this.PC ++;
                }
            }
            case 0x18 -> {
                this.PC ++;
                byte a = getOpcode();
                this.PC ++;
                byte b = getOpcode();
                this.memory[a] = b;
            }

            case 0x19 -> {
                this.PC ++;
                byte a = getOpcode();
                a = this.registers[a];
                this.PC ++;
                byte b = getOpcode();
                this.memory[a] = b;
            }

            case 0x20 -> {
                this.PC ++;
                byte a = getOpcode();
                this.PC ++;
                byte b = getOpcode();
                b = this.registers[b];
                this.memory[a] = b;
            }

            case 0x21 -> {
                this.PC ++;
                byte a = getOpcode();
                a = this.registers[a];
                this.PC ++;
                byte b = getOpcode();
                b = this.registers[b];
                this.memory[a] = b;
            }
        }

        this.PC++;
    }

}
