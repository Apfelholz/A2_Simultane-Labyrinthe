public class SimulanteLabyrinthe {
    public static void main(String[] args) throws Exception {
        String dateipfad = args[0];
        String version;
        if (args.length == 2){
            version = args[1];
        }else {
            version = "non";
        }

        int x = 0;
        int y = 0;

        x = FileReaderx.readToInt2DArray(dateipfad, 0, 1)[0][0];
        y = FileReaderx.readToInt2DArray(dateipfad, 0, 1)[0][1];

        boolean[][] one_wall_v = new boolean[x][y];
        boolean[][] one_wall_h = new boolean[x][y];

        one_wall_v = formatInputData_v(FileReaderx.readToInt2DArray(dateipfad, 1, 1+(y-1)), x, y);
        one_wall_h = formatInputData_h(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+1, 1+(y-1)+y-1), x, y);

        int one_numberOfPits = FileReaderx.readLineToInt(dateipfad, 1+(y-1)+y-1+1);

        boolean[][] one_pits = new boolean[x][y];
        int[][][] one_pitCords = null;

        if (one_numberOfPits > 0){
            one_pits = formatInputData_pits(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+1, 1+(y-1)+y-1+1+one_numberOfPits), x, y);
        }

        boolean[][] two_wall_v = new boolean[x][y];
        boolean[][] two_wall_h = new boolean[x][y];

        two_wall_v = formatInputData_v(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+1, 1+(y-1)+y-1+1+one_numberOfPits+y), x, y);
        two_wall_h = formatInputData_h(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+1, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1), x, y);

        int two_numberOfPits = FileReaderx.readLineToInt(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1);
        
        boolean[][] two_pits = new boolean[x][y];
        int[][][] two_pitCords = null;

        if (two_numberOfPits > 0){
            two_pits = formatInputData_pits(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+1, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+two_numberOfPits), x, y);
        }

        int[][] starts = new int[][] {{0,0},{0,0},{x-1,y-1},{x-1,y-1}};

        if (FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+two_numberOfPits+1, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+two_numberOfPits+4).length > 0){
            starts = FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+two_numberOfPits+1, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+two_numberOfPits+4);
        }

        if (two_numberOfPits > 0){
            two_pitCords = processPitCoordinates(dateipfad, x, y, two_numberOfPits, 1 + (y - 1) + y - 1 + 1 + one_numberOfPits + y + y - 1 + 1 + 1, starts, 1);
        }

        if (one_numberOfPits > 0){
            one_pitCords = processPitCoordinates(dateipfad, x, y, one_numberOfPits, 1 + (y - 1) + y - 1 + 1 + 1, starts, 0);
        }

        char[] instructions = null;

        Integer[][] usedPlats = null;
        
        if (version == "plates"){
            boolean[][] one_plates = new boolean[x][y];
            boolean[][] two_plates = new boolean[x][y];
            
            int[][][] one_plate_cords_action = new int[x][y][4];
            int[][][] two_plate_cords_action = new int[x][y][4];


            if (FileReaderx.readLineToInt(dateipfad, 1 + (y - 1) + y - 1 + 1 + one_numberOfPits + y + y - 1 + 1 + two_numberOfPits + 5) > 0) {

                int plates = FileReaderx.readLineToInt(dateipfad, 1 + (y - 1) + y - 1 + 1 + one_numberOfPits + y + y - 1 + 1 + two_numberOfPits + 5);
            
                int[][] lines = FileReaderx.readToInt2DArray(dateipfad, 1 + (y - 1) + y - 1 + 1 + one_numberOfPits + y + y - 1 + 1 + two_numberOfPits + 5 + 1, 1 + (y - 1) + y - 1 + 1 + one_numberOfPits + y + y - 1 + 1 + two_numberOfPits + 5 + plates);
            
                for (int[] line : lines) {
                    if (line[0] == 1) {
                        formatPlates(line, one_plates, one_plate_cords_action);
                    } else if (line[0] == 2) {
                        formatPlates(line, two_plates, two_plate_cords_action);
                    }
                }
            }
            SyncronDixtraPlates syncronDixtra = new SyncronDixtraPlates(one_wall_v, one_wall_h, one_pits, two_wall_v, two_wall_h, two_pits, x, y, one_pitCords, two_pitCords, one_plates, two_plates, one_plate_cords_action, two_plate_cords_action);
            instructions = syncronDixtra.findInstructions(starts[0][0], starts[0][1], starts[1][0], starts[1][1], starts[2][0], starts[2][1], starts[3][0], starts[3][1]);

            if (instructions.length > 0 && instructions[instructions.length - 1] != 'X'){
                usedPlats = new Integer[syncronDixtra.akkFrame.usedPlats.size()][7];
                for (int i = 0; i < syncronDixtra.akkFrame.usedPlats.size(); i++){
                    usedPlats[i] = syncronDixtra.akkFrame.usedPlats.get(i);
                }
            }else {
                usedPlats = new Integer[syncronDixtra.lastFrame.usedPlats.size()][7];
                for (int i = 0; i < syncronDixtra.lastFrame.usedPlats.size(); i++){
                    usedPlats[i] = syncronDixtra.lastFrame.usedPlats.get(i);
                }
            }

        }else if (version == "duties"){
            SyncronDixtraDuties syncronDixtra = new SyncronDixtraDuties(one_wall_v, one_wall_h, one_pits, two_wall_v, two_wall_h, two_pits, x, y, one_pitCords, two_pitCords);
            instructions = syncronDixtra.findInstructions(starts[0][0], starts[0][1], starts[1][0], starts[1][1], starts[2][0], starts[2][1], starts[3][0], starts[3][1]);
        }else{
            SyncronDixtra syncronDixtra = new SyncronDixtra(one_wall_v, one_wall_h, one_pits, two_wall_v, two_wall_h, two_pits, x, y, one_pitCords, two_pitCords);
            instructions = syncronDixtra.findInstructions(starts[0][0], starts[0][1], starts[1][0], starts[1][1], starts[2][0], starts[2][1], starts[3][0], starts[3][1]);
        } 

        FileLogger fileLogger = new FileLogger("output\\output_" + version + "_" + dateipfad.substring(15, 16) + ".txt");

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Beispiel: " + dateipfad);

        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        fileLogger.println("====================================");
        fileLogger.println("Results for file: " + dateipfad);
        fileLogger.println("====================================");

        if (instructions.length > 0 && instructions[instructions.length - 1] != 'X') {
        System.out.println("Es wurde eine Loesung gefunden");
        System.out.println("Folgende Anweisungsfolge ist die kuerzeste moegliche");
        fileLogger.println("Es wurde eine Loesung gefunden");
        fileLogger.println("Folgende Anweisungsfolge ist die kuerzeste moegliche");
        for (char c : instructions) {
            if (c != '\0') {
            System.out.print(c);
            fileLogger.print(c);
            }
        }
        System.out.println("");
        fileLogger.println("");
        System.out.println("(^:hoch ; >:rechts ; |:runter ; <:links)");
        fileLogger.println("(^:hoch ; >:rechts ; |:runter ; <:links)");
        System.out.println("Die Anweisungsfolge hat eine Laenge von: " + (instructions.length-1));
        fileLogger.println("Die Anweisungsfolge hat eine Laenge von: " + (instructions.length-1));
        } else {
        System.out.println("Es konnte keine Loesung gefunden werden.");
        System.out.println("Folgende Anweisungsfolge ist die best moegliche");
        fileLogger.println("Es konnte keine Loesung gefunden werden.");
        fileLogger.println("Folgende Anweisungsfolge ist die best moegliche");
        for (char c : instructions) {
            if (c != '\0') {
            System.out.print(c);
            fileLogger.print(c);
            }
        }
        System.out.println("");
        fileLogger.println("");
        System.out.println("(^:hoch ; >:rechts ; |:runter ; <:links)");
        fileLogger.println("(^:hoch ; >:rechts ; |:runter ; <:links)");
        System.out.println("Die Anweisungsfolge hat eine Laenge von: " + (instructions.length-1));
        fileLogger.println("Die Anweisungsfolge hat eine Laenge von: " + (instructions.length-1));
        }

        fileLogger.println("====================================");
        fileLogger.println("");
        System.out.println("---------------------------------------------------------------------------");

        fileLogger.close();

        if (version == "plates"){
            for (Integer[] p : usedPlats){
                for (Integer i : p){
                    System.out.print(i + " ");
                }
                System.out.println("");
            }
        }
    }

    private static boolean[][] formatInputData_pits(int[][] rawData, int x, int y){
        boolean[][] pits = new boolean[x][y];

        for (int[] d : rawData){
            pits[d[0]][d[1]] = true;
        }

        return pits;
    }

    private static boolean[][] formatInputData_v(int[][] rawData, int x, int y){
        boolean[][] wall_v = new boolean[x][y];

        for(int iy = 0; iy < y; iy++){
            for(int ix = 0; ix < x-1; ix++){
                if (rawData[iy][ix] == 1){
                    wall_v[ix][iy] = true;
                } else if(rawData[iy][ix] == 0){
                    wall_v[ix][iy] = false;
                }
            }
        }
        for(int i = 0; i < y; i++){
            wall_v[x-1][i] = true;
        }

        return wall_v;
    }

    private static boolean[][] formatInputData_h(int[][] rawData, int x, int y){
        boolean[][] wall_h = new boolean[x][y];

        for(int iy = 0; iy < y-1; iy++){
            for(int ix = 0; ix < x; ix++){
                if (rawData[iy][ix] == 1){
                    wall_h[ix][iy] = true;
                } else if(rawData[iy][ix] == 0){
                    wall_h[ix][iy] = false;
                }
            }
        }
        for(int i = 0; i < x; i++){
            wall_h[i][y-1] = true;
        }

        return wall_h;
    }

    private static int[][][] processPitCoordinates(String dateipfad, int x, int y, int numberOfPits, int startLine, int[][] starts, int maze) {
        int[][][] pitCords = new int[x][y][3];

        for (int[] l : FileReaderx.readToInt2DArray(dateipfad, startLine, startLine + numberOfPits)){
            if (l.length > 4){
                pitCords[l[0]][l[1]][0] = l[2];
                pitCords[l[0]][l[1]][1] = l[3];
                pitCords[l[0]][l[1]][2] = l[4];
            }else if (l.length > 2){
                pitCords[l[0]][l[1]][0] = l[2];
                pitCords[l[0]][l[1]][1] = l[3];
                pitCords[l[0]][l[1]][2] = 0;
            }else {
                pitCords[l[0]][l[1]][0] = starts[maze][0];
                pitCords[l[0]][l[1]][1] = starts[maze][1];
                pitCords[l[0]][l[1]][2] = 0;
            }
        }
    
        return pitCords;
    }

    private static void formatPlates(int[] line, boolean[][] plates, int[][][] plateCordsAction) {
        plates[line[1]][line[2]] = true;
        plateCordsAction[line[1]][line[2]][0] = line[3];
        plateCordsAction[line[1]][line[2]][1] = line[4];
        plateCordsAction[line[1]][line[2]][2] = line[5];
        plateCordsAction[line[1]][line[2]][3] = line[6];
    }
}
