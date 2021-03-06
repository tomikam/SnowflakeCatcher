SnowFlake snowFall [];


void setup()
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
void draw()
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
void mouseDragged()
{
  //your code here
  if (mouseButton == LEFT) {
    noStroke();
    fill(255, 0, 0);
    ellipse(mouseX - 20, mouseY - 20, 10, 10);
  } else  if (mouseButton == RIGHT) {
    fill(0);
    ellipse(mouseX - 20, mouseY - 20, 45, 45);
  } else if (mouseButton == CENTER){
    background(0);
    for (int i = 0; i < snowFall.length; i ++) {
      snowFall[i].myX = (int)(Math.random()* (width - 20)) + 10;
      snowFall[i].myY = (int)(Math.random()*height) - 10;
  }
  }
}
void mouseClicked() 
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
  void show()
  {
    //your code here
    fill(255);
    ellipse(myX, myY, 5, 5);
  }
  void lookDown()
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
  void erase()
  {
    //your code here
    fill(0);
    ellipse(myX, myY, 8, 8);
  }
  void move()
  {
    //your code here
    if (isMoving) {
      myY ++;
    }
  }
  void wrap()
  {
    //your code here
    if (myY == height - 6) {
      myY = 0;
      myX = (int)(Math.random()*width);
    }
  }
}


