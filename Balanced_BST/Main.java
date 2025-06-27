import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out_avl.txt"));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("report_avl.txt"));

        AVLTree avlTree = new AVLTree();
        bw2.write("operation    time(ms) \n");
        int itr = 0;
        long inserttime = 0, deletetime = 0, searchtime = 0, travtime = 0;
        while(true){
            itr++;
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            String c = (st.nextToken());
            var prev = System.nanoTime();
            //if(avlTree == null) avlTree = new AVLTree();
            //System.out.println(c);
            if(c.equalsIgnoreCase("T")) {
                //. traversal
                bw.write(avlTree.inOrderTraversal());
                var nowtime = System.nanoTime() - prev;
                travtime += nowtime;

            }
            else {
                int element = Integer.parseInt(st.nextToken());
                if(c.equalsIgnoreCase("I")) {
                    //insertion

                    avlTree = avlTree.insert(element);
                    bw.write(avlTree.toString());
                    var nowtime = System.nanoTime() - prev;
                    inserttime += nowtime;

                }
                else if(c.equalsIgnoreCase("D")) {
                    //System.out.println(avlTree.toString());
                    avlTree = avlTree.deletion(element);
                    //System.out.println(avlTree.toString());
                    if(avlTree == null) avlTree = new AVLTree();
                    //System.out.println(element);
                    bw.write(avlTree.toString());
                    var nowtime = System.nanoTime() - prev;
                    deletetime += nowtime;
                    //if(element == 8) return;
                }
                else if(c.equalsIgnoreCase("F")) {
                    // Find
                    if(avlTree.find(element)) bw.write("found");
                    else bw.write("not found");
                    var nowtime = System.nanoTime() - prev;
                    searchtime += nowtime;
                }
               // if(itr>1000) break;
               // System.out.println("elemetn " + element);


            }
            //System.out.println("height == " + avlTree.getHeight() + c );
            //System.out.println(avlTree.toString());
            bw.write('\n');


            }
        var totaltime = inserttime + deletetime + searchtime + travtime;
        bw2.write("insert       " + (String.format("%.10f",inserttime / Math.pow(10,6))) + "\n");
        bw2.write("delete       " + (String.format("%.10f",deletetime / Math.pow(10,6))) + "\n");
        bw2.write("search       " + (String.format("%.10f",searchtime / Math.pow(10,6))) + "\n");
        bw2.write("trav         " + (String.format("%.10f",travtime / Math.pow(10,6))) + "\n");
        bw2.write("total        " + (String.format("%.10f",totaltime / Math.pow(10,6))) + "\n");

        br.close();
        bw.close();
        bw2.close();

        System.out.println("\n\n  ------------- Process finished successfully -------------\n");
    }
}
