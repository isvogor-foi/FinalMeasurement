package hr.foi.thor.main.scenario1;

import hr.foi.thor.Initializer;
import hr.foi.thor.main.scenario1.fpga.FpgaCom;
import hr.foi.tiwo.OdInitializerCpu;
import hr.foi.tiwo.OdInitializerGpu;

public class CalculatedScenario2T3 {

	public void run(){
		 System.out.println(" --- FM-S ---");


			Initializer i = new Initializer(1); //1 = cpu, 0 = gpu
			long c1s = System.nanoTime();
				i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
			long c1e = System.nanoTime();
			
			long c2s = System.nanoTime();
				i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
			long c2e = System.nanoTime();
			
			i.initialize();
			long c3s = System.nanoTime();
				i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long c3e = System.nanoTime();
			
			long c4s = System.nanoTime();
				i.runG(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long c4e = System.nanoTime();
			
			i = new Initializer(0); //1 = cpu, 0 = gpu
			long g1s = System.nanoTime();
				i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g1e = System.nanoTime();
			
			long g2s = System.nanoTime();
				i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g2e = System.nanoTime();
			
			i.initialize();
			long g3s = System.nanoTime();
				i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
			long g3e = System.nanoTime();
			
			
			OdInitializerGpu odig = new OdInitializerGpu();
			long gd1s = System.nanoTime();
				odig.detect("/home/ivan/dev/imgs/testimages/1920.jpg");
			long gd1e = System.nanoTime();
			odig = null;
			
			
			i = new Initializer(1); // RUN ON CPU!
			long c5s = System.nanoTime();
				i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/320.jpg"));
			long c5e = System.nanoTime();
			
			FpgaCom fpga = new FpgaCom();
			
			long fp1s = System.nanoTime();
			fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "sobel gauss erode");
			long fp1e = System.nanoTime();
			
			long fp2s = System.nanoTime();
				fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "gauss gauss erode dilate hyst");
			long fp2e = System.nanoTime();

			
	        System.out.println(" --- FM-D-S ---");
	        
	        	System.out.println("cpu-sg-1280: " + (float) ((c1e-c1s)/1e6));
	        	System.out.println("cpu-sge-1280: " + (float) ((c2e-c2s)/1e6));
	        	System.out.println("cpu-s-1920: " + (float) ((c3e-c3s)/1e6));
	        	System.out.println("cpu-g-1920: " + (float) ((c4e-c4s)/1e6));
	        	
	        	System.out.println("gpu-sg-1920: " + (float) ((g1e-g1s)/1e6));
	        	System.out.println("gpu-sge-1920: " + (float) ((g2e-g2s)/1e6));
	        	System.out.println("gpu-sgedh-1920: " + (float) ((g3e-g3s)/1e6));
	        	
	        	System.out.println("gpu-od-1920: " + (float) ((gd1e-gd1s)/1e6));
	        	
	        	System.out.println("cpu-s-320: " + (float) ((c5e-c5s)/1e6));
	        	System.out.println("fpga-sge-320: " + (float) ((fp1e-fp1s)/1e6));
	        	System.out.println("fpga-sgedh-320: " + (float) ((fp2e-fp2s)/1e6));
		      		        
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
