/* 
 * 2진수, 8진수, 10진수, 16진수 표현
  2진수: 표현 불가!
  8진수: 0으로 시작
  10진수:...
  16진수:0X 또는 0x로 시작

 */

package java01;

public class Test10 {

  public static void main(String[] args) {
    int i =13;
    int i2 = 015; //8진수
    int i3 = 0xd;//두 번째로 많이 사용
    int i4 = 0Xd;
    int i5 = 0xD;//가장많이사용
    int i6 = 0XD;
  
  System.out.println(i);
  System.out.println(i2);
  System.out.println(i3);
  System.out.println(i4);
  System.out.println(i5);
  System.out.println(i6);
  }
}

-------------------------------------------
1.다음 중 오류 코드는?     (1,4,5)
    1. char A = '가나다';
    2. long _b = 12345;
    3. boolean $c = true;
    4. int[] scores = new int[3]{10,20,30};
    5. byte e;
       System.out.printf(e);

-------------------------------------------
 2. 변수의 옳바른 선언은?  (2,5)
    1. int i123 = 123.20;
    2. short 숫자 = 123;
    3. boolean _abc = 1;
    4. byte 20 = 20;
    5. double A = 123.20;
 
    
 ------------------------------------------
 안녕하세요.
 자바자바자바~

 3.다음과 같이 console 창에 띄우려면 어떤 코드를 사용해야 할까요? (3, 5)
    1. console.log("안녕하세요.\n");
       console.log("자바자바자바~");
    2. System.out.printf("안녕하세요.");
       System.out.printf("자바자바자바~");
       
    3. System.out.print("안녕하세요.\n");
       System.out.print("자바자바자바~");
    4. System.out.println('안녕하세요.');
       System.out.println('자바자바자바~');
    5. System.out.println("안녕하세요.");
       System.out.print("자바자바자바~");
   
       
       
  -------------------------------------------
  4.이 중에서 자바에서 사용하는 주석은? (1, 2, 4)
     1. // 주석
     2. /* 주석 */
     3. <!-- 주석 -->
     4. /** 주석 */
     5. <%-- 주석 --%>  
     
     
 -------------------------------------------    
  5.다음 배열 선언 중 옳바른 것은?  (1, 5)
   1.int scores[] = new int[]{10,20,30};
   2.byte[] scores = new byte[5]{10,20,30,40,50};
   3.double[] scores = new double(20,30);
   4.int scores[] = new int[5]{};
   5.String[] scores = new String[2];
  
   
   -------------------------------------------   
  6.다음dms Test02.java 파일이다. 오류가 발생하는 곳은? (1, 2 ,3)
      

    public class Test02{}

  (1)public static void class Test02W{}

  (2)class Test02{}

  (3)void class Test02X{}

  (4)class Test02Y{}

  (5)class Test02Z{}
  
  
  -------------------------------------------  
  7.다음 중 틀린 것은? (2, 3)
      1. 자바는 운영체제에 상관없이 class 파일을 생성한다.
      2. 자바는 운영체제에 종속되는 언어이다.
      3. 터미널에서 javac 파일명.java로 컴파일한다.
      4. 컴파일하면 java 파일이 생성된다.
      5. 파일명.class를 바이트코드라고 부른다.
      
      
주관식

주관식
-----------------------------------------
1.빈칸의 답을 순서대로 적으시오.
   a.bin       b.int     c.Gargage   
   d.heap      e.class

*자바코드는 반드시 (    )안에 작성해야한다.
*컴파일을하면 (    )폴더에 class 파일이 생성된다.
*참조하는 변수가 없는 메모리를 (    )라고 한다.
*Gargage Collectorr가 관리하는 메모리 영역은 (     )이다.
*int[] p = new (   )[3];
답 e - a - c - d - b
  
  
-----------------------------------------
2.다음 코드를 설명하시오
long minLong = Long.MIN_VALUE;

답)long이라는 데이터형식이 가질 수 있는 최소의 값을 minLong이라는 변수에 할당한다.

-----------------------------------------
3.자바에서 =와 ==의 차이를 말하시오
답)
'=' 이란 할당(assignment) 연산자
'==' equal 연산자 이다!







      