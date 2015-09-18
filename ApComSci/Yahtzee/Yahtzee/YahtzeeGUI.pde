class YahtzeeGUI {

  public Scoresheet player1S, player2S;
  public Hand hand;

  public YahtzeeGUI() {
    player1S = new Scoresheet();
    player2S = new Scoresheet();
    hand = new Hand();
  }

  /**
  * Draws in the bonus if it is applicable
  */
  public void drawBonus() {
    fill(0, 255, 0);

    if (player1S.bonus()) {
      textSize(32);
      text("35", 340, 520);
    } else {
      textSize(40);
      text("0", 347, 522);
    }

    if (player2S.bonus()) {
      textSize(32);
      text("35", 468, 520);
    } else {
      textSize(40);
      text("0", 474, 522);
    }
  }
 
  /**
  * Draws in the dice of the hand
  */
  public void drawHand() {
    int count = 0;
    for (Die x : hand.getHand ()) {
      image(x.getFace(), 295 + (count*105), 567, 105, 105);
      count++;
    }
  }

  /**
  * Determines who won and displays winner + enables restart
  */
  public void endGame() {
    PImage msg = new PImage();

    if (player1S.getTotalScore() > player2S.getTotalScore())
      msg = loadImage("endMessageP1Win.png");
    else if (player2S.getTotalScore() > player1S.getTotalScore())
      msg = loadImage("endMessageP2Win.png");
    else
      msg = loadImage("endMessageTie.png");

    image(msg, 295, 567, 525, 105);
  }

  /**
  * Indicates whose turn it is
  */
  public void drawWhoTurn() {
    textSize(40);
    fill(255, 255, 0);
    if (player1) {
      text("P1 Turn", 850, 75);
    } else {
      text("P2 Turn", 850, 75);
    }
  }

  /**
  * Draws in the preview when someone clicks the boxes
  */
  public void drawClickedScore() {
    fill(255, 255, 0);
    int temp = 0;
    if (!player1)
      temp = 127;
    else temp = 0;

    if (canPlay && clickedOn) {

      if (currentSide) {
        if (currentScore < 10) {
          textSize(40);
          text(currentScore, 347 + temp, 191 + (currentIndex* 56));
        } else {
          textSize(32);
          text(currentScore, 340 + temp, 191 + (currentIndex* 56));
        }
      } else {
        if (currentScore < 10) {
          textSize(40);
          text(currentScore, 767 + temp, 190 + (currentIndex* 56));
        } else {
          textSize(32);
          text(currentScore, 761 + temp, 190 + (currentIndex* 56));
        }
      }
    }
  }
  
  /**
  * Draws in the scores that have been played/confirmed
  */
  public void drawIndiScores() {
    fill(255);
    int count = 0;

    for (Integer x : player1S.upperScores) {
      if (x != null) {
        if (x < 10) {
          textSize(40);
          text(x, 347, 191 + (count* 56));
        } else {
          textSize(32);
          text(x, 340, 191 + (count* 56));
        }
      }
      count++;
    }

    count = 0;
    for (Integer x : player1S.lowerScores) {
      if (x != null) {
        if (x < 10) {
          textSize(40);
          text(x, 767, 190 + (count* 56));
        } else {
          textSize(32);
          text(x, 761, 190 + (count* 56));
        }
      }
      count++;
    }

    count = 0;
    for (Integer x : player2S.upperScores) {
      if (x != null) {
        if (x < 10) {
          textSize(40);
          text(x, 474, 191 + (count* 56));
        } else {
          textSize(32);
          text(x, 467, 191 + (count* 56));
        }
      }
      count++;
    }

    count = 0;
    for (Integer x : player2S.lowerScores) {
      if (x != null) {
        if (x < 10) {
          textSize(40);
          text(x, 895, 190 + (count* 56));
        } else {
          textSize(32);
          text(x, 888, 190 + (count* 56));
        }
      }
      count++;
    }
  }

  /**
  * Draws in the total score and the scores on the left hand side of the screen; upper section subtotal and total, and lower section
  */
  public void totalScoreDraw() {
    fill(0, 255, 0);
    
    if (player1S.getTotalScore() > 99) {
      textSize(30);
      text(player1S.getTotalScore(), 558, 60);
    } else if (player1S.getTotalScore() > 9) {
      textSize(40);
      text(player1S.getTotalScore(), 562, 63);
    } else {
      textSize(50);
      text(player1S.getTotalScore(), 570, 67);
    }

    if (player2S.getTotalScore() > 99) {
      textSize(30);
      text(player2S.getTotalScore(), 638, 60);
    } else if (player2S.getTotalScore() > 9) {
      textSize(40);
      text(player2S.getTotalScore(), 642, 63);
    } else {
      textSize(50);
      text(player2S.getTotalScore(), 650, 67);
    }

    if (player1S.getUpperTotal() > 99) {
      textSize(20);
      text(player1S.getUpperTotal(), 55, 232);
    } else if (player1S.getUpperTotal() > 9) {
      textSize(30);
      text(player1S.getUpperTotal(), 55, 235);
    } else {
      textSize(40);
      text(player1S.getUpperTotal(), 61, 238);
    }

    if (player2S.getUpperTotal() > 99) {
      textSize(20);
      text(player2S.getUpperTotal(), 120, 232);
    } else if (player2S.getUpperTotal() > 9) {
      textSize(30);
      text(player2S.getUpperTotal(), 120, 235);
    } else {
      textSize(40);
      text(player2S.getUpperTotal(), 126, 238);
    }

    int temp = 0;
    if(player1S.bonus())
      temp = 35;
    
    if (player1S.getUpperTotal() + temp > 99) {
      textSize(20);
      text(player1S.getUpperTotal() + temp, 55, 324);
    } else if (player1S.getUpperTotal() + temp > 9) {
      textSize(30);
      text(player1S.getUpperTotal() + temp, 55, 327);
    } else {
      textSize(40);
      text(player1S.getUpperTotal() + temp, 61, 330);
    }
    
    temp = 0;
    if(player2S.bonus())
      temp = 35;
      
    if (player2S.getUpperTotal() + temp > 99) {
      textSize(20);
      text(player2S.getUpperTotal() + temp, 120, 324);
    } else if (player2S.getUpperTotal() + temp > 9) {
      textSize(30);
      text(player2S.getUpperTotal() + temp, 120, 327);
    } else {
      textSize(40);
      text(player2S.getUpperTotal() + temp, 126, 330);
    }

    if (player1S.getLowerTotal() > 99) {
      textSize(20);
      text(player1S.getLowerTotal(), 55, 457);
    } else if (player1S.getLowerTotal() > 9) {
      textSize(30);
      text(player1S.getLowerTotal(), 55, 460);
    } else {
      textSize(40);
      text(player1S.getLowerTotal(), 61, 463);
    }

    if (player2S.getLowerTotal() > 99) {
      textSize(20);
      text(player2S.getLowerTotal(), 120, 457);
    } else if (player2S.getLowerTotal() > 9) {
      textSize(30);
      text(player2S.getLowerTotal(), 120, 460);
    } else {
      textSize(40);
      text(player2S.getLowerTotal(), 126, 463);
    }
  }

  /**
  * Draws in the the numbers of rolls left
  */
  public void drawRollsLeft(int x) {
    fill(0, 255, 0);
    textSize(40);
    text(x, 234, 631);
  }
}

