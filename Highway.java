
public class Highway extends Tile {
	private int carDensity;  //comment
	public Highway(int carDensity) {
		super();
		this.carDensity = carDensity;
		setMeasurement(carDensity * CARS_WASTE);
	}
	@Override
	public Force strengthen(Force force) {
		Force clone = force.clone();
		clone.setLoad(clone.getLoad() + (carDensity * CARS_WASTE));
		return clone;
	}
	@Override
	public boolean canPropagate() {
		return true;
	}
}
