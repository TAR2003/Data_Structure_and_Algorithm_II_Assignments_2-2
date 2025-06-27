public class HashTableDoubleHashing {
    public int N;
    public int size = 0;
    public int probs = 0;
    public int col = 0, noncol = 0;
    public int highestprobe = 0;
    public mapObject[] array;


    public HashTableDoubleHashing(int n) {
        N = n;
        array = new mapObject[N];
        col = 0;

    }

//    public void insert1(String key, int v) {
//        mapObject m = new mapObject(key, v);
//        int index = Main.hashit(key);
//        int i = 0;
//        if (size + 1 > N) return;
//        else size++;
//        if (array[index] == null) {
//            array[index] = m;
//            noncol++;
//            return;
//        } else {
//            while (true) {
//                i++;
//                int index2 = Main.doubleHash(key, i);
//                if (array[index2] == null) {
//                    array[index2] = m;
//                    break;
//                }
//            }
//        }
//        if (i > highestprobe) highestprobe = i;
//        if (i > 0) col++;
//
//    }
//
//    public void delet1e(String key) {
//        if (find1(key)) {
//            int i = 0;
//            while (i <= highestprobe) {
//                int index = Main.doubleHash(key, i);
//                if (array[index] != null) {
//                    if (array[index].key.equals(key)) {
//                        array[index] = null;
//                        size--;
//                        return;
//                    }
//                }
//                i++;
//            }
//        }
//    }
//
//    public int find11(String key) {
//        if (find1(key)) {
//            int i = 0;
//            while (i <= highestprobe) {
//                probs++;
//                int index = Main.doubleHash(key, i);
//                if (array[index] != null) {
//                    if (array[index].key.equals(key)) {
//                        probs += i;
//                        return array[index].value;
//                    }
//                }
//                i++;
//
//            }
//            return -1;
//        } else return -1;
//    }
//
//    public boolean find111(String key) {
//        int i = 0;
//        while (i <= highestprobe) {
//            int index = Main.doubleHash(key, i);
//            if (array[index] != null) {
//                if (array[index].key.equals(key)) {
//                    return true;
//                }
//            }
//            i++;
//
//        }
//        return false;
//    }

    public void print() {
        for (int i = 0; i < N; i++) {
            if (array[i] == null) System.out.println("null");
            else System.out.println(array[i].key + " " + array[i].value);
        }
    }
    public void insert (String key, int v) {
        //System.out.println("till 3 " + size + " totalsize " + N);
        mapObject m = new mapObject(key, v);
        int index = Main.Hash(key);
        if(size + 1 > N) return;
        else size++;
        int i = 0;
        if(array[index] == null) {
            array[index] = m;
            return;
        }
        else {
            while(true) {
                i++;
                int index2 = Main.doubleHash(key,i);
                if(array[index2] == null) {
                    array[index2] = m;
                    break;
                }
            }
        }
        if(i > highestprobe) highestprobe = i;
        col++;

    }
    public void delete (String key) {
        if(find1(key)) {
            int i = 0;
            while(i <= highestprobe) {
                int index = Main.doubleHash(key, i);
                if(array[index] != null) {
                    if(array[index].key.equals(key)) {
                        array[index] = null;
                        size--;
                        return;
                    }
                }
                i++;
            }
        }
    }
    public int find (String key) {
        if(find1(key)) {
            int i = 0;
            while(i <= highestprobe) {

                int index = Main.doubleHash(key, i);
                if(array[index] != null) {
                    if(array[index].key.equals(key)) {
                        probs += i + 1;
                        //System.out.println(i);
                        return array[index].value;
                    }
                }
                i++;

            }
            return -1;
        }
        else {

            return -1;
        }
    }
    public boolean find1(String key) {

        int i  = 0;
        while(i <= highestprobe) {
            int index = Main.doubleHash(key, i);
            if(array[index] != null) {
                if(array[index].key.equals(key)) {
                    return true;
                }
            }
            i++;

        }
        return false;
    }
}
