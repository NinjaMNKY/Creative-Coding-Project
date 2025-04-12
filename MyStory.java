import org.code.theater.*;
import org.code.media.*;


public class MyStory extends Scene {

// Instance Variables
 private String[][] images;
  private String[][] sounds;

  // Constructor
  public MyStory(String[][] images, String[][] sounds) {
    this.images = images;
    this.sounds = sounds;
  }
  
  /**
 * draws all three different scenes of the projects
 *
 * Precondition: there must be scenes to draw
 * Postcondition: All availiable scense were drawn
 
 * @return		the three scense animated 
 */
public void drawScene() {
   introScene();
  fightingScene();
  finalScene();
  }
  
/**
 * Introduction scene where the peter and the chicken first see each other
 *
 * Precondition: there must be a peter image and a chicken image
 * Postcondition: the chicken tackles peter griffin off screen
 * 
 * @return draws the first scene where peter and the chicken see eachother
 */

 public void introScene() {
 //peter walks into frame and then the chicken walks in after peter 
   clear("white");
  drawImage("househouse.png", 0, 20, 500);
   peterWalk();
   playSound("peter-griffin-laugh-1.wav");
   chickenWalk();
   pause(1);
   drawImage("textbubble.png", 180, 180, 120);
   drawText("Oh No!", 220, 240); 
   pause(2);
   playSound("realistic_punch-mark_diangelo-1609462330.wav");
   playSound("realistic_punch-mark_diangelo-1609462330.wav");
   
   scroll("tackle.png", "househouse.png");
 }


  /**
 * the main fighting scene where the chicken and peter griffin are exchanging blows as explosions are going off
 *
 * Precondition: the introScene must play first
 * Postcondition: Peter and the chicken must throw punches
 * 
 * @return	the chicken and peter griffin are exchanging blows as explosions are going off
 */

  public void fightingScene(){
     clear("Gray");
      drawImage("The_Drunken_Clam.png", 0, 0, 400);
    punching(370, 13, "The_Drunken_Clam.png", "Gray");
    pause(0.5);
   
  }
    

/**
 * the chicken and Peter griffin keep fighting but then Peter griffin does a kick which sends the chicken off the screen. Peter griffin then walks into the sunset while laughing.
 *
 * the fightingScene must play first  
 * Peter has to walk off into the sunset 
*
 * Peter griffin walks off and "The End" is displayed 
 */
public void finalScene(){
     clear("ORANGE");
  drawImage("sunset.png", 0, 40, 500);
  punching(370, 8, "sunset.png", "ORANGE");
  scroll("chickenpunched.png", "sunset.png", 200);
  pause(2);
       clear("ORANGE");
  drawImage("sunset.png", -60, 0, 550);
  shrink();
  
    drawText("The End",170, 100 ); 
  pause(1);
}


  /**
 * Animates peter walking from the left side of the screen to the middle
 *
 * Precondition: There must be a usable peter image to animate
 * Postcondition: Peter must walk from the left side of the screen to the middle of the screen 
 * 
 * Animates peter walking to the middle of the screen 
 */
private void peterWalk(){
  int currX = -40;
  int rotation = 5;
  for(int i = 0; i< 4; i++){
    clear("AQUA");
    drawImage("househouse.png", 0, 20, 500);
    drawImage(images[0][0], currX, 260, 80, rotation);
    pause(0.5);
    currX += 50;
    rotation *= -1;
  }
}
 /**
 * Animates the Chicken walking from the right side of the screen to the middle
 *
 * Precondition: There must be a usable the Chicken image to animate
 * Postcondition: Peter must walk from the right side of the screen to the middle of the screen 
 * 
 * Animates the Chicken walking to the middle of the screen 
 */
  
  private void chickenWalk(){
  int currX = 400;
  int rotation = 5;
  for(int i = 0; i< 4; i++){
    clear("AQUA");
    drawImage("househouse.png", 0, 20, 500);
    drawImage(images[1][0], currX, 250, 100, rotation);
    drawImage(images[0][0], 130, 260, 80);
    
    pause(0.5);
    currX -= 60;
    rotation *= -1;
  }

    
}

