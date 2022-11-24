import java.util.Scanner;

public class MatrixOperation {

    Scanner sc=new Scanner(System.in);
    public void populateMatrix(int[][] g,int size) {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
                g[i][j]=sc.nextInt();

        }
    }
    public void showMatrix(int[][] g){
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<g.length;j++)
            System.out.print(g[i][j]+" ");
            System.out.println();
        }

    }

    
}
