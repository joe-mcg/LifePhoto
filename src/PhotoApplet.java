
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

class Photo extends Component {

	private static final long serialVersionUID = 1L;
	private int lengthOfGame = 100;
    private int numcells = lengthOfGame*lengthOfGame;
    private int[] cells;
    private BufferedImage mainImage, img2;
    int w, h, cw, ch;
    static LifeGame game;

    
    public Photo(String imageSrc) {
        try {
            mainImage = ImageIO.read(this.getClass().getResource(imageSrc));
            img2 = ImageIO.read(this.getClass().getResource("/images/testImage1.png"));
            w = mainImage.getWidth(null);
            h = mainImage.getHeight(null);
        } catch (IOException e) {
            System.out.println("Image could not be read");
//            System.exit(1);
        }
        game = new LifeGame();
		game.createNewGrid(lengthOfGame);
        cw = w/lengthOfGame;
        ch = h/lengthOfGame;
        cells = new int[numcells];
        for (int i=0;i<numcells;i++) {
            cells[i] = i;
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    public void paint(Graphics g) {

        int dx, dy;
        for (int x=0; x<lengthOfGame; x++) {
            int sx = x*cw;
            for (int y=0; y<lengthOfGame; y++) {
                int sy = y*ch;
                int cell = cells[x*lengthOfGame+y];
                dx = (cell / lengthOfGame) * cw;
                dy = (cell % lengthOfGame) * ch;
               // if (PhotoApplet.isAlive()) {
                if (game.grid[x][y]==1) {
                g.drawImage(mainImage,
                            dx, dy, dx+cw, dy+ch,
                            sx, sy, sx+cw, sy+ch,
                            null);
                } else {
                	g.drawImage(img2,
                            dx, dy, dx+cw, dy+ch,
                            sx, sy, sx+cw, sy+ch,
                            null);
                }
            }
        }
		game.move();
    }
}

public class PhotoApplet extends JApplet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String imageFileName = "/images/testImage2.png";
	static String image2FileName= "/images/testImage.png";
	static boolean gameOfLife;

    public void init() {
        buildUI();
    }
     
    public void buildUI() {
        final Photo ji = new Photo(imageFileName);
        add("Center", ji);
        JButton jumbleButton = new JButton("Move");
        
        jumbleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton)e.getSource();
                    ji.repaint();
                };
            });
        Dimension jumbleSize = ji.getPreferredSize();
        resize(jumbleSize.width, jumbleSize.height+40);
        add("South", jumbleButton);
    }

    public static void main(String s[]) {

        JFrame f = new JFrame("PhotoLife");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        
        PhotoApplet jumbler = new PhotoApplet();
        jumbler.buildUI();
        f.add("Center", jumbler);
        f.pack();
        f.setVisible(true);
        PictureController picControl = new PictureController();
		picControl.loadImagesFirstTime();		
    }

}