package GraphNew;
import java.util.*;
/**
 *
 * @author @tulkumar
 */
public class adj2Mat {
    private static int V;
    private static LinkedList<Integer> adj[];
    
    public adj2Mat(int v) { //Create of Adjacency List.
        V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;++i){
            adj[i] = new LinkedList<>();
        }
    }
    
    void addEdge(int v,int w){ //Adding Edges to the Adjacency List.
        adj[v].add(w);
        adj[w].add(v);
    }
    
    public static void main(String[] args) {
        adj2Mat g = new adj2Mat(9);
        int grid[][] = new int[V][V]; //Declaration matrix of the size of the number of edges.
        g.addEdge(0, 1);   //Adding edges.
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(0, 7);
        g.addEdge(0, 8);   
  
        
        for(int i=0;i<V;i++){ // Initialization of matrix with 0 in each index.
            for(int j=0;j<V;j++){
                grid[i][j] = 0;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){ // Conversion.
            Iterator<Integer> j = adj[i].listIterator();
            while(j.hasNext()){
                int n = j.next();
                q.add(n);
            }
            while(q.size() != 0){
                int n = q.poll();
                grid[i][n]=1;
                grid[n][i]=1;
            }
        }
        for(int i=0;i<V;i++){ // Print the matrix.
            for(int j=0;j<V;j++){
                 System.out.print(grid[i][j]+" ");  
            }
            System.out.println("");
        }
    }
}
