package hr.foi.thor.main.scenario1;

import hr.foi.thor.Initializer;
import hr.foi.tiwo.OdInitializerCpu;
import hr.foi.tiwo.OdInitializerGpu;

public class CalculatedScenario2 {

	public void run(){
		 System.out.println(" --- FM-S ---");


			Initializer i = new Initializer(0); // RUN ON GPU!
			long g1s = System.nanoTime();
				i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
			long g1e = System.nanoTime();
			
			i = new Initializer(1); // RUN ON CPU!
			long c1s = System.nanoTime();
				i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
			long c1e = System.nanoTime();
			
			i = new Initializer(0); 
			long g2s = System.nanoTime();
				i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g2e = System.nanoTime();
			
			long g3s = System.nanoTime();
				i.runG(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g3e = System.nanoTime();
			
			i.initialize();
			long g4s = System.nanoTime();
				i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g4e = System.nanoTime();
			
			long g5s = System.nanoTime();
				i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g5e = System.nanoTime();
			
			i.initialize();
			long g6s = System.nanoTime();
				i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g6e = System.nanoTime();
			
			OdInitializerGpu odig = new OdInitializerGpu();
			long gd1s = System.nanoTime();
				odig.detect("/home/ivan/dev/imgs/testimages/1920.jpg");
			long gd1e = System.nanoTime();
			odig = null;
			
			long g7s = System.nanoTime();
				i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
			long g7e = System.nanoTime();
			
			i = new Initializer(1); // RUN ON CPU!
			long c2s = System.nanoTime();
				i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
			long c2e = System.nanoTime();
			
			long c3s = System.nanoTime();
				i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
			long c3e = System.nanoTime();

			
	        System.out.println(" --- FM-D-S ---");
	        
	        	System.out.println("gpu-sg-1280: " + (float) ((g1e-g1s)/1e6));
	        	System.out.println("cpu-sge-1280: " + (float) ((c1e-c1s)/1e6));
	        	System.out.println("gpu-s-1920: " + (float) ((g2e-g2s)/1e6));
	        	System.out.println("gpu-g-1920: " + (float) ((g3e-g3s)/1e6));
	        	System.out.println("gpu-sg-1920: " + (float) ((g4e-g4s)/1e6));
	        	System.out.println("gpu-sge-1920: " + (float) ((g5e-g5s)/1e6));
	        	System.out.println("gpu-sgedh-1920: " + (float) ((g6e-g6s)/1e6));
	        	System.out.println("gpu-od-1920: " + (float) ((gd1e-gd1s)/1e6));
	        	System.out.println("gpu-s-320: " + (float) ((g7e-g7s)/1e6));
	        	System.out.println("gpu-sge-320: " + (float) ((c2e-c2s)/1e6));
	        	System.out.println("gpu-sgedh-320: " + (float) ((c3e-g3s)/1e6));
		      		        
	        System.out.println(" --- FM-D-E ---");
	        
	        System.out.println(" --- FM-E ---");
	}

	
}
