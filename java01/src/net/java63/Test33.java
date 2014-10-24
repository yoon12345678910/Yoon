/*
  boxing and unboxing
  -boxing : 기본 형 값을 가지고 랩퍼 객체를 자동으로 만드는 것
  -unboxing : 랩퍼 객체에서 기본 형 값을 자동 추출하는 것
   -이 두가지가 자동으로 이루어지는 것 => autoboxing(JDK 1.5이상)
  
*/
package net.java63;

public class Test33 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    //boxing
    
    Integer i = 10; //new Integer(10);
    
      //unboxing
    int j = i;//i.intValue() 와 같다.
    
  }

}
