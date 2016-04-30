package linkedlist;

/**
 * Created by vasant on 1/9/16.
 */
public class LinkedList {

    private class Node
    {
        private Node next;
        private int data;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int data) {
            this.data=data;
        }
    }

    private Node head;

    public void insert(int value) {
        if(head == null) {
            head = new Node(value);
            return;
        }

        Node temp=head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next=new Node(value);
    }

    public void remove(int value) {
        if(head==null) {
            return;
        }
        Node prev;
        Node next;
        if(head.data==value) {
            if(head.next==null) {
                head = null;
                return;
            }
            else {
                next = head.next;
                head.next = null;
                head = next;
                return;
            }
        }
        prev = head;
        while( prev.next!=null) {
            if(prev.next.data == value) {
                break;
            }
            prev = prev.next;
        }
        if(prev!=null) {
            if(prev.next!=null) {
                next = prev.next.next;
                prev.next.next=null;
                prev.next=next;
            }
            else {
                prev.next = null;
            }

        }

    }

    public int findKthLast(int k) {
        Node curr =head;
        Node kFast = head;
        int i=0;
        while(i!=k) {
            kFast= kFast.next;
            i++;
        }
        while(kFast!=null){
            curr=curr.next;
            kFast=kFast.next;
        }
        return curr.data;
    }

    public void print() {
        Node temp=head;
        while(temp!=null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }

    public void print(Node temp) {
        while(temp!=null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }

    private void reverse(Node node){
        if(node.next==null) {
            head=node;
            return;
        }
        reverse(node.next);
        node.next.next=node;
        node.next=null;
    }

    private void ireverse(Node node) {

        Node prev=null;
        Node curr=head;
        while(curr!=null) {
            Node temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
    }
    public void reverse() {
        ireverse(head);
    }

    public int mid() {
        Node slow = head;
        Node fast = head.next;
        while(slow!=null && fast!=null) {
            slow=slow.next;
            if(fast.next==null)
                fast=fast.next;
            else
                fast=fast.next.next;
        }
        return slow.data;
    }

    public int addNumbers(Node n1, Node n2) {
        Node n3= null;
        int sum;
        int carry=0;
        while(n1!=null || n2!=null) {

            sum = carry + (n1==null?0:n1.data) + (n2==null?0:n2.data);

            if(sum>=10) {
                sum=sum%10;
                carry=1;
            }
            if(n3==null){
                n3= new Node(sum);
            }
            else{
                n3.next= new Node(sum);
                n3=n3.next;
            }
            if(n1!=null) {
                n1=n1.next;
            }
            if(n2!=null){
                n2=n2.next;
            }

        }
        return n3.data;
    }



    public String asString() {
        Node temp=head;
        StringBuffer ll = new StringBuffer();
        while(temp!=null) {
            ll.append(temp.data).append(" ");
            temp = temp.next;
        }
        return ll.substring(0,ll.length()-1);
    }

    public Node getHead()
    {
        return head;
    }
}
