import java.util.ArrayList;
import java.io.Serializable;

public class Folder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5502867876331652655L;
	private ArrayList<Task> tasks;
	private ArrayList<Label> labels; 
	private String title; 
	private int folderID; 
	
	public Folder(String title, int folderID) {
		tasks = new ArrayList<Task>();  
		this.folderID=folderID;
		this.title = title; 
	}
	
	public void addTask(Task task) {
		this.tasks.add(task); 
	}
	
	public void removeTask(Task task) {
		this.tasks.remove(task); 
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
		this.labels.add(label); 
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
	 * Searches for and returns Task objects within this Folder with all Label objects specified. O(n)
	 * TODO: test it
	 * 
	 * @param labels: ArrayList<Label>
	 * @return tasksFound: tasks containing all labels. Note they may have more labels than specified. 
	 */
	public ArrayList<Task> getTasksByLabels(ArrayList<Label> labels){
		ArrayList<Task> tasksFound = new ArrayList<Task>(); 
		for(Task i: tasks) {
			
			//COMMENTED OUT BY JESUS
			//ArrayList<Label> labelsInTask = i.getLabels();  -----------------------------------------------------
			
//			boolean matches = true; 
//			for(Label ii: labels) {
//				if(!labelsInTask.contains(ii)) {
//					matches = false; 
//				}
//			}
//			if(matches) {
//				tasksFound.add(i); 
//			}
			//COMMENTED OUT BY JESUS
		}
		
		return tasksFound; 
	}
}
