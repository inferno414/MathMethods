package mainpack;

public class Matrix {
	float[][] M;
	int size;
	
	public Matrix(int Size){
		size = Size;
		M = new float[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size ; j++){
				M[i][j] = 0;
			}
		}
	}
	public Matrix(Matrix other){
		size = other.size;
		M = new float[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size ; j++){
				M[i][j] = other.M[i][j];
			}
		}
	}
	public void Print(){
		for(float[] str : M){
			for(float elem : str){
				System.out.print(elem);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	public void Init(float[][] other) throws Exception{
		if (other.length != size){
			throw new Exception("Wrong size");
		}
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size ; j++){
				M[i][j] = other[i][j];
			}
		}
	}
	
	public void Init(float[] other) throws Exception{
		if (other.length != size*size){
			throw new Exception("Wrong size");
		}
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size ; j++){
				M[i][j] = other[i*size+j];
			}
		}
	}

	public boolean Equals(Matrix other){
		for(int i = 0 ; i< size; i++){
			for(int j = 0; j < size; j++){
				if (M[i][j] != other.M[i][j]) 
					return false;
			}
		}
		return true;
	}
	public boolean Equals(float[][] other){
		for(int i = 0 ; i< size; i++){
			for(int j = 0; j < size; j++){
				if (M[i][j] != other[i][j]) 
					return false;
			}
		}
		return true;
	}

	public Matrix Mult(Matrix B) throws Exception{
		if (size == B.size){
			Matrix res = new Matrix(size);
			for(int i = 0 ; i< size; i++){
				for(int j = 0; j < size; j++){
					for(int k = 0; k <size ; k++){
						res.M[i][j] += M[i][k]*B.M[k][j]; 
					}
				}
			}
			return res;
		}
		throw new Exception("Wrong size");
	}
	
	public void Identity() {
		for(int i = 0 ; i< size; i++){
			for(int j = 0; j < size; j++){
				if (i == j) {
					M[i][j] = 1;
				} else {
					M[i][j] = 0;
				}
			}
		}
	}
	
	public void SwapRows(int r1, int r2) throws Exception {
		if( r1 >= size || r1 < 0 || r2 >=size || r1 < 0){
			throw new Exception("Incorrect index");
		}
		float tmp;
		for(int i = 0 ; i < size; i++){
			tmp = M[r1][i];
			M[r1][i] = M[r2][i];
			M[r2][i] = tmp;
		}
	}
	
	public void SwapColumns(int c1, int c2) throws Exception {
		if( c1 >= size || c1 < 0 || c2 >=size || c1 < 0){
			throw new Exception("Incorrect index");
		}
		float tmp;
		for(int i = 0 ; i < size; i++){
			tmp = M[i][c1];
			M[i][c1] = M[i][c2];
			M[i][c2] = tmp;
		}
	}
	public Vector Mult(Vector vect) throws Exception{
		if (vect.size != size){
			throw new Exception("Wrong size");
		}
		Vector res = new Vector(size);
		for(int i= 0; i< size; i++){
			for(int j = 0; j < size; j++){
				res.V[i] += M[i][j]*vect.V[j];
			}
		}
		return res;
	}
}
