//
//import java.util.*;
//
//class DFS {
//    private int Vtx;
//
//    private LinkedList<Integer> adj[];
//
//    DFS(int vtx)
//    {
//        Vtx = vtx;
//        adj = new LinkedList[vtx];
//
//
//        for (int i = 0; i < vtx; ++i)
//        {
//            adj[i] = new LinkedList();
//        }
//
//
//    }
//
//    void addEdge(int v, int w)
//    {
//        adj[v].add(w);
//    }
//    void Helper(int v, boolean visited[])
//    {
//        visited[v] = true;
//        System.out.print(v + " ");
//
//        Iterator<Integer> i = adj[v].listIterator();
//        while (i.hasNext()) {
//            int n = i.next();
//            if (!visited[n])
//                Helper(n, visited);
//        }
//    }
//    void DFS_graph(int v)
//    {
//        boolean visited[] = new boolean[Vtx];
//
//        Helper(v, visited);
//    }
//
//    public static void main(String args[])
//    {
//        DFS g = new DFS(4);
//
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//
//        System.out.println(
//                "Following is Depth First Traversal "
//                        + "(starting from vertex 2)");
//
//        g.DFS_graph(2);
//    }
//}