 /**
 * Animates a image sliding from the middle off screen to the left
 *
 * Precondition: There must be a usable image to animate scrolling aswell as a usable backgroud to use
 * Postcondition: image must leave the frame 
 
 * @param		paramName description
 * @return		description
 * Animates an image scrolling from the middle to the left and out fo frame 
 */
  private void scroll(String image, String background){
    int x= 150;
    while(x> -220){
       clear("AQUA");
        drawImage(background, 0, 20, 500);
      drawImage(image, x, 250, 200 );
      x-=120;
      pause(0.2);
    }
  }
 /**
 * Animates an image slding up and out of frame followed by a KO effect
 *
 * Precondition: There muust be a usable peter image to animate
 * Postcondition: Peter must walk from the left side of the screen to the middle of the screen 
 * 
* parameters: image is to set an image to scroll, background is the image that is set as the background, y is the starting y position of the image
 *
 * Animates peter walking to the middle of the screen 
 */
private void scroll(String image, String background, int y){
    
playSound("punch.wav");
      int sizeNum = 180;
  //variable so the chciken can shrink but staying on the same x value
  int x = 170;
    while(y> -100){
       clear("Gray");
               drawImage(background, -60, 0, 550);
      //draw the chicken being hit up 
      drawImage(image, x, y, sizeNum );
      y-=100;
      sizeNum-= 50;
    x+=20;
      drawImage("peterKick.png", -20, 200, 300 );
      pause(0.5);
      
    }
  clear("Gray");
         drawImage(background, -60, 0, 550);
  drawImage("peterKick.png", -20, 200, 300 );
  pause(0.2);
  drawImage("KOeffect.png", 350, -100, 300, 90);
  playSound("knockOutSound.wav");
  }

 /**
 * Animates an peter griffin punching the chicken, and then the chicken punching peter griffin, with explosions going off in the backgorund
 *
 * Precondition: There must be a usable peter and chicken image to animate
 * Postcondition: Peter must walk from the left side of the screen to the middle of the screen 
 * 
* parameters: currX is the starting x that the image starts on, background is the image that is set as the background, color is the color that color that clears the screen after it animates
 *
 * animates peter griffin and the chicken fighting eachother
 */
 private void punching( int currX, int amtPunches, String background, String color){
   for(int i = 0; i< amtPunches; i++){
  
    int chickenX = currX+80;
    
       if(i% 2 == 0){
       clear(color);
                drawImage(background, -60, 0, 550);
         //peter punching
         drawImage(images[0][2], currX, 250, 140);
       drawImage(images[1][1], chickenX, 250, 140);
         playSound(sounds[0][1]); 
         double pauseTime = (double)(Math.random()*0.5);
  pause(pauseTime);
         explosions();
         pause(0.5);
       currX -=50;
         chickenX -=50; 
         
       }else if(i % 2 != 0){
          clear(color);
                drawImage(background, -60, 0, 550);
         //chickenpunching
         drawImage(images[1][2], chickenX, 220, 160);
         drawImage(images[0][1], currX, 220, 140);
         playSound(sounds[1][2]); 
         
         explosions();
       pause(0.5);
       currX -=50;
         chickenX -=50; 
         
       }
 }
 }
   /**
 * creates a random explosion at a random x and y value
 *
 * Precondition: the sound files for the explosions must be valid 
 * Postcondition: the explosion happened somewhere random on the screen  
 * 
* 
 *
 * creates a random explosion at a random x and y value
 */
private void explosions(){

  int randomX=(int)(Math.random()*300);
 int randomY= (int)(Math.random()*300);

  if(randomX % 2 == 0){
    drawImage("explosion1.png", randomX, randomY, 150);
    playSound("cartoon-sound-fx-explosion-6.wav");
    
  }else if(randomX % 2 != 0){
    drawImage("explosion2.png", randomX, randomY, 150);
    playSound("cartoon-sound-fx-explosion_F_minor.wav");
  }
  
     
}
 /**
 * Animates an ipeter griffin shrinking into the sunset 
 *
 * Precondition: There muust be a usable peter image to animate
 * Postcondition: Peter must be have a size of 0 at the end 
 * 
 *
 * Animates an ipeter griffin shrinking into the sunset 
 */
private void shrink(){
  int size = 160;
  int x = 50;
  int y = 160;
  while(size >= 0){
    clear("Gray");
         drawImage("sunset.png", -60, 0, 550);
    drawImage("petergriffidle.png", x, y, size);
    size -= 20;
      x+= 25;
    playSound("peter-griffin-laugh-1.wav"); 
if(size<100){
  y+=15;
}
    pause(0.2);
  }
}



}