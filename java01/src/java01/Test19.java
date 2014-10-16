/* 
  switch문
  
 -특정 값에 따라 명령어의 실행을 분기할 때 사용
 -문법
 switch(4byte이하 정수값,byte,short, int, char)
  case 값:
  명령어
  break;
  default://else의미
  명령어
  
  JDK 7부터는 switch문에 문자열을 넣을수있따 
*/

package java01;

import java.util.Scanner;



public class Test19 {

  public static void main(String[] args) {

       
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
