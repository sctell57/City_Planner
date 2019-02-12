
public class BodyOfWater extends Tile {
	public BodyOfWater() {
		super();
		setMeasurement(0); 
	}
	
	@Override
	public Force strengthen(Force force) {
		return force.clone();
	}

	@Override
	public boolean canPropagate() {
		return true;
	}
	
}
