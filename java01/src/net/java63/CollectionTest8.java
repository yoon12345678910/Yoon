package net.java63;

class MyStack {

  Object[] list = new Object[100];
  int top;

  public void push(Object value) {
    if(top < 100){
      this.list[this.top++] = value;
    }else{
      System.out.println("꽉참");
    }
  }

  // 마지막에 입력한 값을 꺼낸다.
  public Object pop() { // 꺼낸다 목록에서 제거됨
    if(list.length > 0){
      Object temp = list[--this.top];// 꺼낸다 목록에서 제거됨
      list[top] = null;
      return temp;
    }else{
      System.out.println("비었음");
    }   
    return null;
  }
}

class MyQueue {
  class Bucket {
    Object value;
    Bucket next;
  }

  Bucket start;
  Bucket end;
  
  public MyQueue() {
    start = new Bucket();
    end = start;
  }

  public void add(Object value) {
    end.value = value;
    end.next = new Bucket();
    end = end.next;
  }

  // 첫 번째 입력 값을 꺼낸다.
  public Object poll() {// 꺼낸다 목록에서 제거됨
   
    Bucket temp = start;
    start = start.next;
    
    
    
    
    return temp.value; 
  }

}

public class CollectionTest8 {

  public static void main(String[] args) {

    MyStack stack = new MyStack();
    stack.push("00000");
    stack.push("11111");
    stack.push("22222");
    stack.push("33333");
  

    for (int i = 0; i < 4; i++) {
      System.out.println(stack.pop());
    }
    /*
     * 예상 출력 결과 
     * 
     * 33333 
     * 22222 
     * 11111 
     * 00000
     */
    
    MyQueue queue = new MyQueue();
    
    
    queue.add("AAAAA");
    queue.add("BBBBB");
    queue.add("CCCCC");
    queue.add("DDDDD");
    

    //System.out.println(queue);
    for (int i = 0; i < 4; i++) {
      System.out.println(queue.poll());
    }

    /*
     * 예상 출력 결과 
     * AAAAA 
     * BBBBB 
     * CCCCC 
     * DDDDD 
     * EEEEE
     */

  }

}
