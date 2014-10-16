/* 
  클래스 변수
  -클래스를 로딩할 때 준비되는 변수
  -Method Area 영역에 준비됨
  -JVM이 실행이 좋료할 때까지 유지
  
 *로컬변수
 *함수가 호출될 때 준비되는 변수
  -Stack영역에 준비됨
 *함수 호출이 끝나면 제거된다.
  
  
 *인스턴스 변수
  -인스턴스가 생성될 때 준비되는 변수
  -Heap 영역에 준비됨
  -가비지 컬렉터에 의해 해제되기 전까지 존재한다.
  
 
 */

package java01;

import java.util.Scanner;

public class Test27 {

  static int v1;
  static int v2;
  static String op;
  static int result;

  static void compute() {
    switch (op) {
    case "+":result = v1 + v2;break;
    case "-":result = v1 - v2;break;
    case "*":result = v1 * v2;break;
    case "/":result = v1 / v2;break;
    default :System.out.println("op선택 잘못핬습니다.");
    }
  }

  static void displayResult() {
    System.out.println("****************");
    System.out.printf("%d %s %d = %d \n", v1, op, v2, result);
    System.out.println("***  *************");
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("값1?");
    v1 = Integer.parseInt(scan.nextLine());

    System.out.print("값2?");
    v2 = Integer.parseInt(scan.nextLine());

    System.out.print("연산자?");
    op = scan.nextLine();
    compute();
    // 메서드 호출: 반드시 호출할 때 정확하게 파라미터를 넘겨야 한다.
    displayResult();

  }
}
