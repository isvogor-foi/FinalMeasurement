package hr.foi.thor.main.scenario1;

import hr.foi.thor.Initializer;
import hr.foi.tiwo.OdInitializerCpu;
import hr.foi.tiwo.OdInitializerGpu;

public class CalculatedScenario2T2 {

	public void run(){
		 System.out.println(" --- FM-S ---");


			Initializer i = new Initializer(1); 
			long g1s = System.nanoTime();
				i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
			long g1e = System.nanoTime();
			
			long c1s = System.nanoTime();
				i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
			long c1e = System.nanoTime();
			
			
			i = new Initializer(0); 
			long g2s = System.nanoTime();
				i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g2e = System.nanoTime();
			
			i = new Initializer(1); 
			long g3s = System.nanoTime();
				i.runG(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g3e = System.nanoTime();
			
			
			long g4s = System.nanoTime();
				i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g4e = System.nanoTime();
			
			i = new Initializer(0);
			long g5s = System.nanoTime();
				i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g5e = System.nanoTime();
			
			
			long g6s = System.nanoTime();
				i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g6e = System.nanoTime();
			
			
			OdInitializerGpu odig = new OdInitializerGpu();
			long gd1s = System.nanoTime();
				odig.detect("/home/ivan/dev/imgs/testimages/1920.jpg");
			long gd1e = System.nanoTime();
			odig = null;
			
			i = new Initializer(1); // RUN ON CPU!
			long g7s = System.nanoTime();
				i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
			long g7e = System.nanoTime();
			
			
			long c2s = System.nanoTime();
				i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
			long c2e = System.nanoTime();
			
			i.initialize();
			long c3s = System.nanoTime();
				i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
			long c3e = System.nanoTime();

			
	        System.out.println(" --- FM-D-S ---");
	        
	        	System.out.println("cpu-sg-1280: " + (float) ((g1e-g1s)/1e6));
	        	System.out.println("cpu-sge-1280: " + (float) ((c1e-c1s)/1e6));
	        	System.out.println("gpu-s-1920: " + (float) ((g2e-g2s)/1e6));
	        	System.out.println("cpu-g-1920: " + (float) ((g3e-g3s)/1e6));
	        	System.out.println("cpu-sg-1920: " + (float) ((g4e-g4s)/1e6));
	        	System.out.println("gpu-sge-1920: " + (float) ((g5e-g5s)/1e6));
	        	System.out.println("gpu-sgedh-1920: " + (float) ((g6e-g6s)/1e6));
	        	System.out.println("gpu-od-1920: " + (float) ((gd1e-gd1s)/1e6));
	        	System.out.println("cpu-s-320: " + (float) ((g7e-g7s)/1e6));
	        	System.out.println("cpu-sge-320: " + (float) ((c2e-c2s)/1e6));
	        	System.out.println("cpu-sgedh-320: " + (float) ((c3e-c3s)/1e6));
		      		        
	        System.out.println(" --- FM-D-E ---");
	        
	        System.out.println(" --- FM-E ---");
	}
	public void rest(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
