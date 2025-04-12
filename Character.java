import org.code.theater.*;
import org.code.media.*;
public class Character {

// Instance Variables
private String image;
private String sound;
  

private int x;
private int y;

public Character(String image, int x, int y ) {
    this.image = image;
  this.x=x;
  this.y=y;
  }
  
public String getImage() {
    return image;
  }
  
  public String getSound() {
    return sound;
  }
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
}