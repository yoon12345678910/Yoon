package apple;

class Seller {
  private int appleCount;
  int applePrice;
  private int Money;

  Seller(int count, int price, int money) {
    this.appleCount = count;
    this.applePrice = price;
    this.Money = money;
  }

  int sale(int count) {
    this.appleCount -= count;
    this.Money += this.applePrice * count;
    return count;
  }

  void show() {
    System.out.println("사과의 수:" + appleCount);
    System.out.println("보유금액:" + Money);
  }
}


class Buyer {
  private int appleCount = 0;
  private int Money;

  Buyer(int money) {
    this.Money = money;
  }

  void buy(int count, int price) {
    this.appleCount += count;
    this.Money -= price * count;
  }

  void show() {
    System.out.println("사과의 수:" + appleCount);
    System.out.println("보유금액:" + Money);
  }
}

public class test01 {

  public static void main(String[] args) {

    Seller seller1 = new Seller(30, 2000, 10000);
    Seller seller2 = new Seller(20, 1500, 10000);

    Buyer buyer = new Buyer(30000);

    System.out.println("사과장수1");
    seller1.show();
    System.out.println("사과장수2");
    seller2.show();
    System.out.println("구입자");
    buyer.show();
    System.out.println("------------------------------------");

    buyer.buy(seller1.sale(4), seller1.applePrice);
    System.out.println("사과장수1");
    seller1.show();
    System.out.println("구입자");
    buyer.show();

    System.out.println("------------------------------------");

    buyer.buy(seller2.sale(3), seller2.applePrice);
    System.out.println("사과장수2");
    seller2.show();
    System.out.println("구입자");
    buyer.show();

  }
}
