/*
  다형성(polymorphism): overloading(오버로딩)
  -파라미터 개수나 파라미터의 타입이 다르더라도 결국 동일한 기능을 수행할 경우
  메서드의 이름을 같게 하는 것
  
*/


package java01.test38;




// Scores : 학생의 이름과 국어, 영어, 수학, 평균, 합계를 저장하는
//             메모리의 데이터 형이다.
public class Scores {
  String name; //용어: 인스턴스 변수, 속성(attribute)
  int kor;
  int eng;
  int math;
  int sum;
  float average;

  public Scores(String name, int kor, int eng, int math){
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;    
    compute();
  }
  
  public Scores(String name){
    this.name = name;    
    compute();
  }

  public Scores() {
    // TODO Auto-generated constructor stub
  }

  public void compute(){
    this.sum = this.kor + this.eng + this.math;
    this. average = this.sum / 3.0f;
  }
  
  public void result(){
      System.out.println("이름:"+this.name);
      System.out.println("국어:"+this.kor);
      System.out.println("영어:"+this.eng);
      System.out.println("수학:"+this.math);
      System.out.println("합계:"+this.sum);
      System.out.println("평균:"+this.average);
  }
  
 
  
}
