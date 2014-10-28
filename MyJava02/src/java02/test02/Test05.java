/*
  File을 사용하여 특정 디렉토리의 파일 목록 추출하기

*/

package java02.test02;

import java.io.File;

public class Test05 {
  public static void main(String[] args) throws Exception {  
      File f = new File("../../java63/java01");
      System.out.println(f.getAbsolutePath());
      System.out.println(f.getCanonicalPath());
  }
}
