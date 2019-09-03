package Queue;

public class Queue {
	private int maxSize;
	private long[] queueArray;
	private int frontIndex;
	private int rearIndex;
	private int nItem;
	
	public Queue(int size) {
		this.maxSize = size;
		this.queueArray = new long [maxSize];
		frontIndex = 0;
		rearIndex = -1;
		nItem = 0;
	}
	
	public void insert(long data) {
		if (rearIndex == maxSize-1) {
			rearIndex = -1;
			System.out.println("Maximum queue index has been reached and resetting...!");
		}	
		rearIndex ++;
		queueArray[rearIndex] = data;
		nItem ++;
	}
	
	public long remove() {
		int removedIndex = frontIndex;
		frontIndex++;
		//Reset to initial position once reaches to the end of queue.
		if (frontIndex == maxSize) {
			frontIndex = 0;
			System.out.println("Maximum queue index has been reached and resetting...!");
		}
		nItem --;
		System.out.println("Removed " + removedIndex + ":" + queueArray[removedIndex]);
		return queueArray[removedIndex];		
	}

	public boolean isEmpty() {
		return (nItem == 0);
	}
	
	public long peekfrontIndex() {
		return queueArray[frontIndex];
	}
	
	public boolean isFull () {
		return (nItem == maxSize);
	}
	
	public void view() {
		System.out.println("================================================");
		System.out.print("Memory: [ ");
		for (int i=0; i < queueArray.length; i++) {
			System.out.print(queueArray[i]);
			System.out.print(" ");
		}
		System.out.println(" ]");
		System.out.print("Queue: [ ");
		for (int i=frontIndex; i < queueArray.length; i++) {
			System.out.print(queueArray[i]);
			System.out.print(" ");
		}
		System.out.println(" ]");
		System.out.println("Number if items in the queue: " + nItem + "!");
		System.out.println("================================================");
	}
	
}


