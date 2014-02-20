package mainpack;
import mainpack.*;

public class Main {
	public static void main(String[] args){
		Matrix mm = new Matrix(3);
		Matrix m1 = new Matrix(3);
		float[][] arr = {{1,2,3},{4,5,6},{7,8,10}};
		try {
			mm.Init(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LUMatrix mmm = new LUMatrix(mm);
		mmm.Init(); 
		mmm.Print();
		System.out.println(mmm.Determinant());
	}
}
