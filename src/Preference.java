import java.util.ArrayList;


public class Preference {
	public int[] holster;
	public int length;
	public int owner;
	
	public Preference(int size){
		holster = new int[size];
		length = holster.length;
		for(int i = 0; i < size; i++)
			holster[i] = i;
		owner = -1;
	}
	
	public Preference(int size, int myowner){
		holster = new int[size];
		length = holster.length;
		for(int i = 0; i < size; i++)
			holster[i] = i;
		owner = myowner;
	}
	
	public Preference(int[] blockrow, int studentOwner){
		holster = blockrow;
		length = holster.length;
		owner = studentOwner;
	}
	
	public Block permutionBlock(int[] pref){
		Block result = new Block(pref.length, pref.length);
		return result;
		
		
	}

	
	public void overwriteData(int[] newData){
		assert newData.length == this.length;
		for(int i = 0; i < this.length; i++){
			this.holster[i] = newData[i];
		}
	}
	
	public String toString(){
		String result ="";
		for (int i=0; i<holster.length; i++) {
				result += " " + holster[i] + " ";
		}
		return result;
	}
	
	public int getNumTiers(){
		int result = 1;
		for(int i = 0; i < this.length; i++){
			if(this.holster[i] == -1)
				result++;
		}
		return result;
	}
	
	public ArrayList<Integer> getTier(int tierNum){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(tierNum > this.getNumTiers()){
			System.out.println("You done goofed");
			return result;
		}	
		int numZeros = 0;
		int numPassed;
		if(this.holster[0] == -1)
			numPassed = 0;
		else
			numPassed = 1;
		
		for(int i = 0; i < this.length; i++){
			if(this.holster[i] == 0){
				numZeros++;
				if (numZeros > 1)
					break;
			}
			if(this.holster[i] == -1)
				numPassed++;
			if(numPassed == tierNum && numZeros < 2 && this.holster[i] != -1){
				result.add(this.holster[i]);
			}
		}
		return result;
	}

}
