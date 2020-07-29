package less3;

public class MyReverseString {
    private String str;

    public MyReverseString(String str) {
        this.str = str;
    }

    public void reverseString() {
        MyStack<Character> myStack = new MyStack<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            myStack.push(str.charAt(i));
        }
        while (!myStack.isEmpty()){
            System.out.print(myStack.pop());
        }
        System.out.println();
    }
}
