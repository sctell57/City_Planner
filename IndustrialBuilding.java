
public class IndustrialBuilding extends Building {
	private double emissions; //comment
	private int EMISSIONS_CONSTANT = 10; //comment
	public IndustrialBuilding(int people, int cars, int height,double emissions) {
		super(people, cars, height);
		this.emissions = emissions;
		setMeasurement((people * PEOPLE_WASTE) + (cars * CARS_WASTE)  + (emissions * EMISSIONS_CONSTANT));
	}
	public double getEmissions() {
		return emissions;
	}
	public void setEmissions(double emissions) {
		this.emissions = emissions;
	}
	@Override
	public Force strengthen(Force force) {
		Force clone = force.clone();
		clone.setLoad(clone.getLoad() + (getPeople() * PEOPLE_WASTE) + (getCars() * CARS_WASTE) + (emissions * EMISSIONS_CONSTANT));
		return clone;
	}
	@Override
	public boolean canPropagate() {
		return true;
	}
	
	
}
