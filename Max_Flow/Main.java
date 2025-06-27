import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String nm = br.readLine();
        StringTokenizer st1 = new StringTokenizer(nm);
        int n = Integer.parseInt(st1.nextToken());
        String[] names = new String[n];
        int [] wins = new int[n];
        int[] losses = new int[n];
        int[] toPlay = new int[n];
        int[][] prematrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            names[i] = st.nextToken();
            wins[i] = Integer.parseInt(st.nextToken());
            losses[i] = Integer.parseInt(st.nextToken());
            toPlay[i] = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < n ; j++) {
                prematrix[i][j] = Integer.parseInt(st.nextToken());
            }
            //int weight = Integer.parseInt((st.nextToken()));
        }
//        for(int i = 0 ; i < n ; i++) {
//            System.out.println(g1.parent[i]);
//        }
        //tring newstr = br.readLine();
        //StringTokenizer st2 = new StringTokenizer(newstr);
       // int root = Integer.parseInt(st2.nextToken());
        //int dest = Integer.parseInt(st2.nextToken());
       // bw.write((new BellmanFord(g1, root, dest)).toString());
        //bw.write((new Dijkstras(g1, root, dest)).toString());

        int totalnum = n*n + n + 2;
        int[][] greatmatrix = new int[totalnum][totalnum];
        for(int i = 0 ; i < totalnum ; i++) {
            for(int j = 0 ; j < totalnum ; j++) {
                greatmatrix[i][j] = 0;
            }
        }

//        for(int i = 0 ; i < n ; i++) {
//            for(int j = 0 ; j < n ;j++){
//                System.out.print(prematrix[i][j] + " ");
//            }
//            System.out.println();
//        }


        int source = n*n;
        int sink = n*n + 1;
        for (int  i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ;j++) {
                if(prematrix[i][j] > 0) {
                    greatmatrix[(n*i)+j][n*n + i] = Integer.MAX_VALUE;
                    greatmatrix[(n*i)+j][n*n + j] = Integer.MAX_VALUE;
//                    greatmatrix[n*n + i][(n*i)+j] = Integer.MAX_VALUE;
//                    greatmatrix[n*n + j][(n*i)+j] = Integer.MAX_VALUE;
                }
            }
        }

        maxFlow m = new maxFlow(n,totalnum,names, wins, losses, toPlay, greatmatrix, prematrix);
        String answerstring = m.toString();
        bw.write(answerstring);
        br.close();
        bw.close();

        System.out.println("\n\n  ------------- Process finished successfully -------------\n");
    }
}

class Edge implements Comparable<Edge> {
    public node v, w;
    int weight;
    public boolean visit;
    public String color;

    public Edge(node v, node w, int weight) {
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
    public String color;
    public boolean visit;
    public arr<node> adjList = new arr<>(node.class, 2);
    public arr<Edge> adjWeightList = new arr<>(Edge.class, 2);
    public node parent;

    public node(int v) {
        this.value = v;
        this.visit = false;
        this.color = "white";
        //int kj = Integer.MAX_VALUE;

    }

//    public boolean connected(node w) {
//        if (this.visit) return false;
//        this.visit = true;
//        for (int it = 0; it < this.adjList.size(); it++) {
//            node i = this.adjList.arrlist[it];
//            if (i.visit) continue;
//            if (i.value == w.value) return true;
//            boolean b = i.connected(w);
//            if (b) return true;
//
//
//        }
//        return false;
//    }

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

    public void addEdge(int v, int w, int weight) {

        Edge temporary = new Edge(nodeArr[v], nodeArr[w], weight);
        nodeArr[v].adjList.pushback(nodeArr[w]);
        nodeArr[v].adjWeightList.pushback(temporary);
        edgeArr.pushback(temporary);
    }

    public boolean connection(int v, int w) {
//        for (int i = 0; i < this.size; i++) {
//            nodeArr[i].visit = false;
//        }
//        return nodeArr[v].connected(nodeArr[w]);
        if(parent[v] == -1 || parent[w] == -1) return false;
        else return parent[v] == parent[w];

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
