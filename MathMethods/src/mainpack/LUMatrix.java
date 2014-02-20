package mainpack;
import mainpack.Matrix;

public class LUMatrix{
	private int size;
	private Matrix Source;
	private Matrix L;
	private Matrix U;
	
	public LUMatrix(Matrix source) {
		Source = new Matrix(source);
		size = source.size;
	}
	public void Init(){
		U = new Matrix(Source);
		L = new Matrix(Source.size);

	    for(int i = 0; i < size; i++)
	        for(int j = i; j < size; j++)
	            L.M[j][i]=U.M[j][i]/U.M[i][i];
	    
	    for(int k = 1; k < size; k++)
	    {
	        for(int i = k-1; i < size; i++)
	            for(int j = i; j < size; j++)
	                L.M[j][i]=U.M[j][i]/U.M[i][i];

	        for(int i = k; i < size; i++)
	            for(int j = k-1; j < size; j++)
	                U.M[i][j]=U.M[i][j]-L.M[i][k-1]*U.M[k-1][j];
	    }
	}
	public void Print(){
		System.out.println("L-matrix:");
		L.Print();
		System.out.println("U-matrix:");
		U.Print();
	}
	
	public Matrix GetL(){
		return L;
	}
	public Matrix GetU(){
		return U;
	}
	public float Determinant(){
		float res = 1;
		for(int i = 0; i < size; i++){
			res *= U.M[i][i];
		}
		return res;
	}


}
