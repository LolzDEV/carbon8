package com.carbon8.cpu;

import java.util.ArrayList;
import java.util.HexFormat;

public class Program {
    public ArrayList<Byte> data = new ArrayList<>();

    public void addOpCode(byte opcode) {
        data.add(opcode);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (byte b : this.data) {
            builder.append(b).append(" ");
        }
        return builder.toString();
    }

    public void loadData(String data) {
        for (String b : data.split(" ")) {
            this.data.add((byte)HexFormat.fromHexDigits(b));
        }
    }
}
