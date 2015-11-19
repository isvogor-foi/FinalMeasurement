package hr.foi.thor.main.scenario1;

import hr.foi.thor.Initializer;
import hr.foi.thor.main.scenario1.fpga.FpgaCom;
import hr.foi.tiwo.OdInitializerGpu;

public class ManualScenario1 {

	public void run(){
		
        System.out.println(" --- FM-S ---");
        //
        // --------------------------- CPU -------------------------------------------------------------
        //
		// S-VGA
		Initializer i = new Initializer(1); // RUN ON CPU!
		long f1s = System.nanoTime();
			i.runS(i.createBufferedImage("/home/ivan/dev/imgs/testimages/640.jpg"));
		long f1e = System.nanoTime();
		
		rest();
		
		// SGE-VGA
		long f2s = System.nanoTime();
			i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/640.jpg"));
		long f2e = System.nanoTime();
		
		rest();
		
		// SGE-SXGA
		i.initialize();
		
		long f3s = System.nanoTime();
			i.runSge(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
		long f3e = System.nanoTime();
		
		rest();
		
		// SGEDH-SXGA
		long f4s = System.nanoTime();
			i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
		long f4e = System.nanoTime();
		rest();
        //
        // --------------------------- GPU -------------------------------------------------------------
        //
		OdInitializerGpu odi = new OdInitializerGpu();
		
		long d1s = System.nanoTime();
			odi.detect("/home/ivan/dev/imgs/testimages/640.jpg");
		long d1e = System.nanoTime();
		odi = null;
		rest();
		odi = new OdInitializerGpu();
		long d2s = System.nanoTime();
			odi.detect("/home/ivan/dev/imgs/testimages/1920.jpg");
		long d2e = System.nanoTime();
		rest();
		i = new Initializer(0); // RUN ON GPU!
		// SGEDH-SXGA
		i.initialize();
		long f5s = System.nanoTime();
			i.runSged(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long f5e = System.nanoTime();
		rest();
		long f6s = System.nanoTime();
			i.runSgedh(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long f6e = System.nanoTime();

        //
        // --------------------------- FPGA -------------------------------------------------------------
        //
		
		// FPGA
		FpgaCom fpga = new FpgaCom();
		
		long fp1s = System.nanoTime();
		fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "sobel");
		long fp1e = System.nanoTime();
		rest();
		long fp2s = System.nanoTime();
			fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "gauss");
		long fp2e = System.nanoTime();
		rest();
		long fp3s = System.nanoTime();
			fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "sobel gauss");
		long fp3e = System.nanoTime();
        
        System.out.println(" --- FM-D-S ---");
	        System.out.println("CPU-S-VGA: " + (float) ((f1e-f1s)/1e6));
	        System.out.println("CPU-SGE-VGA: " + (float) ((f2e-f2s)/1e6));
	        System.out.println("CPU-SGE-SXGA: " + (float) ((f3e-f3s)/1e6));
	        System.out.println("CPU-SGEDH-SXGA: " + (float) ((f4e-f4s)/1e6));
	        
	        System.out.println("GPU-OD-VGA: " + (float) ((d1e-d1s)/1e6));
	        System.out.println("GPU-OD-FHD: " + (float) ((d2e-d2s)/1e6));
	        System.out.println("GPU-SGED-FHD: " + (float) ((f5e-f5s)/1e6));
	        System.out.println("GPU-SGEDH-FHD: " + (float) ((f6e-f6s)/1e6));
	        
	        System.out.println("FPGA-S: " + (float) ((fp1e-fp1s)/1e6));
	        System.out.println("FPGA-G: " + (float) ((fp2e-fp2s)/1e6));
	        System.out.println("FPGA-SG: " + (float) ((fp3e-fp3s)/1e6));
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
