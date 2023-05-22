package engine;

import java.util.ArrayList;

import model.world.Champion;

public class PriorityQueue {

	@SuppressWarnings("rawtypes")
	private Comparable[] elements;
	private int nItems;
	private int maxSize;

	public PriorityQueue(int size) {
		maxSize = size;
		elements = new Comparable[maxSize];
		nItems = 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insert(Comparable item) {

		int i;
		for (i = nItems - 1; i >= 0 && item.compareTo(elements[i]) > 0; i--)
			elements[i + 1] = elements[i];

		elements[i + 1] = item;
		nItems++;
	}

	@SuppressWarnings("rawtypes")
	public Comparable remove() {
		nItems--;
		return elements[nItems];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	@SuppressWarnings("rawtypes")
	public Comparable peekMin() {
		return elements[nItems - 1];
	}

	public int size() {
		return nItems;
	}
	public String toString() {
		ArrayList<Comparable> a=new ArrayList<Comparable>();
		String s="";
		
		while(!this.isEmpty()) {
			s=s+"   "+(((Champion)this.peekMin()).getName());
			a.add(this.remove());
			}
		while(!a.isEmpty()) {
			this.insert((Comparable)a.remove(0));
		}
		return s;
	}
}
