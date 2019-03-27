//This will be a function to generate a random interrupt for
//the launch

import java.util.Random;

public class RandomFail implements Runnable{
	int interuptTime;
	TimeMoniter tm;
	RandomFail(TimeMoniter t){
		this.tm=t;
	}
	private int getRandom(TimeMoniter tm){
		//This will generate a random interrupt point
		int inter; int max=tm.getTime();
		Random rand=new Random();
		inter=rand.nextInt(max);
		return inter;
	}
	public void run(){
		boolean aborted=false;
		boolean eventDone=false;
		//first figure out when you are going to interrupt
		int interruptPoint=getRandom(tm);
		while(!eventDone){
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				aborted=true;
			}
			if(tm.getTime()<=interruptPoint){
				tm.AbortCountdown();
				eventDone=true;
			}
			if(aborted){
				System.out.println("Random Fail has been ironically interrupted");
				break;
			}
			
		}
	}
}
