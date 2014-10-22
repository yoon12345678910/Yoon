/*

static 블록
클래스가 로딩 > 클래스 변수 준비 +> static 블록 쇼리행
클래스가 로딩된 후 클래스 변수를 초기화 하는 용도로 사용


클래스 로딩은 단 한번만 수행된다. = > static 블록도 단 한번만 실행된다.
*/

package java01.test45;

public class ClassA {
  static int value;
  static {
    System.out.println("하하하하");
    value = 200;
  }
  
  static {
    System.out.println("호호호호");
  }


}
