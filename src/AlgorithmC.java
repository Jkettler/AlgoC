
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
						//U = new ArrayList<Student>();	//our "left hand side", U	
						//V = new int[numStudentsCurrentBlock];

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
						System.out.println(U.get(i));//.print2Darrayints();
					}
					V = new int[numStudentsCurrentBlock];
					initialize(V);
					U.trimToSize();
					System.out.println("U contains: " + U.size() + " students, the longest of which numTiers = " + maxTiers);
					ArrayList E = new ArrayList();
					Configuration initialConfig = new Configuration(U,V,E);
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

	private static void initialize(int[] v) {
		for(int i = 0; i < v.length; i++){
			v[i] = i;
		}
	}

	private static void runAlgorithm(Configuration initial) {
		while(initial.unsatisfied.size() >= 1){
			//updates unsatisfied list
			initial.updateUnsatisfied();
			
			//performs reveals
			
			//compute distances
			
			//determine next/ make students pick a room
			
			//find cycles in pruned
			
			//perform trades and remove students from unsatisfied
			
		}

	}

}