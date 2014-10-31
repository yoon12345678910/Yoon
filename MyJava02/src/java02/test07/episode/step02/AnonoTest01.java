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


package java02.test07.episode.step02;


public class AnonoTest01 {

  public static void main(String[] args) {

    Class clazz = MyObject.class;
    
    MyAnnotation myAnno = 
        (MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
       System.out.println(myAnno.value());
       System.out.println(myAnno.name());
       System.out.println(myAnno.age());
       String[] langs = myAnno.language();
       for(String lang: langs){
         System.out.println(lang);
       }
       System.out.println(myAnno.country());

      
  }
}
