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

import java.util.ArrayList;

public class Test24 {

  public static void main(String[] args) {
    int[] scores = new int[] { 100, 90, 80 };
    for (int value : scores) {
      System.out.println(value);
    }
    System.out.println("-----------------------------");

    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(100);
    list.add(50);
    list.add(70);
    //Collection 객체에 저장된 값을 순차적으로 꺼낸다
    for (Object value : list) {
      System.out.println(value);
    }
  }
}
