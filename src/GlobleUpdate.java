//Author: Nathan Atkinson  added to by Jesus Capo

public class GlobleUpdate extends Thread {

	int seconds;

 public void run(){

 while(true) {

try {								//sub program that is running in the background and updating the program clock and updating the panda
	seconds++;
	if (seconds%10==0) {
	Main.sprite.update();
	}
	Main.timeLabel.update();

} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

try {

Thread.sleep(1000); 				// stops for a little bit

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
