import java.util.Arrays;
import java.util.Comparator;

public class binomialHeap {
    private heapNode minNode;
    private linkedList ll;

    public binomialHeap() {
        ll = new linkedList();
        minNode = null;
    }

    public void insert(int key) {
        ll.insert(new heapNode(key));
        balance();

    }

    public void insertNode(heapNode h) {
        ll.insert(h);
        balance();
    }

    private void balance() {
        linkedList temp = ll.next;
        if(temp == null) return;
        while (true) {
            if (temp.next == null) break;
                //System.out.println(temp.next.getH().getOrder());
            else if (temp.next.getH().getOrder() == temp.getH().getOrder()) {
//                System.out.println("here 1st");
//                System.out.println(temp.getH());
//                System.out.println("here 2nd ");
//                System.out.println(temp.next.getH());
                heapNode nr = merge(temp.getH(), temp.next.getH());
//                System.out.println("after operation : ");
//                System.out.println(nr);
                temp.deleteNext();
                ll.size--;
                //System.out.println("Now size " + ll.size);
                temp.setH(nr);
            } else {
                if(temp.next == null) break;
                else temp = temp.next;
            }
        }
        detetmineMin();
    }

    public heapNode findMin() {
        return minNode;
    }

    public void detetmineMin() {
        if (ll.getSize() == 0) minNode = null;
        else {
            //System.out.println(ll.getSize());
            linkedList temp = ll.next;
            //System.out.println(temp.getH());
            int min = ll.next.getH().getValue();
            minNode = ll.next.getH();
            while (temp != null) {
                if (temp.getH().getValue() < min) {
                    min = temp.getH().getValue();
                    minNode = temp.getH();
                }
                temp = temp.next;
            }
        }
    }

    public binomialHeap extractMin() {
        linkedList temp = ll;
        if (minNode == null) return null;
        while (true) {
            if (temp.next.getH() == minNode) {
                temp.deleteNext();
                ll.size--;
                break;
            }
            temp = temp.next;
        }
        //if(ll.next == null) System.out.println("confiremed ");
        heapNode prevmin = minNode;
        int order = minNode.childNode.size();
        heapNode[] ha = new heapNode[order];
        for(int j = 0 ;j < order ; j++) {
            ha[j] = minNode.childNode.arrlist[j];
        }
        binomialHeap b2 = new binomialHeap();
        for (int j = 0; j < order; j++) {
            b2.insertNode(ha[j]);
        }
        b2 = b2.union(this);

        b2.detetmineMin();
        return b2;
    }

    public void union1(binomialHeap b) {
        linkedList t = b.ll.next;
        linkedList cur = ll.next;
        while (t != null) {
            this.insertNode(t.getH());
            t = t.next;
        }

    }
    public binomialHeap union(binomialHeap b) {
        linkedList samel = new linkedList();
        linkedList difl = new linkedList();
        linkedList l1 = this.ll.next;
        linkedList l2 = b.ll.next;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                difl.insert(l2.getH());
                l2 = l2.next;
            }
            else if(l2 == null) {
                difl.insert(l1.getH());
                l1 = l1.next;
            }
            else if(l2.getH().getOrder() == l1.getH().getOrder()) {
                heapNode same = merge(l1.getH(),l2.getH());
                samel.insert(same);
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1.getH().getOrder() < l2.getH().getOrder()) {
                difl.insert(l1.getH());
                l1 = l1.next;
            }
            else {
                difl.insert(l2.getH());
                l2 = l2.next;
            }

        }
        binomialHeap newb = new binomialHeap();
        newb.ll = samel;
        l1 = difl.next;
        while(l1 != null) {
            newb.insertNode(l1.getH());
            l1 = l1.next;
        }
        return newb;
    }

    private heapNode merge(heapNode h1, heapNode h2) {
        heapNode newroot = h2;
        if (h1.getValue() < h2.getValue()) {
            h1.addChild(h2);
            newroot = h1;
        } else h2.addChild(h1);
        return newroot;

    }
    public int totalsize() {
        linkedList l = ll.next;
        int k = 0;
        int sum = 0;
        while(l!=null) {
            k = l.getH().getOrder();
            sum += Math.pow(2, k);
            l = l.next;
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        linkedList temp = ll.next;
        if (ll.getSize() == 0) return "";
        while (temp != null) {
            // int order = temp.getH().getOrder();
            str.append("Binomial Tree, B").append(temp.getH().getOrder());
            str.append('\n');
            str.append(temp.getH().toString());
            temp = temp.next;

        }
        return str.toString();
    }

}

class linkedList {
    public linkedList next, cur;
    public linkedList head;
    private heapNode h;
    public int size;

    public linkedList() {
        head = this;
        size = 0;
        cur = head;
        next = null;
        this.h = null;
    }

    public void add(heapNode h) {
        cur.next = new linkedList();
        cur.next.setH(h);
        size++;
    }

    public void insert(heapNode h) {
        linkedList temp = new linkedList();
        temp.h = h;
        linkedList parent = head;
        linkedList t = head.next;
        //System.out.println(" ------ til now ");
        if (head.next == null) {
            head.next = temp;
            t = temp;
        } else {
            while (true) {
                //System.out.println(t.next.h.getValue() + " h ");
               // System.out.println("now determining " + t.h.getOrder() + " vs " + temp.h.getOrder());
                if (t.h.getOrder() < temp.h.getOrder()) {
                    if(t.next == null) {
                        t.next = temp;
                        temp.next = null;
                        break;
                    }
                    else {
                        t = t.next;
                        parent = parent.next;
                    }
                } else {
                    //System.out.println("surely");
                    temp.next = parent.next;
                    parent.next = temp;
                    break;
                }
            }
        }
        size++;
        //System.out.println("done " + size);
        //System.out.println("insereted " + t.getH().getValue());
        //System.out.println(t.getH());
        //System.out.println(size);
    }

    public void deleteNext() {
        this.next = this.next.next;

    }

    public void setH(heapNode h) {
        this.h = h;
    }

    public heapNode getH() {
        return h;
    }

    public int getSize() {
        return size;
    }
}

class heapNode {
    private int value;
    private int order;
    public arr<heapNode> childNode;

    public heapNode(int value) {
        this.value = value;
        order = 0;
        childNode = new arr<>(heapNode.class, 2);
    }

    public void addChild(heapNode h) {
        childNode.pushback(h);
        increaseOrder();
    }

    public int getOrder() {
        return order;
    }

    public int getValue() {
        return value;
    }

    public void increaseOrder() {
        order++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        heapNode temp = this;
        queueArr<heapNode> q = new queueArr<>(heapNode.class, 2);
        q.enqueue(this);
        str.append("Level 0 : ").append(this.value).append(" ").append('\n');
        //str.append(order ).append(" <- ");
        for (int l = 1; l <= order; l++) {
            str.append("Level ").append(l).append(" : ");
            queueArr<heapNode> q2 = new queueArr<>(heapNode.class, 2);
            while (q.length() > 0) {
                heapNode t = q.dequeue();
                int ord = t.order;
                heapNode[] harr = new heapNode[ord];
                for (int j = 0; j < t.getOrder(); j++) {
                    harr[j] = t.childNode.arrlist[j];
                }
                Arrays.sort(harr, new Comparator<heapNode>() {
                    @Override
                    public int compare(heapNode o1, heapNode o2) {
                        return Integer.compare(o2.getOrder(), o1.getOrder());
                    }
                });
                for(heapNode hp:harr) str.append(hp.value).append(" ");;
                for(heapNode hp:harr) q2.enqueue(hp);
            }

            q = q2;
            str.append('\n');

        }
        return str.toString();
    }
}