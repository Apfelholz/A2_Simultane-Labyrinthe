public class SimulanteLabyrinthe {
    public static void main(String[] args) throws Exception {
        String dateipfad = args[0];

        int x = 0;
        int y = 0;

        x = FileReaderx.readLineToInt(dateipfad, 0);
        y = FileReaderx.readLineToInt(dateipfad, 1);

        boolean[][] one_wall_v = new boolean[x][y];
        boolean[][] one_wall_h = new boolean[x][y];

        one_wall_v = formatInputData_v(FileReaderx.readToInt2DArray(dateipfad, 2, 2+x-1), x, y);
        one_wall_h = formatInputData_h(FileReaderx.readToInt2DArray(dateipfad, (2+x-1)+1, (2+x-1)+y-1), x, y);

        int one_numberOfPits = FileReaderx.readLineToInt(dateipfad, ((2+x-1)+y-1)+1);

        int[][] one_pits = new int[one_numberOfPits][2];

        one_pits = FileReaderx.readToInt2DArray(dateipfad, (((2+x-1)+y-1)+1)+1, (((2+x-1)+y-1)+1)+1+one_numberOfPits);

        boolean[][] two_wall_v = new boolean[x][y];
        boolean[][] two_wall_h = new boolean[x][y];

        two_wall_v = formatInputData_v(FileReaderx.readToInt2DArray(dateipfad, ((((2+x-1)+y-1)+1)+1+one_numberOfPits)+1, (((((2+x-1)+y-1)+1)+1+one_numberOfPits)+1)+x-1), x, y);
        two_wall_h = formatInputData_h(FileReaderx.readToInt2DArray(dateipfad, ((((((2+x-1)+y-1)+1)+1+one_numberOfPits)+1)+x-1)+1, ((((((2+x-1)+y-1)+1)+1+one_numberOfPits)+1)+x-1)+1+y-1), x, y);

        int tow_numberOfPits = FileReaderx.readLineToInt(dateipfad, (((((((2+x-1)+y-1)+1)+1+one_numberOfPits)+1)+x-1)+1+y-1)+1);

        int[][] tow_pits = new int[tow_numberOfPits][2];

        tow_pits = FileReaderx.readToInt2DArray(dateipfad, ((((((((2+x-1)+y-1)+1)+1+one_numberOfPits)+1)+x-1)+1+y-1)+1)+1, ((((((((2+x-1)+y-1)+1)+1+one_numberOfPits)+1)+x-1)+1+y-1)+1)+1+tow_numberOfPits);

    }

    private static boolean[][] formatInputData_v(int[][] rawData, int x, int y){
        boolean[][] wall_v = new boolean[x][y];

        for(int i = 0; i < )

    }

    private static boolean[][] formatInputData_h(int[][] rawData, int x, int y){

    }
}
