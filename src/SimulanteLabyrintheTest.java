import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class SimulanteLabyrintheTest{
    @Test
    void testMainWithLabyrinthA_main() {
        String[] output = testMainWithFile("data\\labyrintheA.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthB_main() {
        String[] output = testMainWithFile("data\\labyrintheB.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthC_main() {
        String[] output = testMainWithFile("data\\labyrintheC.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthD_main() {
        String[] output = testMainWithFile("data\\labyrintheD.txt", "main"); 
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertFalse(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthE_main() {
        String[] output = testMainWithFile("data\\labyrintheE.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthF_main() {
        String[] output = testMainWithFile("data\\labyrintheF.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthG_main() {
        String[] output = testMainWithFile("data\\labyrintheG.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthH_main() {
        String[] output = testMainWithFile("data\\labyrintheH.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }


    @Test
    void testMainWithLabyrinthI_main() {
        String[] output = testMainWithFile("data\\labyrintheI.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthJ_main() {
        String[] output = testMainWithFile("data\\labyrintheJ.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthK_main() {
        String[] output = testMainWithFile("data\\labyrintheK.txt", "main"); 
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthL_main() {
        String[] output = testMainWithFile("data\\labyrintheL.txt", "main"); 
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }


    @Test
    void testMainWithLabyrinth0_main() {
        String[] output = testMainWithFile("data\\labyrinthe0.txt", "main"); 
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth1_main() {
        String[] output = testMainWithFile("data\\labyrinthe1.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth2_main() {
        String[] output = testMainWithFile("data\\labyrinthe2.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth3_main() {
        String[] output = testMainWithFile("data\\labyrinthe3.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth4_main() {
        String[] output = testMainWithFile("data\\labyrinthe4.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth5_main() {
        String[] output = testMainWithFile("data\\labyrinthe5.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth6_main() {
        String[] output = testMainWithFile("data\\labyrinthe6.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth7_main() {
        String[] output = testMainWithFile("data\\labyrinthe7.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertFalse(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth8_main() {
        String[] output = testMainWithFile("data\\labyrinthe8.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth9_main() {
        String[] output = testMainWithFile("data\\labyrinthe9.txt", "main");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthA_plats() {
        String[] output = testMainWithFile("data\\labyrintheA.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthB_plats() {
        String[] output = testMainWithFile("data\\labyrintheB.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthC_plats() {
        String[] output = testMainWithFile("data\\labyrintheC.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthD_plats() {
        String[] output = testMainWithFile("data\\labyrintheD.txt", "plates"); 
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertFalse(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthE_plats() {
        String[] output = testMainWithFile("data\\labyrintheE.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthF_plats() {
        String[] output = testMainWithFile("data\\labyrintheF.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthG_plats() {
        String[] output = testMainWithFile("data\\labyrintheG.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthH_plats() {
        String[] output = testMainWithFile("data\\labyrintheH.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }


    @Test
    void testMainWithLabyrinthI_plats() {
        String[] output = testMainWithFile("data\\labyrintheI.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthJ_plats() {
        String[] output = testMainWithFile("data\\labyrintheJ.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthK_plats() {
        String[] output = testMainWithFile("data\\labyrintheK.txt", "plates"); 
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinthL_plats() {
        String[] output = testMainWithFile("data\\labyrintheL.txt", "plates"); 
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }


    @Test
    void testMainWithLabyrinth0_plats() {
        String[] output = testMainWithFile("data\\labyrinthe0.txt", "plates"); 
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth1_plats() {
        String[] output = testMainWithFile("data\\labyrinthe1.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth2_plats() {
        String[] output = testMainWithFile("data\\labyrinthe2.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth3_plats() {
        String[] output = testMainWithFile("data\\labyrinthe3.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth4_plats() {
        String[] output = testMainWithFile("data\\labyrinthe4.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth5_plats() {
        String[] output = testMainWithFile("data\\labyrinthe5.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth6_plats() {
        String[] output = testMainWithFile("data\\labyrinthe6.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth7_plats() {
        String[] output = testMainWithFile("data\\labyrinthe7.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertFalse(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth8_plats() {
        String[] output = testMainWithFile("data\\labyrinthe8.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }

    @Test
    void testMainWithLabyrinth9_plats() {
        String[] output = testMainWithFile("data\\labyrinthe9.txt", "plates");
        for (String l : output){
            System.out.println(l);
        }
        boolean found = Arrays.stream(output)
            .anyMatch(line -> line.startsWith("Es wurde eine Loesung gefunden"));

        assertTrue(found, "Solution Found!");
    }
    
    private String[] testMainWithFile(String filePath, String method) {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call the main method with the input file path
        try {
            SimulanteLabyrinthe.main(new String[]{filePath, method});
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
            String pathSequence = lines[5].strip();
            String optionalArgsStr = "";
            if (lines.length > 9){
                String[] optionalArgs = Arrays.copyOfRange(lines, 9, lines.length); // Extract optional lines starting from the 10th line
                optionalArgsStr = String.join(",", optionalArgs).strip(); // Join them into a single string
            }
            ProcessBuilder pb = new ProcessBuilder(
                "py", 
                "D:\\Documents\\Programiren\\Informatik Wettbewerb\\BWINF 2024\\Runde 2\\maze_visualization\\maze_visualization.py", 
                filePath, 
                method,
                pathSequence,
                optionalArgsStr // Pass optional arguments as a single string
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