/*

추상클래스
-그 자체로 사용하지 않는 클래스
-단지 서브 클래스에게 공통 속성이나 메소드를 물려주기 위해 만든 클래스
-인스턴스를 생성할 수 없다.
문법 : abstract class 클래스명{}

 용어정리!
 
 -일반클래스(concrete class)
   1)패키지 멤버 클래스:package member class(배움) 패키지의 직속
   2)중첩 클래스(내부 클래스):inner class (클래스안에 클래스)
     i)top level inner class 
     ii)member inner class 
     iii)local inner class
     iv)anonymous inner class
       
     
   
 
 
 -추상클래스(abstract class)(배움)
 
 
 
 
 
 */

package java01.test43;


//public ( access modifier) 접근 제어자와 abstract 키워드는 순서에 상관없다.
abstract public class Car {
  
  String maker;
  String model;
  int cc;
  int capacity;
  java.util.Date releaseDate;
  
  
}
