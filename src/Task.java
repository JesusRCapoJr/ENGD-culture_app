 //Author: Jesus Capo
//Additional Constributors: Steven Xia

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable{
//	//TODO: implement due. Argue on setLabels() method
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8052698667359727655L;
	private String title;
	private String description;
	private Date dueDate; //yyyy/mm/dd
	private String dueTime; //00:00
	private int dueMinute;
	private int dueHour;
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
		this.setTitle(Main.getLanguage().get("Title"));
		this.setDescription(new String(""));
		//this.setDueDate(new String("yyyy/mm/dd"));
		//this.setPriority(Main.getLanguage().get("Priority"));
		this.setLabel(Main.getLanguage().get("Label"));
		this.priority=0;
		try {
			this.setCompleted(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDueTime(0,0);
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
		else if (newPriority.matches(new String("High"))) {
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
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setDueTime(int dueHour, int dueMinute) {
		
		this.dueHour=dueHour;
		this.dueMinute=dueMinute;
		
		String dueHoursString = String.valueOf(dueHour);
		if (dueHour < 10) {
			dueHoursString = "0"+String.valueOf(dueHour);
		}
		
		String dueMinuteString = String.valueOf(dueMinute);
		if (dueMinute < 10) {
			dueMinuteString = "0"+String.valueOf(dueMinuteString);
		}
		
		this.dueTime = dueHoursString + ":" + dueMinuteString;
	}
	
	/**
	 * An exception is thrown if there is no spirit in Main. 
	 * @param completed
	 * @throws Exception
	 */
	public void setCompleted(boolean completed) throws Exception {
		this.completed = completed;
		if(this.completed==true) {
			Main.sprite.taskConpleted();
		}
		else {
			Main.sprite.taskUnConpleted();
		}
		
//		Main.sprite.taskConpleted();
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
			priorityString=Main.getLanguage().get("Priority");
		break;
		case 1:
			priorityString=Main.getLanguage().get("Low");
		break;
		case 2:
			priorityString=Main.getLanguage().get("Medium");
		break;
		case 3:
			priorityString=Main.getLanguage().get("High");
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

	
	public Date getDueDate() {
		return dueDate;
	}
	
	public String getDueDateString() {
		return String.format("%1$ty/%1$tm/%1$td", this.dueDate);
	}
	
	public String getDueTime() {
		return this.dueTime;
	}
	
	public int getDueMinute() {
		return this.dueMinute;
	}
	
	public int getDueHour() {
		return this.dueHour;
	}

	public boolean isCompleted() {
		return completed;
	}
	
	public Folder getFolder() {
		return this.folder;
	}

}
