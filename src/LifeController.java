
public class LifeController {

	public static void main(String[] args) {
		PictureController picControl = new PictureController();
		picControl.loadImagesFirstTime();
		LifeGame game = new LifeGame();
		game.createNewGrid(10);
		game.start();
	}
}
