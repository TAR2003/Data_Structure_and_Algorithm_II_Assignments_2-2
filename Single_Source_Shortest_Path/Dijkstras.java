import java.util.PriorityQueue;

public class Dijkstras {
    public graph g;
    public int[] d;
    public int[] parent;
    public boolean[] finished;
    public int root, destination, size;

    public Dijkstras(graph g1, int r, int dest) {
        g = new graph(g1);
        size = g.size;
        for (int i = 0; i < g.edgeArr.size(); i++)
            g.edgeArr.arrlist[i].weight = Math.abs(g.edgeArr.arrlist[i].weight);

        root = r;
        destination = dest;
        finished = new boolean[size];
        parent = new int[size];
        d = new int[size];
        for(int i = 0; i < size ; i++) {
            parent[i] = -1;
            d[i] = Integer.MAX_VALUE;
            finished[i] = false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(root);
        d[root] = 0;
        parent[root] = root;

        while(!pq.isEmpty()) {
            int n = pq.poll();
            finished[n] = true;
            for(int i = 0 ; i < g.nodeArr[n].adjWeightList.size() ; i++) {
                node temp = g.nodeArr[n];
                RELAX(temp, temp.adjWeightList.arrlist[i].w, temp.adjWeightList.arrlist[i].weight);
                if(!finished[temp.adjWeightList.arrlist[i].w.value]) {
                    pq.add(temp.adjWeightList.arrlist[i].w.value);
                }
            }

        }




    }

    public void RELAX(node v, node w, int weight) {
        if (d[w.value] > (d[v.value] + weight)) {
            d[w.value] = d[v.value] + weight;
            parent[w.value] = v.value;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n\nDijkstra Algorithm:\n");
        stackArr<Integer> s = new stackArr<>(Integer.class, 2);
        int ds = destination;
        System.out.println();
        str.append(this.d[ds]).append('\n');
        while (ds != root) {
            s.push(ds);
            ds = parent[ds];
        }
        str.append(root);
        while (s.length() != 0) {
            str.append("->").append(s.pop());
        }
        return str.toString();
    }
}
