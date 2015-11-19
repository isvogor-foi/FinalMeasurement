package hr.foi.thor.main.scenario1;

import hr.foi.thor.Initializer;
import hr.foi.thor.main.scenario1.fpga.FpgaCom;
import hr.foi.tiwo.OdInitializerGpu;

public class ManualScenario2 {

	public void run(){
		
        System.out.println(" --- FM-S ---");
        //
        // --------------------------- CPU -------------------------------------------------------------
        //
		// S-VGA
		Initializer i = new Initializer(1); // RUN ON CPU!
		long f1s = System.nanoTime();
			i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
		long f1e = System.nanoTime();
		
		// SGE-VGA
		long f2s = System.nanoTime();
			i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
		long f2e = System.nanoTime();
		
        //
        // --------------------------- GPU -------------------------------------------------------------
        //
		
		i = new Initializer(0); // RUN ON GPU!
		// SGEDH-SXGA
		i.initialize();
		long f3s = System.nanoTime();
			i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long f3e = System.nanoTime();
		
		long f4s = System.nanoTime();
			i.runG(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long f4e = System.nanoTime();
		
		i.initialize();
		long f5s = System.nanoTime();
			i.runSg(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long f5e = System.nanoTime();
		
		long f6s = System.nanoTime();
			i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long f6e = System.nanoTime();
		
		i.initialize();
		long f7s = System.nanoTime();
			i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long f7e = System.nanoTime();	
		
		OdInitializerGpu odi = new OdInitializerGpu();
		
		long d1s = System.nanoTime();
			odi.detect("/home/ivan/dev/imgs/testimages/1920.jpg");
		long d1e = System.nanoTime();
		

        //
        // --------------------------- FPGA -------------------------------------------------------------
        //
		
		// FPGA
		FpgaCom fpga = new FpgaCom();
		
		long fp1s = System.nanoTime();
		fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "sobel");
		long fp1e = System.nanoTime();
		
		long fp2s = System.nanoTime();
			fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "gauss gauss erode");
		long fp2e = System.nanoTime();
		
		long fp3s = System.nanoTime();
			fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "sobel gauss erode dilate hyst");
		long fp3e = System.nanoTime();
        
        System.out.println(" --- FM-D-S ---");
        
	        System.out.println("CPU-SG-VGA: " + (float) ((f1e-f1s)/1e6));
	        System.out.println("CPU-SGE-VGA: " + (float) ((f2e-f2s)/1e6));
	        
	        System.out.println("GPU-S-FHD: " + (float) ((f3e-f3s)/1e6));
	        System.out.println("GPU-G-FHD: " + (float) ((f4e-f4s)/1e6));
	        System.out.println("GPU-SG-FHD: " + (float) ((f5e-f5s)/1e6));
	        System.out.println("GPU-SGE-FHD: " + (float) ((f6e-f6s)/1e6));
	        System.out.println("GPU-SGEDH-FHD: " + (float) ((f7e-f7s)/1e6));
	       
	        System.out.println("GPU-OD-FHD: " + (float) ((d1e-d1s)/1e6));
	        
	        System.out.println("FPGA-S: " + (float) ((fp1e-fp1s)/1e6));
	        System.out.println("FPGA-SGE: " + (float) ((fp2e-fp2s)/1e6));
	        System.out.println("FPGA-SGEDH: " + (float) ((fp3e-fp3s)/1e6));
	        
        System.out.println(" --- FM-D-E ---");
        
        System.out.println(" --- FM-E ---");

	}
	
}
