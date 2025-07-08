package dev.obrienlabs.mathematics;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * Option 1: brute force 2 dimensional array
 * Option 2: single dimensional array - using positional r/c arithmetic
 */
public class MatrixImpl implements Matrix {

	// Primitives
	private final int rowSize;
	private final int colSize;
	double[] cells;// = new double[rowSize][colSize];
	
	
	// OO
	private Map<Integer, Map<Integer, Number>> rowMap = new ConcurrentHashMap<>();
	private Map<Integer, Number> colMap = new ConcurrentHashMap<>();
	
	
	public MatrixImpl(int rows, int cols) {
		rowSize = rows;
		colSize = cols;
		cells = new double[rowSize * colSize];
	}
	
	@Override
	public Matrix add(Matrix m1) {
		Matrix m3 = new MatrixImpl(m1.rowSize(), m1.colSize());
		//for(int r=0;r<m3.rowSize(); r++) {
		//	for(int c=0;c<m3.colSize(); c++) {
		//		m3.set(r, c, m1.get(r, c) + this.get(r, c));
		//	}
		//}
		// create an iterative sequence and get both arrays by position
		IntStream.range(0, rowSize * colSize)
			.forEach(i -> m3.set(i, m1.get(i) + this.get(i)));
		return m3;
	}

	@Override
	public Matrix subtract(Matrix m1) {
		Matrix m3 = new MatrixImpl(m1.rowSize(), m1.colSize());
		IntStream.range(0, rowSize * colSize)
			.forEach(i -> m3.set(i, this.get(i) - m1.get(i)));
		return m3;
	}

	@Override
	public Matrix multiply(Matrix m1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, Map<Integer, Number>> getRowMap() { return rowMap; }

	public void setRowMap(Map<Integer, Map<Integer, Number>> rows) { this.rowMap = rows; }

	public Map<Integer, Number> getColMap() { return colMap; }

	public void setColMap(Map<Integer, Number> columns) { this.colMap = columns; }

	@Override
	public int rowSize() { return rowSize; }
	@Override
	public int colSize() { return colSize; }
	@Override
	public double get(int r, int c) { return cells[r * colSize + c]; }
	@Override
	public void set(int r, int c, double value) { cells[r * colSize + c] = value; }
	@Override
	public void set(int pos, double value) { this.cells[pos] = value; }
	@Override
	public double get(int pos) { return this.cells[pos]; }
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		//IntStream flat = Arrays.stream(cells).flatMapToInt(Arrays::stream);
		//flat.forEach(c -> buffer.append(c));
		//Arrays.stream(cells).forEach(r -> {
		//	buffer.append("[");
		//	Arrays.stream(r).forEach(c -> buffer.append(c).append(","));
		//	buffer.append("]");
		//});
		
		Arrays.stream(cells).forEach(c -> buffer.append(c).append(","));
		buffer.append("]");
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		Matrix m1 = new MatrixImpl(4,4);
		Matrix m2 = new MatrixImpl(4,4);
		m1.set(0, 0, 1);
		m2.set(0, 0, 2);
		m1.set(2, 1, 1);
		m2.set(1, 4, 2);
		Matrix m3 = m1.subtract(m2);
		System.out.println(m3);
		
	}

	
}
