package dev.obrienlabs.mathematics;

public interface Matrix {

	void set(int r, int c, int value);
	int get(int r, int c);
	Matrix add(Matrix m1);
	Matrix subtract(Matrix m1);
	Matrix multiply(Matrix m1);
	
	// stats
	int rowSize();
	int colSize();
	
}
