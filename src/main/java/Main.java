import com.carbon8.asm.Assembler;
import com.carbon8.cpu.Cpu;
import com.carbon8.cpu.Program;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Program program1 = Assembler.assemble(Files.readString(Path.of(Main.class.getResource("test.asm").toURI())));

        System.out.println(program1.data);

        String programString = "01 0F";
        Program program = new Program();


        program.loadData(programString);

        System.out.println(program.data);

        Cpu cpu = new Cpu();

        cpu.loadInMemory(program1);

        cpu.run();

        System.out.println(Arrays.toString(cpu.registers));
    }
}
