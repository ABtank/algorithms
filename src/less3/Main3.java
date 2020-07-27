package less3;

import java.util.Comparator;

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

        MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>(Comparator.reverseOrder());
        myPriorityQueue.insert(4);
        myPriorityQueue.insert(7);
        myPriorityQueue.insert(2);
        myPriorityQueue.insert(1);
        myPriorityQueue.insert(9);

        System.out.println(myPriorityQueue);
        for (int i = 0; i <5 ; i++) {
            System.out.println(myPriorityQueue.remove());
        }

        MyReverseString a = new MyReverseString("Hello World!");
        a.reverseString();

        MyDQueue<Integer> myDQueue = new MyDQueue<>();
        myDQueue.insertLeft(1);
        myDQueue.insertLeft(2);
        myDQueue.insertLeft(3);
        myDQueue.insertLeft(4);
        myDQueue.insertLeft(5);
        System.out.println(myDQueue);
        for (int i = 0; i <5 ; i++) {
            System.out.print(myDQueue.removeRight()+" ");
        }
        System.out.println();

        myDQueue.insertRight(1);
        myDQueue.insertRight(2);
        myDQueue.insertRight(3);
        myDQueue.insertRight(4);
        myDQueue.insertRight(5);
        myDQueue.insertLeft(0);
        System.out.println(myDQueue);
        for (int i = 0; i <3 ; i++) {
            System.out.print(myDQueue.removeRight()+" ");
        }
        for (int i = 0; i <3 ; i++) {
            System.out.print(myDQueue.removeLeft()+" ");
        }

    }
}
