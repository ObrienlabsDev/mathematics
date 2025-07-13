package dev.obrienlabs.mathematics.data;

import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Multiply a matrix row by a matrix column vector
 */
public class DotProduct {
	
	private List<Double> rowCells;
	private List<Double> colCells;
	
	
	public Double computeDotProduct() {
		DoubleAdder dp = new DoubleAdder();
		IntStream.range(0, rowCells.size()).forEach(
				i -> dp.add(rowCells.get(i) * colCells.get(i)));
		return dp.doubleValue();
	}
	
	public List<Double> getRowCells() {
		return rowCells;
	}

	public void setRowCells(List<Double> rowCells) {
		this.rowCells = rowCells;
	}

	public List<Double> getColCells() {
		return colCells;
	}

	public void setColCells(List<Double> colCells) {
		this.colCells = colCells;
	}

	public static void main(String[] args) {
		DotProduct dp = new DotProduct();
		//List<Integer> list = IntStream.range(0, 3).asDoubleStream().collect(Collectors.toList());
		List<Double> list = IntStream.range(0, 3)
				.mapToDouble(i -> Double.parseDouble(Integer.toString(i)))
				.boxed().
				collect(Collectors.toList());
		dp.setColCells(list);
		dp.setRowCells(list);
		System.out.println(dp.computeDotProduct());
		

	}

}
