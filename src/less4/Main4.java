package less4;

public class Main4 {

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList();
        System.out.println(myLinkedList);
        myLinkedList.insertFirst("Katia");
        myLinkedList.insertFirst("Petia");
        myLinkedList.insertFirst("Maria");
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.deleteFirst());
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.getFirst());

        myLinkedList.insert(0,"Maria");
        myLinkedList.insert(1,"Sasha");
        myLinkedList.insert(3,"Sasha");
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.delete("Sasha"));
        System.out.println(myLinkedList.delete("Peggggggggg"));
        System.out.println(myLinkedList.indexOf("Peggggggggg"));
        System.out.println(myLinkedList.indexOf("Sasha"));
        System.out.println(myLinkedList.contains("Peggggggggg"));
        System.out.println(myLinkedList);

        System.out.println("---- Двусвязный список----");
        MyDoLinkedList<String> myDoLinkedList = new MyDoLinkedList();
        System.out.println(myDoLinkedList);
        myDoLinkedList.insertFirst("Katia");
        myDoLinkedList.insertFirst("Petia");
        myDoLinkedList.insertFirst("Maria");
        myDoLinkedList.insertLast("Bob");
        myDoLinkedList.insertFirst("Boby");
        System.out.println(myDoLinkedList);
        System.out.println(myDoLinkedList.deleteFirst());
        System.out.println(myDoLinkedList);
        System.out.println(myDoLinkedList.getFirst());

        System.out.println(myDoLinkedList.delete("Petia"));
        System.out.println(myDoLinkedList.getLast());
        System.out.println(myDoLinkedList.contains("Bob"));
        System.out.println(myDoLinkedList.delete("Bob"));
        System.out.println(myDoLinkedList.delete("Bob"));
        System.out.println(myDoLinkedList.delete("Maria"));
        myDoLinkedList.insert(1,"Petia");
        System.out.println(myDoLinkedList);
        for (String s : myLinkedList) {
            System.out.println(s);
        }

        System.out.println("---stack---");
        MyLinkedStack<String> stack = new MyLinkedStack<>();
        System.out.println(stack);
        stack.push("Katia");
        stack.push("Petia");
        stack.push("Maria");
        stack.push("Bob");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
        System.out.println("\n---queue---");
        MyLinkedQueue<String> queue = new MyLinkedQueue<>();
        queue.insert("Katia");
        queue.insert("Petia");
        queue.insert("Maria");
        queue.insert("Bob");
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        while (!queue.isEmpty()){
            System.out.print(queue.remove()+ " ");
        }
    }
}
