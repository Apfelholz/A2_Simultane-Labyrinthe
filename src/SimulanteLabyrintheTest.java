import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SimulanteLabyrintheTest{
    @Test
    void testMainWithLabyrinth00() {
        String[] output = testMainWithFile("data\\labyrinthe00.txt");
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
        String[] output = testMainWithFile("data\\labyrinthe01.txt");
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
        String[] output = testMainWithFile("data\\labyrinthe02.txt");
        for (String l : output){
            System.out.println(l);
        }
        char[] instructions = new char[] {'|', '|', '>', '^', '^', '>', '|', '|'};
        int length = 8;
        assertEquals(length, Integer.parseInt(output[1].strip()));
        assertArrayEquals(instructions, output[0].strip().toCharArray());
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
        return lines;
    }
}