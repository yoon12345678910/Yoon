/*
  HashMap 사용하기
  key - value의 쌍으로 데이터를 관리한다.
  key로 사용할 클래스는 hashCode(), equals()를 재정의 해야한다.
    => 인스턴스가 다르더라도 값이 같으면 같은 
          해시코드를 리턴하도록 구현해야 한다
    =>값이 같으면 equals()가 true를 리턴한다.
  기존에 자바에서 제공하는 클래스들 중에서 String과 랩퍼 클래스들은 
  hashCode()와 equals()를 재정의했기 때문에 키로 사용할 수 있다.
 */
package java01.test52;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class CollectionTest04 {
/*
   member inner class
   -인스턴스 메소드나 같은 멤버 이너 클래스만이 이 클래스를 사용할 수 있다.
   참고: 클래스 멤버란? 클래스를 구성하고 있는 원소. 변수, 메소드, 이너 클래스.
  */
  
  /* static이 붙으면 top level inner class
  -member inner 클래스에서 static을 붙인 클래스
  클래스 메소드나 static 블록에서 사용할 수 있다.
  */
  static class Score{
    String name;
    int kor;
    int eng;
    int math;
    
    public Score(String n, int k, int e, int m){
      this.name = n;
      this.kor = k;
      this.eng = e;
      this.math = m;
    }
  }
  
  /*static 블록에서는 오로지 클래스 변수 및 클래스 메소드만 사용할 수 있다.
  이유
    =>
           class A{
           int value;
           
           void print(){System.out.println(value);}
           static void test(){
             print(); //호출가능 하다면 어떤 일이 생길까?
             }
           }
   */
  public static void main(String[] args) {
    HashMap<String, Score> map = new HashMap<String, Score>();  
    map.put("111", new Score("홍길동", 100, 100, 100));
    //key는 중복될 수 없다. 따라서 임꺽정 데이터는 기존 데이터를 덮어 버린다.
    map.put("111", new Score("임꺽정", 100, 100, 100));
    map.put("222", new Score("유관순", 90, 90, 90));
    
    System.out.println(map.get("111").name);
    System.out.println(map.get("222").name);
    
    //질문 : 키를 모른다고 가정하고 map에 저장된 값을 모두 출력하시오
    //힌트 : API문서를 보시오.
    
    
    System.out.println("=-=-=-=-=-entrySet-=-=-=-=-=-=-=-");
     Set<Entry<String, Score>> kvSet = map.entrySet();
      for(Entry<String, Score> entry : kvSet){
          System.out.println(entry.getKey() + ":"
                                      + entry.getValue().name);
      }
      
      System.out.println("=-=-=-=-=-keySet-=-=-=-=-=-=-=-=-");
    Set<String> keySet = map.keySet();
      for(String key : keySet){
        System.out.println(key + ":" + map.get(key).name);
      }
      
      System.out.println("=-=-=-=-=-values-=-=-=-=-=-=-=-=-");
      Collection<Score> valueList = map.values();
      for(Score value : valueList){
        System.out.println(value.name);
      }
  }
  }
