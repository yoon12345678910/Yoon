package java01.test53.step04;

public class ReverseIterator {
  String[] list;
  int cursor;
  
  public ReverseIterator(){}
  
  public ReverseIterator(String[] list){
    this.list = list;
    cursor = list.length -1; 
  }
  
  public void setList(String[] list){
    this.list = list;
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
