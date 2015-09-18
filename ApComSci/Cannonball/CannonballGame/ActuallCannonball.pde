    class Ball {
      
      private float vx, vy, iv, a, xPos = 0, yPos = 0, interval, time = 0;
      private boolean left;
      public static final float GRAVITY = 9.81;
    
      /**
       * Initializes cannonball
       * @param velocity - Initial velocity of cannonball
       * @param alpha - anglee in degrees that the cannonball was fired at
       * @param deltaT - Interval between updates using <code>nextIteration()</code>
       */
      public Ball(float velocity, float alpha, float deltaT, int xPos, int yPos, boolean leftFacing){
        this.xPos = xPos;
        this.yPos = yPos;
        left = leftFacing;
        interval = deltaT;
        iv = velocity;
        a = alpha;
        vx = (float)(iv * Math.cos(Math.toRadians(a)));
        vy = (float)(iv * Math.sin(Math.toRadians(a)));
      }
      
      public void nextIteration(){
        if(left)
          xPos = xPos + vx * interval;
        else
          xPos = xPos - vx * interval;
        yPos = yPos - vy * interval;
        vy = vy - GRAVITY * interval;
        time += interval;
        
        if(yPos >= 500)
        {
          yPos =500;
          vx = 0;
        }
      }
      
      public float getX(){
        return xPos;
      }
      
      public float getY(){
        return yPos;
      }
      
      public double getTime(){
        return time;
      }
    }

