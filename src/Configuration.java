import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Configuration {
	public ArrayList<Student> students;
	public int[] spaces;
	public ArrayList<Student> unsatisfied;
	public int[] distance;
	private static final HashSet<Class<?>> WRAPPER_TYPES = getWrapperTypes();
	public ArrayList toTrade;
	
	public Configuration(ArrayList<Student> u, int[] v){
		students = u;
		spaces =v;
		unsatisfied = new ArrayList<Student>();
		//need to deep copy
		for(Student s: u)
			unsatisfied.add(s);
		distance = new int[v.length];
		toTrade = new ArrayList();
	}
	
//	public Configuration(ArrayList<Student> u, int[] v, ArrayList<Student> unsat){
//		students = u;
//		spaces =v;
//		unsatisfied = unsat;
//	}
	/**
	 * method to update the unsatisfied list.
	 */
	public void removeSatisfied(){
		for(int i =0; i<unsatisfied.size(); i++){
			if(unsatisfied.get(i).out.contains(unsatisfied.get(i).id) || unsatisfied.get(i).satisfied){
				unsatisfied.get(i).satisfied = true;
				unsatisfied.remove(i);
				i--;
			}
		}
	}
		
	public void performReveals(){
		//TODO
	}
	
	//method to find distances for each space to closest unsatisfied student
	public void calcDistance(){
		for(int space=0; space<distance.length; space++){
			distance[space] = distance(space);
		}
	}
	//method to find closest unsatisfied student from a space
	private int distance(int space) {
		int currentStudent = spaces[space];
		Queue L = new LinkedList();
		ArrayList visited = new ArrayList();
		boolean found = false;
		int count = 1;
		//gets the student that the space is pointing to
		Student temp = findStudent(currentStudent);
		if(!temp.satisfied)
			return count;
		L.add(temp);
		while(!found || !L.isEmpty()){
			if(isWrapperType(L.peek().getClass())){
				currentStudent = (int) L.remove();
				temp = findStudent(currentStudent);
				if(visited.contains(temp)){
					continue;
				}else if(!temp.satisfied){
					count++;
					return count;
				}
				else{
					count+=2;
					L.addAll(temp.out);
					visited.add(temp);
				}
				
			}else{
				temp = (Student) L.remove();
				count++;
				L.addAll(temp.out);
				visited.add(temp);
			}			
		}
		return -1;
		
	}
	
	public static boolean isWrapperType(Class<?> clazz)
    {
        return WRAPPER_TYPES.contains(clazz);
    }

    private static HashSet<Class<?>> getWrapperTypes()
    {
        HashSet<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }
    
	public Student findStudent(int i) {
		for(Student s: students){
			if(s.id == i)
				return s;
		}
		return null;
	}

	public void pruned(int spaceNext){
		//TODO
		
	}
	
	public int findNext(){
		int ind =0;
		int smallest= Integer.MAX_VALUE;
		for(int i =0; i< distance.length; i++){
			if(distance[i] == -1)
				continue;
			if(distance[i]<smallest){
				ind = i;
				smallest = distance[i];
			}
		}
		return ind;
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
