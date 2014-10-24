/* 

import
다른 패키지에 있는 클래스를 사용하려면 반드시 패키지 이름을 지정해야 한다.

예)java.util.ArrayList
그러나 import문을 사용하여 미리 클래스의 정보를 컴파일러에게 알려줄수있다.

예)import java.util.Array;
또는 클래스가 소속되어 있는 패키지 이름을 알려 줄 수 있다.

예)import java.util.*;
-가능한 클래스 이름까지 알려 주는게 소스 코드 해석에 도움이 된다.
컴파일 속도도 더 빠르다.
    
  
 *
 */

package net.java63;

//import 문은 컴파일러가 참조하는 명령어다.
//컴파일 후 제거된다.

public class Test26 {

  public static void main(String[] args) {

    for(int a = 0;  a <= 2; a++){
      System.out.println("하하");
    };
  }
}
