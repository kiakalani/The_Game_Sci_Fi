import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * @author Kia
 * @version 1.00
 * <code>Audio</code> class is responsible for playing the audio files.
 */
public class Audio {
    /**
     * The <code>File</code> including the sound file
     */
    private File file;
    /**
     * <code>Clip</code> of the audio file
     */
    private Clip clip;

    /**
     * The constructor
     * @param path refers to the path of the audio file
     */
    public Audio(String path) {
        file=new File(path);
        //Getting the audio file
        try {
            clip= AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
        }catch (Exception err) {
            System.out.println("Error playing file");
        }
    }

    /**
     * This method is responsible for playing the audio files inside a loop
     */
    public void play() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * This method is responsible for playing an audio file normally with no looping
     */
    public void playNormal(){
        clip.start();
    }

    /**
     * This method would stop the audio file from being played
     */
    public void stop() {
        clip.stop();
    }

    /**
     * This method would indicate whether the sound playing is over or not.
     * @return
     */
    public boolean isOver() {
        return !clip.isActive();
    }
}