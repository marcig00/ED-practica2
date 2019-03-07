package ule.edi.limitedpriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


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
		QueueNode<T> aux = first;
		
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
					
				}else { //General
					QueueNode<T> nuevo = new QueueNode<T>(p, element);
					while(aux.next != null ) {
						aux = aux.next;
					}
					if(p == aux.priority) {
						nuevo = aux.next;
						aux.next = nuevo;
					}else {
						
					}
				}
			}
		}
		return returnedElement;
	}

	@Override
	public T first() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
		      // TODO : MOSTRAR LOS ELEMENTOS DE LA COLA DE PRIORIDAD CON EL MISMO FORMATO QUE LA OTRA IMPLEMENTACIÓN
		
			rx.append("]");
			return rx.toString();
		} else {
			return "[]";
		}
	}


  
}
