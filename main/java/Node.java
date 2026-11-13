package main.java;

public class Node {

    // is the element of a linked list

    private int value;
    private Node pointer;

    public Node (int value){
        this.value = value;
        pointer = null;
    }

    public int getValue(){
        return this.value;
    }

    public Node getPointer(){
        return this.pointer;
    }

    public void setPointer(Node newNode){
        this.pointer = newNode;
    }
}
