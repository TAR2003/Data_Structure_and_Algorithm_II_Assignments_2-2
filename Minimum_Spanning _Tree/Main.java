import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter kruskalOutput = new BufferedWriter(new FileWriter("kruskal.txt"));
        BufferedWriter primOutput = new BufferedWriter(new FileWriter("prim.txt"));
        String nm = br.readLine();
        StringTokenizer st1 = new StringTokenizer(nm);
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        graph g1 = new graph(n);
        //arr<element> elementarr = new arr<>(element.class, 2);
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            float weight = Float.parseFloat(st.nextToken());
            g1.addEdge(v, w, weight);
        }
//        for(int i = 0 ; i < n ; i++) {
//            System.out.println(g1.parent[i]);
//        }
        int root = 0;
        kruskalOutput.write((new kruskal(g1)).toString());
        primOutput.write(new prim(g1, root).toString());
        kruskalOutput.close();
        br.close();
        primOutput.close();

        System.out.println("\n\n  ------------- Process finished successfully -------------\n");
    }
}

class Edge implements Comparable<Edge> {
    public node v, w;
    float weight;
    public boolean visit;
    public String color;

    public Edge(node v, node w, float weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
        visit = false;
        color = "white";
    }


    @Override
    public int compareTo(Edge o) {
        if (this.weight < o.weight) return -1;
        else if (this.weight > o.weight) return 1;
        return 0;
    }
}

class node {
    public int value;
    public String color = "white";
    public boolean visit = false;
    public arr<node> adjList = new arr<>(node.class, 2);
    public arr<Edge> adjWeightList = new arr<>(Edge.class, 2);

    public node(int v) {
        this.value = v;
        this.visit = false;
        this.color = "white";

    }

    public boolean connected(node w) {
        if (this.visit) return false;
        this.visit = true;
        for (int it = 0; it < this.adjList.size(); it++) {
            node i = this.adjList.arrlist[it];
            if (i.visit) continue;
            if (i.value == w.value) return true;
            boolean b = i.connected(w);
            if (b) return true;


        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }


}

class graph {
    public String color = "white";

    public node[] nodeArr;
    public arr<Edge> edgeArr = new arr<>(Edge.class, 2);
    public int vertex, edge;
    public int size, edgenum;
    public node root = null;

    public int[] parent;

    public graph(int s) {
        size = s;
        nodeArr = new node[s];
        for (int i = 0; i < nodeArr.length; i++) nodeArr[i] = new node(i);
        vertex = 0;
        parent = new int[s];
        for (int i = 0; i < s; i++) parent[i] = -1;
    }

    public graph(graph g) {
        nodeArr = new node[g.size];
        this.size = g.size;
        parent = new int[this.size];
        for (int i = 0; i < size; i++) parent[i] = -1;
        for (int i = 0; i < nodeArr.length; i++) nodeArr[i] = new node(i);
        for (int i = 0; i < g.edgeArr.size(); i++) {
            this.addEdge(g.edgeArr.arrlist[i].v.value, g.edgeArr.arrlist[i].w.value, g.edgeArr.arrlist[i].weight);
        }


    }

    public void addEdge(int v, int w, float weight) {
        if (v > w) {
            int t = w;
            w = v;
            v = t;
        }
        if(parent[v] == -1 && parent[w] == -1){
            parent[v] = v;
            parent[w] = v;
        }
        else if(parent[v] != -1 && parent[w] != -1) {
            int tw = parent[w];
            for(int i = 0 ; i < size ; i++)
            {
                if(parent[i] == tw) parent[i] = parent[v];
            }
        }
        else if(parent[v] == -1) {
            parent[v] = parent[w];
        }
        else {
            parent[w] = parent[v];
        }
        Edge temporary = new Edge(nodeArr[v], nodeArr[w], weight);
        nodeArr[v].adjList.pushback(nodeArr[w]);
        nodeArr[v].adjWeightList.pushback(temporary);
        nodeArr[w].adjList.pushback(nodeArr[v]);
        nodeArr[w].adjWeightList.pushback(temporary);
        edgeArr.pushback(temporary);
    }

    public boolean connection(int v, int w) {
//        for (int i = 0; i < this.size; i++) {
//            nodeArr[i].visit = false;
//        }
//        return nodeArr[v].connected(nodeArr[w]);
        if(parent[v] == -1 || parent[w] == -1) return false;
        else if (parent[v] == parent[w]) return true;
        else return false;

    }

    public void makeEdgeFalse() {
        for (int i = 0; i < this.edgeArr.size(); i++) {
            edgeArr.arrlist[i].visit = false;
            edgeArr.arrlist[i].color = "white";
        }
    }

    public void newVisitation() {
        for (node i : nodeArr) {
            i.visit = false;
            i.color = "white";
        }

    }


}
