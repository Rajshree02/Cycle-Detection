
public class Main {
    public static void main(String[] args) {
        System.out.println("Generating a random no: ");

        int max=10,min=3;
        int n = (int)Math.floor(Math.random()*(max-min+1)+min);
        int matrix[][] = new int[n][n];
        System.out.println("A Matrix of size: " + n + " has been generated\n" + "populate it");

        // Matrix operation
        MatrixOperation m = new MatrixOperation();
        m.populateMatrix(matrix, n);

        CycleDetection cd = new CycleDetection(n);
        System.out.println("::::So Your Current Graph status::::");
        cd.hamCycle(matrix);
        


        for (int z = 3; z < n; z++) {
           int i=0; 
                do{
                    System.out.println("Checking cycle between"+i+"-->"+(i+1)%n+"-->"+(i+2)%n);
                    SubMatrix sb = new SubMatrix(z);
                    System.out.println("Sub Graph is");
                    m.showMatrix(sb.makeGraph(n,z, i, matrix));
                    CycleDetection cd1 = new CycleDetection(z);
                    System.out.println("::::So Your Sub-Graph status::::");
                    if(cd1.hamCycle(sb.makeGraph(n,z, i, matrix))==1)
                    {
                        System.out.println("Cycle between "+i+"-->"+(i+1)%n+"-->"+(i+2)%n+" exists");
                    }
                   
                    i=(i+1)%n;
                   
                }while(i!=0);

            }
        
    }
}

/*
0 1 0 1
1 0 1 1
0 1 0 1
1 1 1 0
 */