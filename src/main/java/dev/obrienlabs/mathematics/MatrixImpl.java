package dev.obrienlabs.mathematics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatrixImpl implements Matrix {

	
	private Map<Integer, Number> rows = new ConcurrentHashMap<>();
	private Map<Integer, Number> columns = new ConcurrentHashMap<>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Matrix add(Matrix m1) {
		// TODO Auto-generated method stub
		return null;
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

	public Map<Integer, Number> getRows() {
		return rows;
	}

	public void setRows(Map<Integer, Number> rows) {
		this.rows = rows;
	}

	public Map<Integer, Number> getColumns() {
		return columns;
	}

	public void setColumns(Map<Integer, Number> columns) {
		this.columns = columns;
	}

}
