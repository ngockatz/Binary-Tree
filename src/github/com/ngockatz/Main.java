package github.com.ngockatz;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Main<K,E> {
    private static void preorder2(BSTNode<String,Integer> somenode){
        if (somenode==null) {return;}
        System.out.print(somenode.getKey()+" ");
        preorder2(somenode.getLeft());
        preorder2(somenode.getRight());
    }
    private static void inorder2(BSTNode<Integer,String> node){
        if (node==null) {return;}
        inorder2(node.getLeft());
        System.out.print(node.getKey()+" ");
        inorder2(node.getRight());
    }
    private void preorder(BSTNode<K,E> node){
        if (node==null) {return;}
        System.out.print(node.getKey()+" ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    private void inorder(BSTNode<K,E> node){
        if (node==null) {return;}
        inorder(node.getLeft());
        System.out.print(node.getKey()+" ");
        inorder(node.getRight());
    }

    private void postorder(BSTNode<K,E> node){
        if (node==null) {return;}
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getKey()+" ");
    }

    public static void main(String[] args) {
        Main<String,Integer> mainz = new Main<>();
        BSTNode<String,Integer> B = new BSTNode<>(
                "B",1,
                new BSTNode<>("D",2,null,null),
                new BSTNode<>("E",3,null,null)
                );
        BSTNode<String,Integer> C = new BSTNode<>(
                "C",4,
                null,
                new BSTNode<>("F",6,null,null)
        );
        BSTNode<String, Integer> A = new BSTNode<>(
                "A", 0, B, C
        );
        mainz.preorder(A);
        System.out.println();
        mainz.inorder(A);
        System.out.println();
        mainz.postorder(A);
        System.out.println();
        //-------------------

        Random n = new Random();
        //long[] time = new long[25];
        //for (int k=0;k<25;k++) {
            Instant start = Instant.now();
            BST<Integer, String> atree = new BST<>();
            for (int i = 0; i < 100000; i++)
                atree.insert(n.nextInt(100000), " ");
            Instant finish = Instant.now();
        //    time[k] = Duration.between(start,finish).toMillis();
        //}
        atree.insert(-35,"special");
        atree.insert2(-50,"also special");
        String s = atree.remove(-50);
        System.out.println(s);
        System.out.println(atree.find(-50));
        //atree.__deletemin(atree.getRoot());
        //System.out.println(atree.__findmin(atree.getRoot()).getElement());
        //atree.inorder();
        //System.out.println();
        //System.out.println(Arrays.stream(time).sum());
    }
}
