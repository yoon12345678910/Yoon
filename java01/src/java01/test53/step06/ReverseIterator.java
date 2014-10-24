package java01.test53.step06;

public class ReverseIterator extends AbstractIterator{
  int cursor;
  
  public ReverseIterator(){}
  
  @Override
  public void setList(String[] list){
   /*
    super 키워드 : 오버라이딩 전의 메소드를 가리킬 때 사용.
    주의)super는 수퍼 클래스를 가리키는 것이 아니다!!!!! 
           상속 받기전이 오버라이딩 전 상태임;
    */
    super.setList(list); //기존 기능은 그대로 두고 
    cursor = list.length -1; // 새로운 명령 추가
  }
  
  public boolean hasNext(){
    if(cursor >= 0)
      return true;
    else
      return false;
  }
  
  public String next(){
    return list[cursor--];
  }
}
