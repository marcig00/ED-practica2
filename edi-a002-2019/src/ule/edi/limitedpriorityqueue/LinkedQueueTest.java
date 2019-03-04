package ule.edi.limitedpriorityqueue;

import static org.junit.Assert.*;


import javax.xml.soap.Node;

import org.junit.*;

public class LinkedQueueTest {
	
	private LinkedQueue c1;
	private LinkedQueue c2;
	
	public LinkedQueueTest() {
		
	}
	
	@Before
	public void testBefore() {
	
		c1 = new LinkedQueue<String>();
		c2 = new LinkedQueue<String>();
		
	}
	
	@Test
	public void testSomething() throws Exception {
		
	    assertEquals(c1.isEmpty(), true);
	    assertEquals(c2.isEmpty(), true);
	    assertEquals(c1.size(), 0);
	    assertEquals(c2.size(), 0);
	    assertEquals(c1.toString(), "");
	    assertEquals(c2.toString(), "");
	}
	
	
	@Test
	public void testLinkedQueue() {
	
		assertEquals(c1.isEmpty(), true);
	    assertEquals(c1.size(), 0);
	}

	@Test
	public void testEnqueue() {
		
		String n1 = "A";
		String n2 = "B";
		
		c1.enqueue(n1);
		assertEquals(1, c1.size());
		c1.enqueue(n2);
		assertEquals(2, c1.size());
		
	}

	@Test (expected = NullPointerException.class)
	public void testEnqueueNull() {
	
		 c1.enqueue(null);
		 
	}
	
	@Test
	public void testDequeue() throws EmptyCollectionException {
		
		String n1 = "A";
		c1.enqueue(n1);
		assertEquals(1, c1.size());
		c1.dequeue();	
		assertEquals(0, c1.size());
	
	}
	
	@Test
	public void testDequeueMoreThanOneNode() throws EmptyCollectionException {
		String n1 = "A";
		String n2 = "B";
		c1.enqueue(n1);
		c1.enqueue(n2);
		assertEquals(2, c1.size());
		c1.dequeue();
		assertEquals("B", c1.first());
		
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testDequeueEmpty() throws EmptyCollectionException {
		
		c1.dequeue();
		
	}

	@Test
	public void testFirst() throws EmptyCollectionException {
		
		String n1 = "A";
		c1.enqueue(n1);
		assertEquals(1, c1.size());
		assertEquals("A", c1.first());
		
	}
	
	@Test
	public void testFirstEmpty() throws EmptyCollectionException {
		c1.first();
	}

	@Test
	public void testIsEmptyTrue() {
		Assert.assertEquals(0, c2.size());
		Assert.assertTrue(c2.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() {
		
		String n1 = "A";
		c1.enqueue(n1);
		Assert.assertEquals(1, c1.size());
		Assert.assertFalse(c1.isEmpty());
	}

	@Test
	public void testSize() {
		
		Assert.assertEquals(0, c2.size());
		
	}

	@Test
	public void testDequeueLast() throws EmptyCollectionException {
	
		String n1 = "A";
		String n2 = "B";
		String n3 = "C";
		c1.enqueue(n1);
		c1.enqueue(n2);
		c1.enqueue(n3);
		assertEquals(3, c1.size());
		assertEquals("C", c1.dequeueLast());
		
	}

	
	@Test
	public void testDequeueLastOneNode() throws EmptyCollectionException{
		
		String n1 = "A";
		c1.enqueue(n1);
		assertEquals(1, c1.size());
		assertEquals("A", c1.dequeueLast());
	}
	
	@Test
	public void testDequeueLastEmpty() throws EmptyCollectionException{
	
		c1.dequeueLast();
		
	}

	@Test
	public void testToString() {
		String n1 = "A";
		String n2 = "B";
		c1.enqueue(n1);
		c1.enqueue(n2);
		assertEquals("A, B", c1.toString());
	}

}
