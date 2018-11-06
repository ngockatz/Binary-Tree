package github.com.ngockatz;

public class BSTNode<K,E> implements BinaryNodeInterface<E> {
    private K key;
    private E element;
    private BSTNode<K, E> left;
    private BSTNode<K, E> right;

    BSTNode() {
        left = right = null;
    }

    BSTNode(K akey, E avalue) {
        key = akey;
        element = avalue;
    }

    BSTNode(K akey, E avalue, BSTNode<K, E> leftval, BSTNode<K, E> rightval) {
        key = akey;
        element = avalue;
        left = leftval;
        right = rightval;
    }

    @Override
    public E getElement() {
        return element;
    }

    public K getKey() {
        return key;
    }

    @Override
    public void setElement(E avalue) {
        element = avalue;
    }

    public void setKey(K akey) {
        key = akey;
    }

    @Override
    public BSTNode<K, E> getLeft() {
        return left;
    }

    @Override
    public BSTNode<K, E> getRight() {
        return right;
    }

    public void setLeft(BSTNode<K, E> leftval) {
        left = leftval;
    }

    public void setRight(BSTNode<K, E> rightval) {
        right = rightval;
    }

    @Override
    public boolean isLeaf() {
        return left == null && right == null;
    }

}
