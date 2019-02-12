
public class Force {
	private double load; //comment
	private String name; //comment
	public Force(double load, String name) {
		this.load = load;
		this.name = name;
		
	}
	public double getLoad() {
		return load;
	}
	public void setLoad(double load) {
		this.load = load;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void decay() {
		load = (load *.8);
	}
	@Override
	public Force clone() {
		return new Force(load, name);
	}
	@Override
	public String toString() {
		return name + " has a load of " + Math.round(load);
		
	}
}
