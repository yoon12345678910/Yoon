/* 
 반복문

  
   //퀴즈 
    //1에서 100까지 출력하라 
    
4배수출력

20배수일때마다 경계문자 출력
60배수가 아닌것은 경계문자열을 출력하지말라
for문을 사용하라

    
  
 *
 */

package java01;

public class Test25 {

  public static void main(String[] args) {

    for (int i = 4; i < 101; i += 4) {

      System.out.print(i + ",");
      if (i % 20 == 0) {
        System.out.println();
        if (i % 60 == 0) {
          System.out.print("@");
        }

      }
    }
  }
}
