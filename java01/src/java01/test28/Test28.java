/* 
 * 클래스란?
   역할에 따라 메서드(함수(기능))와 변수를 정의한 것
   
   Calulator 클래스를 정의하고 계사노가 관련된기능을 분리한다.
   Calulator의 기능을 이용하여 다음 계싼ㅇ르 수행하라
   단 계산은 순차적으로 실행하라(즉, 연산자 우선순위 적용하지마라!)

 */

package java01.test28;

import java.util.Scanner;

public class Test28 {
 
  public static void main(String[] args) {
    // 10 + 2 * 7 - 4 / 2 = ?
    // 클래스 변수나 인스턴스 변수는 자동 초기화 된다.
    // 따라서 다음과 같이 별도로 초기화 할 필요는 없다.
    // Calculator.result = 0;
    Calculator.plus(10);
    Calculator.plus(2);
    Calculator.multiple(7);
    Calculator.result = -100;
    Calculator.minus(4);
    Calculator.dividie(2);
    
    System.out.println("결과는 = " + Calculator.result);
       
  }
}
