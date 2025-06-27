public class HashTableSeparateChaining {
    public int N;
    public int probs;
    public int col = 0;
    public linkedList ll;
    public linkedList[] array;
    public int size;


    public HashTableSeparateChaining (int n) {
        N = n;
        array = new linkedList[N];
        size = 0;
        probs = 0;
        col = 0;

    }
    public void insert (String key, int v) {
        size++;
        mapObject m = new mapObject(key, v);
        int index = Main.Hash(key);
        if(array[index] == null) array[index] = new linkedList();
        if(array[index].size == 0) {
            array[index].add(m);
            //col++;
           // System.out.println("for 1 " + v + " hash = " + index);
        }
        else {
            array[index].add(m);
            col++;
            //System.out.println(col);
        }


    }
    public void delete (String key) {
        if(!find1(key)) return;
        int index = Main.Hash(key);
        array[index].delete(key);
        size--;
    }
    public int find (String key) {
        //System.out.println("initially " + this.probs);
        int index = Main.Hash(key);
        if(find1(key)) {
            int temp = array[index].find(key);
            this.probs += array[index].probs;
            //System.out.println(this.probs + " " + array[index ].probs);
            array[index].probs = 0;
            return temp;
        }
        else return -1;
    }
    public boolean find1(String key) {
        int index = Main.Hash(key);
        if (array[index] != null) return array[index].isthere(key);
        else return false;
    }


//    public static void main(String[] args) {
//        System.out.println(Main.findNextPrime(20000));
//    }

}

class linkedList  {
    linkedList next;
    linkedList end;
    mapObject value;
    int probs;
    public int size;
    public linkedList () {
        next = null;
        value = null;
        size = 0;
        probs = 0;

    }
    public void add (mapObject m) {
        linkedList l = new linkedList();
        l.value = m;
        l.next = this.next;
        this.next = l;
        size++;
    }
    public boolean isthere(String key) {
        if(size == 0) return false;
        linkedList ll = this.next;
        while(ll != null) {
            if(ll.value.key.equals(key)) return true;
            ll = ll.next;
        }
        return false;
    }
    public int find(String key) {
        linkedList ll = this.next;
        this.probs = 0;
        while(ll != null) {
            this.probs++;
            if(ll.value.key.equals(key)) return ll.value.value;

            ll = ll.next;

        }
        return -1;

    }
    public void delete(String key) {
        linkedList ll = this;
        while(ll.next != null) {
            if(ll.next.value.key.equals(key)) {
                ll.next = ll.next.next;
                return;
            }
        }

    }


}
