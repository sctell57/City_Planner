
public class Nature extends Tile {
	private int treeDensity; //comment

	public Nature(int treeDensity) {
		super();
		this.treeDensity = treeDensity;
		setMeasurement(0);
	}

	public int getTreeDensity() {
		return treeDensity;
	}

	public void setTreeDensity(int treeDensity) {
		this.treeDensity = treeDensity;
	}

	@Override
	public Force strengthen(Force force) {

		return force.clone();
	}
	@Override
	public Force weaken(Force force) {
		Force newforce = force.clone();
		double newLoad = (newforce.getLoad() * (treeDensity / 100.0));
		double reduce = (newforce.getLoad() - newLoad);
		if (reduce <= 0)
			newforce.setLoad(0);
		else
			newforce.setLoad(reduce);
		return newforce;
	}

	@Override
	public boolean canPropagate() {
		if (treeDensity <= 50)
			return true;
		else
			return false;
	}

}
