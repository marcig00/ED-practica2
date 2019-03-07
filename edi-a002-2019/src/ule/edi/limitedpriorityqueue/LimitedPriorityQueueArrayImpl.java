package ule.edi.limitedpriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class LimitedPriorityQueueArrayImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;
	    private int npriorities;
	    private int count;

	    private ArrayList<LinkedQueue<T>> colas;
	
	

	public LimitedPriorityQueueArrayImpl(int capacity, int npriorities) {
		
	  // Crear el arrayList, y añadir una cola por cada una de las prioridades (1..npriorities)
	  // Si capacidad <=0 disparar la excepción: IllegalArgumentException
	
		if(capacity <= 0) {
			
			throw new IllegalArgumentException();
			
		}else {
			
			this.capacity = capacity;
			this.npriorities = npriorities;
			this.count = 0;
			colas = new ArrayList<LinkedQueue<T>>();
			
			for(int i = 0; i < npriorities; i++) {
				colas.add(new LinkedQueue<T>());
			}
		}		
	}
	

    @Override
    public int getCapacity() {
    	
		return capacity;
    	
    }

    @Override
    public int getSize() {
    	return count;
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
		if(element == null) {
			throw new NullPointerException();
		}else {
			if(p <= 0 || p > npriorities) {	
				throw new IllegalArgumentException();
		
			}else if(isFull() == true) {
				colas.get(p-1).enqueue(element); //insertar element en su lugar de la cola
				count++;
				for(int i = npriorities-1; i >= 0; i--) {
					if(colas.get(i).isEmpty() != true) {
						returnedElement =  colas.get(i).dequeueLast(); //eliminar el elemento que lleva menos esperando en todo el arraylist
						count--;
						return returnedElement;
					}
				}	
			}else {
				colas.get(p-1).enqueue(element);
				count++;
			}
		}
		return returnedElement;
	}


	@Override
	public T first() throws EmptyCollectionException {
		
		T firstElement = null;
		if(getSize() <= 0) {
			throw new EmptyCollectionException("LimitedPriorityQueueArrayImpl");
		}else {
			for(int i = 0; i < npriorities-1; i ++) {
				if(colas.get(i).isEmpty() != true) {
				
					firstElement = colas.get(i).first();
				}
			}
		}
		return firstElement;
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		
		T returnedElement = null;
		
		if(isEmpty() == true) {
			throw new EmptyCollectionException("LimitedPriorityQueueArrayImpl");
		}else {
			for(int i = 0; i < npriorities-1; i++) {
				if(colas.get(i).isEmpty() != true) {
					returnedElement = colas.get(i).dequeue();
				}
			}
		}
		return returnedElement;
	}

	@Override
	public boolean isEmpty() {
		return count==0; 
	}

	
	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
			for (int n = 0; n < this.npriorities; ++n) {
				rx.append("( Priority:"+(n+1)+" (");
				rx.append(colas.get(n).toString());
				rx.append(")), ");
			}
			rx.delete(rx.length() - 2, rx.length());
			rx.append("]");
			return rx.toString();
		} else {
			return "[]";
		}
	}

};
  

