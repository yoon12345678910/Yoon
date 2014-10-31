/*
  애노테이션 사용
    애노테이션이란?
      -컴파일러나 JVM에게 전달하는 주석
      
  1. 애노테이션 정의
    -MyAnnotation 생성
  2.애노테이션 적용
    -MyObject 생성 및 애노테이션 적용
  3.애노테이션 추출




*/


package java02.test07.episode.step01;


public class AnonoTest01 {
  /*
   * 
  /Class 객체를 얻는 또 다른 방법
  JVM은 클래스를 로딩할 때
  "class"라는 이름의 static 변수를  자동으로 추가한다.
  이 변수에는 "Class" 객체가 들어있다.
  클래스 이름으로 접근 가능하다.
  
  */
  public static void main(String[] args) {
    /* 클래스 로딩 방법1: 인스턴스를 통해 얻기
    MyObject obj = new MyObject();
    Class clazz = obj.getClass();
    */

    /* 가장 베스트!!
     클래스 로딩 방법2 : Class.forName() 통해 얻기
    Class clazz = Class.forName("java02.test07.episode.MyObject");
    */
    
    
    /* 클래스 로딩 방법 3: 클래스의 스태틱 변수를 통해 얻기 
   Class clazz = MyObject.class;
     */ 
    Class clazz = MyObject.class;
    
    MyAnnotation myAnno = 
        (MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
       System.out.println(myAnno.value());
    
    //모든 애노테이션은 java.lang.annotation.Annotation 인터페이스를
    //자동으로 구현한다.
    //따라서 우리가 만든 MyAnnotation도 이 인터페이스를 구현하였다/
   /* Annotation[] annos = clazz.getAnnotations();
    
   for(Annotation anno : annos){
     System.out.println(anno.toString());
   }
   
   MyAnnotation myAnno = (MyAnnotation)annos[0];
   System.out.println(myAnno.value());
    
    */
    
    
    
      
  }
}
