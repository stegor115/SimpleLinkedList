//Stephen Gordon
public class LinkedList {
	private class Node{
		private Integer data;
		private Node next;
		private Node prev;
		
		public Node(Integer data){
			this.data = data;
			next = null;
		} //end public Node
	} //end private class Node
	
	private Node head;
	
	public void addBack(Integer data){
		Node w = head;
		Node n = new Node(data);
		System.out.println("Added " + data + " to the back");
		if(head == null){
			head = n;
			return;
		} //end if
		while(w.next != null){
			w = w.next;
		} //end while
		w.next = n;
	} //end addBack method
	
	public void addFront(Integer data){
		Node w = head;
		Node n = new Node(data);
		System.out.println("Added " + data + " to the front");
		if(head == null){
			head = n;
			return;
		} //end if
		n.next = head;
		head = n;
	} //end addFront method
	
	public void print(){
		Node current = head;
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		} //end while
		System.out.println();
	} //end print method
	
	public void remove(Integer nuke){
		Node current = head;
		Node prev = null;
		while(current!= null){
			if(current.data == nuke){ // Once the node that matches the value is found
				System.out.println("Removed " + nuke);
				if(current == head){ // Moves head if remove value is equal to the head
					head = head.next;
				} else{ // Has pointer skip over current, erasing it
					prev.next = current.next;
					break;
				} //end if else
			} else{
				prev = current;
				current = current.next; //Traverse
			} //end else
		} //end while
	} //end remove method
	
	public LinkedList getSublist(Integer pos1, Integer pos2){
		LinkedList newList = new LinkedList();
		Node current = head;
		int realpos = 0;
		
		while(realpos != pos1){
			current = current.next;
			realpos++;
		} //end while
		head = current;
		while(realpos <= pos2){
			newList.addBack(current.data);
			current = current.next;
			realpos++;
		} //end while
		return newList;
	}

	public static void main(String args[]){
		LinkedList banana = new LinkedList();
		banana.addBack(5);
		banana.addBack(3);
		banana.addBack(213);
		banana.addBack(32);
		banana.addBack(3);
		banana.addBack(5);
		banana.addBack(10);
		banana.addBack(7);
		banana.addBack(8);
		banana.addBack(52);
		banana.addBack(51);
		banana.addBack(5);
		banana.addFront(31413132);
		banana.print();
		banana.remove(10);
		banana.print();
		LinkedList oranges = banana.getSublist(0, 3);
		oranges.print();
		banana.print();
		
	} //end main method
} //end class
