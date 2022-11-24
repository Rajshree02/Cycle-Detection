# Cyclic Nature of a graph
## Detecting cyclic nature of a graph and it's all possible subgraphs.

**Problem Statement**
Generate a random number “n” between [5-10], create a matrix of size nxn
Populate the locations with “0” and “1” [the self-loops should be avoided]
Write the program to check and declare:
- Complete graph is cyclic
- Part of the graph is cyclic
- Write the cycle in terms of vertices.

**Logic Applied**
Logic for this question has been divided into 2 parts :
- Extracting all possible subgraphs
- Checking Cyclicity in a graph

So, firstly we check whether the given graph is cyclic in nature or not, for which this code uses Hamiltonian cycle detection algorithm and after which we calculate all possible
subgraphs of that matrix and pass each matrix to the Hamiltonian Algo to check whether cycle exists or not.

**Code Info**
- Language    : Java
- Java classes: 4
    - MatrixOperation.java := Contains Matix related operational functions.
    - CycleDetection.java  := This includes cycle detection algorithm that is Hamiltonian Cycle.
    - SubMatrix.java       := This is a class which is responsible to calculate all sub graphs of a graph.
    - Main.java            := This has the main implementation part.
> Matrix Operation File
```
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
```

> Cycle Detection File
```
public class CycleDetection {
    static int V;
    int path[]={0};
    public CycleDetection(int V) {
        CycleDetection.V=V;
    }
    boolean isSafe(int v, int graph[][], int path[], int pos) {

        if (graph[path[pos - 1]][v] == 0)
            return false;
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
        return true;
    }
    boolean hamCycleUtil(int graph[][], int path[], int pos) {

        if (pos == V) {
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }
        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamCycleUtil(graph, path, pos + 1) == true)
                    return true;
                path[pos] = -1;
            }
        }
        return false;
    }
    int hamCycle(int graph[][]) {
        path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;
        path[0] = 0;
        if (hamCycleUtil(graph, path, 1) == false) {
            System.out.println("\nSolution does not exist");
            return 0;
        }
        printSolution(path);
        return 1;
    }
    void printSolution(int path[]) {
        System.out.println("Solution Exists: Following" +
                " is one Hamiltonian Cycle");
        for (int i = 0; i < V; i++)
            System.out.print(" " + path[i] + " ");
        System.out.println(" " + path[0] + " ");
    }

}

```
> Sub Matrix File
```


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

```

> Main file
```

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

```
##### Test Cases

###### Test Case 1:
> Graph
<img width="209" alt="image" src="https://user-images.githubusercontent.com/96655436/203825187-b85d1640-512f-4438-a6b6-e564448580d8.png">

> Output

<img width="911" alt="image" src="https://user-images.githubusercontent.com/96655436/203823187-2afe990d-f434-44cc-929b-8b22d9e07060.png">
<img width="910" alt="image" src="https://user-images.githubusercontent.com/96655436/203823295-1d13df31-ac02-494f-bfa0-8da54d849782.png">

###### Test Case 2:
>Graph
<img width="242" alt="image" src="https://user-images.githubusercontent.com/96655436/203828067-a2bdd4ce-b212-48d4-9762-f7850c5e9635.png">

>Output

<img width="907" alt="image" src="https://user-images.githubusercontent.com/96655436/203827389-682ece59-a1d7-453b-a24d-244aa47f4d27.png">
<img width="910" alt="image" src="https://user-images.githubusercontent.com/96655436/203827540-22f7a7a6-e3ce-40cc-b700-6716785d7a49.png">
<img width="914" alt="image" src="https://user-images.githubusercontent.com/96655436/203827858-4457f1ac-61f6-4a9c-bcac-e6d3f7c6961a.png">



