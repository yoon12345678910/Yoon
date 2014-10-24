/*









 */
package java01.test51;

/* 버킷 관리 */
// 시작과 끝 버킷은 알고있어야함

class MyLinkedList4 {

  /*
   * member inner class 멤버 inner 클래스는 바깥 클래스의 인스턴스에 접근할 수 있따. 메소드처럼 생각하면 된다.
   */

  class Iterator {

    Bucket cursor = start;

    public boolean hasNext() {
      if (cursor != end)
        return true;
      else
        return false;
    }

    public Object next() {
      Object value = cursor.value;
      cursor = cursor.next;
      return value;
    }
  }

  class Bucket {
    Object value;
    Bucket next;
  }

  Bucket start;
  Bucket end;

  int size;

  public MyLinkedList4() {
    start = new Bucket();
    end = start;
  }

  public Iterator iterator() {
    return new Iterator();
  }

  public int add(Object value) {
    end.value = value;
    end.next = new Bucket();
    end = end.next;
    return ++size;
  }

  private Bucket getBucketByIndex(int index) {
    Bucket cursor = start;
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    } // for
    return cursor;
  }

  public Object get(int index) {
    if (index < 0 || index >= this.size)
      return null;

    return getBucketByIndex(index).value;
  }

  public int size() {
    return size;
  }

  public int insert(int index, Object obj) {
    if (index < 0 || index >= this.size)
      return -1;

    Bucket temp = new Bucket();
    temp.value = obj;

    if (index == 0) {
      temp.next = start;
      start = temp;
    } else {

      Bucket cursor = getBucketByIndex(index - 1);
      temp.next = cursor.next;
      cursor.next = temp;
    }
    size++;
    return 0;
  }

  public int remove(int index) {
    if (index < 0 || index >= this.size)
      return -1;

    if (index == 0) {
      start = start.next;
    } else {
      Bucket cursor = getBucketByIndex(index - 1);
      cursor.next = cursor.next.next;
    }
    size--;
    return 0;
  }
}

public class CollectionTest04 {

  public static void printArray(MyLinkedList4 list) {
    MyLinkedList4.Iterator iterator = list.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  public static void main(String[] args) {
    MyLinkedList4 arr = new MyLinkedList4();

    for (int i = 0; i < 10000; i++) {
      arr.add("==>" + i);
    }
    
    Object value = null;

    System.out.println("get(i)사용하기------------");
   long start = System.currentTimeMillis();
    int size = arr.size();
    for(int i = 0; i < size; i++){
     System.out.println(".");
   }
    long end = System.currentTimeMillis();
     System.out.println("\n소요 시간: " + (end - start));
    
    System.out.println("Iterator 사용하기------------");
    start = System.currentTimeMillis();
    MyLinkedList4.Iterator iterator = arr.iterator();
    while(iterator.hasNext()){
      value = iterator.next();
      System.out.println(".");
    }
    end = System.currentTimeMillis();
    System.out.println("\n소요 시간: " + (end - start));
    
    
    
  }

  public static void main01(String[] args) {
    MyLinkedList4 arr = new MyLinkedList4();
    arr.add("00000");
    arr.add("11111");
    arr.add("22222");
    arr.add("33333");
    arr.add("44444");
    arr.add("55555");
    arr.add("66666");
    arr.add("77777");

    System.out.println("------------");
    printArray(arr);
  }
}
