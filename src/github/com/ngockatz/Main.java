package github.com.ngockatz;

import java.util.Random;

public class Main<K, E> {
    void preorder(BSTNode<K, E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getKey() + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    void inorder(BSTNode<K, E> node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getKey() + " ");
        inorder(node.getRight());
    }

    void postorder(BSTNode<K, E> node) {
        if (node == null) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getKey() + " ");
    }

    public static void main(String[] args) {
        Main<String, Integer> mainz = new Main<>();
        /* Create following BST
              A
            /   \
           B     C
         /  \      \
        D    E      F */
        BSTNode<String, Integer> B = new BSTNode<>(
                "B", 1,
                new BSTNode<>("D", 2, null, null),
                new BSTNode<>("E", 3, null, null)
        );
        BSTNode<String, Integer> C = new BSTNode<>(
                "C", 4,
                null,
                new BSTNode<>("F", 6, null, null)
        );
        BSTNode<String, Integer> A = new BSTNode<>(
                "A", 0, B, C
        );
        System.out.print("Preorder: ");
        mainz.preorder(A);
        System.out.println();
        System.out.print("Inorder: ");
        mainz.inorder(A);
        System.out.println();
        System.out.print("Postorder: ");
        mainz.postorder(A);
        System.out.println();
        //-------------------
        Random n = new Random();
        BST<Integer, String> atree = new BST<>();
        for (int i = 0; i < 100; i++)
            atree.insert(n.nextInt(100), "BAM!");

        atree.insert(-35, "special");
        atree.insert2(-50, "more special");
        System.out.println(atree.remove(-50));
        System.out.println("Inorder traversal:");
        atree.inorder();
    }
}
