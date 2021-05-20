
public class GlobleUpdate extends Thread {

	int seconds;

 public void run(){

 while(true) {

try {
	seconds++;
	if (seconds%10==0) {
	Main.sprite.update();
	}
	Main.timeLabel.update();
	Main.sprite.update();
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

try {

Thread.sleep(1000);

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
