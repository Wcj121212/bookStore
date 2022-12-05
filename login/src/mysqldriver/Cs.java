package mysqldriver;

public class Cs {
    public static void main(String[] args) {
        DealLogin se=new DealLogin();
        String state=se.deal("1","123456");
        System.out.println(state);
    }
}
