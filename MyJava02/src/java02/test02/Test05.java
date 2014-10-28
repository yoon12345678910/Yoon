/*
  File을 사용하여 특정 디렉토리의 파일 목록 추출하기

*/

package java02.test02;

import java.io.File;

public class Test05 {
  public static void main(String[] args) throws Exception {  
      File f = new File("../../java63/java01");
      
      //결과:    /home/bit/git/Yoon/MyJava02/../../java63/java01
      System.out.println(f.getAbsolutePath());
      
      //결과:    /home/bit/git/java63/java01
      System.out.println(f.getCanonicalPath());
      
      //결과:    ../../java63/java01
      System.out.println(f.getPath());
      
      //결과:    java01
      System.out.println(f.getName());
      
      //결과:   ../../java63
      System.out.println(f.getParent());
  }
}
