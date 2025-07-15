class DoublyLinkedList{
class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
Node head;
//inseratatbegin
public void inseratatbegin(int data){
    Node newnode = new Node(data);
    if(head==null){
        head=newnode;
        return;
    }
    else{
        head.prev=newnode;
        newnode.prev=null;
        newnode.next=head;
        head=newnode;
    }
}
//insertatend
public void insertatend(int data){
    Node newnode= new Node(data);
    if(head==null){
     head=newnode;
     return;
    }
    else{
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.prev=temp;
    }
}
//insertatspecificposition
public void insertatspecificposition(int data,int Position){
    Node newnode = new Node(data);
    Node temp= head;
    if(Position<1){
        System.out.println("invalid");
        return;
    } 
    else if(Position==1){
        inseratatbegin(data);
        return;
    }
    else{
        for(int i=0;temp!=null&&i<Position-1;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Out of bound");
            return;
        }else{
     
      newnode.next=temp.next;
       temp.next.prev=newnode;
      newnode.prev=temp;
      temp.next=newnode;
        }
          

    }
}
//deleteatbegin
public void deleteatbegin(){
    if(head==null){
        return;
    }else{
        head=head.next;
        head.prev=null;

    }
}
//deleteatend
public void deleteatend(){
    Node temp=head;
    if(temp==null){
    return;
    }
    else{
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.prev.next=null;
        temp.prev=null;
        
    }
}
//deleteatspecificposition
public void deleteatspecificposition(int Position){
    Node temp=head;
    if(Position<1){
        System.out.println("out of bond");
        return;
    }
    else if(Position==1){
        deleteatbegin();
        return;
    }
    else{
       for (int i =0;temp!=null&&i<Position-1;i++){
           
                temp=temp.next;
            }
              
        }
         
             temp.next.next.prev=temp;
            temp.next=temp.next.next;

    }
    public void display(){
        Node temp=head;
        System.out.print("Null->");
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("<-null");

    }






    public static void main(String[] args) {
        DoublyLinkedList list= new DoublyLinkedList();
        list.inseratatbegin(10);
        list.inseratatbegin(20);
         list.inseratatbegin(30);
        list.inseratatbegin(40);
         list.inseratatbegin(50);
        
        list.insertatspecificposition(300,3);
        list.insertatend(100);
        list.deleteatbegin();
        list.deleteatend();
        list.deleteatspecificposition(3);

        list.display();
        
    }

}
