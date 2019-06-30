package lesson_6;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> { // ??

    private Node<E> root;
    private int size;

    private int maxLevel;

    public TreeImpl() {
        this(0);
    }

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }


    @Override
    public boolean add(E value) {
        Node<E> newNode = new Node<>(value);
        if(isEmpty()) {
            this.root = newNode;
            return true;
        }

        NodeAndParent nodeAndParent = doFind(value);

        if (nodeAndParent.current != null) {
            return false;
        }

        Node<E> parent = nodeAndParent.parent;

        assert parent != null;
        if (parent.shouldBeLeft(value)) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean find(E value) {
        return doFind(value).current != null;
    }

    private NodeAndParent doFind(E value){
        Node<E> parent = null;
        Node<E> current = this.root;

        while ( current != null ){
            if ( current.getValue().equals(value)){
                return new NodeAndParent(current, parent);
            }

            parent = current;
            if ( !current.shouldBeLeft(value) ){
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }
        return new NodeAndParent(null,parent);
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removedNode = nodeAndParent.current;

        if (removedNode == null) {
            return false;
        }

        if (removedNode.isLeaf()){
            removeLeafNode(parent, removedNode);
        } else if (hasOnlySingleChildNode(removedNode)){
            removeNodeWithSingleChild(parent, removedNode);
        }
        else {
            removedCommonNode(parent, removedNode);
        }

        size--;
        return true;
    }

    private void removedCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeft(successor);
        } else {
            parent.setRight(successor);
        }

        successor.setLeft(removedNode.getLeft());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRight();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

        if (successor != removedNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(removedNode.getRight());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node<E> parent, Node<E> removedNode) {
        Node<E> childNode = removedNode.getLeft() != null ? removedNode.getLeft() : removedNode.getRight();
        if (removedNode == root){
            root = childNode;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeft(childNode);
        } else {
            parent.setRight(childNode);
        }
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if (removedNode == root){
            root = null;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }

    private boolean hasOnlySingleChildNode(Node<E> removedNode) {
        return removedNode.getLeft() != null ^ removedNode.getRight() != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void travers(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
                default:
                    throw new IllegalArgumentException("Unknown value: " + mode);
        }
    }

    private void postOrder(Node<E> current) {
        if (current == null){
            return;
        }

        inOrder(current.getLeft());
        inOrder(current.getRight());
        System.out.println(current);
    }

    private void preOrder(Node<E> current) {
        if (current == null){
            return;
        }

        System.out.println(current);
        inOrder(current.getLeft());
        inOrder(current.getRight());
    }

    private void inOrder(Node<E> current) {
        if (current == null){
            return;
        }

        inOrder(current.getLeft());
        System.out.println(current);
        inOrder(current.getRight());
    }

    private class NodeAndParent {
        Node<E> current;
        Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeft());
                    localStack.push(tempNode.getRight());
                    if (tempNode.getLeft() != null || tempNode.getRight() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeft()) &&
                        isBalanced(node.getRight()) &&
                        Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1;
    }

    private int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
}
