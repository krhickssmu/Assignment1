import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

public class QueueOperations<Item> implements Iterable<Item> {

    private Node first, last;

    private class Node {
        Node next;
        Item item;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void enqueue(Item item){ //
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }
        else{
            oldlast.next = last;
        }
    }
    public Item dequeue(){ //void or item??
        Item item = first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        public void remove(){

        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("\nIn one line, enter 1 digit integers and add P next to it (for push to top),\n minus sign for pop,\n and number with E to add to queue (for enqueue); ex. 1P pushes 1:\n");
//        String input = scan.nextLine();
//
//        Steque<String> item = new Steque<String>();
//
//        for (int i = 0; i < input.length(); i++){
//            String num = input.charAt(i) + "";
//            if (input.charAt(i) != '-' && (input.charAt(i+1) == 'P' || input.charAt(i+1) == 'p')){
//
//                item.push(num);
//                System.out.println(" push " + num);
//            }
//            else if (input.charAt(i) != '-' && (input.charAt(i+1) == 'E' || input.charAt(i+1) == 'e')){
//                item.enqueue(num);
//                System.out.println(" enqueue " + num);
//            }
//            if (input.charAt(i) == '-'){
//
//                try{
//                    System.out.println(" pop " + item.pop()); //pops first input
//                } catch (Exception e) {
//                    System.out.println("Can't redirect to null element, can't pop anymore");
//                }
//
//            }
//        }
//    }

}
