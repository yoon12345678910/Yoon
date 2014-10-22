/*
  상수 문자열
  -"문자열" 식으로 표현
  -내부적으로 STring 클래스의 인스턴스를 생성한다.
  String pool 영역에 생성한다.
  ****중복 생성되지 않는다.
 
 Method Area영역에 클래스가 로딩되면 
 각 클래스 별로 상수 문자열의 String 인스턴스가 생성된다.
 
 Method Area 영역에서 각 클래스 별로 상수 문자열을 준비하는 메모리 영역을 
 상수풀(Constant Pool이라고 한다.
 
 즉, Method Area 안에 클래스가 로딩되고, 로딩된 클래스 안에 상수 문자열이 준비된다.
 
 
 String pool
 -상수 문자열을 ㅂ관하는 메모리 영역
 method area의 일부분이다.
 -상수 문자열은 자주 상ㅇ되기 때문에 메모리 낭비를 줄이기 위해서
 스트링 풀이라는 영역에 통합관리한다.
 
 같은 상수 문자열이 존재할 수 없다. => 중복 생성되지 않는다.
 
 
 */

package java01.test50;
public class StringTest02 {
  class A {
    //다 각 클래스마다 개인적으로 변수를 지정해줘서 애러가 안난다용~!!
    static String str1 = "Hello";
    static String str2 = "Hello";
  }
  
  class B {
    static String str1 = "Hello";
    static String str2 = "Hello";
  }



  static String str1 = "Hello";
  static String str2 = "Hello";
 
  // 특정 클래스 안에서만 사용할 클래스라면, 그 클래스 내부에 선언하라!
  // =>중첩 클래스(inner class) 부른다.


  public static void main(String[] args) {
    if(str1 == str2) System.out.println("str1 == str2");
    if(A.str1 == A.str2) System.out.println("A.str1 == A.str2");
    if(B.str1 == B.str2) System.out.println("B.str1 == B.str2");
    
    if(str1 == A.str2) System.out.println("str1 == A.str2");
    if(A.str1 == B.str2) System.out.println("A.str1 == B.str2");
    
  }

  public static void main01(String[] args) {
    String str1 = "Hello"; //String pool에 인스턴스 생성후 주소 리턴
    String str2 = "Hello"; //기존 인스턴스의 주소 리턴
    String str3 = new String("Hello"); //heap에 인스턴스 생성
    
    if (str1 == str2)System.out.println("str1 == str2");
    if (str1 == str3)System.out.println("str1 == str3");
    
    
    //자바는 문자열을 객체로 다룬다.
    
    //문자열 비교할때는 equals()를 사용하라!
    //객체이기 때문에 == 연산자는 문자열이 아닌 주소를 비교하므로 
    //문자열 비교를 할 수 없다.
 
    if(str1.equals(str3)) System.out.println("str1.equals(str3)");

  }

}
