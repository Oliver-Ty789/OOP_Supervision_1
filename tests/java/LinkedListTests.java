package tests.java;

import main.java.LinkedList;
import main.java.Node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {

    @Test
    void addNodeToAnEmptyList () throws Exception {
        var list = new LinkedList();
        var node = new Node (5);
        list.add(node);
        assertEquals(node.getValue(), list.getHead());
    }

    @Test
    void isAnEmptyList () throws Exception {
        var list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    void tryingToPopAnEmptyList () throws Exception {
        var list = new LinkedList();

        assertThrows(Exception.class,
                () -> {
            list.pop();
                });
    }

    @Test
    void popANodeFromANonEmptyList () throws Exception {
        var list = new LinkedList();
        var node = new Node (5);
        list.add(node);
        assertEquals(5, list.pop());
    }

    @Test
    void removeANodeFromAnEmptyList () throws Exception {
        var list = new LinkedList();
        var node = new Node (5);

        assertThrows(Exception.class,
                () -> {
            list.remove(node);
                });
    }

    @Test
    void removeANodeFromANonEmptyListToAnEmptyList () throws Exception{
        var list = new LinkedList();
        var node = new Node (5);
        list.add(node);
        list.remove(node);
        assertTrue(list.isEmpty());
    }

    @Test
    void checkLengthOfEmptyList () {
        var list = new LinkedList();
        assertEquals(0, list.getLength());
    }

    @Test
    void checkLengthOfNonEmptyList () {
        var list = new LinkedList();
        var node = new Node (10);
        var node2 = new Node (10);
        list.add(node);
        list.add(node2);
        assertEquals(2, list.getLength());
    }

    @Test
    void find2ndOfNonEmptyList () throws Exception{
        var list = new LinkedList();
        var node = new Node (10);
        var node2 = new Node (15);
        list.add(node);
        list.add(node2);
        assertEquals(15, list.getNth(1));
    }

    @Test
    void find2ndOfEmptyList () throws Exception{
        var list = new LinkedList();
        var node = new Node (10);
        var node2 = new Node (15);

        assertThrows(Exception.class,
                () -> {
            list.getNth(2);
                });
    }

    @Test
    void find8thOfListOf2Items () throws Exception{
        var list = new LinkedList();
        var node = new Node (10);
        var node2 = new Node (15);

        list.add(node);
        list.add(node2);

        assertThrows(Exception.class,
                () -> {
                    list.getNth(8);
                });
    }





}
