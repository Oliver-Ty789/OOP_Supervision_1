package main.java;
import java.util.HashSet;

public class LinkedList extends DataStructures {

    // this class contains the start of the linked list
    // and performs all the operations linked to said list

    public void add(Node newNode){
        // adds a new node to the linked list
        if (this.isEmpty()){
            // if an empty list, make the newNode the head
            this.headNode = newNode;
        }
        else {
            // traverse through list until a null pointer is found
            currentNode = this.headNode;
            nextNode = currentNode.getPointer();
            while (!(nextNode == null)){
                // traverse through list until end of list found
                currentNode = nextNode;
                nextNode = currentNode.getPointer();
            }
            // newNode added at end of list
            currentNode.setPointer(newNode);
        }
    }

    public int pop() throws Exception{
        // traverse til the end of list
        // changes previous node pointer to null
        // so last element can never be reached

        // if is empty throw an exception
        if (this.isEmpty()){
            throw new Exception("List is empty!");
        }

        else{
            // if only the head in list, you cannot traverse
            currentNode = this.headNode;
            if (currentNode.getPointer() == null){
                this.headNode = null;
                // returns the previous head
                return this.currentNode.getValue();
            }
            else{
                nextNode = currentNode.getPointer();
                while (!(nextNode.getPointer() == null)){
                    // traverse until nextNode is the last element
                    currentNode = nextNode;
                    nextNode = currentNode.getPointer();
                }
                // now end of list is found, change current node to end
                currentNode.setPointer(null);
                // return the value of the last element
                return nextNode.getValue();
            }
        }

    }
    public void remove(Node targetNode) throws Exception{
        // traverse til nextNode.value equals targetNode.value
        // changes previous node pointer to nextNode pointer
        // so nextNode can never be reached

        // if targetNode never found, throw exception

        // if is empty throw an exception
        if (isEmpty()){
            throw new Exception("List is empty!");
        }

        else{
            // if only the head in list, you cannot traverse
            currentNode = this.headNode;
            // must check first if the head is the targetNode
            if (currentNode.getValue() == targetNode.getValue()){
                // list now empty
                this.headNode = null;
                return; // leave function
            }

            nextNode = currentNode.getPointer();
            while (!(nextNode == null)){
                // traverse until the end of the list
                if (nextNode.getValue() == targetNode.getValue()) {
                    currentNode.setPointer(nextNode.getPointer());
                    return; // leave function
                }
                // if targetNode not found, check next element
                else {
                    currentNode = nextNode;
                    nextNode = currentNode.getPointer();
                }

            }
            // targetNode never found, so throw exception
            throw new Exception("targetNode not in List!");
        }

    }

}

