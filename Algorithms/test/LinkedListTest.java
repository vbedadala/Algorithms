import linkedlist.LinkedList;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by vasant on 1/9/16.
 */
public class LinkedListTest {

    @Test
      public void testAdd() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        assertThat("1 2 3 4", equalTo(ll.asString()));
    }

    @Test
    public void testRemoveMiddle() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.remove(3);
        assertThat("1 2 4", equalTo(ll.asString()));
    }

    @Test
    public void testRemoveLast() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.remove(4);
        assertThat("1 2 3", equalTo(ll.asString()));
    }

    @Test
    public void testRemoveFirst() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.remove(1);
        assertThat("2 3 4", equalTo(ll.asString()));
    }

    @Test
    public void testRemoveEntryWhichDoesNotExit() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.remove(11);
        assertThat("1 2 3 4", equalTo(ll.asString()));
    }

    @Test
    public void testRemoveAndAddOnSingleElementList() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.remove(1);
        ll.insert(3);
        assertThat("3", equalTo(ll.asString()));
    }

    @Test
    public void testReverse() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.reverse();
        assertThat("4 3 2 1", equalTo(ll.asString()));
    }

    @Test
    public void testKthLast() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insert(6);
        ll.insert(7);
        ll.insert(8);
        ll.insert(9);
        ll.insert(10);
        assertThat(6, equalTo(ll.findKthLast(5)));
    }

    @Test
    public void testMiddle() {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);


        assertThat(3, equalTo(ll.mid()));
    }

    @Test
    public void testAddNumbers() {
        LinkedList ll1 = new LinkedList();
        ll1.insert(1);
        ll1.insert(2);
        ll1.insert(3);
        ll1.insert(4);

         LinkedList ll2 = new LinkedList();
        ll2.insert(9);
        ll2.insert(8);
        ll2.insert(1);


        ll2.addNumbers(ll1.getHead(),ll2.getHead());
    }
}
