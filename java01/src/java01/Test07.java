/* 변수/ 메서드(함수)/클래스의 이름 
  알파벳, 숫자, _, $, 문자
  주의
  .변수의 첫 문자는 반드시 숫자가 올 수 없다.
  가능한 $를 변수 이름으로 사용하지 말 것
  $는 자동화 도구에서 값을 대치하는 특수 기호로 많이 사용
  패키지 멤버 클래스는 영어 외 문자를 사용하지 말아라 
  내부 클래스는 한글 사용가능
  그냥 영어 사용
     
 * */


package java01;
public class Test07 {

  public static void main(String[] args) {
    byte i;
   byte 나이=123;
   byte abc;
   byte Abc;
   byte _;
   byte $;
  // byte 20; 오류
   
   byte age20;
   short 안녕;
   /*변수 이름 짓기 규칙
   camel 표기법
   예 firstName, createDate
   널리 알려진 약어인 경우는 변수명을 사용해도 되지만,
   가능한 약어 사용을 자제하라!=> 소스코드의 해독을 좋게 하기 위해
   변수나 메서드는 소문자로 시작
   클래스는 대문자로 시작
   메서드명은 동사로 시작 => 일을 시키는 식으로 이름을 지어라
  *
  */
   System.out.print(나이);
  
  }
}








