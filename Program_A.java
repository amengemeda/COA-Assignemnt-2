
package coa1;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Amen Gemeda 122475 All rights reserved 
 */
public class Program_A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      int choice;
      Scanner scan= new Scanner(System.in);
      System.out.println("*** Welcome to the number system conversion program ***"); 
      do{
        System.out.println("\nEnter 1 to get a complete conversion table");
        System.out.println("Enter 2 to get a corresponding binary and hexadecimal number for a specific decimal number");
        System.out.println("Enter 3 to end the program");
        System.out.print("Choice: ");
        choice=scan.nextInt();
            switch(choice){
                case 1:
                    listTable();
                    break;
                case 2:
                    System.out.println("Enter the decimal number you want to convert");
                    System.out.print("Number: ");
                    int number = scan.nextInt();
                    System.out.println("Decimal Number: "+number);
                    System.out.println("Binary Number: "+changeToBinary(number));
                    System.out.println("HexaDecimal Number: "+changeToHexadecimal(number));
                    break;
                case 3:
                    System.out.println("Thank you for using the program1\n Bye!\n");
                    break;
                default: 
                    System.out.println("\nWrong value keyed in.\nKindly choose the appropriate alternative");
            }
            
        }while(choice!=3);
       
       
        
    }
    public static void listTable(){
        System.out.println("decimal \t\t  Binary\t\t  hexadecimal\t\t");
        for(int i=0; i<=18; i++){
            System.out.println(i+"\t\t\t"+changeToBinary(i)+"\t\t\t"+Integer.toHexString(i));
        }
        System.out.println(31+"\t\t\t"+changeToBinary(31)+"\t\t\t"+changeToHexadecimal(31)+"\t\t");
        System.out.println(100+"\t\t\t"+changeToBinary(100)+"\t\t\t"+changeToHexadecimal(100)+"\t\t");
        System.out.println(255+"\t\t\t"+changeToBinary(255)+"\t\t"+changeToHexadecimal(255)+"\t\t");
        System.out.println(256+"\t\t\t"+changeToBinary(256)+"\t\t"+changeToHexadecimal(256)+"\t\t");
        
    }
    
    public static String changeToBinary(int decimalNumber){
        Stack<Integer> binaryStack= new Stack<>();
        do{
            binaryStack.push(decimalNumber%2);
            decimalNumber/=2;
        }while(decimalNumber!=0);
        String binaryNumber="";
        while(!binaryStack.empty()){
            binaryNumber+=binaryStack.pop();
        }
        return binaryNumber;
    }
    public static String changeToHexadecimal(int decimalNumber){
        Stack<String> hexadecimalStack= new Stack<>();
        int intermediateValue;
        while(decimalNumber!=0){
            intermediateValue=decimalNumber%16;           
            hexadecimalStack.push(getCorrespondingHexadecimal(intermediateValue));
            decimalNumber/=16;
        }
        String hexadecimalNumber="";
        while(!hexadecimalStack.empty()){
            hexadecimalNumber+=hexadecimalStack.pop();
        }
        return hexadecimalNumber;
    }
    public static String getCorrespondingHexadecimal(int intermediateValue){
        switch(intermediateValue){
        
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return Integer.toString(intermediateValue);
        }
    }
}
