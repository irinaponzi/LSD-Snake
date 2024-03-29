package game.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Music {

    Clip musicClip;

    public Music(String music) {
        upLoadMusic(music);
        startMusic();
    }

    private void upLoadMusic(String musicURL) {

        try {
            URL resourcesUrl = getClass().getClassLoader().getResource(musicURL);
            if(resourcesUrl != null) {
                File musicFile = new File(resourcesUrl.toURI());
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                musicClip = (Clip) AudioSystem.getLine(info);
                musicClip.open(audioStream);
            } else {
                System.err.println("No se pudo encontrar el archivo de música");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | URISyntaxException e) {
            e.printStackTrace(); // VER DE CAMBIAR
        }
    }

    private void startMusic() {
        if(musicClip != null) {
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            //musicClip.start(); // sin bucle
        }
    }

    public void stopMusic() {
        if(musicClip != null) {
            musicClip.stop();
            musicClip.close();
        }
    }
}
