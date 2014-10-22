package java01.test51;

/* 버킷 관리 */
// 시작과 끝 버킷은 알고있어야함

class MyLinkedList {
  
  class Bucket{
    Object value;
    Bucket next;
  }

  Bucket start;
  Bucket end;

  int size;
  

  public MyLinkedList() {
    start = new Bucket();
    end = start;
  }

  public int add(Object value) {
    end.value = value;
    end.next = new Bucket();
    end = end.next;
    return ++size;
  }

  private Bucket getBucketByIndex(int index){
    Bucket cursor = start;
    
    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    return cursor;
  };  
  
  
  public Object get(int index) {
    if (index < 0 || index >= this.size)
      return null;

    return  getBucketByIndex(index).value;
  }

  public int size() {
    return size;
  }
  
  
  
  public int insert(int index, Object obj) {
    if (index < 0 || index >= this.size)
      return -1;
    
    Bucket temp = new Bucket();
    temp.value = obj;
    
    
    if(index == 0){
      temp.next = start;
      start = temp;
    }else{
      
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
    
    Bucket cursor = start;
    if(index == 0){
      start = start.next;
    }else{
      Bucket cursor = getBucketByIndex(index - 1);
      cursor.next = cursor.next.next;
    }
    size--;
    return 0;
    
  }

}

public class CollectionTest04 {

  public static void printArray(MyLinkedList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  public static void main(String[] args) {
    MyLinkedList arr = new MyLinkedList();
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
    
   
/*   System.out.println("-1에 입력");
    arr.insert(-1, "-1에 입력");
    printArray(arr);
    
    System.out.println("30에 입력");
    arr.insert(30, "30에 입력");
    printArray(arr);
    
    System.out.println("0번에 ! 입력");
    arr.insert(0, "!!!!!!!");
    printArray(arr);
    
    System.out.println("8번에 @ 입력");
    arr.insert(8, "@@@@@@@@");
    printArray(arr);
    
    System.out.println("4번에 # 입력");
    arr.insert(4, "########");
    printArray(arr);
    
   */
    
    System.out.println("-30번 삭제-------");
    arr.remove(-30);
    printArray(arr);
    
    System.out.println("30번 삭제-------");
    arr.remove(30);
    printArray(arr);
    
    System.out.println("10번 삭제-------");
    arr.remove(10);
    printArray(arr);
    
    System.out.println("0번 삭제-------");
    arr.remove(0);
    printArray(arr);
    
    System.out.println("4번 삭제-------");
    arr.remove(4);
    printArray(arr);
    
    System.out.println("6번 삭제-------");
    arr.remove(6);
    printArray(arr);
    
    
  }

}
