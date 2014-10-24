package java01.test53.step02;

public class test02 {

  public static void main(String[] args) {

    Iterator iterator = new Iterator(args);

    while(iterator.hasNext()){
      System.out.println(iterator.next());
    }
  }
}
