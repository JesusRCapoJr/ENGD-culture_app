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
	
	private FileOutputStream data;
	private FileOutputStream tasks;
	private FileOutputStream folders;
	private FileOutputStream labels;
	
	private ArrayList<String> testList;
	private ArrayList<String> gotList;

	public Saver() {
		try {
			this.data = new FileOutputStream("data.txt",true);
			this.tasks = new FileOutputStream("tasks.txt",true);
			this.folders = new FileOutputStream("folders.txt",true);
			this.labels = new FileOutputStream("labels.txt",true);
			
			this.testList = new ArrayList<String>();
			
			this.testList.add("Lemon");
			this.testList.add("Words");
			this.testList.add("qdlwijwijiewfiewflifefefjfkewlkjflkwf;qhfhf the world is lemon");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void save() {
	try {
		ObjectOutputStream dataWriter = new ObjectOutputStream(this.data);
		ObjectOutputStream tasksWriter = new ObjectOutputStream(this.tasks);
		
		dataWriter.writeObject("something");
		tasksWriter.writeObject(testList);
		
		dataWriter.close();
		tasksWriter.close();
		
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
