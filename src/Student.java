import java.util.ArrayList;

public class Student {
	public ArrayList<ArrayList<Integer>> tierList = new ArrayList<ArrayList<Integer>>();
	public int id;
	public int classSize;
	public int numTiers;
	public int maxTierSize = 0;
	public ArrayList<Integer> outs = new ArrayList<Integer>();
	public int hopefulTier;


	public Student(String s, int index){
		id = index;
		hopefulTier = 0;
		String[] tempStringTierList = s.trim().split("\\s-1\\s");
		numTiers = tempStringTierList.length;
		for(int t = 0; t < numTiers; t++){
			String[] temp = tempStringTierList[t].trim().split("[\\s]");
			if(temp.length > maxTierSize) maxTierSize = temp.length;

			ArrayList<Integer> temp2 = new ArrayList<Integer>();
			for(int j = 0; j < temp.length; j++){

				temp2.add(Integer.parseInt(temp[j]));
			}
			tierList.add((ArrayList<Integer>) temp2);
		}
		tierList.trimToSize();
		outs = tierList.get(hopefulTier);
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
	
	public String toString(){
		String out= "Student= "+id+ " ";
		for(ArrayList<Integer> i : tierList){
			out+="[";

			for(int j : i){	
				out+= "[" + j + "]";
			}
//			out+="]\n";
		}
		return out;
	}
	
	public boolean outsHaz(int target){
		return this.outs.contains(target);
	}

	//	public String print1Darraystrings(){
	//		for(int i = 0; i < )
	//	}

}
