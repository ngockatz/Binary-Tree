package github.com.ngockatz;

public interface BinaryNodeInterface<E> {
    E getElement();
    void setElement(E val);

    BinaryNodeInterface<E> getLeft();
    BinaryNodeInterface<E> getRight();

    boolean isLeaf();

}
