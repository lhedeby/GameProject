import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;

public class KeyManager  {
    Key key;
    Screen screen;
    Player player;

    public KeyManager(Player player, Screen screen){
        this.player = player;
        this.screen = screen;
    }

    public void keyDetector(){
        key = screen.readInput();
        player.setxVelocity(0);
        if (key!=null){
            switch (key.getKind()){
                case ArrowUp:
                    player.setyVelocity(-1);
                    break;
                case ArrowLeft:
                    player.setxVelocity(-1);
                    break;
                case ArrowRight:
                    player.setxVelocity(1);
                    break;
                case Escape:
                    System.exit(0);
            }
        }
    }

    public boolean keyDetectorPause(){
        key = screen.readInput();
        if (key!=null){
            if (key.getKind() == Key.Kind.Escape)
                return false;
        }
        return true;
    }
}
