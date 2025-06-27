public class kruskal {
    graph g;
    graph answer;


    public kruskal(graph g1) {

        g = new graph(g1);
        g.edgeArr.sortArr();
        answer = new graph(g1.size);
        g.newVisitation();
        for (int i = 0; i < g.edgeArr.size(); i++) {
            Edge tempedge = g.edgeArr.arrlist[i];
            if (tempedge.v.color.equalsIgnoreCase("white") || tempedge.w.color.equalsIgnoreCase("white")) {
                tempedge.v.color = "black";
                tempedge.w.color = "black";
                answer.addEdge(tempedge.v.value, tempedge.w.value, tempedge.weight);
            } else if (!answer.connection(tempedge.v.value, tempedge.w.value)) {
                answer.addEdge(tempedge.v.value, tempedge.w.value, tempedge.weight);
                answer.newVisitation();
            }

        }
    }

    @Override
    public String toString() {
        String str = "Kruskal’s Algorithm:\nTotal weight = ";
        float weight = 0;
        for(int i = 0 ; i < answer.edgeArr.size() ; i++) weight+=answer.edgeArr.arrlist[i].weight;
        str += weight;
        str += '\n';
        for(int i = 0 ; i<answer.edgeArr.size() ; i++) {
            str += answer.edgeArr.arrlist[i].v.value;
            str += " ";
            str += answer.edgeArr.arrlist[i].w.value;
            str += '\n';
        }

        //for (int i = 0; i < answer.size ; i++) System.out.println(answer.parent[i]);

        return str + '\n';
    }
}
