import data_structures.LinkedList;

public class Algo {

    public static void main(String[] args) {
        VertexRepository vertexRepository = new VertexRepository("src/main/java/test.txt");
        LinkedList<Edge>[] graph = createGraph(vertexRepository.getVertexes().getSize() + 1);
        fillGraph(graph, vertexRepository.getNumVertexesFrom(),
                  vertexRepository.getNumVertexesTo(), vertexRepository.getCapacity());
        System.out.println("Max flow is: " +
                EdmonsKarpAlgo(graph, 0, vertexRepository.getVertexes().getSize() - 1));
    }

    public static LinkedList<Edge>[] createGraph(int nodesCount) {
        LinkedList<Edge>[] graph = new LinkedList[nodesCount];

        for (int i = 0; i < nodesCount; i++)
            graph[i] = new LinkedList<>();

        return graph;
    }

    public static void addEdge(LinkedList<Edge>[] graph, int s, int t, int capacity) {
        graph[s].pushBack(new Edge(s, t, graph[t].getSize(), capacity));
        graph[t].pushBack(new Edge(t, s, graph[s].getSize() - 1, 0));
    }

    public static void fillGraph(LinkedList<Edge>[] graph, int[] vertexFrom,
                                 int[] vertexTo, LinkedList<Integer> capacity) {

        for (int i = 0; i < vertexFrom.length; i++) {
            addEdge(graph, vertexFrom[i], vertexTo[i], capacity.get(i));
        }

    }

    public static int EdmonsKarpAlgo(LinkedList<Edge>[] graph, int s, int t) {

        int maxFlow = 0;
        int[] q = new int[graph.length];

        while (true) {

            int qt = 0;
            q[qt++] = s;
            Edge[] prev = new Edge[graph.length];

            for (int h = 0; h < qt && prev[t] == null; h++) {
                
                int current = q[h];

                for (int i = 0; i < graph[current].getSize(); i++) {
                    if (prev[graph[current].get(i).t] == null 
                            && graph[current].get(i).capacity > graph[current].get(i).f) {
                        prev[graph[current].get(i).t] = graph[current].get(i);
                        q[qt++] = graph[current].get(i).t;
                    }
                }
                
            }
            
            if (prev[t] == null)
                break;
            
            int flow = Integer.MAX_VALUE;
            
            for (int u = t; u != s; u = prev[u].s)
                flow = Math.min(flow, prev[u].capacity - prev[u].f);
            for (int u = t; u != s; u = prev[u].s) {
                prev[u].f += flow;
                graph[prev[u].t].get(prev[u].rev).f -= flow;
            }
            
            maxFlow += flow;
        }
        return maxFlow;
    }
}