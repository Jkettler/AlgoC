
public class Student {
	public Preference prefList;
	public int id;
	public Preference listStripped;

	public int classSize;

	public int bottom;
	public int top;
	public int top_pointer;

	public Student(Preference p, int ID){
		prefList = p;
		id = ID;
		top_pointer = 0;
		bottom = p.holster[p.holster.length-1];
		top = p.holster[top_pointer];
		listStripped = listStripper(prefList);
	}

	private Preference listStripper(Preference prefList2) {
		int j = prefList2.length/2 + 1;
		int counter = 0;
		Preference result = new Preference(j);
		for(int i = 0; i < prefList2.holster.length; i++){
			if (prefList2.holster[i] != -1){
				result.holster[counter] = prefList2.holster[i];
				counter++;
			}
		}
		return result;
	}


	void prefPrint(){

		String result ="";
		for (int i=0; i<this.prefList.holster.length; i++) {
			result += " " + this.prefList.holster[i] + " ";
		}
		System.out.println(result);
	}

	void prefStripPrint(){
		String result ="";
		for (int i=0; i<this.listStripped.holster.length; i++) {
			result += " " + this.listStripped.holster[i] + " ";
		}
		System.out.println(result);
	}

	public int indexFinder(Preference p){
		for(int i = 0; i < p.holster.length; i++){
			if (p.holster[i] == this.id)
				return i;
		}
		return 0;
	}
	public void setTop(int x){
		this.top = x;
	}
	public void setTop_pointer(int x){
		this.top_pointer = x;
	}
	public int getTop(){
		return this.top;
	}

	public void reveal() {
		if(this.top_pointer >= listStripped.holster.length - 1){
			this.top = listStripped.holster[listStripped.holster.length - 1];
			return;
		}
		//System.out.println("potential new top is: " + this.listStripped.holster[top_pointer + 1]);
		int potential = this.listStripped.holster[top_pointer + 1]; 
		//int defaultRank = indexFinder(this.listStripped);


		if(this.listStripped.holster[top_pointer] == this.id){
			this.top = this.listStripped.holster[top_pointer];
			return;
		}



		else{
			this.top = potential;
			this.top_pointer++;
			return;
		}

	}

}
