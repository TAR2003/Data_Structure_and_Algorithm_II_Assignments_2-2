public class maxFlow {
    public int totalnum, n;
    public String[] names;
    public int[] wins, losses, toPlay;
    public int[][] greatmatrix, prematrix;
    public boolean[] eliminated;


    public maxFlow(int n1, int totalnum1, String []names1, int []wins1, int []loss, int[] toPlay1, int [][]greatM, int[][] premat) {
        n = n1;
        totalnum = totalnum1;
        names = names1;
        wins = wins1;
        losses = loss;
        toPlay = toPlay1;
        greatmatrix = greatM;
        prematrix = premat;
        eliminated = new boolean[n];
        for (int i = 0; i < n; i++) {
            eliminated[i] = fordFulkerson(i);
            //System.out.println(eliminated[i]);
        }

    }

    public boolean fordFulkerson(int vertex) {
        int mostpossibleWin = wins[vertex] + toPlay[vertex];
        int[][] matrix = new int[totalnum][totalnum];
        for (int i = 0; i < totalnum; i++) {
            for (int j = 0; j < totalnum; j++) {
                matrix[i][j] = greatmatrix[i][j];
            }
        }
        int sink = n * n + n + 1;
        int source = sink - 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == vertex || j == vertex) continue;
                matrix[source][(n * i) + j] = prematrix[i][j];
                //matrix[source][n*n + j] = prematrix[i][j];

            }
        }
        int itr = n * n;
        for (int i = 0; itr < (n * n + n); i++) {
            int temp = mostpossibleWin - wins[i];
            matrix[itr][sink] = Math.max(0, temp);
            itr++;
        }

//        for(int i = 0 ; i < totalnum ; i++) {
//            for(int j = 0 ; j < totalnum ; j++) {
//                System.out.print(matrix[i][j] + " ");
//
//            }
//            System.out.println( " after ward " + i);
//        }
//        System.out.println("\nsource\n" + source);


        int[] parents = new int[totalnum];
        int mx = 0;
        while (true) {
            //System.out.println("once 222");
            if (!BFS(parents, matrix)) break;
            int cur = sink;
            int currentflow = Integer.MAX_VALUE;
            while (cur != source) {
                int pr = parents[cur];
                if (matrix[pr][cur] < currentflow) currentflow = matrix[pr][cur];
                cur = pr;
            }
            cur = sink;
            while (cur != source) {
                int pr = parents[cur];
                matrix[pr][cur] -= currentflow;
                matrix[cur][pr] += currentflow;
                cur = pr;
            }
            //System.out.println("IN thek   ");
            mx += currentflow;
        }
        //System.out.println(mx + " for te j " + vertex);
        boolean nirnaok = false;
        for (int i = 0; i < totalnum; i++) {
            if (matrix[source][i] > 0) {
                nirnaok = true;
                //System.out.println("not" + names[vertex]);
                break;
            }
        }
        return nirnaok;

    }

    public boolean BFS(int []p, int[][] m) {
        boolean[] isVisit = new boolean[totalnum];
        for (int i = 0; i < totalnum; i++) isVisit[i] = false;
        queueArr<Integer> q = new queueArr<>(Integer.class, 2);
        q.enqueue(totalnum - 2);
        while (q.length() != 0) {
            int temp = q.dequeue();
            for (int i = 0; i < totalnum; i++) {
                if (m[temp][i] > 0 && !isVisit[i]) {
                    if (i == totalnum - 1) {
                        p[i] = temp;
                        return true;
                    } else {
                        q.enqueue(i);
                        p[i] = temp;
                        isVisit[i] = true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        int[] canwin = new int[n];
        for (int i = 0; i < n; i++) {
            canwin[i] = wins[i] + toPlay[i];
        }
        for (int i = 0; i < n; i++) {
            if (eliminated[i]) {
                ans.append(names[i]);
                ans.append(" is eliminated.\n");
                ans.append("They can win at most ").append(wins[i]).append(" + ").append(toPlay[i]).append(" = ").append(wins[i] + toPlay[i]).append(" games.\n");
                boolean istopalready = false;
                int memory = 0;
                for (int k = 0; k < n; k++) {
                    if (canwin[i] < wins[k]) {
                        istopalready = true;
                        memory = k;
                    }
                }
                if (istopalready) {
                    ans.append(names[memory]).append(" has won a total of ").append(wins[memory]).append(" games.\n");
                    ans.append("They play each other 0 times.\n");
                    ans.append("So on average, each of the teams in this group wins ").append(wins[memory]).append("/1 = ").append(wins[memory]).append(" games.\n");
                } else {
                    int topi = 0;
                    int topj = 0;
                    int toptotal = 0;
                    for (int u = 0; u < n; u++) {
                        for (int v = 0; v < n; v++) {
                            if (u == i || v == i) continue;
                            int temp = wins[u] + wins[v] + prematrix[u][v];
                            if (temp > toptotal) {
                                toptotal = temp;
                                topi = u;
                                topj = v;
                            }
                        }
                    }
                    if (((float) toptotal / 2) > (float) canwin[i]) {
                        ans.append(names[topi]).append(" and ").append(names[topj]).append(" have won a total of ").append(wins[topi] + wins[topj]).append(" games.\n");
                        ans.append("They play each other ").append(prematrix[topi][topj]).append(" times.\n");
                        ans.append("So on average, each of the teams wins ");
                        ans.append(toptotal).append("/").append(2).append(" = ").append((float) toptotal / 2).append(" games.\n");
                    }

                }
                ans.append("\n");


            }

        }
        return ans + "\n";
    }
}
