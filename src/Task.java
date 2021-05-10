import java.util.ArrayList;

public class Task {
//	//TODO: implement due. Argue on setLabels() method
	private String title; 
	private String description; 
	//private ??? due; 
	private int priority; 
	private ArrayList<Label> labels; 
	private boolean finished; 
	
	public Task(String title, String description,/*??? due,*/ int priority, ArrayList<Label> labels) {
		this.title = title; 
		this.description = description; 
		//this.due = due; 
		this.priority = priority; 
		this.labels = labels; 
	}
	
	public Task(String title, /*??? due,*/ int priority, ArrayList<Label> labels) {
		this.title = title; 
		//this.due = due; 
		this.priority = priority; 
		this.labels = labels; 
	}
	
	//setters 
	public void setTitle(String newTitle) {
		this.title = newTitle; 
	}
	
	public void setDescription(String newDes) {
		this.description = newDes;
	}
	
	public void setDue(/*??? due*/) {
		//this.due = due; 
	}
	
	public void setPriority(int newPriority) {
		this.priority = newPriority; 
	}
	
	public void setLabels() {
		//TODO: Do we want to completely reset every time? Or do we want to add and delete one by one? 
	}
	
	//getters
	public String getTitle() {
		return this.title; 
	}
	
	public String getDescription() {
		return this.description; 
	}
	
	public String getDescriptionByRows(int columnLength, int firstRowOffset, int fontSize) {
		int i = 0; 
		String choppedDescription = ""; 
		if(this.description == null) {
			return null; 
		}else {
			while(i < description.length()) {
				if(i == 0) {
					choppedDescription += (description.substring(i, Math.min(description.length(), i+(columnLength-firstRowOffset)/fontSize)) + "\n"); 
					i += (columnLength-firstRowOffset)/fontSize; 
				}else {
					choppedDescription += (description.substring(i, Math.min(description.length(), i+columnLength/fontSize)) + "\n"); 
					i += columnLength/fontSize; 
				}
			}
			return choppedDescription; 
		}
	}
	
	//public ??? getDue()
	
	public int getPriority() {
		return this.priority; 
	}
	
	public ArrayList<Label> getLabels(){
		return this.labels; 
	}
}
