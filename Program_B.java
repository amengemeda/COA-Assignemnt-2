
package coa1;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Amen Gemeda 122475 All rights reserved
 */
public class Program_B {
    public static void main(String[] args) {
      int choice;
      Scanner scan= new Scanner(System.in);
      System.out.println("*** Welcome to the decimal floating numbers to binary numbers conversion program ***"); 
      do{
        System.out.println("\nEnter 1 to get a complete conversion table");
        System.out.println("Enter 2 to get a corresponding binary number for a specific floating decimal number");
        System.out.println("Enter 3 to end the program");
        System.out.print("Choice: ");
        choice=scan.nextInt();
            switch(choice){
                case 1:
                    listTable(); //Create a binary converstion table for random 30 floating decimal table 
                    break;
                case 2:
                    //Takes a specific floating decimal number from the user and gets its corresponding binary value
                    System.out.println("Enter the floating decimal number you want to convert");
                    System.out.print("Number: ");
                    float number = scan.nextFloat();
                    String []array;
                    float floatingNumber;
                    int wholeNumber;
                    floatingNumber = number-(int)number;
                    wholeNumber= (int)number;
                    array=getBinaryNumber(wholeNumber, floatingNumber).split(",");
                    String finalBinaryAnswer=array[0];
                    String remark=array[1];
                    System.out.println("Decimal Number: "+number);
                    System.out.println("Binary Number: "+finalBinaryAnswer);
                    System.out.println("Remark: "+remark);
                    break;
                case 3:
                    System.out.println("Thank you for using the program1\n Bye!\n");
                    break;
                default: 
                    System.out.println("\nWrong value keyed in.\nKindly choose the appropriate alternative");
            }
            
        }while(choice!=3);
       
       
        
    }
     public static String changeToBinary(int decimalNumber){
       //Uses stack data structure to change decimal to binary number
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
      public static void listTable(){
          String floatNumber;
          float number;
          float floatingNumber;
          int wholeNumber;
          String []array;
          String finalBinaryAnswer;
          String remark;
           System.out.println("\t\t\tdecimal\t\t\tBinary\t\t\tRemark");
          for(int i=0; i<30; i++){
              floatNumber=getRandomFloatingNumber();
             number= Float.parseFloat(floatNumber);
             floatingNumber = number-(int)number;
             wholeNumber= (int)number;
             array=getBinaryNumber(wholeNumber, floatingNumber).split(",");
             finalBinaryAnswer=array[0];
             remark=array[1];
             System.out.println((i+1)+"\t\t\t"+floatNumber+"\t\t\t"+finalBinaryAnswer+"\t\t\t"+remark);
          } 
    }
    
    public static String getBinaryNumber(int wholeNumber, float floatingNumber){
         String binaryValueForTheWholeNumber= changeToBinary(wholeNumber);
         String binaryValueForTheFloatingPart="";
         String finalBinaryValue="";
         String remark;
         float intermediateFloatValue;
         boolean exactValue=false;
         int intermediateIntValue;
         Queue<Integer> binaryQueue= new LinkedList<>();
         for(int i=0; i<5; i++){
             floatingNumber=floatingNumber*2;
             intermediateIntValue=(int)floatingNumber;
             intermediateFloatValue=getFloatingPoint(floatingNumber);
             binaryQueue.add(intermediateIntValue);
             if(intermediateFloatValue==0){
                 exactValue=true;
                 break;
             }
             floatingNumber=intermediateFloatValue;
         }
         finalBinaryValue+=binaryValueForTheWholeNumber;
         while(!binaryQueue.isEmpty()){
             binaryValueForTheFloatingPart+=binaryQueue.remove();
         }
         finalBinaryValue+=".";
         finalBinaryValue+=binaryValueForTheFloatingPart;
         remark=(exactValue==true)? "Exact": "Approximate";
         finalBinaryValue+=",";
         finalBinaryValue+=remark;
         return finalBinaryValue;
     }
     public static float getFloatingPoint(float number){
         return number-(int)number;
     }
    public static String getRandomFloatingNumber(){
          Random rand = new Random(); //instance of random class
          float float_random=rand.nextFloat();
          int multiplier;
          String finalRandomFloatingNumber;
          DecimalFormat df= new DecimalFormat(".#####");
          String doubleRandomNumber=df.format(float_random);
          multiplier= (2+rand.nextInt(2));
          multiplier=getRandomizedDivider(multiplier);
          float_random= (Float.parseFloat(doubleRandomNumber)*multiplier);
          finalRandomFloatingNumber=Float.toString(float_random);
           DecimalFormat df2= new DecimalFormat("###.###");
          finalRandomFloatingNumber= df2.format(Float.parseFloat(finalRandomFloatingNumber));
          return finalRandomFloatingNumber;
    }  
    public static int getRandomizedDivider(int number){
        switch(number){
            case 2:
                return 100;
            case 3:
                return 1000;
            case 4:
                return 10000;
        }
        return -1;
    }   
    
 
}
