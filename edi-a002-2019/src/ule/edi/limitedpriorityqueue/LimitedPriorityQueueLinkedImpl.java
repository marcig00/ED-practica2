package ule.edi.limitedpriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import ule.edi.limitedpriorityqueue.LinkedQueue.Node;


public class LimitedPriorityQueueLinkedImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;

	    private QueueNode<T> first;
	    private int count;
	

	private static class QueueNode<E> {
	
		public QueueNode(int priority, E content) {
			this.priority = priority;
			this.content = content;
			this.next = null;
		}
		
		public int priority;
		
		public E content;
		
		public QueueNode<E> next;
	};
	

	
	public LimitedPriorityQueueLinkedImpl(int capacity) {
		
		if(capacity <= 0) {
			
			throw new IllegalArgumentException();
			
		}else {
			this.capacity = capacity;
			this.count = count;
			this.first = first;
		}	
	}
	
  

  
    @Override
    public int getCapacity() {

        return capacity;
    }

    @Override
    public int getSize() {
        return count ;
    }

    @Override
    public boolean isFull() {
    	boolean isFull = false;
    	
    	if(getCapacity() == getSize()) {
    		isFull = true;
    	}
        return isFull;
    	
    }

	@Override
	public T enqueue(int p, T element) {
		T returnedElement = null;
		
		if(element == null) {//Comprobar elemento no nulo
			throw new NullPointerException();
		}else {//Si no es null
			
			if(p <= 0) {//comprobamos que la prioridad sea positiva
				throw new IllegalArgumentException();	
			}else { //si lo es
				if(isEmpty() == true) { //Si esta vacio
					first = new QueueNode<T>(p, element);
					count++;
				}else if( isFull()) {//Si esta llena
					
					if(getSize() == 1) {//un elemento
						try {
						 enqueueElement1(p, element);
						 returnedElement = dequeueLastElement();
						}catch(Exception EmptyCollectionException) {
							
						}
					}else {
						try {
						simpleEnqueue(p, element);
						returnedElement = dequeueLastElement(); //eliminar el elemento que lleva menos esperando en todo el arraylist
						}catch(Exception EmptyCollectionException){
							
						}
					}				
				}else { //General
					if(getSize() == 1) {//un elemento
						 enqueueElement1(p, element);		
					}else {
						simpleEnqueue(p, element);
						
					}
				}
			}
		}
		return returnedElement;
	}
	
	private void enqueueElement1(int p, T element) {
		
		QueueNode<T> nuevo = new QueueNode<T>(p, element);
		 if(p < first.priority) {//Delante del primero
			 nuevo.next = first;
			 first = nuevo;
			
		 }else {
			 first.next = nuevo;
			 nuevo.next = null;
		 }
		 count++;

		
	}
	
	private void simpleEnqueue (int p , T element) {
		QueueNode<T> aux = first;
		QueueNode<T> nuevo = new QueueNode<T>(p, element);
		
		while(aux.next != null  && p >= aux.next.priority) {
			aux = aux.next;
		}
			nuevo.next = aux.next;
			aux.next = nuevo;
			count++;
		
		
	}
	
	private T dequeueLastElement() throws EmptyCollectionException {
		T returnedElement = null;
		QueueNode<T> aux = first;
		
		if(isEmpty() == true) {
			throw new EmptyCollectionException("LimitedPriorityQueueLinkedImpl");
		}else {
			while(aux.next.next != null) {
				aux = aux.next;
			}
			returnedElement = aux.next.content;
			aux.next = null;
		}
		
		count--;
		return returnedElement; 
	}
	
	@Override
	public T first() throws EmptyCollectionException {
		
		T firstElement = null;
		
		if(isEmpty() == true){
			
			throw new EmptyCollectionException("linkedQueue");
			
		}else{
			firstElement = first.content;
		}
		return firstElement;
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		T deququeElement = null;
		
		if(isEmpty() == true) {
			throw new EmptyCollectionException("linkedQueue");
		}else {
		deququeElement = first.content;
		first = first.next;
		count--;
		}
		return deququeElement;
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public String toString() {
		
		boolean separator=false;
		if (! this.isEmpty()) {
			
		QueueNode<T> aux = first; 
		QueueNode<T> aux2 = first.next; 
		
	    	
	    	StringBuffer rx = new StringBuffer();
            rx.append("[");
            
            if(first != null) {//si es primero
            	
        		rx.append("( Priority:"+first.priority+" (");
    			rx.append(first.content.toString());
        		
        	} 
        	
            while(aux != null && aux2 != null) {  
            	
            		
            		if(aux.priority == aux2.priority) {//misma prioridad
            			rx.append(", ");
            			rx.append(aux2.content.toString());
            		}else {
            			rx.append(")), ");
            			rx.append("( Priority:"+aux2.priority+" (");
            			rx.append(aux2.content.toString());
            		}
            		
            		
            	if(aux2.next == null) {
            		rx.append(")), "); 
            	}
            	
            	aux = aux.next;
        		aux2 = aux2.next;
        	
            }
           
            	separator = true;
           
            if(separator == true) {
            	  rx.delete(rx.length() - 2,rx.length());

                  rx.append("]");

                  return rx.toString();
            	
            }
        }
            return "[]";

        
	}
};
