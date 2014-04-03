
public class LifeController {

	public static void main(String[] args) {
		PictureController picControl = new PictureController();
		picControl.loadImages();
		LifeGame game = new LifeGame();
		//game.createNewGrid(50);
		//game.start();
	}
}
