/*
  바이너리 데이터의 읽기
   FileInputStream
   텍스트 파일을 바이너리 스트림 객체를 사용하여 읽기
  
    read(): 1바이트씩 읽는다.
 
 *
 *
 */
package java02.test02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test08 {
  public static void main(String[] args) throws Exception{
  
    FileInputStream in = new FileInputStream("test01.txt");
    int b = -1;
    
    while((b = in.read()) != -1){
    //인티져를 16진수 스트링으로 변환하여 리턴함
      System.out.println(Integer.toHexString(b));
    
    }
    in.close();
    
    
  }
}