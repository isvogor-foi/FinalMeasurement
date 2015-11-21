package hr.foi.thor.main;

import hr.foi.thor.main.scenario1.CalculatedScenario1;
import hr.foi.thor.main.scenario1.CalculatedScenario1T2;
import hr.foi.thor.main.scenario1.CalculatedScenario1T3;
import hr.foi.thor.main.scenario1.CalculatedScenario2;
import hr.foi.thor.main.scenario1.CalculatedScenario2T2;
import hr.foi.thor.main.scenario1.CalculatedScenario2T3;
import hr.foi.thor.main.scenario1.ManualScenario1;
import hr.foi.thor.main.scenario1.ManualScenario2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world...");

		//ManualScenario1 fi = new ManualScenario1();
		//ManualScenario2 fi = new ManualScenario2();
		//CalculatedScenario1 fi = new CalculatedScenario1();
		//CalculatedScenario2 fi = new CalculatedScenario2();
		//CalculatedScenario2T2 fi = new CalculatedScenario2T2();
		//CalculatedScenario1T2 fi = new CalculatedScenario1T2();
		//CalculatedScenario1T3 fi = new CalculatedScenario1T3();
		CalculatedScenario2T3 fi = new CalculatedScenario2T3();
		
		try {
			System.out.println("Waiting...");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fi.run();
		
		
	}

}