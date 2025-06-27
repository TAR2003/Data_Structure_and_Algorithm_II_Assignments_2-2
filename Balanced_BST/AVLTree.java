import java.sql.SQLOutput;

class AVLTree {
    private int value;
    private AVLTree leftchild, rightchild;
    public int height, balance;

    public AVLTree() {
        this.value = -1;
        leftchild = null;
        rightchild = null;
        height = 0;
        balance = 0;
    }

    public AVLTree insert(int item) {
        if (this.value == -1) {
            value = item;

        } else if (item > value) {
            if (rightchild == null) {
                rightchild = new AVLTree();
                rightchild = rightchild.insert(item);
            } else {
                rightchild = rightchild.insert(item);
            }
        } else if (item < value) {
            if (leftchild == null) {
                leftchild = new AVLTree();
                leftchild = leftchild.insert(item);
            } else {
                leftchild = leftchild.insert(item);
            }
        } else {
            return this;
        }
        return this.balanceTree();

    }


    public AVLTree deletion(int item) {
        AVLTree a = this.delete(item);
        if (a != null) a = a.balanceTree();
        return a;
    }

    public AVLTree delete(int item) {
        if (this.value == -1) return this;
        if (item < this.value) {
            if (this.leftchild != null) this.leftchild = this.leftchild.deletion(item);
            return this;
        }
        if (item > this.value) {
            if (this.rightchild != null) this.rightchild = this.rightchild.deletion(item);
            return this;
        }
        AVLTree changedTree;
        if (this.leftchild == null && this.rightchild == null) return null;
        else if (this.rightchild == null) changedTree = this.leftchild;
        else if (this.leftchild == null) changedTree = this.rightchild;
        else {
            AVLTree toDelete = this;
            AVLTree inOrderSuccessor = this.rightchild;
            while (inOrderSuccessor.leftchild != null) {
                inOrderSuccessor = inOrderSuccessor.leftchild;
            }

            int newRootValue = inOrderSuccessor.value;
            //if(this.rightchild.deletion(newRootValue) == null) toDelete.rightchild = null;
            toDelete.rightchild = this.rightchild.deletion(newRootValue);
            toDelete.value = newRootValue;
            changedTree = toDelete;
        }
        return changedTree;

    }

    public boolean find(int item) {
        if (this.value == item) return true;
        if (item > value) {
            if (rightchild == null) {
                return false;
            } else {
                return rightchild.find(item);
            }
        } else {
            if (leftchild == null) {
                return false;
            } else {
                return leftchild.find(item);
            }
        }
    }

    public AVLTree balanceTree() {
        if (this.value == -1) return this;
        this.getHeight();
        //System.out.println(this.value);
        int rootbalance = this.getBalance();
        if (rootbalance > 1) {
            if (this.leftchild.getBalance() >= 0)
                return this.rotateRight();

            if (this.leftchild.getBalance() < 0) {
                this.leftchild = this.leftchild.rotateLeft();
                return this.rotateRight();
            }
        }
        if (rootbalance < -1) {
            if (this.rightchild.getBalance() <= 0)
                return this.rotateLeft();

            if (this.rightchild.getBalance() > 0) {
                this.rightchild = this.rightchild.rotateRight();
                return this.rotateLeft();
            }
        }

        return this;
    }

    public int getBalance() {
        int lefth = 0;
        int righth = 0;
        if (this.leftchild != null) lefth = this.leftchild.height;
        if (this.rightchild != null) righth = this.rightchild.height;
        this.balance = lefth - righth;
        return this.balance;
    }

    public int getHeight() {
        if (this.value == -1) {
            this.height = 0;
        }
        if (this.leftchild == null && this.rightchild == null) {
            this.height = 1;
        } else if (this.leftchild == null) {
            this.height = this.rightchild.getHeight() + 1;
        } else if (this.rightchild == null) {
            this.height = this.leftchild.getHeight() + 1;
        } else
            this.height = Math.max(this.leftchild.getHeight(), this.rightchild.getHeight()) + 1;
        return this.height;
    }

    public AVLTree rotateRight() {
        // System.out.println("right rotate");
        AVLTree treey = this;
        AVLTree treex = treey.leftchild;
        AVLTree treeT = treex.rightchild;
        treex.rightchild = treey;
        treey.leftchild = treeT;
        return treex;
    }

    public AVLTree rotateLeft() {
        // System.out.println("left rotetate");
        AVLTree treex = this;
        AVLTree treey = treex.rightchild;
        AVLTree treeT = treey.leftchild;
        treey.leftchild = treex;
        treex.rightchild = treeT;
        return treey;
    }

//    public String preOrderTraversal() {
//        String s1 = "";
//        String s2 = "";
//        String s3 = "";
//        if (value != -1)
//            s1 = value + " ";
//        else return "Empty Tree";
//        if (leftchild != null)
//            s2 = leftchild.preOrderTraversal();
//        if (rightchild != null) {
//            s3 = rightchild.preOrderTraversal();
//        }
//        return s1 + s2 + s3;
//    }

    public String inOrderTraversal() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        if (leftchild != null)
            s2 = leftchild.inOrderTraversal();
        if (value != -1)
            s1 = value + " ";
        else return "Empty Tree";
        if (rightchild != null) {
            s3 = rightchild.inOrderTraversal();
        }
        return s2 + s1 + s3;
    }

//    public String postOrderTraversal() {
//        String s1 = "";
//        String s2 = "";
//        String s3 = "";
//        if (leftchild != null)
//            s2 = leftchild.postOrderTraversal();
//        if (rightchild != null) {
//            s3 = rightchild.postOrderTraversal();
//        }
//        if (value != -1)
//            s1 = value + " ";
//        else return "Empty Tree";
//        return s2 + s3 + s1;
//    }

    @Override
    public String toString() {
        String s1, s2, s3, s4, s5, s6;
        if (value != -1)
            s1 = value + "";
        else return "";
        s2 = "";
        s3 = "";
        s4 = "";
        s5 = "";
        s6 = "";
        //System.out.print(value + "");
        boolean b = leftchild != null || rightchild != null;
        if (b)
            s2 = "(";
        if (leftchild != null)
            s3 = leftchild.toString();
        if (b)
            s4 = ",";
        if (rightchild != null)
            s5 = rightchild.toString();
        if (b)
            s6 = ")";
        return s1 + s2 + s3 + s4 + s5 + s6;
    }
}