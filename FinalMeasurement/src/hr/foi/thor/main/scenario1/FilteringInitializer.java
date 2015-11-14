package hr.foi.thor.main.scenario1;

import hr.foi.thor.InitializerS1;
import hr.foi.thor.main.scenario1.fpga.FpgaCom;
import hr.foi.tiwo.OdInitializerS1;

public class FilteringInitializer {

	public static void run(){
		
        System.out.println(" --- FM-S ---");
        //
        // --------------------------- CPU -------------------------------------------------------------
        //
		// S-VGA
		InitializerS1 i = new InitializerS1(0); // RUN ON CPU!
		long f1s = System.nanoTime();
			i.runSVga(i.createBufferedImage("/home/ivan/dev/imgs/testimages/640.jpg"));
		long f1e = System.nanoTime();
		
		// SGE-VGA
		long f2s = System.nanoTime();
			i.runSgeVga(i.createBufferedImage("/home/ivan/dev/imgs/testimages/640.jpg"));
		long f2e = System.nanoTime();
		
		// SGE-SXGA
		i.initialize();
		
		long f3s = System.nanoTime();
			i.runSgeSxga(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
		long f3e = System.nanoTime();
		
		// SGEDH-SXGA
		long f4s = System.nanoTime();
			i.runSgedhSxga(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1280.jpg"));
		long f4e = System.nanoTime();
		
        //
        // --------------------------- GPU -------------------------------------------------------------
        //
		OdInitializerS1 odi = new OdInitializerS1();
		
		long d1s = System.nanoTime();
			odi.detectOnCPU("/home/ivan/dev/imgs/testimages/640.jpg");
		long d1e = System.nanoTime();
		
		long d2s = System.nanoTime();
			odi.detectOnCPU("/home/ivan/dev/imgs/testimages/1920.jpg");
		long d2e = System.nanoTime();
		
		i = new InitializerS1(1); // RUN ON GPU!
		// SGEDH-SXGA
		i.initialize();
		long f5s = System.nanoTime();
			i.runSgedFhd(i.createBufferedImage("/home/ivan/dev/imgs/testimages/640.jpg"));
		long f5e = System.nanoTime();
		
		long f6s = System.nanoTime();
			i.runSgedFhd(i.createBufferedImage("/home/ivan/dev/imgs/testimages/1920.jpg"));
		long f6e = System.nanoTime();

        //
        // --------------------------- FPGA -------------------------------------------------------------
        //
		
		// FPGA
		FpgaCom fpga = new FpgaCom();
		
		long fp1s = System.nanoTime();
		fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "sobel");
		long fp1e = System.nanoTime();
		
		long fp2s = System.nanoTime();
			fpga.call("/home/ivan/dev/imgs/beagle_qvga.jpg", "gauss");
		long fp2e = System.nanoTime();
		
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
	        System.out.println("SPGA-SG: " + (float) ((fp3e-fp3s)/1e6));
        System.out.println(" --- FM-D-E ---");
        
        System.out.println(" --- FM-E ---");

	}
	
}
