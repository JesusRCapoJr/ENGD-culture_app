import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import java.util.ArrayList;


public class Saver {
	
//	private FileOutputStream importedData;
//	private FileOutputStream importedTasks;
//	private FileOutputStream importedFolders;
//	private FileOutputStream labels;
	
	private ArrayList<String> testList;
	private ArrayList<String> gotList;

	public Saver() {
		try {
			
			this.testList = new ArrayList<String>();
			
			this.testList.add("Lemon");
			this.testList.add("Words");
			this.testList.add("qdlwijwijiewfiewflifefefjfkewlkjflkwf;qhfhf the world is lemon");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void save(ArrayList<String> preferenceList, ArrayList<Task> taskList, ArrayList<Folder> folderList, ArrayList<Label> labelList) {
	try {
		FileOutputStream data = new FileOutputStream("data.txt",false);
		FileOutputStream tasks = new FileOutputStream("tasks.txt",false);
		FileOutputStream folders = new FileOutputStream("folders.txt",false);
		FileOutputStream labels = new FileOutputStream("labels.txt",false);
		
		ObjectOutputStream dataWriter = new ObjectOutputStream(data);
		ObjectOutputStream taskWriter = new ObjectOutputStream(tasks);
		ObjectOutputStream folderWriter = new ObjectOutputStream(folders);
		ObjectOutputStream labelWriter = new ObjectOutputStream(labels);
		
		dataWriter.writeObject(preferenceList);
		taskWriter.writeObject(taskList);
		folderWriter.writeObject(folderList);
		labelWriter.writeObject(labelList);
		
		dataWriter.close();
		taskWriter.close();
		folderWriter.close();
		labelWriter.close();
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	@SuppressWarnings("unchecked")
	public void read() {
		try {
			
          FileInputStream dataStream = new FileInputStream("data.txt");
          ObjectInputStream dataReader = new ObjectInputStream(dataStream);
          
          FileInputStream tasksStream = new FileInputStream("tasks.txt");
          ObjectInputStream tasksReader = new ObjectInputStream(tasksStream);
            
          this.gotList = (ArrayList<String>) tasksReader.readObject();
	      System.out.println(dataReader.readObject());
	      System.out.println(this.gotList.get(1));
	      System.out.println(this.gotList.get(2));
	      
          dataReader.close();
          tasksReader.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	}
