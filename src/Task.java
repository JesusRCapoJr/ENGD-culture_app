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
	private Folder folder;
	
	public Task() {
//		this.title = title; 
//		this.description = description; 
//		//this.due = due; 
//		this.priority = priority; 
//		this.label = label; 
		this.setTitle(new String("Add Title Here"));
		this.setDescription(new String(""));
		this.setDueDate(new String("yyyy/mm/dd"));
		this.setPriority(new String("Priority"));
		this.setLabel(new String("Lable"));
		this.setCompleted(false);
	}
	
//	public Task(String title, String description,/*??? due,*/ int priority, String label) {
//		this.title = title; 
//		//this.due = due; 
//		this.priority = priority; 
//		this.label = label; 
//	}
//	

//SETTERS
	
	public void setTitle(String newTitle) {
		this.title = newTitle; 
	}
	
	public void setDescription(String newDes) {
		this.description = newDes;
	}
	
	public void setDue(/*??? due*/) {
		//this.due = due; 
	}
	
	public void setPriority(String newPriority) {
		if(newPriority.matches(new String("Priority"))) {
			this.priority = 0;
		}
		else if(newPriority.matches(new String("Low"))) {
			this.priority = 1;
		}
		else if(newPriority.matches(new String("Medium"))) {
			this.priority = 2;
		}
		else if (newPriority.matches(new String("Hight"))) {
			this.priority = 3;
		}
		else {
			this.priority = 4;
		}
	}
	
	public void setLabel(String lable) {
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
	
	public void setFolder(Folder folder) {
		this.folder=folder;
	}

	
//GETTERS
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
	
	
	public int getPriority() {
		return this.priority; 
	}
	
	public String getPriorityString() {
		String priorityString = "";
		switch (this.priority) {
		case 0:
			priorityString="Priority";
		break;
		case 1:
			priorityString="Low";
		break;
		case 2:
			priorityString="Medium";
		break;
		case 3:
			priorityString="High";
		break;
		}
		return priorityString; 
	}
	
	public String getLabels(){
		if (this.lable==null) {
			return "Label";
		}
		return this.lable; 
	}

	
	public String getDueDate() {
		return dueDate;
	}

	public boolean isCompleted() {
		return completed;
	}
	
	public Folder getFolder() {
		return this.folder;
	}

}
