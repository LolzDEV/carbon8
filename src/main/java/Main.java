import com.carbon8.asm.Assembler;
import com.carbon8.cpu.Cpu;
import com.carbon8.cpu.Program;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    static byte[] memory = new byte[Cpu.MEMORY_SIZE];

    public static void main(String[] args) throws URISyntaxException, IOException {
        Program program = Assembler.assemble(Files.readString(Path.of(Main.class.getResource("test.asm").toURI())));

        System.out.println("Binary Output: " + program);

        Cpu cpu = new Cpu();

        cpu.loadInMemory(program);

        memory = cpu.memory;

        cpu.run();

        System.out.println("CPU Status at the end of the execution: A:" + cpu.status.get(0) + " B: " + cpu.status.get(1));
        System.out.println("Registers at the end of the execution: " + Arrays.toString(cpu.registers));
    }
}
