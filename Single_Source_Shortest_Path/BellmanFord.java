import java.util.Queue;
import java.util.Stack;

public class BellmanFord {
    public graph g;
    public int size;
    public int[] d;
    public int[] parent;
    public boolean aBoolean;
    public int root;
    public int destination;

    public BellmanFord(graph g1, int r, int dest) {
        g = new graph(g1);
        size = g.size;
        d = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            d[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        d[r] = 0;
        root = r;
        destination = dest;
        parent[r] = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < g.edgeArr.size(); j++) {
                Edge tempedge = g.edgeArr.arrlist[j];
                this.RELAX(tempedge.v, tempedge.w, tempedge.weight);

            }
        }
        aBoolean = true;

        for (int j = 0; j < g.edgeArr.size(); j++) {
            Edge tempedge = g.edgeArr.arrlist[j];
            if (d[tempedge.w.value] > (d[tempedge.v.value] + tempedge.weight)) {
                aBoolean = false;
                break;
            }
        }

    }

    public void RELAX(node v, node w, int weight) {
        if (d[v.value] == Integer.MAX_VALUE) return;
        if (w.value == root) return;
        if (d[w.value] > (d[v.value] + weight)) {
            d[w.value] = d[v.value] + weight;
            parent[w.value] = v.value;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Bellman Ford Algorithm:\n");
        if (!aBoolean) return str + "Negative weight cycle present\n\n";
        stackArr<Integer> s = new stackArr<>(Integer.class, 2);
        int ds = destination;
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
