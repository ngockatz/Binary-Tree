package github.com.ngockatz;

public class BST<K extends Comparable<? super K> ,E> {
    private BSTNode <K,E> root;
    private int nodecount;

    BST(){
        root=null;
        nodecount=0;
    }

    public void clear(){
        root=null;
        nodecount=0;
    }

    /* insert record to tree */
    public void insert(K akey, E avalue){
        ++nodecount;
        if (root==null) {
            root = new BSTNode<>(akey, avalue);
            return;
        }
        __insert(akey,avalue,root);
    }
    private void __insert(K akey, E avalue, BSTNode<K,E> aroot){
        if (akey.compareTo(aroot.getKey())>=0){
            if (aroot.getRight()==null){
                aroot.setRight(new BSTNode<>(akey,avalue,null,null));
                return;
            }
            __insert(akey,avalue,aroot.getRight());
        }
        else{
            if (aroot.getLeft()==null){
                aroot.setLeft(new BSTNode<>(akey,avalue,null,null));
                return;
            }
            __insert(akey,avalue,aroot.getLeft());
        }
    }
    /* Another way to insert -- return the modified subtree */
    public void insert2(K akey, E avalue){
        root=__insert2(root,akey,avalue);
        nodecount++;
    }
    private BSTNode<K,E> __insert2(BSTNode<K,E> rt, K key, E ele){
        if (rt==null) {return new BSTNode<>(key,ele);}
        if (rt.getKey().compareTo(key)>=0)
            rt.setLeft(__insert2(rt.getLeft(),key,ele));
        else
            rt.setRight(__insert2(rt.getRight(),key,ele));
        return rt;
    }


    /* remove a record based on key */
    public E remove (K akey){
        E temp = find(akey);
        if (temp!=null){
            root= __remove(akey, root);
            --nodecount;
        }
        return temp;
    }
    private BSTNode<K,E> __remove(K akey, BSTNode<K,E> rt){
        if (rt==null) return null;
        if (akey.compareTo(rt.getKey())<0)
            rt.setLeft(__remove(akey, rt.getLeft()));
        else if (akey.compareTo(rt.getKey())>0)
            rt.setRight(__remove(akey, rt.getRight()));
        else{ //found the key
            if (rt.getLeft()==null) return rt.getRight();
            else if (rt.getRight()==null) return rt.getLeft();
            else {//two children
                BSTNode<K,E> temp = __findmin(rt.getRight());
                rt.setElement(temp.getElement());
                rt.setKey(temp.getKey());
                rt.setRight(__deletemin(rt.getRight()));
            }
        }
        return rt;
    }
    /* Helper: find node with minimum key */
    private BSTNode<K,E> __findmin(BSTNode<K,E> rt){
        if (rt.getLeft()==null) return rt;
        return __findmin(rt.getLeft());
    }
    /* Helper: delete node with minimum key from tree */
    private BSTNode<K,E> __deletemin(BSTNode<K,E> rt){
        if (rt.getLeft()==null) return rt.getRight();
        rt.setLeft(__deletemin(rt.getLeft()));
        return rt;
    }

    /* return record based on key */
    public E find (K akey){
        return __find(root,akey);
    }
    private E __find(BSTNode<K,E> rt,K akey){
        if (rt==null) return null;
        if (akey.compareTo(rt.getKey())==0) return rt.getElement();
        if (akey.compareTo(rt.getKey())<0)
            return __find(rt.getLeft(),akey);
        else
            return __find(rt.getRight(),akey);
    }

    public E removeRoot(){
        return remove(root.getKey());
    }

    public void inorder(){
        __inorder(root);
    }
    private void __inorder(BSTNode<K,E> node){
        if (node==null) {return;}
        __inorder(node.getLeft());
        System.out.print(node.getKey()+" ");
        __inorder(node.getRight());
    }

    public void preorder(){
        __preorder(root);
    }
    private void __preorder(BSTNode<K,E> node){
        if (node==null) {return;}
        System.out.print(node.getKey()+" ");
        __preorder(node.getLeft());
        __preorder(node.getRight());
    }

    public void postorder(){
        __postorder(root);
    }
    private void __postorder(BSTNode<K,E> node){
        if (node==null) {return;}
        __postorder(node.getLeft());
        __postorder(node.getRight());
        System.out.print(node.getKey()+" ");
    }

    public BSTNode<K,E> getRoot(){
        return root;
    }

    public int getSize(){return nodecount;}
}
