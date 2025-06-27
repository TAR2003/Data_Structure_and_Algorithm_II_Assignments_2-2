public class MatrixMultiplication {
    int[][] ans;
    graph g;

    public MatrixMultiplication(graph g1) {
        g = new graph(g1);
        int[][] M = new int[g.size][g.size];
        for (int i = 0; i < g.size; i++) {
            for (int j = 0; j < g.size; j++) {
                M[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < g.edgeArr.size(); i++) {
            M[g.edgeArr.arrlist[i].v.value][g.edgeArr.arrlist[i].w.value] = g.edgeArr.arrlist[i].weight;
        }
        for (int i = 0; i < g.size; i++) {
            M[i][i] = 0;
        }
        ans = APSP(M);

    }

    public int[][] APSP(int[][] M) {
        int[][] L = M;
        for (int i = 1; i < g.size - 1; i*=2) {
            L = ESP(L);
        }
        return L;
    }

    public int[][] ESP(int[][] L) {
        int[][] newL = new int[g.size][g.size];
        for (int i = 0; i < g.size; i++) {
            for (int j = 0; j < g.size; j++) {
                newL[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < g.size; k++) {
                    if (newL[i][j] == Integer.MAX_VALUE) {
                        if (L[i][k] == Integer.MAX_VALUE || L[k][j] == Integer.MAX_VALUE) {
                            newL[i][j] = Integer.MAX_VALUE;
                        } else newL[i][j] = L[i][k] + L[k][j];
                    } else {
                        if (L[i][k] == Integer.MAX_VALUE || L[k][j] == Integer.MAX_VALUE) {

                        } else {
                            if ((newL[i][j]) > (L[i][k] + L[k][j])) {
                                newL[i][j] = L[i][k] + L[k][j];
                            }
                        }

                    }
                }
            }
        }
        return newL;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Shortest Distance Matrix\n");
        for (var i : ans) {
            for (var j : i) {
                if (j == Integer.MAX_VALUE)
                    str.append("INF ");
                else
                    str.append(j).append(" ");
            }
            str.append('\n');
        }
        return str.toString();
    }
}
