
public class LifeController {

	public static void main(String[] args) {
		LifeGame game = new LifeGame();
		game.createNewGrid(10);
		game.start();
	}
}
