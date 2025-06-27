import java.io.*;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static int N = 10000;
    public static int markerHash = 1;
    public static int C1 = 29, C2 = 37;
    public static Random random = new Random(91);

    public static void main(String[] args) throws IOException {
        N = findNextPrime(5000);
        markerHash = 1;
        HashTableDoubleHashing h2 = new HashTableDoubleHashing(Main.N);
        HashTableCustomProbing h3 = new HashTableCustomProbing(Main.N);
        //Random random = new Random(91);

        int num = 10000;
        HashTableSeparateChaining h1 = new HashTableSeparateChaining(Main.N);
        String[] all = new String[num];
        int c = 0;
        for (int i = 0; i < num; i++) {
            all[i] = Main.generateString();
            boolean b = true;
            while (true) {
                if (h1.find1(all[i])) {
                    all[i] = Main.generateString();

                } else break;
            }
            h1.insert(all[i], i + 1);
            h2.insert(all[i], i + 1);
            h3.insert(all[i] ,i + 1);
        }

        h2.probs = 0;
        h3.probs = 0;
        h1.probs = 0;
        String [] tst = new String[1000];
        for(int i = 0 ; i < 1000 ; i++) {
            int ind = random.nextInt(N - 1);
            tst[i] = all[ind];
            h2.find(tst[i]);
            h3.find(tst[i]);
            h1.find(tst[i]);
        }
        int[] collarr1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] probarr1 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] collarr2 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] probarr2 = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        collarr1[0] = h1.col;
        collarr1[1] = h2.col;
        collarr1[2] = h3.col;
        probarr1[0] = h1.probs;
        probarr1[1] = h2.probs;
        probarr1[2] = h3.probs;

        markerHash = 2;
        h1  = new HashTableSeparateChaining(N);
        h2 = new HashTableDoubleHashing(N);
        h3 = new HashTableCustomProbing(N);
        for (int i = 0; i < num; i++) {
            h1.insert(all[i], i + 1);
            h2.insert(all[i], i + 1);
            h3.insert(all[i] ,i + 1);
        }
        for(int i = 0 ; i < 1000 ; i++) {
            h2.find(tst[i]);
            h3.find(tst[i]);
            h1.find(tst[i]);
        }
        collarr2[0] = h1.col;
        collarr2[1] = h2.col;
        collarr2[2] = h3.col;
        probarr2[0] = h1.probs;
        probarr2[1] = h2.probs;
        probarr2[2] = h3.probs;

        N = findNextPrime(10000);
        markerHash = 1;
        h1  = new HashTableSeparateChaining(N);
        h2 = new HashTableDoubleHashing(N);
        h3 = new HashTableCustomProbing(N);
        for (int i = 0; i < num; i++) {
            h1.insert(all[i], i + 1);
            h2.insert(all[i], i + 1);
            h3.insert(all[i] ,i + 1);
        }
        for(int i = 0 ; i < 1000 ; i++) {
            int ind = random.nextInt(9999);
            tst[i] = all[ind];
            h2.find(tst[i]);
            h3.find(tst[i]);
            h1.find(tst[i]);
        }
        collarr1[3] = h1.col;
        collarr1[4] = h2.col;
        collarr1[5] = h3.col;
        probarr1[3] = h1.probs;
        probarr1[4] = h2.probs;
        probarr1[5] = h3.probs;

        markerHash = 2;
        h1  = new HashTableSeparateChaining(N);
        h2 = new HashTableDoubleHashing(N);
        h3 = new HashTableCustomProbing(N);
        for (int i = 0; i < num; i++) {
            h1.insert(all[i], i + 1);
            h2.insert(all[i], i + 1);
            h3.insert(all[i] ,i + 1);
        }
        for(int i = 0 ; i < 1000 ; i++) {
            h2.find(tst[i]);
            h3.find(tst[i]);
            h1.find(tst[i]);
        }
        collarr2[3] = h1.col;
        collarr2[4] = h2.col;
        collarr2[5] = h3.col;
        probarr2[3] = h1.probs;
        probarr2[4] = h2.probs;
        probarr2[5] = h3.probs;

        N = findNextPrime(20000);
        markerHash = 1;
        h1  = new HashTableSeparateChaining(N);
        h2 = new HashTableDoubleHashing(N);
        h3 = new HashTableCustomProbing(N);
        for (int i = 0; i < num; i++) {
            h1.insert(all[i], i + 1);
            h2.insert(all[i], i + 1);
            h3.insert(all[i] ,i + 1);
        }
        for(int i = 0 ; i < 1000 ; i++) {
            int ind = random.nextInt(9999);
            tst[i] = all[ind];
            h2.find(tst[i]);
            h3.find(tst[i]);
            h1.find(tst[i]);
        }
        collarr1[6] = h1.col;
        collarr1[7] = h2.col;
        collarr1[8] = h3.col;
        probarr1[6] = h1.probs;
        probarr1[7] = h2.probs;
        probarr1[8] = h3.probs;

        markerHash = 2;
        h1  = new HashTableSeparateChaining(N);
        h2 = new HashTableDoubleHashing(N);
        h3 = new HashTableCustomProbing(N);
        for (int i = 0; i < num; i++) {
            h1.insert(all[i], i + 1);
            h2.insert(all[i], i + 1);
            h3.insert(all[i] ,i + 1);
        }
        for(int i = 0 ; i < 1000 ; i++) {
            int ind = random.nextInt(9999);
            tst[i] = all[ind];
            h2.find(tst[i]);
            h3.find(tst[i]);
            h1.find(tst[i]);
        }
        collarr2[6] = h1.col;
        collarr2[7] = h2.col;
        collarr2[8] = h3.col;
        probarr2[6] = h1.probs;
        probarr2[7] = h2.probs;
        probarr2[8] = h3.probs;


