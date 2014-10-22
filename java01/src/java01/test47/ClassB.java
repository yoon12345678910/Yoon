package java01.test47;

public class ClassB extends ClassA{
  static int value = 10;
  
  static {
    System.out.println("ClassB => static 블록 실행");
    ClassA.value = 80;
    System.out.println("ClassB => ClassA.value = " + ClassA.value);
    System.out.println("ClassB => value = " + value);
  }

}
