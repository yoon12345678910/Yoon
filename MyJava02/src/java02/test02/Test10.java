/*
   문자 데이터 출력
 
 *
 *
 */
package java02.test02;

import java.io.FileWriter;

public class Test10 {
  public static void main(String[] args) throws Exception{

    
    
    //Write() = > OS기본 문자집합을 사용하여 변환한다.
    //=>UTF-8
    FileWriter out = new FileWriter("test10.dat");
    char[] str = {'A', 'B', 'C', '가', '가', '간' };
   for(char c : str){
    out.write(c);
  }
  out.close();
    
  }
}