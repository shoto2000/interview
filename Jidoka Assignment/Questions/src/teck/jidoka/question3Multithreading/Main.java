package teck.jidoka.question3Multithreading;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

		URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/0/03/Cm-logo-200x200.jpg");
        InputStream is = url.openStream();
        BufferedImage img= (BufferedImage) ImageIO.read(is);

		int rows = 2; 
		int cols = 2;
		int chunks = rows * cols; 
		int chunkWidth = img.getWidth() / cols;
		int chunkHeight = img.getHeight() / rows;
		int count = 0;
		BufferedImage imgs[] = new BufferedImage[chunks];

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				imgs[count] = new BufferedImage(chunkWidth, chunkHeight, img.getType());
				Graphics2D gr = imgs[count++].createGraphics(); // Actually create an image for us to use
				gr.drawImage(img, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x,
						chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
				gr.dispose();

			}
		}
		
		for(int i=0;i<imgs.length;i=i+2) {
			Multithread thread1 = new Multithread(imgs[i],i);
			Multithread thread2 = new Multithread(imgs[i+1],i+1);
			
			thread1.start();
			Thread.sleep(10);
			thread2.start();
			thread1.join();
			thread2.join();
		}

		

	}
}