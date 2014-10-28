/*
  Buffer의 사용
  한 바이트씩 데이터를 읽는 것보다
  여러 바이트를 한꺼번에 읽는 것이 속도가 더 빠르다.
  
  이유: 
  데이터 읽기 속도 = Data Seek Time + Data Access Time
  예)퀀텀 하드
  Data Seek Time( 데이터의 위치 찾는 시간) : 4.2ms => 0.0042초
  Data Transfer time(데이터 전송 시간) : 3Gb(기가비트) / sec = >0.000003초/1byte
  
  1byte 읽기 시간 = 0.0042 + 0.000003초 = 0.004203초
  100byte 읽기 시간 = 0.004203초 * 100 = 0.4203초
  
  
  
  3GB(기가 바이트)
  
  
  
 */

package java02.test02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Test16 {
  
  
//버퍼 사용전
  public static void main(String[] args) throws Exception {

    FileInputStream in = new FileInputStream("//home/bit/다운로드/test.pdf");
    BufferedInputStream in2 = new BufferedInputStream(in);
    
    
    byte[] buf = new byte[100000];
    int len = 0;
    
    long start = System.currentTimeMillis();
    
    while ((len = in2.read(buf)) != -1) {}
      long end = System.currentTimeMillis();

      System.out.println(end - start);
      in2.close();
      in.close();
    
  }
  
  
  
//버퍼 사용전
  public static void main01(String[] args) throws Exception {

    FileInputStream in = new FileInputStream("//home/bit/다운로드/test.pdf");
  
    int b;
    long start = System.currentTimeMillis();
    while ((b = in.read()) != -1) {}
      long end = System.currentTimeMillis();

      System.out.println(end - start);
      in.close();
    
  }
}