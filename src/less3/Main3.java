package less3;

public class Main3 {


    public static void main(String[] args) {

        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        for (int i = 0; i <5 ; i++) {
            System.out.println(myStack.peek());
        }

        Expression e = new Expression("{4-6}+[{67+45}*{a/b}]");
        System.out.println(e.checkBracket());

        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);
        System.out.println(myQueue);
        for (int i = 0; i <3 ; i++) {
            System.out.println(myQueue.remove());
        }

        MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();
        myPriorityQueue.insert(4);
        myPriorityQueue.insert(7);
        myPriorityQueue.insert(2);
        myPriorityQueue.insert(1);
        myPriorityQueue.insert(9);

        System.out.println(myPriorityQueue);
        for (int i = 0; i <5 ; i++) {
            System.out.println(myPriorityQueue.remove());
        }
    }
}
