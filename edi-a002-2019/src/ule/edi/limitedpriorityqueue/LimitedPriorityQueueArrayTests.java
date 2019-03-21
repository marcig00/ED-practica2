package ule.edi.limitedpriorityqueue;

import org.junit.*;
import static org.junit.Assert.*;




public class LimitedPriorityQueueArrayTests {

	
	private LimitedPriorityQueueArrayImpl<String> pq3;
	private LimitedPriorityQueueArrayImpl<String> pq5;
	
	
	public LimitedPriorityQueueArrayTests() {
		

	}
	
	@Before
	public void testBefore() throws Exception{
	    pq3 = new LimitedPriorityQueueArrayImpl<String>(3,2); // limitado a 3 elementos, las posibles prioridades son [1,2]
	    pq5 = new LimitedPriorityQueueArrayImpl<String>(5,3); // limitado a 5 elementos, las posibles prioridades son [1,2,3]

	}
	
	@Test
	
	public void testLimitedPriorityQueueArrayImplTest(){
		
		assertEquals(3, pq3.getCapacity());
		assertEquals(0, pq3.getSize());
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLimitedPriorityQueueArrayImplWrongCapacity() {
		
		LimitedPriorityQueueArrayImpl<String> pq0= new LimitedPriorityQueueArrayImpl<>(0, 1);		
		
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
	public void testIsFullTrue() throws EmptyCollectionException {
		
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
	public void testEnqueueOK() throws EmptyCollectionException{
		
		String n1 = "Namjoon";
		String n2 = "Jin";
		
		assertNull(pq3.enqueue(1, n1));
		assertNull(pq3.enqueue(2, n2));
	}
	
	@Test (expected = NullPointerException.class)
	public void testEnqueueNullElement() throws EmptyCollectionException{
		String n1 = null;
		pq3.enqueue(1, n1);
		
	}
	
	@Test 
	public void testEnqueueFullMayorPrio() throws EmptyCollectionException{
	
		String n1 = "Namjoon";
		String n2 = "Jin";
		String n3 = "Yoongi";
		String n4 = "Hobi";
		
		assertNull(pq3.enqueue(1, n1));
		assertNull(pq3.enqueue(2, n2));
		assertNull(pq3.enqueue(2, n3));
		assertEquals("Yoongi", pq3.enqueue(1, n4));
		assertEquals("[( Priority:1 (Namjoon, Hobi)), ( Priority:2 (Jin))]", pq3.toString());
		
	}
	
	@Test 
	public void testEnqueueNoElementInQueue() throws EmptyCollectionException{
		
		String n1 = "Namjoon";
		String n3 = "Yoongi";
		
		assertNull(pq3.enqueue(1, n1));
		
		assertNull(pq3.enqueue(2, n3));
		
	}
	
	
	
	@Test 
	public void testEnqueueFullMenorPrio() throws EmptyCollectionException{
	
		String n1 = "Namjoon";
		String n2 = "Jin";
		String n3 = "Yoongi";
		String n4 = "Hobi";
		
		assertNull(pq3.enqueue(1, n1));
		assertNull(pq3.enqueue(2, n2));
		assertNull(pq3.enqueue(2, n3));
		assertEquals("Hobi", pq3.enqueue(2, n4));
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEnqueueWrongPrio() throws EmptyCollectionException {
		
		String n1 = "Namjoon";
	
		pq3.enqueue(4455, n1);
		pq3.enqueue(-8, n1);
		pq3.enqueue(0, n1);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEnqueueIsEmpty() throws EmptyCollectionException {
	
		String n1 = "Namjoon";
		String n2 = "Jin";
		String n3 = "Yoongi";
		
		assertNull(pq3.enqueue(1, n1));
		assertNull(pq3.enqueue(1, n2));
		
		assertEquals(null, pq3.enqueue(2, n3));
		
		
	}
	
	@Test
	public void testFirst() throws EmptyCollectionException {
	
		String n1 = "Namjoon";
		String n2 = "Jin";
		
		pq3.enqueue(1, n1);
		pq3.enqueue(2, n2);
		
		assertEquals("Namjoon", pq3.first());
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testFirstEmpty() throws EmptyCollectionException{
		pq3.first();
	}
	
	@Test 
	public void  testDequeue() throws EmptyCollectionException{
		
		String n1 = "Namjoon";
		String n2 = "Jin";
		
		pq3.enqueue(1, n1);
		pq3.enqueue(2, n2);
		assertEquals("Namjoon", pq3.dequeue());
	}
	
	@Test (expected = EmptyCollectionException.class)
	public void  testDequeueEmpty() throws EmptyCollectionException{
		
		pq3.dequeue();
		
	}
	
	
	@Test
	public void testIsEmptyTrue() throws EmptyCollectionException {
		
		assertTrue(pq3.isEmpty());
		assertEquals("[]",pq3.toString() );
		
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
	public void testEnVacia() throws Exception {
		
	    Assert.assertEquals(pq3.isEmpty(), true);
	    Assert.assertEquals(pq3.isFull(), false);
	    Assert.assertEquals(pq3.getSize(), 0);
	    Assert.assertEquals(pq3.toString(), "[]");
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
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
	}

	@Test
	public void testInsertarMenorPrioEnLLena() throws Exception{
	    Assert.assertEquals(pq3.enqueue(1, "Prior1_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_1"), null);
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_2"), null);
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	    Assert.assertEquals(pq3.enqueue(2, "Prior2_3"), "Prior2_3");    // El elemento insertado tiene menor prioridad que los que estaban, por tanto es el que sale
	    Assert.assertEquals(pq3.toString(), "[( Priority:1 (Prior1_1)), ( Priority:2 (Prior2_1, Prior2_2))]");
	  
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
	
	
}