//        for(var v: collarr1) System.out.println(v);
//        System.out.println();
//        for(var v : probarr1) System.out.println(v);
//        System.out.println();
//        for(var v: collarr2) System.out.println(v);
//        System.out.println();
//        for(var v: probarr2) System.out.println(v);
//        System.out.println("\n\n\n\n");


        System.out.println("\n\nFor N' = 5000");
        System.out.print("Hash Table Size    " +  "    Collision Resolution Method   ");
        System.out.print("   #of Collisions for Hash1    " + "   # of Average Probes for Hash1  ");
        System.out.println("   #of Collisions for Hash2   " + "   # of Average Probes for Hash2");
        System.out.print("----------------------------------------------------------------------");
        System.out.print("----------------------------------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.print(findNextPrime(5000) + "                   Chaining                         " );
        System.out.print(collarr1[0] + "                           " + ((float)probarr1[0]/1000) + "                             " );
        System.out.println(collarr2[0] + "                          " + ((float)probarr2[0]/1000) + "                            " );
        System.out.print(findNextPrime(5000) + "                   Double Hashing                   " );
        System.out.print(collarr1[1] + "                           " + ((float)probarr1[1]/1000) + "                            " );
        System.out.println(collarr2[1] + "                          " + ((float)probarr2[1]/1000) + "                            " );
        System.out.print(findNextPrime(5000) + "                   Custom Probing                   " );
        System.out.print(collarr1[2] + "                           " + ((float)probarr1[2]/1000) + "                             " );
        System.out.println(collarr2[2] + "                          " + ((float)probarr2[2]/1000) + "                            " );


        System.out.println("\n\nFor N' = 10000");
        System.out.print("Hash Table Size    " +  "    Collision Resolution Method   ");
        System.out.print("   #of Collisions for Hash1    " + "   # of Average Probes for Hash1  ");
        System.out.println("   #of Collisions for Hash2   " + "   # of Average Probes for Hash2");
        System.out.print("----------------------------------------------------------------------");
        System.out.print("----------------------------------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.print(findNextPrime(10000) + "                  Chaining                         " );
        System.out.print(collarr1[3] + "                           " + ((float)probarr1[3]/1000) + "                             " );
        System.out.println(collarr2[3] + "                          " + ((float)probarr2[3]/1000) + "                            " );
        System.out.print(findNextPrime(10000) + "                  Double Hashing                   " );
        System.out.print(collarr1[4] + "                           " + ((float)probarr1[4]/1000) + "                             " );
        System.out.println(collarr2[4] + "                          " + ((float)probarr2[4]/1000) + "                            " );
        System.out.print(findNextPrime(10000) + "                  Custom Probing                   " );
        System.out.print(collarr1[5] + "                           " + ((float)probarr1[5]/1000) + "                             " );
        System.out.println(collarr2[5] + "                          " + ((float)probarr2[5]/1000) + "                            " );


        System.out.println("\n\nFor N' = 20000");
        System.out.print("Hash Table Size    " +  "    Collision Resolution Method   ");
        System.out.print("   #of Collisions for Hash1    " + "   # of Average Probes for Hash1  ");
        System.out.println("   #of Collisions for Hash2   " + "   # of Average Probes for Hash2");
        System.out.print("----------------------------------------------------------------------");
        System.out.print("----------------------------------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.print(findNextPrime(20000) + "                  Chaining                         " );
        System.out.print(collarr1[6] + "                           " + ((float)probarr1[6]/1000) + "                             " );
        System.out.println(collarr2[6] + "                          " + ((float)probarr2[6]/1000) + "                            " );
        System.out.print(findNextPrime(20000) + "                  Double Hashing                   " );
        System.out.print(collarr1[7] + "                           " + ((float)probarr1[7]/1000) + "                             " );
        System.out.println(collarr2[7] + "                          " + ((float)probarr2[7]/1000) + "                            " );
        System.out.print(findNextPrime(20000) + "                  Custom Probing                   " );
        System.out.print(collarr1[8] + "                           " + ((float)probarr1[8]/1000) + "                             " );
        System.out.println(collarr2[8] + "                          " + ((float)probarr2[8]/1000) + "                            " );

    }


    public static int Hash1(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sum += 37 * sum + c;
            sum += c << 3;
            sum++;
            sum %= N;
        }
        return sum;
    }

    public static int Hash2(String str)
    {
        int sum = 0;
        int marker = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int k = (int) c;
            if (marker == 1) {
                sum += (67 * sum) + k;
                marker = 2;
            } else {
                sum += (411 * sum) + k;
                marker = 1;
            }
            sum %= N;
        }
        if (sum < 0) sum += N;
        return sum;
    }

    public static int Hash(String str) {
        if (markerHash == 1) return Hash1(str);
        else return Hash2(str);
    }

    public static int customHash(String str, int i) {
        int s = (Hash(str) + ((C1 * i * auxHash(str)) % N) + (C2 * i * i) % N) % N;
        if (s < 0) s += N;
        return s;
    }

    public static int doubleHash(String str, int i) {
        int s = (Hash(str) + ((i * auxHash(str)) % N)) % N;
        if (s < 0) s += N;
        return s;
    }


