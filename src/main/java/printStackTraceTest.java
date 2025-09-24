public class printStackTraceTest {
    static int a =5;
    static int b =0;

    public static void main(String[] arg){
        System.out.println("*****Testing printStackTrace*****");

        division();

        }
        public static void division(){
        try {
            int c =a/b;
        }catch(Exception e){
            System.out.println("Something went wrong"+e.getMessage());

        }

    }
}
