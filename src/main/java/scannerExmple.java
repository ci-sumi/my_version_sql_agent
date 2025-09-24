import java.util.Scanner;
public class scannerExmple {
    void  display(double var){
        System.out.println("Its double number");
    }
    public  static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String age;
        boolean validage=false;
        do {
            System.out.println("Enter your age:");
            age = scanner.nextLine();
            try {
                float Intage = Float.parseFloat(age);
                validage =true;
            }catch (Exception e){
                System.out.println("You didnt enter a valid age");
            }
        }while (validage==false);


        System.out.println("Your age is"+age);
        System.out.println("Your name is");
        String str = "abc";
        System.out.println(str.getClass().getName());
        scannerExmple scannerExmple = new scannerExmple();
        scannerExmple.display(16.6);


    }
}
