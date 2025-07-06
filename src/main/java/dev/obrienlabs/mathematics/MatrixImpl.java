package dev.obrienlabs.mathematics;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class MatrixImpl implements Matrix {

	// Primitives
	private int rowSize = 4;
	private int colSize = 4;
	int[][] cells;// = new int[rowSize][colSize];
	
	
	// OO
	private Map<Integer, Number> rowMap = new ConcurrentHashMap<>();
	private Map<Integer, Number> colMap = new ConcurrentHashMap<>();
	
	
	public MatrixImpl(int rows, int cols) {
		rowSize = rows;
		colSize = cols;
		cells = new int[rowSize][colSize];
	}
	
	@Override
	public int get(int r, int c) {
		return cells[r][c];
	}
	
	@Override
	public void set(int r, int c, int value) {
		cells[r][c] = value;
	}
	
	@Override
	public Matrix add(Matrix m1) {
		Matrix m3 = new MatrixImpl(m1.rowSize(), m1.colSize());
		for(int r=0;r<m3.rowSize(); r++) {
			for(int c=0;c<m3.colSize(); c++) {
				m3.set(r, c, m1.get(r, c) + this.get(r, c));
			}
		}
		return m3;
	}

	@Override
	public Matrix subtract(Matrix m1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matrix multiply(Matrix m1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, Number> getRowMap() { return rowMap; }

	public void setRowMap(Map<Integer, Number> rows) { this.rowMap = rows; }

	public Map<Integer, Number> getColMap() { return colMap; }

	public void setColMap(Map<Integer, Number> columns) { this.colMap = columns; }

	@Override
	public int rowSize() { return rowSize; }

	@Override
	public int colSize() { return colSize; }
	
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("[");
		//IntStream flat = Arrays.stream(cells).flatMapToInt(Arrays::stream);
		//flat.forEach(c -> buffer.append(c));
		Arrays.stream(cells).forEach(r -> {
			buffer.append("[");
			Arrays.stream(r).forEach(c -> buffer.append(c).append(","));
			buffer.append("]");
		});
		buffer.append("]");
		return buffer.toString();
	}
	

	public static void main(String[] args) {
		Matrix m1 = new MatrixImpl(4,4);
		Matrix m2 = new MatrixImpl(4,4);
		m1.set(0, 0, 1);
		m2.set(0, 0, 2);
		Matrix m3 = m1.add(m2);
		System.out.println(m3);
		
	}

	
}
