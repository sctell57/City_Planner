
public class Map {
	private Tile[][] map; //comment
	private int freeRow; //comment
	private int freeColumn; //comment

	public Map(int width, int height) {
		map = new Tile[height][width];
	}

	public boolean addTile(Tile tile) {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if (map[row][col] == null) {
					map[row][col] = tile;
					tile.setRow(row);
					tile.setColumn(col);
					return true;
				}
			}
		}
		return false;
	}

	public Tile getTile(int row, int col) {
		return map[row][col];
	}

	public Tile[] getNeighbors(Tile tile, Direction direction) {
		Tile[] neighbors = new Tile[3];
		int index = 0;
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if (direction == Direction.NORTH) {
					if (row == (tile.getRow() - 1) && (col == tile.getColumn() - 1 || col == tile.getColumn()
							|| col == tile.getColumn() + 1)) {
						neighbors[index] = map[row][col];
						index++;
					}
				}
				if (direction == Direction.SOUTH) {
					if (row == (tile.getRow() + 1) && (col == tile.getColumn() - 1 || col == tile.getColumn()
							|| col == tile.getColumn() + 1)) {
						neighbors[index] = map[row][col];
						index++;
					}

				}
				if (direction == Direction.EAST) {
					if (col == (tile.getColumn() + 1)
							&& (row == tile.getRow() - 1 || row == tile.getRow() || row == tile.getRow() + 1)) {
						neighbors[index] = map[row][col];
						index++;
					}

				}
				if (direction == Direction.WEST) {
					if (col == (tile.getColumn() - 1)
							&& (row == tile.getRow() - 1 || row == tile.getRow() || row == tile.getRow() + 1)) {
						neighbors[index] = map[row][col];
						index++;
					}
				}
			}
		}
		if (index == 3)
			return neighbors;
		Tile[] newNeighbors = new Tile[index];
		for (int i = 0; i < index; i++) {
			newNeighbors[i] = neighbors[i];
		}
		return newNeighbors;
	}

	public void propagate(Force force, int row, int column, Direction direction) {
		Tile tile = getTile(row, column);

		Force weaken = tile.weaken(force);
		Force strengthen = tile.strengthen(force);
		tile.setMeasurement((strengthen.getLoad() + weaken.getLoad()) / 2);
		Tile[] neighbors = getNeighbors(tile, direction);
		force.setLoad((strengthen.getLoad() + weaken.getLoad()) / 2);

		// recursion below
		for (int i = 0; i < neighbors.length; i++)
			propagate(force, neighbors[i].getRow(), neighbors[i].getColumn(), direction);

	}
	@Override
	public String toString() {
		String str1 = "";
		String stringnew = "";
		for (Tile[] i : map) {
			for (Tile x : i) {
				stringnew = String.format("%-32s", x.getClass() + " " + x.getMeasurement());
				str1 += stringnew;
			}
			str1 += "\n";
		}

		return str1;

	}
}
