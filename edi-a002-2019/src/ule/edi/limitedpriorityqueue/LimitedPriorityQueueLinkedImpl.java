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
	public T enqueue(int p, T element) throws EmptyCollectionException {
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
					simpleEnqueue(p, element);
					returnedElement = deququeLastElement(); //eliminar el elemento que lleva menos esperando en todo el arraylist
					return returnedElement;
									
				}else if(p < first.priority) {//insertar delante de prioridades menores
				
					if(isFull() == false) {
					QueueNode<T> nuevo = new QueueNode<T>(p, element);
					nuevo.next = first;
					first = nuevo;
					count++;
					}else {
						returnedElement = deququeLastElement();
					}
				}else { //General
					simpleEnqueue(p, element);
				}
			}
		}
		return returnedElement;
	}
	private void simpleEnqueue (int p , T element) {
		QueueNode<T> aux = first;
		QueueNode<T> nuevo = new QueueNode<T>(p, element);
		
		while(aux.next != null  && p > aux.next.priority) {
			aux = aux.next;
		}
			nuevo.next = aux.next;
			aux.next = nuevo;
			count++;
		
		
	}
	
	private T deququeLastElement() throws EmptyCollectionException {
		T returnedElement = null;
		QueueNode<T> aux = first;
		
		if(isEmpty() == true) {
			throw new EmptyCollectionException("LimitedPriorityQueueLinkedImpl");
		}else if(getSize() == 1){
			returnedElement = first.content;
			first = null;
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
		
		T firstElement = first.content;
		
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
		QueueNode<T> aux = first;
		int auxPrio = 0;
		
	    if (! this.isEmpty()) {
	    	StringBuffer rx = new StringBuffer();
            rx.append("[");
            while(aux.priority < aux.next.priority) {
            	rx.append("( Priority:"+aux.priority+" (");
            	rx.append(aux.toString());
            	rx.append(")), ");
            	separator = true;
            }
            
            if(separator == true) {
            	  rx.delete(rx.length() - 2,rx.length());

                  rx.append("]");

                  return rx.toString();
            	
            }
        } else {¡

            return "[]";

        }
	}
};
