public class Main {

    public static void main(String[] args) {
        int i;
        int j;
        int k;
        int incI = 1;
        int incJ = 1;
        int rows = 7;
        int cols = 7;
        int total = rows * cols;

        int[][] I = new int[rows][cols];
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                I[i][j] = 0;
            }
        }
        I[0][0] = 1;
        k = I[0][0] + 1;

        i = 0;
        j = 0;

        while (k <= total) {
            while (true) {
                j += incJ;
                if (!(j >= cols) && !(j < 0) && (i != 0 || j != 0) && (I[i][j] == 0)) {
                    I[i][j] = k;
                    k++;
                } else {
                    j -= incJ;
                    incJ = -incJ;
                    break;
                }
            }
            while (true) {
                i += incI;
                if (!(i >= rows) && !((i < 0)) && (i != 0 || j != 0) && (I[i][j] == 0)) {
                    I[i][j] = k;
                    k++;
                } else {
                    i -= incI;
                    incI = -incI;
                    break;
                }
            }
        }

        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                System.out.print(String.format("%7s", I[i][j]));
            }
            System.out.println();
        }
    }
}