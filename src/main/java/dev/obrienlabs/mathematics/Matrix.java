package dev.obrienlabs.mathematics;

public interface Matrix {

	void set(int r, int c, double value);
	void set(int pos, double value);
	double get(int r, int c);
	double get(int pos);
	Matrix add(Matrix m1);
	Matrix subtract(Matrix m1);
	Matrix multiply(Matrix m1) throws IllegalArgumentException;
	
	// statistics
	int rowSize();
	int colSize();
	
}
