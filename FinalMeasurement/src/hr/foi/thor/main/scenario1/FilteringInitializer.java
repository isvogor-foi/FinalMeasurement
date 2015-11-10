package hr.foi.thor.main.scenario1;

import hr.foi.thor.InitializerS1;
import hr.foi.thor.main.scenario1.fpga.FpgaCom;
import hr.foi.tiwo.OdInitializerS1;

public class FilteringInitializer {

	public static void run(){
		
		// TODO: set image sizes..
		// S-VGA
		InitializerS1 i = new InitializerS1(0); // RUN ON CPU!
		i.runSVga(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));
		
		// SGE-VGA
		i.runSgeVga(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));

		// SGE-SXGA
		i.initialize();
		i.runSgeSxga(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));

		// SGEDH-SXGA
		i.runSgedhSxga(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));
		
		// GPU
		
		OdInitializerS1 odi = new OdInitializerS1();
		odi.detectOnCPU();
		
		odi.detectOnCPU();
		
		// SGEDH-SXGA
		i.initialize();
		i.runSgedFhd(i.createBufferedImage("/home/ivan/Dev/java/temp/cap2g.jpg"));
		
		// FPGA
		//FpgaCom fpga = new FpgaCom();
		//fpga.call();

	}
	
}
