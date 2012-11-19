import java.util.ArrayList;

public class Student {
	public ArrayList<ArrayList<Integer>> tierList = new ArrayList<ArrayList<Integer>>();
	public int id;
	public int numTiers;
	public int maxTierSize = 0;
	public ArrayList<Integer> out;
	public int currentTier;
	public boolean satisfied;

	public Student(String s, int index){
		id = index;
		currentTier = 0;
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
		out = new ArrayList<Integer>();
		out = tierList.get(currentTier);
		satisfied = false;
	}
	
	public String toString(){
		String out= "Student= "+id+ " ";
		for(ArrayList<Integer> i : tierList){
			out+="[";

			for(int j : i){	
				out+= "[" + j + "]";
			}
			out+="] ";
		}
		return out;
	}
	
	public ArrayList<Integer> getEdgesOfTier(int tiernum){
		return tierList.get(tiernum);
	}
}
