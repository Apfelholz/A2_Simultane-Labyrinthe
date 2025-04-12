import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SimulanteLabyrintheTest{
    @Test
    void testMainWithLabyrinth00() {
        String[] output = testMainWithFile("data\\labyrintheT0.txt");
        for (String l : output){
            System.out.println(l);
        }
        char[] instructions = new char[] {'>', '>', '|', '|'};
        int length = 4;
        assertEquals(length, Integer.parseInt(output[1].strip()));
        assertArrayEquals(instructions, output[0].strip().toCharArray());
    }

    @Test
    void testMainWithLabyrinth01() {
        String[] output = testMainWithFile("data\\labyrintheT1.txt");
        for (String l : output){
            System.out.println(l);
        }
        char[] instructions = new char[] {'|', '|', '>', '^', '^', '>', '|', '|'};
        int length = 8;
        assertEquals(length, Integer.parseInt(output[1].strip()));
        assertArrayEquals(instructions, output[0].strip().toCharArray());
    }

    @Test
    void testMainWithLabyrinth02() {
        String[] output = testMainWithFile("data\\labyrintheT2.txt");
        for (String l : output){
            System.out.println(l);
        }
        char[] instructions = new char[] {'|', '|', '>', '^', '^', '>', '|', '|'};
        int length = 8;
        assertEquals(length, Integer.parseInt(output[1].strip()));
        assertArrayEquals(instructions, output[0].strip().toCharArray());
    }

    @Test
    void testMainWithLabyrinth03() {
        String[] output = testMainWithFile("data\\labyrintheT3.txt"); 
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth0() {
        String[] output = testMainWithFile("data\\labyrinthe0.txt"); 
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth1() {
        String[] output = testMainWithFile("data\\labyrinthe1.txt");
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth2() {
        String[] output = testMainWithFile("data\\labyrinthe2.txt");
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth3() {
        String[] output = testMainWithFile("data\\labyrinthe3.txt");
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth4() {
        String[] output = testMainWithFile("data\\labyrinthe4.txt");
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth5() {
        String[] output = testMainWithFile("data\\labyrinthe5.txt");
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth6() {
        String[] output = testMainWithFile("data\\labyrinthe6.txt");
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth7() {
        String[] output = testMainWithFile("data\\labyrinthe7.txt");
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth8() {
        String[] output = testMainWithFile("data\\labyrinthe8.txt");
        for (String l : output){
            System.out.println(l);
        }
    }

    @Test
    void testMainWithLabyrinth9() {
        String[] output = testMainWithFile("data\\labyrinthe9.txt");
        for (String l : output){
            System.out.println(l);
        }
    }
    
    private String[] testMainWithFile(String filePath) {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call the main method with the input file path
        try {
            SimulanteLabyrinthe.main(new String[]{filePath});
            System.out.println("Test with file " + filePath + " ran successfully.");
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        } finally {
            // Reset System.out
            System.setOut(originalOut);
        }

        // Verify the output
        String output = outContent.toString();
        assertFalse(output.isEmpty(), "Output should not be empty for file: " + filePath);
        String[] lines = output.split("\n");

        // Call the Python script with the required arguments
        try {
            String pathSequence = lines[0].strip(); // Extract the path sequence
            ProcessBuilder pb = new ProcessBuilder(
                "py", 
                "D:\\Documents\\Programiren\\Informatik Wettbewerb\\BWINF 2024\\Runde 2\\maze_visualization\\maze_visualization.py", 
                filePath, 
                pathSequence
            );
            pb.inheritIO(); // Pass output to the console
            Process process = pb.start();
            int exitCode = process.waitFor();
            assertEquals(0, exitCode, "Python script exited with an error.");
        } catch (Exception e) {
            fail("Failed to execute maze_visualization.py: " + e.getMessage());
        }

        return lines;
    }
}