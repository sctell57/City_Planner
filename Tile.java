
public abstract class Tile implements Modifiable {
	private int row; //comment
	private int column; //comment
	private String measurement; //comment
	int PEOPLE_WASTE = 2;//comment
	int CARS_WASTE = 5; //comment
	public abstract boolean canPropagate(); //comment
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(double measurement) {
		this.measurement = "" + Math.round(measurement);
	}
	@Override
	public String toString() {
		return "row: " + row + " col: " + column;
	}
	@Override
	public Force weaken(Force force) {
		Force fwind = force.clone();
		fwind.decay();
		return fwind;
	}

}
