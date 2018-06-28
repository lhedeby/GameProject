package supergame.game.sound;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MP3Player{

    private static final Map<String, MediaPlayer> audioMap;
    private static final JFXPanel fxPanel;
    private static boolean pauseMode;

    static{
        audioMap = new ConcurrentHashMap<>();
        fxPanel = new JFXPanel(); // need to create one instance
        pauseMode = false;
    }

    private static void setLoop(MediaPlayer mediaPlayer, boolean loop) {
        if (mediaPlayer == null){
            return;
        }
        if (loop){
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        }
        else{
            mediaPlayer.setCycleCount(1);
        }
    }

    public static void play(String filepath){
        play(filepath, false);
    }

    public static void play(String filepath, boolean repeat){
        if (pauseMode) return;
        try {
            MediaPlayer mediaPlayer;
            if (audioMap.containsKey(filepath)) {
                mediaPlayer = audioMap.get(filepath);
                setLoop(mediaPlayer, repeat);
            }
            else{
                mediaPlayer = new MediaPlayer( new Media(new File(filepath).toURI().toString()) );
                setLoop(mediaPlayer, repeat);
                audioMap.put(filepath, mediaPlayer);
            }
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        }
        catch ( Exception e){
            e.printStackTrace();
        }
    }

    public static void stop(String filepath){
        try {
            if (audioMap.containsKey(filepath)) {
                MediaPlayer mediaPlayer = audioMap.get(filepath);
                mediaPlayer.pause();
                mediaPlayer.seek(Duration.ZERO);
                audioMap.remove(filepath);
            }
        }
        catch ( Exception e){
            e.printStackTrace();
        }
    }

    public static void stopAll(){
        Set<String> keys = audioMap.keySet();
        if (keys.size() == 0) return;
        for (String s : keys){
            stop(s);
        }
        pauseMode = false;
    }

    public static void pauseAll(){
        Set<String> keys = audioMap.keySet();
        if (keys.size() == 0) return;
        for (String s : keys){
            if (pauseMode)
                resume(s);
            else
                pause(s);
        }
        pauseMode = !pauseMode;
    }

    private static void pause(String filepath){
        try {
            if (audioMap.containsKey(filepath)) {
                MediaPlayer mediaPlayer = audioMap.get(filepath);
                mediaPlayer.pause();
            }
        }
        catch ( Exception e){
            e.printStackTrace();
        }
    }

    private static void resume(String filepath){
        try {
            if (audioMap.containsKey(filepath)) {
                MediaPlayer mediaPlayer = audioMap.get(filepath);
                mediaPlayer.play();
            }
        }
        catch ( Exception e){
            e.printStackTrace();
        }
    }

    public static void playFX(String filepath){
        try {
            MediaPlayer mediaPlayer = new MediaPlayer( new Media(new File(filepath).toURI().toString()) );
            mediaPlayer.play();
        }
        catch ( Exception e){
            e.printStackTrace();
        }
    }
}