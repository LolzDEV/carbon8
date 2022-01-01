package com.carbon8.asm;

import com.carbon8.cpu.Program;

import java.util.HashMap;
import java.util.HexFormat;

public class Assembler {
    public static Program assemble(String assemblySource) {
        Program program = new Program();
        HashMap<String, Short> labels = new HashMap<>();
        short PC = 0x0000;

        String[] lines = assemblySource.split(System.getProperty("line.separator"));

        for (String line : lines) {
            String[] tokens = line.split(" ");
            if (tokens[0].startsWith(":")) {
                labels.put(tokens[0].substring(1), PC);
                System.out.println("Label " + tokens[0] + " inserted at " + PC);
            } else if (!tokens[0].startsWith(";")) {
                switch (tokens[0]) {
                    case "lda", "ldb", "ldc", "ldd" -> PC += 2;
                    case "jmp", "cmp", "jeq", "jne", "jgt", "jng", "mov" -> PC += 3;
                }
            }
        }

        PC = 0x0000;

        for (String line : lines) {
            String[] tokens = line.split(" ");
            if (!tokens[0].startsWith(";")) {
                switch (tokens[0]) {
                    case "lda" -> {
                        switch (tokens[1]) {
                            case "a" -> {
                                program.addOpCode((byte) 0x02);
                                program.addOpCode((byte) 0x00);
                            }
                            case "b" -> {
                                program.addOpCode((byte) 0x02);
                                program.addOpCode((byte) 0x01);
                            }
                            case "c" -> {
                                program.addOpCode((byte) 0x02);
                                program.addOpCode((byte) 0x02);
                            }
                            case "d" -> {
                                program.addOpCode((byte) 0x02);
                                program.addOpCode((byte) 0x03);
                            }
                            case "ca" -> {
                                program.addOpCode((byte) 0x02);
                                program.addOpCode((byte) 0x04);
                            }
                            case "cb" -> {
                                program.addOpCode((byte) 0x02);
                                program.addOpCode((byte) 0x05);
                            }
                            case "cc" -> {
                                program.addOpCode((byte) 0x02);
                                program.addOpCode((byte) 0x06);
                            }
                            case "cd" -> {
                                program.addOpCode((byte) 0x02);
                                program.addOpCode((byte) 0x07);
                            }
                            default -> {
                                program.addOpCode((byte) 0x01);
                                program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1]));
                            }
                        }
                        PC += 2;
                    }
                    case "ldb" -> {
                        switch (tokens[1]) {
                            case "a" -> {
                                program.addOpCode((byte) 0x04);
                                program.addOpCode((byte) 0x00);
                            }
                            case "b" -> {
                                program.addOpCode((byte) 0x04);
                                program.addOpCode((byte) 0x01);
                            }
                            case "c" -> {
                                program.addOpCode((byte) 0x04);
                                program.addOpCode((byte) 0x02);
                            }
                            case "d" -> {
                                program.addOpCode((byte) 0x04);
                                program.addOpCode((byte) 0x03);
                            }
                            case "ca" -> {
                                program.addOpCode((byte) 0x04);
                                program.addOpCode((byte) 0x04);
                            }
                            case "cb" -> {
                                program.addOpCode((byte) 0x04);
                                program.addOpCode((byte) 0x05);
                            }
                            case "cc" -> {
                                program.addOpCode((byte) 0x04);
                                program.addOpCode((byte) 0x06);
                            }
                            case "cd" -> {
                                program.addOpCode((byte) 0x04);
                                program.addOpCode((byte) 0x07);
                            }
                            default -> {
                                program.addOpCode((byte) 0x03);
                                program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1]));
                            }
                        }
                        PC += 2;
                    }
                    case "ldc" -> {
                        switch (tokens[1]) {
                            case "a" -> {
                                program.addOpCode((byte) 0x06);
                                program.addOpCode((byte) 0x00);
                            }
                            case "b" -> {
                                program.addOpCode((byte) 0x06);
                                program.addOpCode((byte) 0x01);
                            }
                            case "c" -> {
                                program.addOpCode((byte) 0x06);
                                program.addOpCode((byte) 0x02);
                            }
                            case "d" -> {
                                program.addOpCode((byte) 0x06);
                                program.addOpCode((byte) 0x03);
                            }
                            case "ca" -> {
                                program.addOpCode((byte) 0x06);
                                program.addOpCode((byte) 0x04);
                            }
                            case "cb" -> {
                                program.addOpCode((byte) 0x06);
                                program.addOpCode((byte) 0x05);
                            }
                            case "cc" -> {
                                program.addOpCode((byte) 0x06);
                                program.addOpCode((byte) 0x06);
                            }
                            case "cd" -> {
                                program.addOpCode((byte) 0x06);
                                program.addOpCode((byte) 0x07);
                            }
                            default -> {
                                program.addOpCode((byte) 0x05);
                                program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1]));
                            }
                        }
                        PC += 2;
                    }
                    case "ldd" -> {
                        switch (tokens[1]) {
                            case "a" -> {
                                program.addOpCode((byte) 0x08);
                                program.addOpCode((byte) 0x00);
                            }
                            case "b" -> {
                                program.addOpCode((byte) 0x08);
                                program.addOpCode((byte) 0x01);
                            }
                            case "c" -> {
                                program.addOpCode((byte) 0x08);
                                program.addOpCode((byte) 0x02);
                            }
                            case "d" -> {
                                program.addOpCode((byte) 0x08);
                                program.addOpCode((byte) 0x03);
                            }
                            case "ca" -> {
                                program.addOpCode((byte) 0x08);
                                program.addOpCode((byte) 0x04);
                            }
                            case "cb" -> {
                                program.addOpCode((byte) 0x08);
                                program.addOpCode((byte) 0x05);
                            }
                            case "cc" -> {
                                program.addOpCode((byte) 0x08);
                                program.addOpCode((byte) 0x06);
                            }
                            case "cd" -> {
                                program.addOpCode((byte) 0x08);
                                program.addOpCode((byte) 0x07);
                            }
                            default -> {
                                program.addOpCode((byte) 0x07);
                                program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1]));
                            }
                        }
                        PC += 2;
                    }
                    case "jmp" -> {
                        program.addOpCode((byte) 0x09);
                        if (tokens[1].startsWith(":")) {
                            if (labels.containsKey(tokens[1].substring(1))) {
                                program.addOpCode((byte) (((byte) (labels.get(tokens[1].substring(1)) & 0xFF00)) >> 8));
                                program.addOpCode(((byte) (labels.get(tokens[1].substring(1)) & 0xFF)));
                            }
                        } else {
                            short value = (short) HexFormat.fromHexDigits(tokens[1]);
                            program.addOpCode((byte) (((byte) (value & 0xFF00)) >> 8));
                            program.addOpCode(((byte) (value & 0xFF)));
                        }
                        PC += 3;
                    }
                    case "cmp" -> {
                        switch (tokens[1]) {
                            case "a" -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x13);
                                } else {
                                    program.addOpCode((byte) 0x11);
                                }
                                program.addOpCode((byte) 0x00);
                            }
                            case "b" -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x13);
                                } else {
                                    program.addOpCode((byte) 0x11);
                                }
                                program.addOpCode((byte) 0x01);
                            }
                            case "c" -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x13);
                                } else {
                                    program.addOpCode((byte) 0x11);
                                }
                                program.addOpCode((byte) 0x02);
                            }
                            case "d" -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x13);
                                } else {
                                    program.addOpCode((byte) 0x11);
                                }
                                program.addOpCode((byte) 0x03);
                            }
                            case "ca" -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x13);
                                } else {
                                    program.addOpCode((byte) 0x11);
                                }
                                program.addOpCode((byte) 0x04);
                            }
                            case "cb" -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x13);
                                } else {
                                    program.addOpCode((byte) 0x11);
                                }
                                program.addOpCode((byte) 0x05);
                            }
                            case "cc" -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x13);
                                } else {
                                    program.addOpCode((byte) 0x11);
                                }
                                program.addOpCode((byte) 0x06);
                            }
                            case "cd" -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x13);
                                } else {
                                    program.addOpCode((byte) 0x11);
                                }
                                program.addOpCode((byte) 0x07);
                            }
                            default -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x12);
                                } else {
                                    program.addOpCode((byte) 0x10);
                                }
                                program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1]));
                            }
                        }

                        switch (tokens[2]) {
                            case "a" -> program.addOpCode((byte) 0x00);
                            case "b" -> program.addOpCode((byte) 0x01);
                            case "c" -> program.addOpCode((byte) 0x02);
                            case "d" -> program.addOpCode((byte) 0x03);
                            case "ca" -> program.addOpCode((byte) 0x04);
                            case "cb" -> program.addOpCode((byte) 0x05);
                            case "cc" -> program.addOpCode((byte) 0x06);
                            case "cd" -> program.addOpCode((byte) 0x07);
                            default -> program.addOpCode((byte) HexFormat.fromHexDigits(tokens[2]));
                        }

                        PC += 3;
                    }
                    case "jeq" -> {
                        program.addOpCode((byte) 0x14);
                        if (tokens[1].startsWith(":")) {
                            if (labels.containsKey(tokens[1].substring(1))) {
                                program.addOpCode((byte) (((byte) (labels.get(tokens[1].substring(1)) & 0xFF00)) >> 8));
                                program.addOpCode(((byte) (labels.get(tokens[1].substring(1)) & 0xFF)));
                            }
                        } else {
                            short value = (short) HexFormat.fromHexDigits(tokens[1]);
                            program.addOpCode((byte) (((byte) (value & 0xFF00)) >> 8));
                            program.addOpCode(((byte) (value & 0xFF)));
                        }
                        PC += 3;
                    }
                    case "jne" -> {
                        program.addOpCode((byte) 0x15);
                        if (tokens[1].startsWith(":")) {
                            if (labels.containsKey(tokens[1].substring(1))) {
                                program.addOpCode((byte) (((byte) (labels.get(tokens[1].substring(1)) & 0xFF00)) >> 8));
                                program.addOpCode(((byte) (labels.get(tokens[1].substring(1)) & 0xFF)));
                            }
                        } else {
                            short value = (short) HexFormat.fromHexDigits(tokens[1]);
                            program.addOpCode((byte) (((byte) (value & 0xFF00)) >> 8));
                            program.addOpCode(((byte) (value & 0xFF)));
                        }
                        PC += 3;
                    }
                    case "jgt" -> {
                        program.addOpCode((byte) 0x16);
                        if (tokens[1].startsWith(":")) {
                            if (labels.containsKey(tokens[1].substring(1))) {
                                program.addOpCode((byte) (((byte) (labels.get(tokens[1].substring(1)) & 0xFF00)) >> 8));
                                program.addOpCode(((byte) (labels.get(tokens[1].substring(1)) & 0xFF)));
                            }
                        } else {
                            short value = (short) HexFormat.fromHexDigits(tokens[1]);
                            program.addOpCode((byte) (((byte) (value & 0xFF00)) >> 8));
                            program.addOpCode(((byte) (value & 0xFF)));
                        }
                        PC += 3;
                    }
                    case "jng" -> {
                        program.addOpCode((byte) 0x17);
                        if (tokens[1].startsWith(":")) {
                            if (labels.containsKey(tokens[1].substring(1))) {
                                program.addOpCode((byte) (((byte) (labels.get(tokens[1].substring(1)) & 0xFF00)) >> 8));
                                program.addOpCode(((byte) (labels.get(tokens[1].substring(1)) & 0xFF)));
                            }
                        } else {
                            short value = (short) HexFormat.fromHexDigits(tokens[1]);
                            program.addOpCode((byte) (((byte) (value & 0xFF00)) >> 8));
                            program.addOpCode(((byte) (value & 0xFF)));
                        }
                        PC += 3;
                    }
                    case "mov" -> {
                        switch (tokens[1]) {
                            case "a" -> {
                                genMov(program, tokens);
                                program.addOpCode((byte) 0x00);
                            }
                            case "b" -> {
                                genMov(program, tokens);
                                program.addOpCode((byte) 0x01);
                            }
                            case "c" -> {
                                genMov(program, tokens);
                                program.addOpCode((byte) 0x02);
                            }
                            case "d" -> {
                                genMov(program, tokens);
                                program.addOpCode((byte) 0x03);
                            }
                            default -> {
                                if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
                                    program.addOpCode((byte) 0x20);
                                } else {
                                    program.addOpCode((byte) 0x18);
                                }
                                program.addOpCode((byte) HexFormat.fromHexDigits(tokens[1]));
                            }
                        }

                        switch (tokens[2]) {
                            case "a" -> program.addOpCode((byte) 0x00);
                            case "b" -> program.addOpCode((byte) 0x01);
                            case "c" -> program.addOpCode((byte) 0x02);
                            case "d" -> program.addOpCode((byte) 0x03);
                            default -> program.addOpCode((byte) HexFormat.fromHexDigits(tokens[2]));
                        }

                        PC += 3;
                    }
                }
            }
        }

        return program;
    }

    private static void genMov(Program program, String[] tokens) {
        if (tokens[2].equals("a") || tokens[2].equals("b") || tokens[2].equals("c") || tokens[2].equals("d") || tokens[2].equals("ca") || tokens[2].equals("cb") || tokens[2].equals("cc") || tokens[2].equals("cd")) {
            program.addOpCode((byte) 0x21);
        } else {
            program.addOpCode((byte) 0x19);
        }
    }
}
