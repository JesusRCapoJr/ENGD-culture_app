 import java.util.ArrayList;
import java.io.Serializable;

public class Task implements Serializable{
//	//TODO: implement due. Argue on setLabels() method
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8052698667359727655L;
	private String title;
	private String description;
	private String dueDate; //yyyy/mm/dd
	private int priority;
//	private Label label; 
	private String lable;
	private boolean completed;
	private int rows = 1; 
	
	public Task() {
//		this.title = title; 
//		this.description = description; 
//		//this.due = due; 
//		this.priority = priority; 
//		this.label = label; 
		this.setTitle(new String("Add Title Here"));
		this.setDescription(new String("Add Description Here"));
		this.setLabel(new String("Lable"));
		this.setDueDate(new String("yyyy/mm/dd"));
		this.setCompleted(false);
		this.setPriority(0);
		
	}
	
//	public Task(String title, String description,/*??? due,*/ int priority, String label) {
//		this.title = title; 
//		//this.due = due; 
//		this.priority = priority; 
//		this.label = label; 
//	}
//	
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
	
	public void setLabel(String label) {
		if (lable.matches("Lable")) {
			this.lable = null;
		}
		else {
			this.lable = lable;
		}
		//TODO: Do we want to completely reset every time? Or do we want to add and delete one by one? 
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	
	//getters
	public String getTitle() {
		return this.title; 
	}
	
	public String getDescription() {
		return this.description; 
	}
	
	public String getDescriptionByRows(int columnLength, int fontSize) {
		//System.out.println("columnLength "+columnLength+/*", firstRowOffset "+firstRowOffset+*/", fontSize "+fontSize); 
		rows = 1; 
		int i = 0; 
		String choppedDescription = "\n"; 
		if(this.description == null) {
			return null; 
		}else {
			while(i < description.length()) {
				//if(i == 0) {
//					choppedDescription += (description.substring(i, Math.min(description.length(), i+(columnLength-firstRowOffset)/fontSize)) + "\n"); 
//					i += (columnLength-firstRowOffset)/fontSize; 
				//}else {
					choppedDescription += (description.substring(i, Math.min(description.length(), i+columnLength/fontSize)) + "\n"); 
					i += columnLength/fontSize; 
					rows++; 
				//}
			}
			return choppedDescription; 
		}
	}
	
	public int getDescriptionRows(int columnLength, int fontSize) {
		getDescriptionByRows(columnLength, fontSize); 
		return rows; 
	}
	
	//public ??? getDue()
	
	public int getPriority() {
		return this.priority; 
	}
	
//	public Label getLabels(){
//		return this.label; 
//	}

	
	public String getDueDate() {
		return dueDate;
	}

	public boolean isCompleted() {
		return completed;
	}

}
