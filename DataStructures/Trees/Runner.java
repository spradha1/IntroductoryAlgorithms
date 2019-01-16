public class Runner {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(10);
        bt.insert(6);
        bt.insert(15);
        bt.insert(12);
        bt.insert(19);
        bt.preorder();
        bt.postorder();
        bt.inorder();

        // search
        System.out.println(bt.get(15).value);

        // add
        bt.insert(18);
        bt.inorder();

        // delete
        bt.remove(18);
        bt.inorder();   
    }
}