public class Die {
  private int value;
  private boolean lock = false;

  /**
  *Randomly rolls a value between one and six
  *@return the random value between one and six
  */
  public int roll() {
    value = (int)(Math.random() * 6 + 1);
    return value;
  }

  /**
  * Returns most recent value shown
  * @return most recent value
  */
  public int getValue() {
    return value;
  }

  /**
  * Returns graphical image of the faceUpFace
  * @return the image of the face
  */
  public PImage getFace() {
    PImage face = new PImage();

    if (value == 0)
      face = loadImage("blankDie.png");
    else if (!lock) {
      if (value == 1)
        face = loadImage("die_face_1.png"); 
      else if (value == 2)
        face = loadImage("die_face_2.png"); 
      else if (value == 3)
        face = loadImage("die_face_3.png"); 
      else if (value == 4)
        face = loadImage("die_face_4.png"); 
      else if (value == 5)
        face = loadImage("die_face_5.png"); 
      else if (value == 6)
        face = loadImage("die_face_6.png");
    } else {
      if (value == 1)
        face = loadImage("die_face_1_lock.png"); 
      else if (value == 2)
        face = loadImage("die_face_2_lock.png"); 
      else if (value == 3)
        face = loadImage("die_face_3_lock.png"); 
      else if (value == 4)
        face = loadImage("die_face_4_lock.png"); 
      else if (value == 5)
        face = loadImage("die_face_5_lock.png"); 
      else if (value == 6)
        face = loadImage("die_face_6_lock.png");
    }

    return face;
  }
  
  /**
  * Changes the state of the die from locked -> unlocked or unlocked -> locked 
  */
  public void changeLock() {
    if (value !=0)
      lock = !lock;
  }
  
  /**
  * Returns if the die is locked
  * @return true if locked, false if unlocked
  */
  public boolean getLockStatus() {
    return lock;
  }
}
