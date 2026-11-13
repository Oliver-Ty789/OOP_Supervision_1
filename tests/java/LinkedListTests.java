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




}
