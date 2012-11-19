import java.util.ArrayList;

public class Configuration {
	public ArrayList<Student> students;
	public int[] spaces;
	public ArrayList<Student> unsatisfied;
	
	public Configuration(ArrayList<Student> u, int[] v){
		students = u;
		spaces =v;
		unsatisfied = new ArrayList<Student>();
		//need to deep copy
		for(Student s: u)
			unsatisfied.add(s);
		
	}
	
	public Configuration(ArrayList<Student> u, int[] v, ArrayList<Student> unsat){
		students = u;
		spaces =v;
		unsatisfied = unsat;
	}
	
	public void removeSatisfied(){
		for(Student s: unsatisfied){
			if(s.out.contains(s.id) || s.satisfied){
				unsatisfied.remove(s);
			}
		}
	}
		
	public void performReveals(){
		//TODO
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
		out+="\nunsatisfied= ";
		for(int i =0; i<unsatisfied.size(); i++){
			out+= unsatisfied.get(i) + " ";
		}	return out;
	}
}
