package java02.test21.spring.exam03;

public class Car {
	String model;
	int cc;
	
	public Car(){}
	
	public Car(String model){	
		this.model = model;
	}
	
	public Car(String model, int cc){
		this.model =model;
		this.cc = cc;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
	
}
