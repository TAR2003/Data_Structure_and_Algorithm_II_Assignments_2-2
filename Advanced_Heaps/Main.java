import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        binomialHeap b = new binomialHeap();
        while (true)
        {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            String command = st.nextToken();
            if (command.equalsIgnoreCase("I"))
            {
                String temp = st.nextToken();
                int key = Integer.parseInt(temp);
                assert b != null;
                b.insert(key);
            }
            else if (command.equalsIgnoreCase("F"))
            {
                assert b != null;
                heapNode h = b.findMin();
                if(h != null) bw.write("Find-Min returned " + h.getValue() + "\n");
            }
            else if (command.equalsIgnoreCase("E"))
            {
                assert b != null;
                heapNode h = b.findMin();
                b = b.extractMin();
                bw.write("Extract-Min returned " + h.getValue() + "\n");
            }
            else if(command.equalsIgnoreCase("U")) {
                binomialHeap b2 = new binomialHeap();
                while(st.hasMoreElements()) {
                    int key = Integer.parseInt(st.nextToken());
                    b2.insert(key);

                }

                b = b2.union(b);
            }
            else if (command.equalsIgnoreCase("P"))
            {
                bw.write("Printing Binomial Heap...\n");
                bw.write(b.toString());
            }
        }

        br.close();
        bw.close();
        System.out.println("\n\n--------Process Completed Successfully----------\n");




    }
}