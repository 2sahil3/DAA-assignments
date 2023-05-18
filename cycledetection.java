
import java.util.*;
class cycledetection {

    // No. of vertices
    private int V;

    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    cycledetection(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int x, int y)
    {
        adj[x].add(y);
        adj[y].add(x);
    }

    Boolean isCyclic(int v, Boolean visited[],
                     int parent)
    {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            if (!visited[i]) {
                if (isCyclic(i, visited, v))
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }

    Boolean isCyclic()
    {

        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int u = 0; u < V; u++) {

            if (!visited[u])
                if (isCyclic(u, visited, -1))
                    return true;
        }

        return false;
    }

    public static void main(String args[])
    {

        cycledetection g1 = new cycledetection(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        cycledetection g2 = new cycledetection(5);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}