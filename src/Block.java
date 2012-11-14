import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Block {
	public int numStudents;
	public int[][] thisShell;
	public int rows;
	public int cols;
	public Block me;

	public Block(int numRows, int numCols){
		rows = numStudents = numRows;
		cols = numCols;
		thisShell = new int[numRows][numCols];
		me = this;
	};

	public Block (){
		thisShell = new int[5][5];
		rows = 5;
		cols = 5;
		numStudents = 5;
		me = this;
	}

	

	public Block(int[][] in) {
		rows = in.length;
		cols = numStudents = in[0].length;
		thisShell = in;
		me = this;
	}

	private Block addRows(Block result, ArrayList<int[]> al) {
		for(int j = 0; j < result.rows; j++){
			result.placeRow(al.get(j), j);			
		}
		return result;
	}

	public Preference getPref(int index){
		int[] temp = new int[this.cols];
		for(int i = 0; i < this.cols; i++){
			temp[i] = this.thisShell[index][i];
		}
		Preference result = new Preference(temp, index);
		return result;
	}


	public Student getStudent(int index){
		int[] temp = new int[this.cols];
		for(int i = 0; i < this.cols; i++){
			temp[i] = this.thisShell[index][i];
		}
		Preference p = new Preference(temp, index);
		Student result = new Student(p, index);
		return result;
	}


	public int getNumStudents(){
		return this.numStudents;
	}


	public Block placeRow(int[] cs, int rowIndex){
		assert( rowIndex < this.rows);

		for(int i = 0; i < this.cols; i++){
			if (i > cs.length-1)
				break;

			this.setThisBlock(cs[i], rowIndex, i);
		}
		return this;
	}

	public void print(){
		for (int i=0; i<this.rows; i++) {
			for (int j=0; j<this.cols; j++) {
				System.out.print("[" + getThisBlock(i, j) + "]");
			}
			System.out.println("");
		}
	}

	public void setThisBlock(int value, int x, int y) {
		this.thisShell[x][y] = value;
	}

	public int getThisBlock(int x, int y) {
		return this.thisShell[x][y];
	}


}
