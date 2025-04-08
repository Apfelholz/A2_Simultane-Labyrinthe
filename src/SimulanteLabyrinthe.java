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

        int[][] one_pits = new int[one_numberOfPits][2];

        if (one_numberOfPits > 0){
            one_pits = FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+1, 1+(y-1)+y-1+1+one_numberOfPits);
        }

        boolean[][] two_wall_v = new boolean[x][y];
        boolean[][] two_wall_h = new boolean[x][y];

        two_wall_v = formatInputData_v(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+1, 1+(y-1)+y-1+1+one_numberOfPits+y), x, y);
        two_wall_h = formatInputData_h(FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+1, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1), x, y);

        int tow_numberOfPits = FileReaderx.readLineToInt(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1);
        
        int[][] tow_pits = new int[tow_numberOfPits][2];

        if(tow_numberOfPits > 0){
            tow_pits = FileReaderx.readToInt2DArray(dateipfad, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+1, 1+(y-1)+y-1+1+one_numberOfPits+y+y-1+1+tow_numberOfPits);
        }
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

        return wall_h;
    }
}
