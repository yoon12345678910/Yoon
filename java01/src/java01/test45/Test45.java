/*
  클래스 로딩
  1) new 연산자를 사용하여 인스턴스를 만들 때
  2)Class.forName("클래스이름")을 호출하여 임의로 클래스 로딩



*/
package java01.test45;

public class Test45 {

  public static void main(String[] args) {

 ClassA obj;
 obj = new ClassA();
 
 System.out.println(obj.value);
 
  }

}
