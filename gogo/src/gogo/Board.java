package gogo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Cloneable {

  

  private String title;
  private  String content;
  private  String password;
  private  String date;

  public Board() {
    getDate();
  }

  public Board(String title, String content, String password) {
    this.title = title;
    this.content = content;
    this.password = password;
    this.date = getDate();
  }

   String getDate() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH");
    return this.date = sd.format(new Date());
  }
   
   
   @Override
  public Board clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return (Board) super.clone();
  }
   
   public String getTitle() {
     return title;
   }

   public void setTitle(String title) {
     this.title = title;
   }

   public String getContent() {
     return content;
   }

   public void setContent(String content) {
     this.content = content;
   }

   public String getPassword() {
     return password;
   }

   public void setPassword(String password) {
     this.password = password;
   }

   public void setDate(String date) {
     this.date = date;
   }
   

}
