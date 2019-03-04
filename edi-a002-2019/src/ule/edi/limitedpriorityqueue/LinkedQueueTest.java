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
		
	    Assert.assertEquals(c1.isEmpty(), true);
	    Assert.assertEquals(c2.isEmpty(), true);
	    Assert.assertEquals(c1.size(), 0);
	    Assert.assertEquals(c2.size(), 0);
	    Assert.assertEquals(c1.toString(), "");
	    Assert.assertEquals(c2.toString(), "");
	}
	
	
	@Test
	public void testLinkedQueue() {
	
		Assert.assertEquals(c1.isEmpty(), true);
	    Assert.assertEquals(c1.size(), 0);
	}

	@Test
	public void testEnqueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testDequeue() {
		fail("Not yet implemented");
	}

	@Test
	public void testFirst() {
		fail("Not yet implemented");
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
		Assert.assertEquals(1, c2.size());
		Assert.assertFalse(c2.isEmpty());
	}

	@Test
	public void testSize() {
		
		Assert.assertEquals(0, c2.size());
		
	}

	@Test
	public void testDequeueLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
