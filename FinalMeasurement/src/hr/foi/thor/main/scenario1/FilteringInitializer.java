package hr.foi.thor.main.scenario1;

import hr.foi.thor.InitializerS1;

public class FilteringInitializer {

	public static void run(){
		
		// TODO: set image sizes..
		// S-VGA
		InitializerS1 i = new InitializerS1(0);
		i.runSVga(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));
		
		// SGE-VGA
		i.runSgeVga(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));

		// SGE-SXGA
		i.initialize();
		i.runSgeSxga(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));

		// SGEDH-SXGA
		i.runSgedhSxga(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));

	}
	
}
