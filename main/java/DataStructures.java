package main.java;

import java.util.HashSet;

public class DataStructures {

    // the master class of linked list and stack
    // reduces redundant code

    Node headNode = null;
    Node currentNode;
    Node nextNode;

    public boolean isEmpty(){
        // if headNode doesn't point to any node, the list must be empty
        return headNode == null;
    }

    public int getHead() throws Exception {
        // returns the value of the head of the list
        if (isEmpty()){
            throw new Exception("List is empty!");
        }
        else {
            return headNode.getValue();
        }
    }
    public int getLength() {
        // if empty, returns 0
        // else traverses through list until
        // the next element is null
        if (isEmpty()){
            return 0;
        }
        else{
            int acc = 1;
            currentNode = headNode;
            nextNode = currentNode.getPointer();
            while (!(nextNode == null)){
                // traverse til end of the list
                currentNode = nextNode;
                nextNode = currentNode.getPointer();
                acc++;
            }
            // return length
            return acc;
        }
    }

    public int getNth(int n) throws Exception{
        // if its empty, throw exception
        // if element outside range of list, throw an exception
        // else traverse to the nth element (0-based indexing)

        if (isEmpty()){
            throw new Exception("This list is empty!");
        }
        if ((this.getLength() - 1) < n){
            throw new Exception(("This is outside the valid range!"));
        }

        else{
            currentNode = this.headNode;
            nextNode = currentNode.getPointer();
            for (int i = 0; i < n; i++){
                currentNode = nextNode;
                nextNode = currentNode.getPointer();
            }
            // returns the nth value
            return currentNode.getValue();
        }


    }

    public boolean detectCycles() throws Exception {
        // can't detect cycles on an empty list,
        // so throw exception if it's empty
        // using a Hashset, nodes will be added to the set
        // if the Hashset doesn't change after adding a node
        // there must be a cycle, so return true
        // if tail is found, no cycles, therefore return false

        if (isEmpty()) {
            throw new Exception("This list is Empty!");
        } else {
            var nodeSet = new HashSet<Node>() {
            };

            currentNode = headNode;
            nextNode = currentNode.getPointer();

            // loop through nodes until tail is found or cycle
            while (!(nextNode == null)) {
                int previousSize = nodeSet.size();
                nodeSet.add(currentNode);
                // checks if any change to size is made to nodeSet
                if (nodeSet.size() == previousSize) {
                    // cycle is found
                    return true;
                }
                currentNode = nextNode;
                nextNode = currentNode.getPointer();
            }
            // tail is found so return false
            return false;
        }
    }
}
