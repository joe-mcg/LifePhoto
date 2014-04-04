import java.awt.FlowLayout;
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
	
	public void loadImages() {
		
		
		try {
		    img2 = ImageIO.read(this.getClass().getResource("/images/testImage1.png"));
		    img1 = ImageIO.read(this.getClass().getResource("/images/testImage2.png"));
		} catch (IOException e) {
			System.out.println("IO exception: " +e);
		}
		
		h = img1.getHeight();
		w = img1.getWidth();
		
		JFrame frame = buildFrame();
		
		JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img1, 0, 0, null);
            }
        };
        frame.add(pane);
       // frame.repaint();
        
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
