public class Game {
    Window window;
    Level level;
    GameObject player;
    KeyManager keyManager;
    Logic logic;


    public void init() {
        window = new Window();
        level = new Level(window);
        player = new Player(10,19);
        keyManager = new KeyManager((Player)player, window.getScreen());
        logic = new Logic((Player)player, level);
        MP3Player.play(".\\src\\supergame.mp3", true);


    }

    public void loop() {
        while (true) {
            window.graphics.drawLevel(level);
            window.graphics.drawPlayer(player);
            window.getScreen().refresh();
            keyManager.keyDetector();
            logic.movePlayer();
            window.getScreen().clear();

            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                continue;
            }
        }
    }
}
