import java.util.PriorityQueue;

public class prim {
    public graph g;
    public graph answer;
    public node rootnode = null;

    public prim(graph g1, int root) {
        g = new graph(g1);
        this.rootnode = g.nodeArr[root];
        answer = new graph(g.size);
        PriorityQueue<Edge> pqueue = new PriorityQueue<>();

        for (int i = 0; i < g.size; i++) {
            g.nodeArr[i].visit = false;
        }
        g.newVisitation();
        g.makeEdgeFalse();
        rootnode.color = "black";
        for (int i = 0; i < rootnode.adjWeightList.size(); i++) {
            pqueue.add(rootnode.adjWeightList.arrlist[i]);
            rootnode.adjWeightList.arrlist[i].color = "grey";
        }

        while (!pqueue.isEmpty()) {
            Edge tempedge = pqueue.remove();
            tempedge.color = "black";
            if(tempedge.v.color.equalsIgnoreCase("black") && tempedge.w.color.equalsIgnoreCase("black")) {
                continue;
            }
            else {
                answer.addEdge(tempedge.v.value, tempedge.w.value , tempedge.weight);
                if(tempedge.v.color.equalsIgnoreCase("white")) {
                    for(int i  = 0 ; i < tempedge.v.adjWeightList.size();i++) {
                        if(tempedge.v.adjWeightList.arrlist[i].color.equalsIgnoreCase("white")) {
                            pqueue.add(tempedge.v.adjWeightList.arrlist[i]);
                            tempedge.v.adjWeightList.arrlist[i].color = "grey";
                        }
                    }
                }

                if(tempedge.w.color.equalsIgnoreCase("white")) {
                    for(int i  = 0 ; i < tempedge.w.adjWeightList.size();i++) {
                        if(tempedge.w.adjWeightList.arrlist[i].color.equalsIgnoreCase("white")) {
                            pqueue.add(tempedge.w.adjWeightList.arrlist[i]);
                            tempedge.w.adjWeightList.arrlist[i].color = "grey";
                        }
                    }
                }

                tempedge.v.color = "black";
                tempedge.w.color = "black";

            }
        }


    }

    @Override
    public String toString() {
        String str = "Prim-Jarnik Algorithm: \nTotal weight = ";
        float weight = 0;
        for (int i = 0; i < answer.edgeArr.size(); i++) weight += answer.edgeArr.arrlist[i].weight;
        str += weight;
        str += '\n';
        str += "Root node = " + this.rootnode.value + '\n';

        for (int i = 0; i < answer.edgeArr.size(); i++) {
            str += answer.edgeArr.arrlist[i].v.value;
            str += " ";
            str += answer.edgeArr.arrlist[i].w.value;
            str += '\n';
        }

        return str + '\n';
    }

}
