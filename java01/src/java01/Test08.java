/*정수 변수

byte(1) : -128~ 127
short(2) : -32768~32767
int(4)   :   약 -21억 ~21억
long(8)  : 약 -922경~ 약 922경

 */

package java01;

public class Test08 {

  public static void main(String[] args) {

      byte minByte = -128; 
      byte maxByte =127;
      
      short minShort = -32768;
      short maxShort = -32667;
      
      int minInt = -2147483648;
      int maxInt =  2147483647;
      
      long minLong = Long.MIN_VALUE;
      long maxLong = Long.MAX_VALUE;
      
     
      /* minByte = -129; //메모리의 크기 보다 값이 더 크면 오류 발생!
      maxByte = 128;
      */
    
      
      
      //정확한 오류 내용확인!
      //Literal : 정수 리터럴 => 4바이트 정수값, 8바이트 정수값
      //10, 20 <= 4바이트 정수
      //10L, 10l, 20L, 20l <=8바이트 정수
      
      
      //1.상수 값이 int(4) 타입이라도 메모리에 저장할 수 있으면 허락한다.
      
      byte b = 127;
      
      //2.상수 값을 메모리에 저장할 수 없으면 원래대로 오류를 발생한다.
      //byte b2 = 128; //오류내용! int를 byte 메모리에 저장할 수 없다.
      //short s = 32768;
  
     /* byte b3 = 30L; //8바이트 상수값 저장 불가!
      short s2 = 30L; 이하 동문
      int i =30L;
      long l = 30L;
      */
  }
}
