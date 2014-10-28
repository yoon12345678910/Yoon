/*
  재귀 호출의 이해



*/
package java02.test02;

public class Test06_Ep02 {

//Quiz : 1부터 50까지의 더하라
  
  
  //함수 호출 통해
  public static void main(String[] args) {

  System.out.println(f(100));
  }
  
  public static int f(int no){
    
    if(no ==1)return no;
    else {
      return no + f(no -1);
    }
  }
  
  
  
  
    //반복문 호출
    public static void main01(String[] args) {
      int result = 0;
      
      for(int i = 1; i < 51; i++){
        result += i;
      }
      System.out.println(result);
    }





}
