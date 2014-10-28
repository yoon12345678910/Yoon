/*
   문자 데이터의 읽기
   FileReader
   -텍스트 파일을 문자 스트림 객체를 사용하여 읽기
     read(): 한 문자 단위로 읽는다. => 리턴 값은 유니코드이다.
      
     한 문자 =>  영어(1바이트), 한글(2 ~ 3)....
     문자 스트림은 읽어들인 데이터를 유니코드!!!!!!!!!!!로 변환한다.




    ***이미지 데이터를 읽을때는
    * FileInputStream(바이너리 데이터)를 사용해야한다.
    그렇지않으면 이미지파일 깨짐
    
    
    
    ***FileReader은 텍스트뽑을때 사용하는것이다.
        바이트를 유니코드를 변환한다...
 *
 *
 */
package java02.test02;

import java.io.FileReader;

public class Test07 {
  public static void main(String[] args) throws Exception {

    FileReader in = new FileReader("test01.txt");
    int b = -1;

    while ((b = in.read()) != -1) {
      // 인티져를 16진수 스트링으로 변환하여 리턴함
      System.out.println(Integer.toHexString(b));

    }
    in.close();

  }
}