package com.carbon8.asm;

import com.carbon8.cpu.Program;

import java.util.HexFormat;

public class Assembler {
    public static Program assemble(String assemblySource) {
        Program program = new Program();

        String[] lines = assemblySource.split(System.getProperty("line.separator"));
        for (String line : lines) {
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "lda" -> {
                    switch (tokens[1]) {
                        case "a" -> { program.addOpCode((byte) 0x02); program.addOpCode((byte) 0x00); }
                        case "b" -> { program.addOpCode((byte) 0x02); program.addOpCode((byte) 0x01); }
                        case "c" -> { program.addOpCode((byte) 0x02); program.addOpCode((byte) 0x02); }
                        case "d" -> { program.addOpCode((byte) 0x02); program.addOpCode((byte) 0x03); }
                        default -> { program.addOpCode((byte) 0x01); program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1])); }
                    }
                }
                case "ldb" -> {
                    switch (tokens[1]) {
                        case "a" -> { program.addOpCode((byte) 0x04); program.addOpCode((byte) 0x00); }
                        case "b" -> { program.addOpCode((byte) 0x04); program.addOpCode((byte) 0x01); }
                        case "c" -> { program.addOpCode((byte) 0x04); program.addOpCode((byte) 0x02); }
                        case "d" -> { program.addOpCode((byte) 0x04); program.addOpCode((byte) 0x03); }
                        default -> { program.addOpCode((byte) 0x03); program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1])); }
                    }
                }
                case "ldc" -> {
                    switch (tokens[1]) {
                        case "a" -> { program.addOpCode((byte) 0x06); program.addOpCode((byte) 0x00); }
                        case "b" -> { program.addOpCode((byte) 0x06); program.addOpCode((byte) 0x01); }
                        case "c" -> { program.addOpCode((byte) 0x06); program.addOpCode((byte) 0x02); }
                        case "d" -> { program.addOpCode((byte) 0x06); program.addOpCode((byte) 0x03); }
                        default -> { program.addOpCode((byte) 0x05); program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1])); }
                    }
                }
                case "ldd" -> {
                    switch (tokens[1]) {
                        case "a" -> { program.addOpCode((byte) 0x08); program.addOpCode((byte) 0x00); }
                        case "b" -> { program.addOpCode((byte) 0x08); program.addOpCode((byte) 0x01); }
                        case "c" -> { program.addOpCode((byte) 0x08); program.addOpCode((byte) 0x02); }
                        case "d" -> { program.addOpCode((byte) 0x08); program.addOpCode((byte) 0x03); }
                        default -> { program.addOpCode((byte) 0x07); program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1])); }
                    }
                }
            }
        }

        return program;
    }
}
