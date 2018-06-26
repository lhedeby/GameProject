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
        if (key!=null){
            switch (key.getKind()){
//                case ArrowUp:
//                    ;
//                case ArrowDown:
//                    ;
                case ArrowLeft:
                    player.movePlayer(-1);
                    break;
                case ArrowRight:
                    player.movePlayer(1);
                    break;
            }
        }
    }
}
