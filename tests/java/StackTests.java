package tests.java;

import main.java.Node;
import main.java.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests {

    @Test
    void aNewStackIsEmpty() {
        var stack = new Stack();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getLength());
    }

    @Test
    void pushingANodeAddsItToTheTopOfTheStack() throws Exception {
        var stack = new Stack();
        var node = new Node(5);

        stack.push(node);

        assertFalse(stack.isEmpty());
        assertEquals(1, stack.getLength());
        assertEquals(5, stack.peek());
    }

    @Test
    void peekReturnsTheTopValueWithoutRemovingIt() throws Exception {
        var stack = new Stack();
        stack.push(new Node(5));

        assertEquals(5, stack.peek());
        assertEquals(1, stack.getLength());
        assertEquals(5, stack.peek());
    }

    @Test
    void popReturnsAndRemovesTheTopNode() throws Exception {
        var stack = new Stack();
        stack.push(new Node(5));

        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getLength());
    }

    @Test
    void valuesArePoppedInLastInFirstOutOrder() throws Exception {
        var stack = new Stack();
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(3));

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peekAndPopOnAnEmptyStackThrowAnException() {
        var stack = new Stack();

        assertThrows(Exception.class, stack::peek);
        assertThrows(Exception.class, stack::pop);
    }

}
