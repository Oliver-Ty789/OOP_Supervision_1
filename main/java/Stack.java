package main.java;

public class Stack extends DataStructures{

    // this class contains the head of the
    // stack data structure and all the
    // methods for operations on it
    // extending from DataStructures
    // which has common methods and attributes

    public void push(Node newNode){
        // adds newNode to the head of the stack
        // newNode now points to old head
        newNode.setPointer(headNode);
        headNode = newNode;
    }

    public int pop() throws Exception{
        // pops the headNode off the stack
        // if its empty, return an underflow error

        if (isEmpty()){
            throw new Exception("This Stack is Empty!");
        }
        else{
            // if not empty
            // set next element to the head
            // return old head value
            currentNode = headNode;
            nextNode = currentNode.getPointer();
            headNode = nextNode;
            return currentNode.getValue();
        }
    }

    public int peek() throws Exception{
        // similar to pop
        // but head is not removed,
        // just returned.
        if (isEmpty()){
            throw new Exception("This Stack is Empty!");
        }
        else{
            // if not empty
            // return value of head
            return getHead();
        }
    }

}
