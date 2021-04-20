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
	
	//public ??? getDue()
	
	public int getPriority() {
		return this.priority; 
	}
	
	public ArrayList<Label> getLabels(){
		return this.labels; 
	}
}
