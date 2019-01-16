import javax.lang.model.util.ElementScanner6;

// binsry search tree that handles non-duplicate integers only
class BinaryTree {
    BinaryTree left;
    BinaryTree right;
    int value;

    BinaryTree (int v) {
        this.value = v;
    }

    //insertion
    void insert (int v) {
        BinaryTree t = new BinaryTree(v);
        if (v > this.value) {
            if (this.right == null)
                this.right = t;
            else
                this.right.insert(v);
        }
        else {
            if (this.left == null)
                this.left = t;
            else
                this.left.insert(v);
        }
    }

    // get value
    BinaryTree get (int key) {
        if (this.value == key || this == null)
            return this;
        if (key > this.value)
            return this.right.get(key);
        else
            return this.left.get(key);
    }

    // delete
    BinaryTree remove (int key) {
        if (this != null) {
            if (key > this.value)
                this.right = this.right.remove(key);
            else if (key < this.value)
                this.left = this.left.remove(key);
            else if (key == this.value) {
                // if only one or no children of key to delete
                if (this.left == null)
                    return this.right;
                else if (this.right == null)
                    return this.left;
                // else replace with lowest value in right tree (inorder successor)
                this.value = low(this.right);
                this.right = this.right.remove(this.value);
            }
        }
        return this;
    }

    // helper for deleting tree element with 2 children
    int low (BinaryTree bt) {
        while (bt.left != null) {
            bt = bt.left;
        }
        return bt.value;
    }


    // traversals
    void preorder () {
        seePreorder(this);
        System.out.println();
    }
    void seePreorder (BinaryTree bt) {
        if (bt == null)
            return;
        System.out.print(bt.value + " ");
        seePreorder(bt.left);
        seePreorder(bt.right);
    }

    void postorder () {
        seePostorder(this);
        System.out.println();
    }
    void seePostorder (BinaryTree bt) {
        if (bt == null)
            return;
        seePostorder(bt.left);
        seePostorder(bt.right);
        System.out.print(bt.value + " ");
    }

    void inorder () {
        seeInorder(this);
        System.out.println();
    }
    void seeInorder (BinaryTree bt) {
        if (bt == null)
            return;
        seeInorder(bt.left);
        System.out.print(bt.value + " ");
        seeInorder(bt.right);
    }
}