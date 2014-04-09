import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class PhotoFrame extends JFrame {
	
	BufferedImage img1, img2 = null;
	static int h, w;
	boolean firstImage;
	Graphics graphics;
	Canvas c;
	
    // The constructor follows:
    public PhotoFrame() {
//        setTitle("Photo");
    	try {
		    img2 = ImageIO.read(this.getClass().getResource("/images/testImage1.png"));
		    img1 = ImageIO.read(this.getClass().getResource("/images/testImage2.png"));
		} catch (IOException e) {
			System.out.println("IO exception: " +e);
		}
		
		h = img1.getHeight(null);
		w = img1.getWidth(null);
		
		c= new Canvas();
		
		graphics = img1.getGraphics();
    	
        setSize(w, h);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void paint(Graphics g, BufferedImage image) {        
        g.drawImage(image, 0, 0, null);
        firstImage = true;
    }
    
    public void update(Graphics g, BufferedImage image) {
    	if (firstImage) {
    		
    	}
    }

    // All classes need a main method, so we create that here too!
    public static void main(String args[]) {
        // We will create a GraphicsDemo object in the main method like so:
        // This should be familar, as we used this to create Random objects and
        // Thread objects:
    	PhotoFrame demo = new PhotoFrame();
//    	demo.repaint(update);
//    	demo.paint

    }
    
    //TODO: USEFUL STUFF, this splits an image into cols and rows:
//    public static BufferedImage[] splitImage(BufferedImage img, int cols, int rows) {
//		int w = img.getWidth()/cols;
//		int h = img.getHeight()/rows;
//		int num = 0;
//		BufferedImage imgs[] = new BufferedImage[w*h];
//		for(int y = 0; y < rows; y++) {
//			for(int x = 0; x < cols; x++) {
//				imgs[num] = new BufferedImage(w, h, img.getType());
//				// Tell the graphics to draw only one block of the image
//				Graphics2D g = imgs[num].createGraphics();
//				g.drawImage(img, 0, 0, w, h, w*x, h*y, w*x+w, h*y+h, null);
//				g.dispose();
//				num++;
//			}
//		}
//		return imgs;
//	}


} 