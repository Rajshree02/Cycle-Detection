

public class SubMatrix {
    int[][] data;

    public SubMatrix(int size) {
        this.data = new int[size][size];
    }

    public int[][] makeGraph(int n,int z,int a, int[][] d) {
    
        for (int row = a, i = 0; i < z; i++, row=(row+1)%n) {
            for (int j = 0, col = a; j < z; j++, col=(col+1)%n) {
                data[i][j] = d[row][col];
            }
        }
        return data;

    }

}
