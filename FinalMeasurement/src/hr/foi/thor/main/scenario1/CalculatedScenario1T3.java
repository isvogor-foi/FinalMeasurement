package hr.foi.thor.main.scenario1;

import hr.foi.thor.Initializer;
import hr.foi.tiwo.OdInitializerCpu;
import hr.foi.tiwo.OdInitializerGpu;

public class CalculatedScenario1T3 {

	public void run(){
        //
        // --------------------------- CPU -------------------------------------------------------------
        //
		// S-VGA
		Initializer i = new Initializer(0); // RUN ON GPU!
		long g1s = System.nanoTime();
			i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/640.jpg"));
		long g1e = System.nanoTime();
		
		i = new Initializer(1); // RUN ON CPU!
		long c1s = System.nanoTime();
			i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/640.jpg"));
		long c1e = System.nanoTime();
		
		long c2s = System.nanoTime();
			i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
		long c2e = System.nanoTime();
		
		i = new Initializer(0); // RUN ON GPU!
		long g2s = System.nanoTime();
			i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
		long g2e = System.nanoTime();
		
		OdInitializerCpu odi = new OdInitializerCpu();
	
		long cd1s = System.nanoTime();
			odi.detect("/home/ivan/dev/imgs/testimages/640.jpg");
		long cd1e = System.nanoTime();
		odi = null;
		
		OdInitializerGpu odig = new OdInitializerGpu();
	
		long gd1s = System.nanoTime();
			odig.detect("/home/ivan/dev/imgs/testimages/1920.jpg");
		long gd1e = System.nanoTime();
		odig = null;
		
		i.initialize();
		long g3s = System.nanoTime();
			i.runSged(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long g3e = System.nanoTime();
		
		long g4s = System.nanoTime();
			i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long g4e = System.nanoTime();

		 i = new Initializer(1); // RUN ON CPU!
		long c3s = System.nanoTime();
			i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
		long c3e = System.nanoTime();
		
		// SGE-VGA
		long c4s = System.nanoTime();
			i.runG(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
		long c4e = System.nanoTime();
		
		// SGE-SXGA
		i.initialize();
		
		long c5s = System.nanoTime();
			i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
		long c5e = System.nanoTime();
		
		
        System.out.println(" --- FM-D-S ---");
	        System.out.println("gpu-s-640: " + (float) ((g1e-g1s)/1e6));
	        System.out.println("cpu-sge-640: " + (float) ((c1e-c1s)/1e6));
	        System.out.println("cpu-sge-1280: " + (float) ((c2e-c2s)/1e6));
	        System.out.println("gpu-sgedh-1280: " + (float) ((g2e-g2s)/1e6));
	        System.out.println("cpu-od-640: " + (float) ((cd1e-cd1s)/1e6));
	        System.out.println("gpu-od-1920: " + (float) ((gd1e-gd1s)/1e6));
	        System.out.println("gpu-sged-1280: " + (float) ((g2e-g2s)/1e6));
	        System.out.println("gpu-sgedh-1920: " + (float) ((g3e-g3s)/1e6));
	        System.out.println("cpu-s-320: " + (float) ((c3e-c3s)/1e6));
	        System.out.println("cpu-g-320: " + (float) ((c4e-c4s)/1e6));
	        System.out.println("cpu-sg-320: " + (float) ((c5e-c5s)/1e6));
        System.out.println(" --- FM-D-E ---");
        
        System.out.println(" --- FM-E ---");
	}
	
}
