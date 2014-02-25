package mainpack;

public class Vector {
	int size;
	float[] V;
	
	public Vector(int n){
		size = n;
		V = new float[n];
		for (int i = 0; i < n ; i++){
			V[i] = 0;
		}
	}
	
	public void Init(float[] other) throws Exception{
		if ( other.length != size ){
			throw new Exception("Wrong size");
		} 
		for (int i = 0; i< size; i++){
			V[i] = other[i];
		}
	}
	public void Print(){
		for(float elem : V){
			System.out.printf("%f ",elem);
		}
		System.out.println();
	}
	public boolean Equal(float [] other){
		for (int i = 0; i< size; i++){
			if(other[i] != V[i]){
				return false;
			}
		}
		return true;
	}
}
