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

package net.java63;

import java.util.Scanner;



public class Test20 {

  public static void main(String[] args) {

       for(int a = 2; a < 10; a++){
           for(int b = 1; b < 10; b++ ){
             System.out.println(a+"*"+b+"="+a*b);
           }
           System.out.println();
         }
  
      
}
}
