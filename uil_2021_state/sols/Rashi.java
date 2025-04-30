import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Rashi {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("rashi.dat"));
		s.useDelimiter(",|\\R");
		int T = s.nextInt();
		for (int t = 1; t <= T; t++) {
			out.printf("TEST CASE #%d: \n", t);
			int D = s.nextInt();
			int R = s.nextInt();
			int C = s.nextInt();
			float [][][] data = new float[D][R][C];
			for (int d = 0; d < D; d++)
				for (int r = 0; r < R; r++)
					for (int c = 0; c < C; c++)
						data[d][r][c] = s.nextFloat();
			ArrayList<Float> clusters = new ArrayList<Float>();
			for (int d = 0; d < D; d++)
				for (int r = 0; r < R; r++)
					for (int c = 0; c < C; c++)
						if (data[d][r][c] != 0) {
							float sum = data[d][r][c];
							ArrayList<Cell> next = new ArrayList<Cell>();
							next = new Cell(d,r,c,data[d][r][c]).getNeighbors(data);
							if (next.size() > 0) {  // have a cluster
								data[d][r][c] = 0;
								while (next.size() > 0) {
									sum += next.get(0).celldata;
									data[next.get(0).layer][next.get(0).row][next.get(0).col] = 0;
									next.addAll(next.remove(0).getNeighbors(data));
								}
								clusters.add(-sum);
							}
						}
			clusters.sort(null);
			if (clusters.size() == 0) out.println("NO CLUSTERS FOUND");
			while (clusters.size() > 0) out.printf("%4.2f\n", -clusters.remove(0));
			out.println("============");
		}
	}
}

class Cell {
	int layer, row, col;
	float celldata;
	
	public Cell(int d, int r, int c, float v) {
		layer = d;
		row = r;
		col = c;
		celldata = v;
	}
	
	ArrayList<Cell> getNeighbors(float [][][] data) {
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		// check west (col-1)
		if (this.col > 0 && data[this.layer][this.row][this.col-1] > 0) {
			neighbors.add(new Cell(this.layer, this.row, this.col-1, data[this.layer][this.row][this.col-1]));
			data[this.layer][this.row][this.col-1] = 0;
		}
		// check east (col+1)
		if (this.col < data[this.layer][this.row].length-1 && data[this.layer][this.row][this.col+1] > 0) {
			neighbors.add(new Cell(this.layer, this.row, this.col+1, data[this.layer][this.row][this.col+1]));
			data[this.layer][this.row][this.col+1] = 0;
		}
		// check north (row-1)
		if (this.row > 0 && data[this.layer][this.row-1][this.col] > 0) {
			neighbors.add(new Cell(this.layer, this.row-1, this.col, data[this.layer][this.row-1][this.col]));
			data[this.layer][this.row-1][this.col] = 0;
		}
		// check south (row+1)
		if (this.row < data[this.layer].length-1 && data[this.layer][this.row+1][this.col] > 0) {
			neighbors.add(new Cell(this.layer, this.row+1, this.col, data[this.layer][this.row+1][this.col]));
			data[this.layer][this.row+1][this.col] = 0;
		}
		// check up (layer-1)
		if (this.layer > 0 && data[this.layer-1][this.row][this.col] > 0) {
			neighbors.add(new Cell(this.layer-1, this.row, this.col, data[this.layer-1][this.row][this.col]));
			data[this.layer-1][this.row][this.col] = 0;
		}
		// check down (layer+1)
		if (this.layer < data.length-1 && data[this.layer+1][this.row][this.col] > 0) {
			neighbors.add(new Cell(this.layer+1, this.row, this.col, data[this.layer+1][this.row][this.col]));
			data[this.layer+1][this.row][this.col] = 0;
		}
		return neighbors;
	}
}
