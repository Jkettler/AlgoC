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
					ArrayList<Student> U = new ArrayList<Student>();	//our "left hand side", U	
					int[] V;
					int maxTiers = 0;
					if(current.length() == 1){
						numStudentsCurrentBlock = Integer.parseInt(current);
						System.out.println("numStudentsCurrentBlock is: " + numStudentsCurrentBlock);
						U = new ArrayList<Student>();	//our "left hand side", U	
						V = new int[numStudentsCurrentBlock];
					}

					for(int i = 0; i < numStudentsCurrentBlock; i++){
						current = br.readLine();
						Student temp = new Student(current, i);
						if (temp.numTiers > maxTiers) maxTiers = temp.numTiers;
//						System.out.println("Adding student: " + i + " whose prefList is: " );
//						temp.print2Darrayints();
						System.out.println(temp.numTiers + " tiers, the longest of which is: " + temp.maxTierSize);
						U.add(temp);
						V = new int[numStudentsCurrentBlock];
					}
					System.out.println("U contains: " + U.size() + " students, the longest of which numTiers = " + maxTiers);
					
				}
			};

			in.close();
			fstream.close();
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}

}