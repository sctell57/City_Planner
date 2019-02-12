
public class Building extends Tile {
	private int people; //comment
	private int cars; //comment
	private int height; //comment
	public Building(int people, int cars, int height) {
		super();
		this.people = people;
		this.cars = cars;
		this.height = height;
		setMeasurement((people * PEOPLE_WASTE) + (cars * CARS_WASTE));
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getCars() {
		return cars;
	}
	public void setCars(int cars) {
		this.cars = cars;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public Force strengthen(Force force) {
		Force clone = force.clone();
		clone.setLoad(clone.getLoad() + (people * PEOPLE_WASTE) + (cars * CARS_WASTE));
		return clone;
		
	}
	@Override
	public boolean canPropagate() {
		if(height< 100 )
			return true;
		else
			return false;
	}
}
