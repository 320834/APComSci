      class Tank{
        int r, g, b, x, lB, rB;
        public Tank(int red, int green, int blue, int pos, int leftBound, int rightBound){
          r = red;
          g = green;
          b = blue;
          x = pos;
          lB = leftBound;
          rB = rightBound;
        } 
        
        public void drawTank(){
          fill(r, g, b);
          rect(x, 475, 75, 25);
        }
        
        public void move(boolean forward){
          if(forward){
              if(x + 76 <= rB)
                x++;
          }
          else{
            
            if(x - 1 >= lB)
            x--;
          }
        }
      }

