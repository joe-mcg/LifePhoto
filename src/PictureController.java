import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class PictureController {

	BufferedImage img1, img2 = null;
	static int h, w;
	JPanel picture;
	
	public void loadImagesFirstTime() {		
		try {
		    img2 = ImageIO.read(this.getClass().getResource("/images/testImage1.png"));
		    img1 = ImageIO.read(this.getClass().getResource("/images/testImage2.png"));
		} catch (IOException e) {
			System.out.println("IO exception: " +e);
		}
		
		h = img1.getHeight();
		w = img1.getWidth();
		
		JFrame frame = buildFrame();
		drawImage(img1);
		
        frame.add(picture);
        
        
        redrawImage(img2);
        frame.repaint();
        redrawImage(img1);
        frame.repaint();
        redrawImage(img2);
        frame.repaint();
        redrawImage(img1);
        frame.repaint();
        redrawImage(img2);
        frame.repaint();
        redrawImage(img1);
	}
	
	public void redrawImage(BufferedImage newImage){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drawImage(newImage);
		
		//TODO:
		// draws the image chunk  
//        Graphics2D gr = imgs[count++].createGraphics();  
//        gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);  
//        gr.dispose();  
	}
	
	public void drawImage(final BufferedImage newImage) {
		picture = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newImage, 0, 0, null);
            }
        };
        
	}
	
	private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(w, h+30);
        frame.setVisible(true);
        return frame;
    }
}
