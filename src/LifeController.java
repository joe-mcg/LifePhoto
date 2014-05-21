import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class LifeController {

	public static void main(String[] args) {
		LifeGame game = new LifeGame();
		game.createNewGrid(10);
		JFrame f = new JFrame("PhotoLife");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        
        PhotoApplet photo = new PhotoApplet();
        photo.buildUI();
        photo.setGrid(game.getGameGrid());
        f.add("Center", photo);
        f.pack();
        f.setVisible(true);
				
		
		//GAME LOOP
		for (int l =0;l<20;l++) {
			photo.setGrid(game.getGameGrid());
			game.move();
		}
	}
}
