//Author: Steven Xia, Jesus Capo

import java.util.ArrayList;
import java.io.Serializable;

public class Folder implements Serializable{
	
	private static final long serialVersionUID = -5502867876331652655L;
	private ArrayList<Task> tasks;
	private ArrayList<Label> labels; 
	private String title; 
	private int folderID; 
	
	/**
	 * Constructs a Folder and register it to Main
	 * @param title
	 * @param folderID
	 */
	public Folder(String title, int folderID) {
		tasks = new ArrayList<Task>();  
		labels = new ArrayList<Label>(); 
		this.folderID = folderID;
		this.title = title; 
		Main.registerFolder(this); 
	}
	
	public void addTask(Task task) {
		if(this.tasks == null) {
			this.tasks = new ArrayList<Task>(); 
		}
		this.tasks.add(task); 
	}
	
	public void removeTask(Task task) {
		this.tasks.remove(task); 
	}
	
	public void removeLabel(Label label) {
		if(this.labels.contains(label)) {
			this.labels.remove(label); 
			Main.removeLabel(label); 
		}else {
			//It does because I used a temporary Folder for registering Label... 
			//System.out.println("Folder: label doesn't exist. This shouldn't happen???");
			return; 
		}
	}
	
	public String getTitle() {
		return this.title; 
	}
	
	public void setTitle(String newTitle) {
		this.title=newTitle; 
	}
	
	public int getID() {
		return this.folderID; 
	}
	
	public ArrayList<Task> getTasks() {
		return this.tasks; 
	}
	
	public void addLabel(Label label) {
		if(this.labels == null) {
			this.labels = new ArrayList<Label>(); 
		}else if(this.labels.contains(label)) {
			return; 
		}
		this.labels.add(label); 
		Main.registerLabel(label); 
	}
	
	public ArrayList<Label> getLabels(){
		return this.labels; 
	}
	
	public int countTasks() {
		return this.tasks.size(); 
	}
	
	public int countLabels() {
		return this.labels.size(); 
	}
	
	/**
	 * Searches for and returns Task objects within this Folder with the Label objects specified. 
	 * Not yet useful. 
	 * Only supports one Label right now. 
	 * 
	 * @param labels: ArrayList<Label>
	 * @return tasksFound: tasks containing all labels. Note they may have more labels than specified. 
	 */
	//reserved for future support of multiple Labels 
//	public ArrayList<Task> getTasksByLabels(ArrayList<Label> labels){
	public ArrayList<Task> getTasksByLabel(Label label){
		
		ArrayList<Task> tasksFound = new ArrayList<Task>(); 
		
		for(Task i: tasks) {
			
			//reserved for future support of multiple Labels. MAY NEED TESTING AND DEBUGGING
//			boolean matches = true; 		
//			for(Label ii: labels) {
//				if(!labelsInTask.contains(ii)) {
//					matches = false; 
//				}
//			}
//			if(matches) {
//				tasksFound.add(i); 
//			}
			
			if(i.getLabels().equals(label.getText())) {
				tasksFound.add(i); 
			}
		}
		
		return tasksFound; 
	}
}
