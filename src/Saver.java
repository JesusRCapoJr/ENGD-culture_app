//Author: Jesus Capo

import java.io.Serializable;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import java.util.ArrayList;


public class Saver {
	
	public void save(ArrayList<Integer> preferenceList, ArrayList<Task> taskList, ArrayList<Folder> folderList, ArrayList<Label> labelList) {
	try {
		
		//ESTABLISH OUTPUT STREAMS to allow editing
		FileOutputStream data = new FileOutputStream("data.txt",false); //set to false so the file is OVERWRITTEN
		FileOutputStream tasks = new FileOutputStream("tasks.txt",false);
		FileOutputStream folders = new FileOutputStream("folders.txt",false);
		FileOutputStream labels = new FileOutputStream("labels.txt",false);
		
		//ESTABLISH OBJECTOUTPUTSTREAM OBJECTS to edit from
		ObjectOutputStream dataWriter = new ObjectOutputStream(data);
		ObjectOutputStream taskWriter = new ObjectOutputStream(tasks);
		ObjectOutputStream folderWriter = new ObjectOutputStream(folders);
		ObjectOutputStream labelWriter = new ObjectOutputStream(labels);
		
		//WRITE GIVEN OBJECTS TO EACH RESPECTIVE FILE
		dataWriter.writeObject(preferenceList);
		taskWriter.writeObject(taskList);
		folderWriter.writeObject(folderList);
		labelWriter.writeObject(labelList);
		
		//CLOSE ALL OBJECTOUTPUTSTREAMS
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
	public void read(ArrayList<Integer> preferenceList, ArrayList<Task> taskList, ArrayList<Folder> folderList, ArrayList<Label> labelList) {
		try {
		  //ESTABLISH INPUT STREAMS to allow reading
          FileInputStream dataStream = new FileInputStream("data.txt") ;
          FileInputStream taskStream = new FileInputStream("tasks.txt");
          FileInputStream folderStream = new FileInputStream("folders.txt");
          FileInputStream labelStream = new FileInputStream("labels.txt");
          
          //ESTABLISH OBJECTINPUTSTREAMS to read from
          ObjectInputStream dataReader = new ObjectInputStream(dataStream);
          ObjectInputStream taskReader = new ObjectInputStream(taskStream);
          ObjectInputStream folderReader = new ObjectInputStream(folderStream);
          ObjectInputStream labelReader = new ObjectInputStream(labelStream);
          
          //LOOP THROUGH EACH ARRAY READ FROM EACH FILE TO CREATE A LOCAL COPY OF EACH ARRAYLIST
  
          for (Integer preference : (ArrayList<Integer>)dataReader.readObject()) {
        	  preferenceList.add(preference);
          }
          
          for (Task task : (ArrayList<Task>)taskReader.readObject()) {
        	  taskList.add(task);
          }
          
          for (Folder folder : (ArrayList<Folder>)folderReader.readObject()) {
        	  folderList.add(folder);
          }
          
          for (Label label : (ArrayList<Label>)labelReader.readObject()) {
        	  labelList.add(label);
          }
	      
          //CLOSE ALL OBJECTINPUTSTREAMS
          dataReader.close();
          taskReader.close();
          folderReader.close();
          labelReader.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	}
