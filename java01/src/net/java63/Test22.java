/* 
 반복문

  
   //퀴즈 
    //1에서 100까지 출력하라 
    
4배수출력

20배수일때마다 경계문자 출력
60배수가 아닌것은 경계문자열을 출력하지말라
do문을 사용하라

    
  
 *
 */

package net.java63;

public class Test22 {

  public static void main(String[] args) {
    long startMilliSec = System.currentTimeMillis();
    int i;

    do {
      i += 4;
      System.out.print(i + ",");

      if (i % 20 == 0) {
        System.out.println();
          if (i % 60 == 0) {
            System.out.print("@");
            }
        }
    } while (i < 4);
    long endMilliSec = System.currentTimeMillis();
    System.out.print(endMilliSec - startMilliSec);
  }
}
