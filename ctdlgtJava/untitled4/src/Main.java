public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;



//        printLinkedList(n1);

//        Node n1AddHead = n1;
//        n1AddHead = addToHead(n1AddHead,0);
//        printLinkedList(n1AddHead);
//        System.out.println();
//
//        Node n1AddTail = n1;
//        n1AddTail = addToTail(n1AddTail,0);
//        printLinkedList(n1AddTail);
//        System.out.println();
//
//        Node n1AddIndex = n1;
//        n1AddIndex = addToIndex(n1AddIndex,0,1);
//        printLinkedList(n1AddIndex);
//        System.out.println();

        printLinkedList(n1);
        n1 = removeAtHead(n1);
        printLinkedList(n1);

    }

    public static class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public static void printLinkedList (Node head) {
        if (head == null){
            System.out.println("List empty.");
        } else {
            Node temp = head;
            while (temp != null){
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null){
                    System.out.print("->");
                } else {
                    System.out.println();
                }
            }
        }
    }

    public static Node addToHead(Node headNode, int value){
        Node newNode = new Node(value);
        if (headNode != null){
            newNode.next = headNode;
        }

        return newNode;
    }

    public static Node addToTail(Node headNode, int value){
        Node newNode = new Node(value);
        if (headNode == null){
            return newNode;
        } else {
            Node lastNode = headNode;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }

        return headNode;
    }

    public static Node addToIndex(Node headNode, int value, int index){
        if (index==0){
            return addToHead(headNode,value);
        }else{
            Node newNode = new Node(value);
            Node curNode = headNode;
            int count = 0;
            while (curNode != null){
                count++;
                if(count == index){
                    newNode.next = curNode.next;
                    curNode.next = newNode;
                    break;
                }
                curNode = curNode.next;
            }
        }
        return headNode;
    }

    public static Node removeAtHead(Node headNode){
        if(headNode != null){
            return headNode.next;
        }
        return headNode;
    }
}
