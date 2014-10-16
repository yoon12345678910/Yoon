/* 
 반복문
  while(조건)명령문
  while(조건){...}
  
  do 명령문; while(조건);
  do{...} while(조건);
  
  for(초기화명령문; 조건; 증가문){...}
   for(변수:배열이나 collection 타입 객체)
  
   //퀴즈 
    //1에서 20까지 출력하라 
    //3배 배수는 출력하지 말라!
    //while문을사용하라
    
    
  
*
*/

package java01;


public class Test21 {

  public static void main(String[] args) {
   
    
    int i = 0;
    while(i<21 ){
      i++;
      if(i%3!=0){
        System.out.println(i);
      }
      
    }
    
    
    
    
  }
  
}
