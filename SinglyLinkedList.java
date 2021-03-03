class LinkedList{
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next = null;
		}
	}
	
	public void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

    public void insert(int position, int value){
        Node newnode = new Node(value);
        if(position==1) {newnode.next = head; head = newnode;}
        else{
            Node previous = head;
            int count =1;
            while(count<position-1){
                previous = previous.next;
                count++;
            }  
            Node current = previous.next;
            previous.next = newnode;
            newnode.next = current;
        }
    }
	
	public void addFront(int data){
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
	}
	
	public void addBetween(Node previous,int data){
		if(previous == null){
			System.out.println("The given node is null \n Can't insert another");
		}
		Node newnode = new Node(data);
		newnode.next = previous.next;
		previous.next = newnode;
	}

    public void addLast(int data){
        Node newnode = new Node(data);
        if(head==null){
            head = new Node(data);
            return;}
        newnode.next = null;
        Node temp = head;
        while(temp!=null){
            temp=temp.next;
        }
        temp.next = newnode;
        return;
    }
	
    public void deleteKey(int key){
        printList();
        Node temp = head, previous = null;
        if(temp!=null && temp.data==key){
            head = temp.next;
            return;
        }
        while(temp!=null && temp.data!=key){
            previous = temp;
            temp = temp.next;
        }
        if(temp==null) return;
        previous.next = temp.next;
        printList();
    }

    public void deletePosition(int position){
        if(head == null) return;
        Node temp = head;
        if(position == 0){
            head = temp.next;
            return;
        }
        for(int i=0;i<position-1 && temp!=null;i++){
            temp = temp.next;
            if(temp==null || temp.next == null) return;
            Node next = temp.next.next; 
            temp.next = next;
        }
    }

    public void deleteFirstNode(){
        if(head == null) {System.out.println("Empty List"); return;}
        if(head.next == null) {System.out.println(head.data); return;}
        Node temp = head;
        System.out.println(head.data);
        head = temp.next;
        return;
    }

    public void deleteLastNode(){
        if(head==null) {System.out.println("List Empty"); return;}
        if(head.next == null){ System.out.println(head.data); return;}
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        } 
        System.out.println(temp.next.data);
        temp.next = null;
        return;
    }
	
	public boolean find(Node head, int searchkey){
		if(head==null){return false;}
		Node current = head;
		while(current!=null){
			if(current.data==searchkey) {return true;}
			current = current.next;
		}
		return false;
	}
	
	public void reverseSinglyLinkedList(){
		Node current = head;
		Node previous = null;
		Node next = null;
		while(current!=null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	public void getMiddleNode(){
		if(head==null) return null;
		Node slowP= head;
		Node fastP= head;
		while(fastP!=null && fastP.next!=null){
			slowP = slowP.next;
			fastP = fastP.next.next;
		}
		return slowP;
	}

	public static void main(String[] args){
		LinkedList sll = new LinkedList();
		sll.head = new Node(3);
		Node second = new Node(5);
		Node third = new Node(7);
		sll.head.next = second;
		second.next = third;
		if(sll.find(head,1)){
			System.out.println("true searchkey found");
		}
		else{
			System.out.rpintln("False searchkey not found");
		}
	}
}
