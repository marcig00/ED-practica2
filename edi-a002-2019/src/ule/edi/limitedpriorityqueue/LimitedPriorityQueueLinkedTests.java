package ule.edi.limitedpriorityqueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;




public class LimitedPriorityQueueLinkedTests {

	
	private LimitedPriorityQueueLinkedImpl<String> pq3;
	private LimitedPriorityQueueLinkedImpl<String> pq5;
	
	
	public LimitedPriorityQueueLinkedTests() {
		

	}
	
	@Before
	public void testBefore() throws Exception{
	    pq3 = new LimitedPriorityQueueLinkedImpl<String>(3); // limitado a 3 elementos
	    pq5 = new LimitedPriorityQueueLinkedImpl<String>(5); // limitado a 5 elementos

	}
	
	@Test
	public void testSomething() throws Exception {
		
	    Assert.assertEquals(pq3.isEmpty(), true);
	    Assert.assertEquals(pq3.isFull(), false);
	    Assert.assertEquals(pq3.getSize(), 0);
	    Assert.assertEquals(pq3.toString(), "[]");
	}
	
@Test
	
	public void testLimitedPriorityQueueArrayImplTest(){
		
		assertEquals(3, pq3.getCapacity());
		assertEquals(0, pq3.getSize());
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLimitedPriorityQueueArrayImplWrongCapacity() {
		
		LimitedPriorityQueueLinkedImpl<String> pq0= new LimitedPriorityQueueLinkedImpl<>(0);		
		LimitedPriorityQueueLinkedImpl<String> pq1= new LimitedPriorityQueueLinkedImpl<>(-1);		
		
	}
	
	@Test
	public void testGetCapacity() {
		
		assertEquals(5, pq5.getCapacity());
		
	}
	
	@Test
	public void testGetSize() {
		
		//String n1 = "Namjoon";
		//pq3.enqueue(1, n1);
		
		assertEquals(0, pq3.getSize());
		
	}
	
	@Test
	public void testIsFullTrue(){
		
		String n1 = "Namjoon";
		String n2 = "Jin";
		String n3 = "Yoongi";
		
		pq3.enqueue(1, n1);
		pq3.enqueue(1, n2);
		pq3.enqueue(1, n3);
		
		assertEquals(3, pq3.getSize());
		assertTrue(pq3.isFull());
		
	}	
	
	@Test
	public void testIsFullFalse() throws EmptyCollectionException {
		
		String n1 = "Namjoon";
		String n2 = "Jin";
		
		pq3.enqueue(1, n1);
		pq3.enqueue(2, n2);
		
		assertFalse(pq3.isFull());
		
	}	

	@Test
	public void testIsEmptyTrue() throws EmptyCollectionException {
		
		assertTrue(pq3.isEmpty());
		
	}
	
	@Test
	public void testIsEmptyFalse() throws EmptyCollectionException {
		String n1 = "Namjoon";
		String n2 = "Jin";
		
		pq3.enqueue(1, n1);
		pq3.enqueue(2, n2);
		
		assertFalse(pq3.isEmpty());
		
	}

	@Test
	public void testEnqueueOK() throws EmptyCollectionException{
		
		String n1 = "Namjoon";
		String n2 = "Jin";
		String  n3 = "Tae";

		
		assertEquals(null, pq3.enqueue(1, n1));
		assertEquals(null, pq3.enqueue(2, n2));
		assertEquals(null, pq3.enqueue(2, n3));		
		
	}
	
	@Test 
	public void testEnqueueOneElement() throws EmptyCollectionException {
		
		String n1 = "Namjoon";
		String n2 = "Jin";
		LimitedPriorityQueueLinkedImpl<String> pq1= new LimitedPriorityQueueLinkedImpl<>(1);		
		pq1.enqueue(1, n1);
		
		
	}
	
	@Test 
	public void testEnqueueFullListOneElement() throws EmptyCollectionException {
		String n1 = "Hobi";
		String n2 = "Tae";
		LimitedPriorityQueueLinkedImpl<String> pq1 = new LimitedPriorityQueueLinkedImpl<String>(1);
		assertEquals(null, pq1.enqueue(2, n1));
		assertTrue(pq1.isFull());
		
		assertEquals("Hobi", pq1.enqueue(1, n2));
		
	}
	
	@Test 
	public void testEnqueueNullElement() throws EmptyCollectionException{
		String n1 = null;
		pq3.enqueue(1, n1);
		
	}
	
	
	@Test (expected = IllegalArgumentException.class) 
	public void testEnqueueWrongPriority() throws EmptyCollectionException {
		String n1 = "Namjoon";
		pq3.enqueue(-1,n1);
		pq3.enqueue(0, n1);
		
	}
	@Test
	public void testEnqueueFull() throws EmptyCollectionException{
		
		String n1 = "Namjoon";
		String n2 = "Jin";
		String  n3 = "Tae";
		String n4 =  "Yoongi";

		
		assertEquals(null, pq3.enqueue(1, n1));
		assertEquals(null, pq3.enqueue(2, n2));
		assertEquals(null, pq3.enqueue(2, n3));	
		assertEquals("Yoongi", pq3.enqueue(3, n4));
		
	}
	
	@Test
	public void testEnqueueHighPriority() throws EmptyCollectionException{
		String n1 = "Namjoon";
		String n2 = "Jin";
		String  n3 = "Tae";
		String n4 =  "Yoongi";

		
		assertEquals(null, pq3.enqueue(2, n1));
		assertEquals(null, pq3.enqueue(2, n2));
		assertEquals(null, pq3.enqueue(2, n3));	
		
		assertTrue(pq3.isFull());
		assertEquals("Tae", pq3.enqueue(1, n4));
	}
	
	@Test
	public void testDequeue() throws EmptyCollectionException{
		
		String n1 = "Namjoon";
		String n2 = "Jin";
		String  n3 = "Tae";

		
		assertEquals(null, pq3.enqueue(2, n1));
		assertEquals(null, pq3.enqueue(2, n2));
		assertEquals(null, pq3.enqueue(1, n3));	
		assertEquals("Namjoon", pq3.dequeue());
	}

	@Test (expected = EmptyCollectionException.class)
	public void  testDequeueEmpty() throws EmptyCollectionException{
		
		pq3.dequeue();
		
	}
	
	@Test
	public void testFirst() throws EmptyCollectionException{
		String n1 = "Namjoon";
		String n2 = "Jin";
		
		assertEquals(null, pq3.enqueue(2, n1));
		assertEquals(null, pq3.enqueue(2, n2));
		
		assertEquals("Namjoon", pq3.first());
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testFirstEmptyList() throws EmptyCollectionException{
		String n1 = "Namjoon";
		assertTrue(pq3.isEmpty());
		pq3.first();
	}
	@Test
	public void testInsertarHastaLLenar() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 1);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 2);	
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 3);	
	    Assert.assertEquals(pq3.isFull(), true);
	    Assert.assertEquals( "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]" ,pq3.toString());
	  
	}
	@Test
	public void testInsertarMayorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_2"), "Prior2_2");
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1, Prior1_2)), ( Priority:2 (Prior2_1))]");
	  
	}
	
	@Test
	public void testInsertarMenorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 1);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 2);	
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.isEmpty(), false);
	    Assert.assertEquals(pq3.getSize(), 3);	
	    Assert.assertEquals(pq3.isFull(), true);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_3"), "Prior2_3");
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}
}
