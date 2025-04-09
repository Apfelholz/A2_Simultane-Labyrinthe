public class SimulanteLabyrinthe {
    public static void main(String[] args) throws Exception {
        String dateipfad = "data\\labyrinthe0.txt";

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

        if (one_numberOfPits > 0){
            one_pits = formatInputData_pits(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+1, 1+(y-1)+y-1+1+one_numberOfPits), x, y);
        }

        boolean[][] two_wall_v = new boolean[x][y];
        boolean[][] two_wall_h = new boolean[x][y];

        two_wall_v = formatInputData_v(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+1, 1+(y-1)+y-1+1+one_numberOfPits+y), x, y);
        two_wall_h = formatInputData_h(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+1, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1), x, y);

        int two_numberOfPits = FileReaderx.readLineToInt(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1);
        
        boolean[][] two_pits = new boolean[x][y];

        if(two_numberOfPits > 0){
            two_pits = formatInputData_pits(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+1, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+two_numberOfPits), x, y);
        }

        SyncronDixtra syncronDixtra = new SyncronDixtra(one_wall_v, one_wall_h, one_pits, two_wall_v, two_wall_h, two_pits, x, y);
        String[] Instructions = syncronDixtra.findInstructions(0, 0, 0, 0);

        System.out.println(Instructions.toString());
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
}
