package hr.foi.thor.main.scenario1.fpga;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tiwo.communication.sockets.ClientSocket;
import com.tiwo.communication.sockets.RpiExchangePackage;

public class FpgaCom {
	
	public void call(){
		ClientSocket client = ClientSocket.getInstance();
		client.startRemote();
		
		// get image bytes
		BufferedImage rawImage = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bytes = null;
	
		try {
			///home/ivan/Dev/C/workspace/cimgs/beagle_qvga.jpg
			//openFileLocation
			rawImage = ImageIO.read(new File("/home/ivan/Dev/C/workspace/cimgs/beagle_qvga.jpg"));
			
			ImageIO.write(rawImage, "jpg", baos);
			baos.flush();
			bytes = baos.toByteArray();
			baos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		RpiExchangePackage packet = new RpiExchangePackage();
		packet.setFpgaCommand("sobel gauss erode dilate");
		//packet.setFpgaCommand("gauss sobel erode hyst");
		packet.img = bytes;
		packet.setMessage("Message size (" + bytes.length + ")");
		//client.sendPackageToServer(packet);

		
		for( int i = 0; i <= 550; i++){
			//Measurement.startMeasuring();
			System.out.println("At: " + i);
			client.sendPackageToServer(packet);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
