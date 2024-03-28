package game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Music {

    Clip musicClip;

    Music(String music) {
        upLoadMusic(music);
    }

    public void upLoadMusic(String musicURL) {

        try {

            URL resourcesUrl = getClass().getClassLoader().getResource(musicURL);
            if (resourcesUrl != null) {
                File musicFile = new File(resourcesUrl.toURI());
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                musicClip = (Clip) AudioSystem.getLine(info);
                musicClip.open(audioStream);
                musicClip.loop(Clip.LOOP_CONTINUOUSLY);
                //musicClip.start(); // sin bucle
            } else {
                System.err.println("No se pudo encontrar el archivo de música en la carpeta resources.");
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | URISyntaxException e) {
            e.printStackTrace(); // VER DE CAMBIAR
        }

    }

    public void stopMusic() {

        // Detener la música
        if (musicClip != null) {
            musicClip.stop();
        }
    }


}
