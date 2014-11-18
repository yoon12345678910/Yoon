package java02.test21.spring.exam13;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	String model;
	int cc;
	Engine engine;
	Set<Tire> tire;
	Map<String, Object> options;
	
	public Car(){}
	
	public Car(String model){	
		this.model = model;
	}	
		
	public Car(String model, int cc){
		this.model =model;
		this.cc = cc;
	}
	




	@Override
	public String toString() {
		return "Car [model=" + model + ", cc=" + cc + ", engine=" + engine
				+ ", tire=" + tire + ", options=" + options + "]";
	}

	public Set<Tire> getTire() {
		return tire;
	}

	public void setTire(Set<Tire> tire) {
		this.tire = tire;
	}

	public Map<String, Object> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Object> options) {
		this.options = options;
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
	
	public Engine getEngine() {
		return engine;
	}

	
	
	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
}
