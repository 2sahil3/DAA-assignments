import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class bfs_dfs_self
{
    public LinkedList<Integer> adjacencyList[];
    public bfs_dfs_self(int v)
    {
        adjacencyList = new LinkedList[v];
        for(int i=0;i<v;i++)
        {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public void insertEdge(int src, int dest)
    {
        adjacencyList[src].add(dest);
        adjacencyList[dest].add(src);
    }
    public void traverse_bfs(int src)
    {
        boolean visited[] = new boolean[adjacencyList.length];

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int parent = q.poll();
            System.out.print(parent);
            for (int i:adjacencyList[parent])
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    q.add(i);
                }
                
            }
            
        }
    }
    public void traverse_dfs(int src)
    {
        boolean visited[] = new boolean[adjacencyList.length];

        Stack<Integer> q = new Stack<>();
        q.add(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int parent = q.pop();
            System.out.print(parent);
            for (int i:adjacencyList[parent])
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    q.add(i);
                }

            }

        }
    }


    public static void main(String[] args) {
        System.out.println("enter number of vertices and edges: \n");
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        bfs_dfs_self graph = new bfs_dfs_self(v);

        System.out.println("Enter edge's source and destination: \n");
        int s,d;
        for(int i=0;i<e;i++)
        {
            s=sc.nextInt();
            d=sc.nextInt();
            graph.insertEdge(s,d);

        }
        System.out.println("BFS Traversal:\n");
        graph.traverse_bfs(0);
        System.out.println("DFS Traversal:\n");
        graph.traverse_dfs(0);

    }
}
