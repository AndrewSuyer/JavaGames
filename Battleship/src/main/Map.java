package main;

public class Map {
	
		// instance variables:
	private int size;
	private CellValue[][] grid;
		
	public Map(int size) {
		// instantiates size and grid as well as setting all values of grid to empty
		this.size = size;
		this.grid = new CellValue[size][size];
		for (int i = 0; i < grid.length; i++) {	// sets all elements of grid to empty
			for (int j = 0; j < grid[i].length; j++) {
				setCellValue(i, j, CellValue.EMPTY);
			}
		}
	}
	
	public void setCellValue(int x, int y, CellValue c) {
		// sets CellValue of grid[x][y] 
		grid[x][y] = c;
	}
	
	public void setCellValue(Location l, CellValue c) {
		int x = l.getRowInt();
		int y = l.getCol();
		grid[x][y] = c;
	}
	
	public enum CellValue {
		// the map will not know the location of the ships,
		// only when a missile is shot will a ship reveal if it has been hit
		EMPTY,
		HIT,
		MISS;
	}

}
