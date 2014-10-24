/* 
  배열
  -같은 종류의 데이터를 여러 개 저장할 때 사용
  같은 종류의 메모리를 여러 개 생성하는 방법
  new 데이터[개수];
  new 데이터형[]{값,값,값};

 */

package net.java63;

import java.util.ArrayList;
import java.util.Date;

public class Test13 {

  public static void main(String[] args) {
    int kor, eng, math, sci, soc;
    kor =100;
    eng = 80;
    math =100;
    sci =90;
    soc =100;
    
    //배열 생성: 4바이트 메모리를 연속해서 준비한다.
    //준비된 메모리의 첫 바이트 주소를 변수에 저장해야한다.
    //이렇게 주소를 저장하는 변수 = > reference (참조변수)
    //c에서는 pointer라 한다.
    //int scores[] = new int[5]; //c방식도 허용
    int[] scores = new int[]{}; //신규 배열 3개 생성 및 주소 항당

    scores[0] = 100;
    scores[1] = 90;
    scores[2] = 80;
    
    
    
    //scores[4] = 20; //runtime Exception :실행 중에 발생하는 에러
    
    
    
   
     for(int i =0; i<scores.length; i++){
     System.out.println(scores[i]);
     }
   
      
      
  }
}
