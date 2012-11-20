
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AlgorithmC {
	public static String input = "";
	public static int numBlocks = 0;					//number of blocks in whole input file
	public static int numStudentsCurrentBlock = 0;		//number of students in the block we're currently looking at
	//our "right hand side", V, will contain an index into U (current assignee) 

	public static void main(String[] args) {
		input = "tiny.in";
		String current = "";

		try {
			FileInputStream fstream = new FileInputStream(input);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			numBlocks = Integer.parseInt(br.readLine());
			System.out.println("Num Blocks is: " + numBlocks);
			while (current != null){
				current = br.readLine();
				if(current != null){

					if(current.length() == 1){
						numStudentsCurrentBlock = Integer.parseInt(current);
						System.out.println("numStudentsCurrentBlock is: " + numStudentsCurrentBlock);

					}
					ArrayList<Student> U = new ArrayList<Student>();	//our "left hand side", U	
					int[] V = null;
					int maxTiers = 0;
					Student temp;
					for(int i = 0; i < numStudentsCurrentBlock; i++){
						current = br.readLine();
						temp = new Student(current, i);
						if (temp.numTiers > maxTiers) maxTiers = temp.numTiers;
						U.add(temp);
						System.out.println("Outs is: " + temp.out);
					}
					for(int i = 0; i < U.size(); i++){
						System.out.println("printing student: " + i );
						System.out.println(U.get(i));
					}
					V = new int[numStudentsCurrentBlock];
					for(int i = 0; i < V.length; i++){
						V[i] = i;
					}
					U.trimToSize();
					System.out.println("U contains: " + U.size() + " students, the longest of which numTiers = " + maxTiers);
					Configuration initialConfig = new Configuration(U,V);
					runAlgorithm(initialConfig);
				}


			};

			in.close();
			fstream.close();
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static void runAlgorithm(Configuration initial) {
		
		while(initial.unsatisfied.size() >= 1){
			initial.removeSatisfied();
			System.out.println(initial);
			//compute distances
			initial.calcDistance();
			//find next
			int spaceNext = initial.findNext();
			//pruned (make students pick a room)
			initial.pruned(spaceNext);
			//performs reveals
			initial.performReveals();
			//find cycles in pruned
			
			//perform trades and remove students from unsatisfied
			initial.trade();
			
			//updates unsatisfied list
		}

	}

}