/* 
  캡슐화(encapsulation)?
  클래스를 정의한 의도와 다르게 변수나 메서드를 사용할 경우
  오류가 발생하게 된다.
  1)변수에 무효한 값을 넣는다거나,
  2)내부에서 호출할 메서드를 외부에서 직접 호출한다거나
  등
  -=>클래스 작성자가 의도한 대로만 사용하도록 접근을 제한하는 문법
  =>최소한의 안전장치!
  -문법 
  [접근 제어자(access modifier)] 타입 변수명;
  [접근 제어자(access modifier)] 리턴타입 메서드명(...){...};
  1) private = > 클래스 멤버만 접근 가능
  2)protected = > 같은 패키지의 클래스에 접근 가능. 자식 클래스 접근 가능
   3)(default) = > 같은 패키지의 클래스만 접근 가능
   4) public = > 모두 접근 가능
 */

package java01.test30;

import java.util.Scanner;




public class Test30 {

  public static void main(String[] args) {
    //Calculator 클래스의 명령에 따라 준비된 메모리를 => 인스턴스
    //그 인스턴스 메모리의 주소를 저장하는 변수를 => 레퍼런스
    Calculator c1 =  new Calculator();
    Calculator c2 =  new Calculator();
    //인스턴스 변수 존재하는 이유는 개별적으로 값을 관리하기위해서
    //다음 두개의 식을 동시에 계산하라
    
    // 10 + 2 * 7 - 4 / 2 = ?
    // 20 * 3 + 76 - 5 = ?
    // 클래스 변수나 인스턴스 변수는 자동 초기화 된다.
    // 따라서 다음과 같이 별도로 초기화 할 필요는 없다.
    // Calculator.result = 0;
    Calculator.plus(c1, 10);
    Calculator.plus(c1, 2);
    Calculator.multiple(c1, 7);
    Calculator.minus(c1, 4);
    Calculator.dividie(c1, 2);
    
    Calculator.plus(c2, 20);
    Calculator.multiple(c2, 3);
    Calculator.plus(c2, 76);
    Calculator.minus(c2, 5);
     
    System.out.println("결과는 = " + Calculator.getResult(c1));
    System.out.println("결과는 = " + Calculator.getResult(c2)); 
    
  }
}
