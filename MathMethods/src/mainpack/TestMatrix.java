package mainpack;

import static org.junit.Assert.*;
import mainpack.Matrix;
import mainpack.LUMatrix;

import org.junit.Test;

public class TestMatrix{
	/*@Before
	public static void */

	@Test
	public void testCreate() {
		@SuppressWarnings("unused")
		Matrix mm = new Matrix(3);
	}
	
	@Test
	public void testInit1() throws Exception {
		Matrix mm = new Matrix(3);
		float ar[]  = {1,2,3,4,5,6,7,8,9};  
		mm.Init(ar);
	}
	@Test(expected = Exception.class)
	public void testFailInit() throws Exception {
		Matrix mm = new Matrix(3);
		float ar[]  = {1,2,3,4,5,6,7};  
		mm.Init(ar);
	}
	@Test
	public void testInit2() throws Exception {
		Matrix mm = new Matrix(3);
		float ar[][]  = {{1,2,3},{4,5,6},{7,8,9}};  
		mm.Init(ar);
		assertTrue(mm.Equals(ar));
	}
	@Test
	public void testMult() throws Exception {
		Matrix A = new Matrix(3);
		Matrix B = new Matrix(3);
		float[] Af = {1,2,3,4,5,6,7,8,9};
		float[][] Bf = {{12,33,3},{-2,32,-1},{-3,-1,3}};
		float[][] res = {{-1,94,10},{20,286,25},{41,478,40}};
		A.Init(Af);
		B.Init(Bf);
		assertTrue(A.Mult(B).Equals(res));
	}
	@Test
	public void testIden() throws Exception {
		Matrix A = new Matrix(3);
		float[] Af = {1,2,3,4,5,6,7,8,9};
		A.Init(Af);
		Matrix B = new Matrix(3);
		B.Identity();
		assertTrue(A.Mult(B).Equals(A));
	}
	@Test 
	public void testSwapR() throws Exception {
		Matrix A = new Matrix(3);
		float[][] Af = {{1,2,3},{4,5,6},{7,8,9}};
		float[][] Bf = {{7,8,9},{4,5,6},{1,2,3}};
		A.Init(Af);
		A.SwapRows(0, 2);
		//A.Print();
		assertTrue(A.Equals(Bf));
	}
	@Test 
	public void testSwapC() throws Exception {
		Matrix A = new Matrix(3);
		float[][] Af = {{1,2,3},{4,5,6},{7,8,9}};
		float[][] Bf = {{3,2,1},{6,5,4},{9,8,7}};
		A.Init(Af);
		A.SwapColumns(0, 2);
		assertTrue(A.Equals(Bf));
	}
	public void testLU() throws Exception {
		float[][] Af = {{1,2,3},{4,5,6},{7,8,10}};
		float[][] Bf = {{1,2,3},{0,-3,-6},{0,0,1}};
		Matrix A = new Matrix(3);
		A.Init(Af);
		LUMatrix lum = new LUMatrix(A);
		lum.Init();
		assertTrue(lum.GetU().Equals(Bf));
	}
	public void testLU2() throws Exception{
		float[][] Af = {{1,2,3},{4,5,6},{7,8,10}};
		Matrix A = new Matrix(3);
		A.Init(Af);
		LUMatrix LU = new LUMatrix(A);
		LU.Init();
		assertTrue(LU.GetL().Mult(LU.GetU()).Equals(A));
	}
}
