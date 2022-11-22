package teck.jidoka.question3Multithreading;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Multithread extends Thread {

	private BufferedImage img;
	private int i;

	public Multithread(BufferedImage img,int i) {

		this.img = img;
		this.i = i;
	}

	@Override
	public void run() {

		File output = new File("src/img" + i + ".jpg");
		int a;
		if(i%2==0) a=1;
		else a=2;
		try {
			ImageIO.write(this.img, "jpg", output);
			System.out.println("new splitted image created with name: img"+i+".jpg  with thread"+a);
			Thread.sleep(1000);
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}