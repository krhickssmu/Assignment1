public class Stack<Item>{

    private Node first= null;

    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args){

        Queue<String> queue = new Queue<String>();
        Stack<String> stack = new Stack<String>();
        int InfoCounter = 0;
        int ErrorCounter = 0;
        int WarnCounter = 0;
        int WarnMemoryCounter = 0;

        while(!StdIn.isEmpty()) {
            String token = StdIn.readLine();
            queue.enqueue(token);
        }
        for (String s: queue){
            String token = queue.dequeue();
            if(token.contains("INFO")){
                InfoCounter++;
            }
            if(token.contains("ERROR")){
                ErrorCounter++;
                stack.push(token);
            }
            if(token.contains("WARN")){
                WarnCounter++;
                if(token.contains("Memory")){
                    WarnMemoryCounter++;
                }
            }

        }
        for (int i =0; i<100;i++){
            String past = stack.pop();
            StdOut.println(past);
        }
        StdOut.println("INFO Count:" + InfoCounter);
        StdOut.println("ERROR Count:" + ErrorCounter);
        StdOut.println("WARN Count:" + WarnCounter);
        StdOut.println("WARN MEMORY Count:" + WarnMemoryCounter);
    }
}
