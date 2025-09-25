    import java.util.Enumeration;
    import java.util.Scanner;
    public class promptUser {
        static  Scanner scanner = new Scanner(System.in);
        static int number =0;
        static boolean valid = false;


        public static void main(String[] args) {
            do{
                System.out.println("Enter the number");
                try {
                    scanner.nextInt();
                    valid = true;
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("You didnt enter the right number");
                    scanner.nextLine();
                }
            }while (!valid);
            System.out.println("you entered a number");


        }
    }

