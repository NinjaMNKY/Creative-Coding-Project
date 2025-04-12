import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {
 String[][] images = {
   //peter
   {"petergriffidle.png", "petergetpunch.png", "peterpunching.png"},
   //chicken
   {"bigchicken.png", "chickenpunched.png", "chickenpunches.png"},
   //backgrounds
   {"The_Drunken_Clam.png", "househouse.png", "sunset.png"},
   //effects
   {"textbubble.png", "explosion1.png", "explosion2.png"}
 };
String[][] sounds = {
   //peter
   {"peter-griffin-laugh-1.wav", "punch.wav", "null"},
   //chicken
   {"chickenscream.wav", "chickentheme-(1).wav", "punch2.wav"},
   //backgrounds
   {"cartoon-sound-fx-explosion_F_minor.wav", "cartoon-sound-fx-explosion-6.wav", "knockOutSound.wav"},
 };
// MyStory object
    MyStory scene = new MyStory(images, sounds);
    
    // Call drawScene
    scene.drawScene();
    
    // Play scene in Theater
    Theater.playScenes(scene);
    
    
    
    
  }
}