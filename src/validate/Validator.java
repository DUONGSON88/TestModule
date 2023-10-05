package validate;

import java.util.Scanner;

public class Validator {
    public static Scanner input=new Scanner(System.in);
    public static int inputInt(){
        int number;
        do {
            try{
                number=Integer.parseInt(input.nextLine());
                break;
            }catch (NumberFormatException numberFormatException){
                System.out.println("Bạn nhập sai định dạng! Hãy nhập lại :");
            }
        }while (true);
        return number;
    }
    public static String inputString(){
        return input.nextLine();
    }
    public static int choice(){
        int choice;
        do {
            try{
                choice=Integer.parseInt(Validator.inputString());
                break;
            }catch (Exception e){
                System.out.println("Bạn hãy nhập đúng số!");
            }
        }while (true);
        return choice;
    }
//    public static int idInput(){
//        String regexId="\\d{3,}";
//        String id;
//        do {
//            try{
//
//            }
//        }while (true)
//    }


}
