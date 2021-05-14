import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;


public class Saver {
	
	private FileOutputStream data;
	private FileOutputStream tasks;

	public Saver() {
		try {
			this.data = new FileOutputStream("data.txt");
			this.tasks = new FileOutputStream("tasks.txt");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public void saveString(String string) {
//		try {
//			
//			ObjectOutputStream writer = new ObjectOutputStream(this.data);
//            writer.writeObject(string);
//            
//            writer.close();
//            writer=null;
//            System.gc();
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	public void save() {
	try {
		ObjectOutputStream dataWriter = new ObjectOutputStream(this.data);
		ObjectOutputStream tasksWriter = new ObjectOutputStream(this.tasks);
		
		dataWriter.writeObject("something");
		tasksWriter.writeObject("words");
		
		dataWriter.close();
		tasksWriter.close();
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public void read() {
		try {
			
          FileInputStream dataStream = new FileInputStream("data.txt");
          ObjectInputStream dataReader = new ObjectInputStream(dataStream);
          
          FileInputStream tasksStream = new FileInputStream("tasks.txt");
          ObjectInputStream tasksReader = new ObjectInputStream(tasksStream);
            
          
	      System.out.println(dataReader.readObject());
	      System.out.println(tasksReader.readObject());
	      
          dataReader.close();
          tasksReader.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	}
