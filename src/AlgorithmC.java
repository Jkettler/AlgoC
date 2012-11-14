import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AlgorithmC {
	public static int currentLine = 0;
	public static String input;
	public static int numBlocks;
	public static int currentN;
	public static int currentStart = 0;
	public static int currentStop = 0;
	public static Block block;

	public static void main(String[] args) {
		input = "tiny.in";
		numBlocks = Integer.parseInt(getLine(0, input));
		currentStart++;
		currentLine++;
		currentStop += currentStart + Integer.parseInt(getLine((currentStart), input));
		currentStart++;
		//grabInput(input);
		debugs();

		block = grabBlock(currentStart, currentStop, input);
		block.print();
		
		debugs();
		
	}

	private static Block grabBlock(int start, int stop, String str) {
		int maxLength = 0;
		ArrayList<int[]> al = new ArrayList<int[]>();
		int numStudents = 0;
		int rows = 0;
		int cols = 0;
		int[][] thisShell;
		
		int index = 0;
		String strLine = "";

		while (start <= stop){
			strLine = getLine(start, str);
			start++;

			String[] tokens = strLine.trim().split("[\\s]");
			if (tokens[0].isEmpty()){
				continue;
			}
			if (tokens.length == 1){
				currentStart = index;
				currentStop += Integer.parseInt(tokens[0]);
				numStudents = Integer.parseInt(tokens[0]);
				continue;
			}

			if(tokens.length > maxLength){
				maxLength = tokens.length;
			}

			int[] line = new int[maxLength];
			for(int i = 0; i < tokens.length; i++){
				line[i] = Integer.parseInt(tokens[i]);
			}
			al.add(line);
		}
		currentStart = start + 1;
		numStudents = rows = Integer.parseInt(getLine((start), input));
		currentStop = start + numStudents;
		cols = maxLength;
		Block result = new Block(rows, cols);
		addRows(result, al);
		return result;
	}

	private static Block addRows(Block result, ArrayList<int[]> al) {
		for(int j = 0; j < result.rows; j++){
			result.placeRow(al.get(j), j);			
		}
		return result;
	}

	private static void debugs() {
		System.out.println("Number of blocks is: " + numBlocks);
		System.out.println("The next block will start at line: " + currentStart);
		System.out.println("The next block will stop reading at line:" + currentStop);
	}

	private static String getLine(int line, String string) {
		String result = "";
		try {
			FileInputStream fstream = new FileInputStream(string);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			for(int i = 0; i < line; i++){
				br.readLine();
			}
			result = br.readLine();
			in.close();
			fstream.close();
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		return result;
	}
}