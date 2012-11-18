import java.util.ArrayList;

public class Configuration {
	private ArrayList<Student> students;
	private int[] spaces;
	private ArrayList<int[]> edges;
	private ArrayList<Student> unsatisfied;
	private ArrayList<Student> satisfied;
	
	public Configuration(ArrayList<Student> u, int[] v, ArrayList<int[]> e){
		students = u;
		spaces =v;
		edges = e;
		students.size();
		unsatisfied = new ArrayList<Student>();
		//need to deep copy
		for(Student s: u)
			unsatisfied.add(s);
		satisfied = new ArrayList<Student>();
		//adds first tier of edges to edges to keep track
		//format is of (student, space)
		for(Student s: students){
			for(int edg: s.getEdgesOfTier(0)){
				int edge[] = new int[2];
				edge[0] = s.id;
				edge[1]= edg;
				edges.add(edge);
			}
		}
		
	}
	public void initialUpdateUnsatisfied(){
		for(int i = 0; i < unsatisfied.size(); i++){
			Student temp = unsatisfied.get(i);
			if(temp.outsHaz(temp.id)){
				//need to set out here
				unsatisfied.remove(temp);
				satisfied.add(temp);
				i -=1;
			}
		}
	}
	
	public ArrayList<Student> getUnsatisified(){
		return unsatisfied;
	}
	
	public void performReveals(){
		for(Student s: unsatisfied){
			ArrayList<Integer> tier = s.getEdgesOfTier(s.currentTier);
			//checks if a students's first tier room is already taken
			for(int i: tier){
				if(satisfiedContains(i)){
					
				}
			}

		}
	}
	
	private boolean satisfiedContains(int i) {
		for(Student s: satisfied){
			if(s.out.contains(i)){
				return true;
			}
		}
		return false;
	}
	public int distance(){
		//TODO
		return -1;
	}
	
	public void pruned(){
		//TODO
	}
	
	public void trade(){
		//TODO
	}
	
	
	/**
	 * toString method to show the contents of a configuration
	 */
	public String toString(){
		String out = "";
		out +="Students(U)= ";
		for(int i =0; i<students.size(); i++){
			out+= students.get(i) + " ";
		}
		out+="\nspaces(V)= ";
		for(int i =0; i<spaces.length; i++){
			out+= spaces[i] + " ";
		}
		out+="\nedges(E)= ";
		for(int i =0; i<edges.size(); i++){
			out+= edges.get(i) + " ";
		}
		out+="\nunsatisfied= ";
		for(int i =0; i<unsatisfied.size(); i++){
			out+= unsatisfied.get(i) + " ";
		}
		out+="\nsatisfied= ";
		for(int i =0; i<satisfied.size(); i++){
			out+= satisfied.get(i) + " ";
		}
		return out;
	}
}
