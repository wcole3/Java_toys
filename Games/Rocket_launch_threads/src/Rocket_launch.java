//toy program to launch a rocket

import java.util.*;
import java.util.concurrent.*;
public class Rocket_launch {

	public static void main(String[] args) {
		// call a clock with a 20 second timer
		
		Countdown_clock clock=new Countdown_clock(20);
		//Now create some launch events in a linked list
		ArrayList<Runnable> events = new ArrayList();
		events.add(new LaunchEvent(12, "Flooding the Launch pad",clock));
		events.add(new LaunchEvent(6, "Starting the Engines",clock));
		events.add(new LaunchEvent(1, "Releasing Clamps",clock));
		events.add(new LaunchEvent(0,"Liftoff!!",clock));
		//Below is a random interrupter; comment it out if you don't want interrupts
		
		//events.add(new RandomFail(clock));
		
		//start the clock
		clock.start();
		//start the events
		for(Runnable e: events){
			new Thread(e).start();}

		//Another way of running the programs is using a scheduled pool
		//This does not work as expected
		/*
		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(25);
		for(Runnable e: events){
			pool.schedule(e, 0L, TimeUnit.SECONDS);
		pool.schedule(clock, 0L, TimeUnit.SECONDS);
		pool.s
		}
		*/
	}

}
