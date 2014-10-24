/* 
  조건문 퀴즈
  java java01.Test18
  당신의 나이가 어떻게 되는지 다음보기에서 고르시오
*/

package net.java63;

import java.util.Scanner;





public class Test18 {

  public static void main(String[] args) {

    //int age = Integer.parseInt(args[0]);;
       
    /*
    if (age < 18) {
      System.out.println("청소년입니다.");
    } else if (age >= 20 && age < 40) {
      System.out.println("청년입니다.");
    } else if (age >= 40 && age < 50) {
      System.out.println("장년입니다.");
    } else if (age >= 50 && age < 65) {
      System.out.println("중년입니다.");
    } else {
      System.out.println("노인입니다.");
    }
    
    
    */
    
    
    

        
    System.out.println("당신의 나이가 어떻게 되는지 다음 보기에서 고르시오:");
    System.out.println("1)10대");
    System.out.println("2)20대");
    System.out.println("3)30대");
    System.out.println("4)40대");
    System.out.println("5)50대");
    System.out.println("6)기타");
    
    String message;
    Scanner scan = new Scanner(System.in); 
    message = scan.nextLine();  
    int mes = Integer.parseInt(message);
        
    switch(mes){
    
    case 1:
      System.out.println("청소년입니다.");
    break;
    
    case 2:
      System.out.println("청년입니다.");
      break;
     
    case 3:
      System.out.println("장년입니다.");
      break;
      
      
    case 4:
      System.out.println("중년입니다.");
      break;
      
      
    case 5:
      System.out.println("노인입니다.");
      break;
      
      
    default:
      System.out.println("기타입니다.");
      break;

      
      
      
    }
    
    
    
    
    
    
  }
  
}
