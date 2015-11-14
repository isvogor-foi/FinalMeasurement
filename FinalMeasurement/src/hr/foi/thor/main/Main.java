package hr.foi.thor.main;

import hr.foi.thor.main.scenario1.FilteringInitializer;
import hr.foi.thor.main.scenario1.FilteringInitializerSc2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world...");

		//Scenario 1
		//FilteringInitializer fi = new FilteringInitializer();
		
		//Scenario 2
		FilteringInitializerSc2 fi = new FilteringInitializerSc2();
		
		try {
			System.out.println("Waiting...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fi.run();
		
		
	}

}
