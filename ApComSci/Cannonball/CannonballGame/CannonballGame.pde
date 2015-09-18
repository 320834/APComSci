      PImage cloud1, cloud2, cloud3, controls;
      boolean aKey = false, dKey = false, jKey = false, lKey = false, wKey = false, sKey = false, iKey = false, kKey = false, leftShooting = false, rightShooting = false, fKey = false, initializeLeftShot = true, initializeRightShot = true, qKey = false, eKey = false, hKey = false, uKey = false, oKey = false;
      int leftAngle = 45, rightAngle = 45, lX, lY, rX, rY, leftVelocity = 50, rightVelocity = 50, leftHits = 0, rightHits = 0;
      float lM, rM;
      Tank tankPink = new Tank(255, 105, 180, 50, 0, 325);
      Tank tankBlue = new Tank(0, 255, 255, 775, 575, 900);
      Ball leftBall, rightBall;
      
      void setup() {
        size(900, 700);
        strokeWeight(3);
        cloud1 = loadImage("cloud1.png");
        cloud2 = loadImage("cloud2.png");
        cloud3 = loadImage("cloud3.png");
        controls = loadImage("controls.png");
      }
      
      void draw() {
        backgroundBox();
        stroke(0, 0, 0);
        if(leftShooting){
          if(initializeLeftShot){
            initializeLeftShot = false;
            leftBall = new Ball(leftVelocity, leftAngle, .1, lX + tankPink.x + 40, 475 - lY, true);
          }  
          ellipse(leftBall.getX(), leftBall.getY(), 5, 5);
          if(leftBall.getY() > 475)
            if(leftBall.getX() >= tankBlue.x && leftBall.getX() <= tankBlue.x + 75){
              leftShooting = false;
              initializeLeftShot = true;
              leftHits++;
              reset();
            }
          leftBall.nextIteration();
        }
        if(leftShooting && leftBall.getY() == 500){
          leftShooting = false;
          initializeLeftShot = true;
        }
        
        if(rightShooting){
          if(initializeRightShot){
            initializeRightShot = false;
            rightBall = new Ball(rightVelocity, rightAngle, .1, tankBlue.x + 40 - rX, 475 - rY, false);
          }  
          ellipse(rightBall.getX(), rightBall.getY(), 5, 5);
          if(rightBall.getY() > 475)
            if(rightBall.getX() >= tankPink.x && rightBall.getX() <= tankPink.x + 75){
              rightShooting = false;
              initializeRightShot = true;
              rightHits++;
              reset();
            }
          rightBall.nextIteration();
        }
        if(rightShooting && rightBall.getY() == 500){
          rightShooting = false;
          initializeRightShot = true;
        }
        strokeWeight(6);
        leftTurret();
        rightTurret();
        strokeWeight(3);
        tankBlue.drawTank();
        tankPink.drawTank();
        transformations();
        fill(0, 0, 0);
        text("Hits: " + leftHits, 10, 20);
        text("Hits: " + rightHits, 820, 20);
        text("Angle: " + leftAngle + "\nVelocity: " + leftVelocity, 10, 550);
        text("Angle: " + rightAngle + "\nVelocity: " + rightVelocity, 820, 550);  
        }
      
      void reset(){
        tankPink = new Tank(255, 105, 180, 50, 0, 325);
        tankBlue = new Tank(0, 255, 255, 775, 575, 900);
        leftVelocity = 50;
        rightVelocity = 50;
        leftAngle = 45;
        rightAngle = 45;
      }
      
      void backgroundBox() {
        stroke(0, 0, 0);
        fill(0, 255, 127);
        rect(0, 500, 900, 200);
        fill(135, 206, 250);
        rect(0, 0, 900, 500);
        image(cloud1, 0, 50, 256, 227.5);
        image(cloud2, 150, 150, 318, 265);
        image(cloud3, 300, 200, 600, 189);
        image(cloud2, 500, 50, 318, 265);
        image(controls, 15, 360, 1500, 500);

        boundary();
      }
      
      void transformations(){
        if(fKey)
          leftShooting = true;
        if(hKey)
          rightShooting = true;
        if(uKey)
          if(rightVelocity < 85)
            rightVelocity++;
        if(oKey)
          if(rightVelocity > 20)
            rightVelocity--;
        if(eKey)
          if(leftVelocity < 85)
            leftVelocity++;
        if(qKey)
          if(leftVelocity > 20)
            leftVelocity--;
        if(wKey)
          if(leftAngle < 87)
             leftAngle++;
        if(sKey)
          if(leftAngle > 16)
             leftAngle--;     
        if(iKey)
          if(rightAngle < 87)
             rightAngle++;
        if(kKey)
          if(rightAngle > 16)
             rightAngle--;     
        if(jKey)
            tankBlue.move(false);
        else if(lKey)
                tankBlue.move(true);
        if(aKey)
          tankPink.move(false);
        else if(dKey)
                  tankPink.move(true);    
      }
      
      void leftTurret(){
        lM = tan(radians(leftAngle));          //Formula Derived from slope formula and distance formuls
        lX = (int)(50/sqrt(1 + (lM*lM)));
        lY = (int)(lM*(lX));
        line((tankPink.x + 40), 475, tankPink.x + 40 + lX, 475 - lY);  
      }
      
      void rightTurret(){
        rM = tan(radians(rightAngle));
        rX = (int)(50/sqrt(1 + (rM*rM)));
        rY = (int)(rM*(rX));
        line((tankBlue.x + 40), 475, tankBlue.x + 40 - rX, 475 - rY);
      }
      
      void boundary(){
        stroke(255, 105, 180);
        line(325, 480, 325, 500); 
        stroke(0, 255, 255);
        line(575, 480, 575, 500); 
      }
      
      void keyPressed(){
        toggle(key, true); 
      }
      
      void keyReleased(){
        toggle(key, false); 
      }
      
      void toggle(char key, boolean set){
         if(key == 'a' || key == 'A')
           aKey = set;
         else if(key == 'd' || key == 'D')
                 dKey = set;
         else if(key == 'l' || key == 'L')
                 lKey = set;
         else if(key == 'j' || key == 'J')
                 jKey = set;
         else if(key == 'w' || key == 'W')
                 wKey = set;   
         else if(key == 's' || key == 'S')
                 sKey = set;
         else if(key == 'i' || key == 'I')
                 iKey = set;   
         else if(key == 'k' || key == 'K')
                 kKey = set;
         else if(key == 'f' || key == 'F')
                 fKey = set;
         else if(key == 'q' || key == 'Q')
                 qKey = set;
         else if(key == 'e' || key == 'E')
                 eKey = set;
         else if(key == 'h' || key == 'H')
                 hKey = set;
         else if(key == 'u' || key == 'U')
                 uKey = set;
         else if(key == 'o' || key == 'O')
                 oKey = set;
       }
