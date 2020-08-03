package less5;

public class Main5 {

    public static void main(String[] args) {
        int n=5;
        int m=17;
        int v = 2;
        System.out.println(fact(n));
        System.out.println(reFact(n));
        System.out.println(numberFibo(m));
        System.out.println(numberReFibo(m));
        System.out.println("triangleNum="+triangleNum(m));
        System.out.println("recTriangleNum="+recTriangleNum(m));
        System.out.println("multiply="+ multiply(n,v));
        System.out.println("recMultiply="+ recMultiply(n,v));
    }

    private static int fact(int n) {
        int value = 1;
        for (int i = 1; i <=n ; i++) {
            value*=i;
        }
        return value;
    }

    private static int reFact(int n) {
        if(n==1)return 1;
        return n*reFact(n-1);
    }

    private static long numberFibo(int n){
        long a =1;
        long b =1;
        for (int i = 3; i <=n; i++) {
            b=b+a;
            a=b-a;
        }
        return b;
    }

    private static long numberReFibo(int n){
        if(n<=2)return 1;
        return numberReFibo(n-1)+numberReFibo(n-2);
    }

    private static int triangleNum (int n){
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            sum+=i;
        }
        return sum;
    }

    private static int recTriangleNum (int n){
        if(n<1)throw new IllegalArgumentException("n<1");
        if(n==1) return 1;
        return recTriangleNum(n-1)+n;
    }

    private static int multiply(int a, int b){
        int value = 0;
        for (int i = 0; i <b ; i++) {
            value+=a;
        }
        return value;
    }

    private static int recMultiply(int a, int b){
        if(b==1) return a;
        return recMultiply(a,b-1)+a;
    }
}