//    public static int hashit(String key) {
//        int hash = 0;
//
//        for (int i = 0; i < key.length(); i++) {
//            hash += key.charAt(i);
//            hash += (hash << 10);
//            hash ^= (hash >> 6);
//        }
//
//        hash += (hash << 3);
//        hash ^= (hash >> 11);
//        hash += (hash << 15);
//
//        return Math.abs(hash) % N;
//    }


    public static int auxHash(String str) {
        return findNextPrime(str.length());
    }


    public static String generateString() {
        //Random random = new Random();
        int l = random.nextInt(5);
        l += 5;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        //System.out.println(alphabet.charAt(0));
        //System.out.println(alphabet.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < l; i++) {
            int randindex = random.nextInt(25);
            char tempchar = alphabet.charAt(randindex);
            stringBuilder.append(tempchar);
        }
        return stringBuilder.toString();
    }

    public static int findNextPrime(int n) {
        n = n++;
        while (true) {
            if (isPrime(n)) break;
            n++;
        }
        return n;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
//    public static void uniqueHashValues () {
//        String[] array = new String[500]
//    }


}

class mapObject {
    public String key;
    public int value;

    public mapObject(String str, int v) {
        key = str;
        value = v;
    }
}
//class generalHashTable {
//    int tableSize;
//    public generalHashTable(int s) {
//        tableSize = s;
//    }
//    public has
//}