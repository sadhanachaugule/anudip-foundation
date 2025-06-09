public class factorial {
    public static void main(String[] args) {
        int a =10;
        System.out.println("the no. is:"+a);
        int fact=1;
        for(int i=1;i<=a;i++)
        {
             fact=fact*i;
        }
        System.out.println(fact);
    }
}
