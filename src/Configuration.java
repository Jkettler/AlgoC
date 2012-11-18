import java.util.ArrayList;

public class Configuration {
	ArrayList<Student> students;
	int[] spaces;
	ArrayList edges;
	ArrayList out;
	ArrayList<Student> unsatisfied;
	ArrayList<Student> satisfied;
	
	public Configuration(ArrayList<Student> u, int[] v, ArrayList e){
		students = u;
		spaces =v;
		edges = e;
		out = new ArrayList();
		students.size();
		unsatisfied = u;
		satisfied = new ArrayList<Student>();
		
	}
	public void updateUnsatisfied(){
		for(int i = 0; i < unsatisfied.size(); i++){
			Student temp = unsatisfied.get(i);
			if(temp.outsHaz(temp.id)){
				unsatisfied.remove(temp);
				i -=1;
			}
		}
	}
	
	public ArrayList getUnsatisified(){
		return unsatisfied;
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
		out +="Students= ";
		for(int i =0; i<students.size(); i++){
			out+= students.get(i) + " ";
		}
		out+="\nspaces= ";
		for(int i =0; i<spaces.length; i++){
			out+= spaces[i] + " ";
		}
		out+="\nedges= ";
		for(int i =0; i<edges.size(); i++){
			out+= edges.get(i) + " ";
		}
		out+="\nout= ";
		for(int i =0; i<this.out.size(); i++){
			out+= this.out.get(i) + " ";
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
