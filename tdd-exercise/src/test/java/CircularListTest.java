import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    //TODO: test implementation

    CircularList testList;
    private static final int LIST_SIZE = 10;

    @BeforeEach
    public void testBeforeEach(){
        testList = new CircularListImpl();
    }

    private void addTestNumbers(int n){
        for(int i = 0; i < n; i++){
            testList.add(i);
        }
    }

    @Test
    public void testAdd(){
        addTestNumbers(LIST_SIZE);
        assertEquals(LIST_SIZE, testList.size());
    }

    @Test
    public void testEmpty(){
        assertTrue(testList.isEmpty());
        testList.add(0);
        assertFalse(testList.isEmpty());
    }

    @Test
    public void testNext(){
        addTestNumbers(LIST_SIZE);
        for(int i = 0; i < LIST_SIZE; i++){
            assertEquals(Optional.of(i), testList.next());
        }
        assertEquals(Optional.of(0), testList.next());
    }

    @Test
    public void testPrevious(){
        addTestNumbers(LIST_SIZE);
        for(int i = LIST_SIZE-1; i >= 0; i--){
            assertEquals(Optional.of(i), testList.previous());
        }
        assertEquals(Optional.of(LIST_SIZE-1), testList.previous());
    }

    @Test
    public void testReset(){
        addTestNumbers(LIST_SIZE);
        testList.next();
        testList.next();
        testList.reset();
        assertEquals(Optional.of(0), testList.next());
        testList.next();
        testList.next();
        testList.reset();
        assertEquals(Optional.of(LIST_SIZE-1), testList.previous());
    }

}
