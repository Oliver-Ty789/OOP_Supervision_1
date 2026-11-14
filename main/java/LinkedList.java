package main.java;

public class LinkedList {

    // this class contains the start of the linked list
    // and performs all the operations linked to said list

    private Node headNode = null;
    private Node currentNode;
    private Node nextNode;

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

}

