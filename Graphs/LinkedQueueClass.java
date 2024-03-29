package lab7_1;

public class LinkedQueueClass<T> implements QueueInterface<T>{
	protected class QueueNode<T>{
		T info;
		QueueNode<T> link;
		
		public QueueNode() {
			info = null;
			link =null;
		}
		
		public QueueNode(T element, QueueNode<T> pointer) {
			info = element;
			link = pointer;
		}
		
		public String toString() {
			return info.toString();
		}
	}
	
	private QueueNode<T> queueFront;
	private QueueNode<T> queueRear;
	
	public LinkedQueueClass() {
		queueFront = null;
		queueRear = null;
	}
	
	public void initializeQueue() {
		queueFront = null;
		queueRear = null;
	}
	
	public boolean isEmptyQueue() {
		return (queueFront == null);
	}
	
	public boolean isFullQueue() {
		return false;
	}
	
	public T front() throws QueueUnderflowException{
		if(isEmptyQueue()) {
			throw new QueueUnderflowException();
		}
		
		return queueFront.info;
	}
	
	public T back() throws QueueUnderflowException{
		if(isEmptyQueue()) {
			throw new QueueUnderflowException();
		}
		
		return queueRear.info;
	}
	
	public void addQueue(T newElement) {
		QueueNode<T> newNode;
		
		newNode = new QueueNode<T>(newElement, null);
		
		if(queueFront == null) {
			queueFront = newNode;
			queueRear = newNode;
		} else {
			queueRear.link = newNode;
			queueRear = queueRear.link;
		}
	}
	
	public void deleteQueue() throws QueueUnderflowException{
		if(isEmptyQueue()) {
			throw new QueueUnderflowException();
		}
		
		queueFront = queueFront.link;
		
		if(queueFront == null) {
			queueRear = null;
		}
	}

}
