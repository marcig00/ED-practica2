package ule.edi.limitedpriorityqueue;

public class LinkedQueue<T> implements QueueADT<T> {
	
	protected static class Node<D> {/*Clase anidada*/
		D element;
		Node<D> next;
		
		Node() {
		this.element = null;
		this.next = null;
		}
		Node(D element) {
		this.element = element;
		this.next = null;
		}
		
		}

	private int count;
	private Node<T> front, rear; 
	
	public LinkedQueue()
	 {
		count = 0;
		front =  null;
		rear = null;
	 } 
	
	@Override
	public void enqueue(T element) {
		
		if(element == null) {
			throw new NullPointerException();
		}else {
			
			if(isEmpty() == true){
				
			Node<T> node = new Node<T>(element);
			front = node;
			rear = node;
			count++;
			
			}else {
				
				Node<T> node1 = new Node<T>(element);
				rear.next = node1;
				rear = node1;
				count++;
				
			}
		}
	}

	@Override
	public T dequeue() throws EmptyCollectionException
	   {
		T aux = null;
		if(isEmpty() == true) {
			throw new EmptyCollectionException("linkedQueue");
		}else {
			
			if(size() == 1) {
				aux = rear.element;
				front = null;
				rear = null;
				count--;
			}else {
				aux = rear.element;
				front = front.next;
				count--;
			}
		}
		return aux;
	   }

	@Override
	public T first()  throws EmptyCollectionException{
		T first = null;
		if(isEmpty() == true){
			
			throw new EmptyCollectionException("linkedQueue");
			
		}else{
			first = front.element;
		}
		return first;
	
		
	}

	@Override
	public boolean isEmpty() {
		 boolean empty = false;
		 
		 if(this.size() == 0) {
			 
			 empty = true;
			 
		 }
		 
		return empty;
	}

	@Override
	public int size() {
		
		return count;
	}

	@Override
	public T dequeueLast() throws EmptyCollectionException {
	  /*
	   * recorrer los elementos hasta que me quede en el penultimo
	   * una aux = front, ir avanzando, hasta que llegue al penultimo. sigueinte = rear. IF(AUX.NEXT == REAR)
	   * AUX.NEXT = NULL
	   * AUX = REAR
	   */
		T deleteElement = null;
		Node<T> aux = new Node<T>();
		aux = front;
		
		if(isEmpty() == true) {
			throw new EmptyCollectionException("linkedQueue");
		}else if(this.size() == 1){

			deleteElement = front.element;
			front = null;
			rear = null;
			return deleteElement;
			
		}else {
		
		
			while(aux.next != rear) {/*Avanzamos hasta que el siguiente del aux sea rear*/
				aux =aux.next; 
			}
			deleteElement = aux.next.element;
			aux.next = null;
			rear = aux;	
			count--;
		}
		return deleteElement;
	}

	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			Node<T> actual=front;
			while (actual!=null) {
				rx.append(actual.element.toString());
				rx.append(", ");
				actual=actual.next;
			}
			rx.delete(rx.length() - 2, rx.length());
			return rx.toString();
		}
		return ""; 


};

}
