//class that will enact specific events during launch
//For example at 12 second flood launch pad
//at 6 sec start engines
//at 1 release clamps

public class LaunchEvent implements Runnable{
	String message;
	int time;
	TimeMoniter tm;
	//Need to know what clock the event is running on
	LaunchEvent(int eTime, String eMessage, TimeMoniter t){
		this.time=eTime; this.message=eMessage; this.tm=t;
	}
	public void run(){
		boolean event=false;
		boolean aborted=false;
		while(!event){
			try{
				Thread.sleep(10);
				}
			catch(InterruptedException e){
				aborted=true;
			}
			if(tm.getTime()<=this.time){
				System.out.println(this.message);
				event=true;
				//Below will be a section to activate if you want all launches to fail
				/*
				System.out.println("Something is wrong...ABORT!");
				tm.AbortCountdown();
				*/
			}
			if(Thread.interrupted()){
				aborted=true;
			}
			if(aborted){
				System.out.println("Aborting "+message);
				break;
			}
		}
	}
}
