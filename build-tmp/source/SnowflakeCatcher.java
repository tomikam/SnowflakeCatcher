import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake snowFall [];


public void setup()
{
  //your code here
  size(500, 500);
  background(0);
  snowFall = new SnowFlake [100];
  for (int i = 0; i < snowFall.length; i ++) {
    snowFall[i] = new SnowFlake();
  }
  fill(0);
  rect(0, 400, 400, 400);
}
public void draw()
{

  //your code here
  for (int i = 0; i < snowFall.length; i++) {
    snowFall[i].erase();
    snowFall[i].lookDown();
    snowFall[i].move();
    snowFall[i].wrap();
    snowFall[i].show();
  }

}
public void mouseDragged()
{
  //your code here
  if (mouseButton == LEFT) {
    noStroke();
    fill(255, 0, 0);
    ellipse(mouseX, mouseY, 10, 10);
  } else  if (mouseButton == RIGHT) {
    fill(0);
    ellipse(mouseX + 100, mouseY + 100, 45, 45);
  } else if (mouseButton == CENTER){
    background(0);
    for (int i = 0; i < snowFall.length; i ++) {
      snowFall[i].myX = (int)(Math.random()* (width - 20)) + 10;
      snowFall[i].myY = (int)(Math.random()*height) - 10;
  }
  }
}
public void mouseClicked() 
{
  if (mouseButton == CENTER) {
    background(0);
    for (int i = 0; i < snowFall.length; i++) {
      snowFall[i].myX = (int)(Math.random()* (width - 20)) + 10;
      snowFall[i].myY = (int)(Math.random()*height) - 10;
    }
  }
}

class SnowFlake
{
  //class member variable declarations
  int myX, myY;
  boolean isMoving;
  SnowFlake()
  {
    //class member variable initializations
    myX = (int)(Math.random()* (width - 20)) + 10;
    myY = (int)(Math.random()*height) - 10;
    isMoving = true;
  }
  public void show()
  {
    //your code here
    fill(255);
    ellipse(myX, myY, 5, 5);
  }
  public void lookDown()
  {
    //your code here
    //if (myY > 0 && myY < height) {
      if (get(myX, myY + 4) != color(0)) {
        isMoving = false;
      } else {
        isMoving = true;
      }
    //}
  }
  public void erase()
  {
    //your code here
    fill(0);
    ellipse(myX, myY, 8, 8);
  }
  public void move()
  {
    //your code here
    if (isMoving) {
      myY ++;
    }
  }
  public void wrap()
  {
    //your code here
    if (myY == height - 6) {
      myY = 0;
      myX = (int)(Math.random()*width);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
