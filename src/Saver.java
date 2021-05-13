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

	public Saver() {
		try {
			this.data = new FileOutputStream("data.txt");
		
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
	public void saveString(String string) {
	try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        this.data, "utf-8"))) {
		writer.write("something");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public void saveInt(int num) {
		try {
			
			ObjectOutputStream writer = new ObjectOutputStream(this.data);
            writer.writeInt(num);
            
            writer.close();
            writer=null;
            System.gc();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readString() {
		try {
            FileInputStream fileStream = new FileInputStream("data.txt");
            ObjectInputStream reader = new ObjectInputStream(fileStream);
            
            System.out.println(reader.readObject());
            System.out.println(reader.readInt());
            
            reader.close();
            fileStream.close();
            fileStream=null;
            reader=null;
            System.gc();
//          fileStream.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
