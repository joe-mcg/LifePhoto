
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.swing.*;

import java.util.Random;

class Photo extends Component {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numlocs = 2;
    private int numcells = numlocs*numlocs;
    private int[] cells;
    private BufferedImage mainImage, img2;
    int w, h, cw, ch;
    
    public Photo(String imageSrc) {
        try {
            mainImage = ImageIO.read(this.getClass().getResource(imageSrc));
            w = mainImage.getWidth(null);
            h = mainImage.getHeight(null);
        } catch (IOException e) {
            System.out.println("Image could not be read");
//            System.exit(1);
        }
        cw = w/numlocs;
        ch = h/numlocs;
        cells = new int[numcells];
        for (int i=0;i<numcells;i++) {
            cells[i] = i;
        }
    }

    void jumble() {
        Random rand = new Random();
        int ri;
        for (int i=0; i<numcells; i++) {
            while ((ri = rand.nextInt(numlocs)) == i);

            int tmp = cells[i];
            cells[i] = cells[ri];
            cells[ri] = tmp;
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    public void paint(Graphics g) {

        int dx, dy;
        for (int x=0; x<numlocs; x++) {
            int sx = x*cw;
            for (int y=0; y<numlocs; y++) {
                int sy = y*ch;
                int cell = cells[x*numlocs+y];
                dx = (cell / numlocs) * cw;
                dy = (cell % numlocs) * ch;
                g.drawImage(mainImage,
                            dx, dy, dx+cw, dy+ch,
                            sx, sy, sx+cw, sy+ch,
                            null);
            }
        }
    }
}

public class PhotoApplet extends JApplet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String imageFileName = "/images/testImage2.png";

    public void init() {
        buildUI();
    }
     
    public void buildUI() {
        final Photo ji = new Photo(imageFileName);
        add("Center", ji);
        JButton jumbleButton = new JButton("Jumble");
        
        jumbleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    ji.jumble();
                    ji.repaint();
                };
            });
        Dimension jumbleSize = ji.getPreferredSize();
        resize(jumbleSize.width, jumbleSize.height+40);
        add("South", jumbleButton);
    }

    public static void main(String s[]) {
        JFrame f = new JFrame("Jumbled Image");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        
        PhotoApplet jumbler = new PhotoApplet();
        jumbler.buildUI();
        f.add("Center", jumbler);
        f.pack();
        f.setVisible(true);
    }
}