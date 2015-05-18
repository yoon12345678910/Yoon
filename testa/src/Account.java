import java.io.Serializable;


public class Account implements Serializable, Cloneable{
	private String accountName;
	private int accountNo;
	private String bankName;
	private String bankPhone;
	private int money = 0;
	
	public Account(){};
	
	public Account(String accountName, int accountNo, String bankName, String bankPhone){
		this.accountName = accountName;
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.bankPhone = bankPhone;
	}

	@Override
	public Account clone() throws CloneNotSupportedException {
		return (Account)super.clone();
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankPhone() {
		return bankPhone;
	}

	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}

	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}


	public void deposit(int money) {
		this.money += money;
	}
	
	public void withdraw(int money) {
		this.money -= money;
	}
	
	
	
	
	 
}
