
public class GlobleUpdate extends Thread {


 public void run(){

 while(true) {

try {
	Main.sprite.update();
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

try {

Thread.sleep(10000);

} catch (InterruptedException e) {

 // TODO Auto-generated catch block

e.printStackTrace();

}

}

}

}

//public class GlobleUpate implements Runnable {
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//	  System.out.println("MyThread running");
//	}
//	
//}
