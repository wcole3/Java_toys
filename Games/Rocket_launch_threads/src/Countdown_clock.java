//a class that simulates the countdown for a rocket launch

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Countdown_clock extends Thread implements TimeMoniter{
	int t;
	//Lock the thread so that only one clock can be active at a time
	ReentrantLock lock= new ReentrantLock();
	public void run(){
		lock.lock();
		boolean aborted=false;
		for(;t>0;t--){
			try{
				System.out.println("T minus "+t+" seconds");
				Thread.sleep(1000);	
			}catch(InterruptedException e){	
				aborted=true;
			}
			if(Thread.interrupted()){
				aborted=true;
			}
			if(aborted){
				System.out.println("Stopping the clock!");
				break;
			}
			
		}
		//Unlock the thread once the countdown finishes
		lock.unlock();
	}
	public int getTime(){
		return this.t;
	}
	Countdown_clock(int iTime){
		this.t=iTime;
	}
	public void AbortCountdown(){
		//if this method is called interupt all active threads
		Thread[] active =new Thread[Thread.activeCount()];
		Thread.enumerate(active);
		for(Thread t:active){
			t.interrupt();
		}
	}
}
