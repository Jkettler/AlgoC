import java.util.ArrayList;

public class Student {
	public ArrayList<ArrayList<Integer>> tierList = new ArrayList<ArrayList<Integer>>();
	public int id;
	public int classSize;
	public int numTiers;
	public int maxTierSize = 0;


	public Student(String s, int index){
		id = index;
		String[] tempStringTierList = s.trim().split("\\s-1\\s");
		numTiers = tempStringTierList.length;
		for(int t = 0; t < numTiers; t++){
			String[] temp = tempStringTierList[t].trim().split("[\\s]");
			//System.out.println("temp has leng: " + temp.length);
			if(temp.length > maxTierSize) maxTierSize = temp.length;

			ArrayList<Integer> temp2 = new ArrayList<Integer>();
			for(int j = 0; j < temp.length; j++){
				
				temp2.add(Integer.parseInt(temp[j]));
			}
			tierList.add((ArrayList<Integer>) temp2);
			tierList.trimToSize();
		}
		//System.out.println("maxTierSize is : " + maxTierSize);
	}

	public void print2Darrayints(){
	
		for(ArrayList<Integer> i : tierList){
			System.out.print("[");
			
			for(int j : i){	
				System.out.print( "[" + j + "]");
			}
			System.out.print("]");
			System.out.println();
		}
		
	}
	
//	public String print1Darraystrings(){
//		for(int i = 0; i < )
//	}

}
