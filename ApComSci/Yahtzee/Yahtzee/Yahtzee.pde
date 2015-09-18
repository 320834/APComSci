//
//By Ishaan Attri and Sai Nakka
//June 2015
//
import ddf.minim.*;
import processing.video.*;

PImage bg, surprisePic;
YahtzeeGUI gui = new YahtzeeGUI();
boolean player1 = true, canPlay = false, currentSide = true, clickedOn = false, replay = false, isPlayingIntro = true, surprise = false;
int rollsLeft = 3, currentScore = 0, currentIndex = 0, csX = 0, csY = 0, turnsLeft = 26;
AudioPlayer roll, music, surpriseMusic;
Minim minim;
Movie intro;

void setup() {
  intro = new Movie(this, "YahtzeeIntro.mp4");
  turnsLeft = 26;
  size(1100, 700);
  bg = loadImage("Yahtzee_GUI.png");
  surprisePic = loadImage("guyfieri.jpg");
  minim = new Minim(this);
  surpriseMusic = minim.loadFile("tunaktun.mp3");
  roll = minim.loadFile("roll.mp3");
  music = minim.loadFile("jazzMusic.mp3");
  music.loop();
  intro.play();
}

void draw() {
  if (isPlayingIntro) {
    image(intro, 0, 0, 1100, 700);
    text("Skip: 'S'", 50, 50);

    if (intro.time() >= intro.duration() || ((key == 's' || key == 'S') && keyPressed))
      isPlayingIntro = false;
  } else if (surprise) {
    surprise();
  } else {
    fill(255);
    background(bg);

    gui.totalScoreDraw();
    gui.drawClickedScore();
    gui.drawIndiScores();
    gui.drawBonus();

    if (turnsLeft <= 0) {
      gui.endGame();
    } else {
      gui.drawHand();
      gui.drawRollsLeft(rollsLeft);
      gui.drawWhoTurn();
    }
  }
}

/**
*  Handles hitbox detection
*/
void mousePressed() {
  if ( (turnsLeft <= 0) && (mouseX >= 486 && mouseX <= 632) && (mouseY >= 612 && mouseY <= 668) ) {    //Restart button
    restart();
  } else if ((mouseX >= 295 && mouseX <= 400) && (mouseY >= 567 && mouseY <= 672))    //Lock Dies
    gui.hand.changeLockDie(0);
  else if ((mouseX >= 400 && mouseX <= 505) && (mouseY >= 567 && mouseY <= 672))
    gui.hand.changeLockDie(1);
  else if ((mouseX >= 505 && mouseX <= 610) && (mouseY >= 567 && mouseY <= 672))
    gui.hand.changeLockDie(2);
  else if ((mouseX >= 610 && mouseX <= 715) && (mouseY >= 567 && mouseY <= 672))
    gui.hand.changeLockDie(3);
  else if ((mouseX >= 715 && mouseX <= 820) && (mouseY >= 567 && mouseY <= 672))
    gui.hand.changeLockDie(4);
  else if ((mouseX >= 849 && mouseX <= 994) && (mouseY >= 555 && mouseY <= 610) && rollsLeft > 0) {  //Roll button
    rollsLeft--;
    gui.hand.roll();
    roll.rewind();
    roll.play();
    clickedOn = false;
  } else if ((mouseX >= 849 && mouseX <= 994) && (mouseY >= 628 && mouseY <= 685) && canPlay) {    //Play Button
    if (player1)
      gui.player1S.enterScore(currentScore, currentSide, currentIndex);
    else
      gui.player2S.enterScore(currentScore, currentSide, currentIndex);

    clickedOn = false;
    canPlay = false;
    player1 = !player1;
    gui.hand = new Hand();
    rollsLeft = 3;
    turnsLeft--;
  } else if ((mouseX >= 339 && mouseX <= 507) ) {    //UpperSection
    int x = 0;

    if (mouseY >= 158 && mouseY <= 198)
      x = 0;
    else if (mouseY >= 213 && mouseY <= 254)
      x = 1;
    else if (mouseY >= 269 && mouseY <= 310)
      x = 2;
    else if (mouseY >= 325 && mouseY <= 365)
      x = 3;
    else if (mouseY >= 377 && mouseY <= 416)
      x = 4;
    else if (mouseY >= 432 && mouseY <= 474)
      x = 5;
    else 
      x = 6;

    if (x < 6)
      clickScoreFunction(true, x);
  } else if (mouseX >= 760 && mouseX <= 930) {      //Lower Section
    int x = 0;
    if (mouseY >= 158 && mouseY <= 198)
      x = 0;
    else if (mouseY >= 213 && mouseY <= 254)
      x = 1;
    else if (mouseY >= 269 && mouseY <= 310)
      x = 2;
    else if (mouseY >= 325 && mouseY <= 365)
      x = 3;
    else if (mouseY >= 377 && mouseY <= 416)
      x = 4;
    else if (mouseY >= 432 && mouseY <= 474)
      x = 5;
    else if (mouseY >= 487 && mouseY <= 528)
      x = 6;
    else 
      x = 7;

    if (x < 7)
      clickScoreFunction(false, x);
  } else if ((mouseX >= 0 && mouseX <= 140) && (mouseY >= 0 && mouseY <= 15)) {    //Easter Egg when Author's Names are clicked
    surprise = true;
    surpriseMusic.loop();
  }
}

//Handles clicking on boxes to get a preview of the score
void clickScoreFunction(boolean side, int x) {
  clickedOn = true;
  if (side) {   
    if (player1) {
      if (gui.player1S.upperScores[x] == null) {
        currentScore = gui.player1S.upperCount(x+1, gui.hand);
        updateInstanceFieldsFunction(x, side, 348, 189 + (x * 56));
      }
    } else {
      if (gui.player2S.upperScores[x] == null) {
        currentScore = gui.player2S.upperCount(x+1, gui.hand);
        updateInstanceFieldsFunction(x, side, 476, 189 + (x * 56));
      }
    }
  } else {
    if (x == 0) {
      if (player1) {
        if (gui.player1S.lowerScores[x] == null) {
          currentScore = gui.player1S.ofKind(3, gui.hand);
          updateInstanceFieldsFunction(x, side, 770, 189 + (x * 56));
        }
      } else {
        if (gui.player2S.lowerScores[x] == null) {
          currentScore = gui.player2S.ofKind(3, gui.hand);
          updateInstanceFieldsFunction(x, side, 900, 189 + (x * 56));
        }
      }
    } else if (x == 1) {
      if (player1) {
        if (gui.player1S.lowerScores[x] == null) {
          currentScore = gui.player1S.ofKind(4, gui.hand);
          updateInstanceFieldsFunction(x, side, 770, 189 + (x * 56));
        }
      } else {
        if (gui.player2S.lowerScores[x] == null) {
          currentScore = gui.player2S.ofKind(4, gui.hand);
          updateInstanceFieldsFunction(x, side, 900, 189 + (x * 56));
        }
      }
    } else if (x == 2) {
      if (player1) {
        if (gui.player1S.lowerScores[x] == null) {
          currentScore = gui.player1S.fullHouse(gui.hand);
          updateInstanceFieldsFunction(x, side, 770, 189 + (x * 56));
        }
      } else {
        if (gui.player2S.lowerScores[x] == null) {
          currentScore = gui.player2S.fullHouse(gui.hand);
          updateInstanceFieldsFunction(x, side, 900, 189 + (x * 56));
        }
      }
    } else if (x == 3) {
      if (player1) {
        if (gui.player1S.lowerScores[x] == null) {
          currentScore = gui.player1S.smallStraight(gui.hand);
          updateInstanceFieldsFunction(x, side, 770, 189 + (x * 56));
        }
      } else {
        if (gui.player2S.lowerScores[x] == null) {
          currentScore = gui.player2S.smallStraight(gui.hand);
          updateInstanceFieldsFunction(x, side, 900, 189 + (x * 56));
        }
      }
    } else if (x == 4) {
      if (player1) {
        if (gui.player1S.lowerScores[x] == null) {
          currentScore = gui.player1S.largeStraight(gui.hand);
          updateInstanceFieldsFunction(x, side, 770, 189 + (x * 56));
        }
      } else {
        if (gui.player2S.lowerScores[x] == null) {
          currentScore = gui.player2S.largeStraight(gui.hand);
          updateInstanceFieldsFunction(x, side, 900, 189 + (x * 56));
        }
      }
    } else if (x == 5) {
      if (player1) {
        if (gui.player1S.lowerScores[x] == null) {
          currentScore = gui.player1S.ofKind(5, gui.hand);
          updateInstanceFieldsFunction(x, side, 770, 189 + (x * 56));
        }
      } else {
        if (gui.player2S.lowerScores[x] == null) {
          currentScore = gui.player2S.ofKind(5, gui.hand);
          updateInstanceFieldsFunction(x, side, 900, 189 + (x * 56));
        }
      }
    } else if (x == 6) {
      if (player1) {
        if (gui.player1S.lowerScores[x] == null) {
          currentScore = gui.player1S.chance(gui.hand);
          updateInstanceFieldsFunction(x, side, 770, 189 + (x * 56));
        }
      } else {
        if (gui.player2S.lowerScores[x] == null) {
          currentScore = gui.player2S.chance(gui.hand);
          updateInstanceFieldsFunction(x, side, 900, 189 + (x * 56));
        }
      }
    }
  }
}

//Updates temporary values that are used to print the preview for clicked on boxes
void updateInstanceFieldsFunction(int x, boolean side, int csx, int csy) {
  canPlay = true;
  currentIndex = x;
  currentSide = side;
  csX = csx;
  csY = csy;
}

void movieEvent(Movie m) {
  m.read();
}

//Easter Egg for when Author's Names are clicked
void surprise() {
  music.close();
  image(surprisePic, 0, 0, 1100, 700);
  fill(255, 0, 125);
  textSize(60);
  text("WELCOME TO FLAVORTOWN", 100, 100);
}

//Resets everything to start a new game
void restart() {
  turnsLeft = 26;
  gui = new YahtzeeGUI();
  player1 = true;
  canPlay = false;
  currentSide = true;
  clickedOn = false;
  replay = false;
  rollsLeft = 3;
  currentScore = 0;
  currentIndex = 0;
  csX = 0;
  csY = 0;
}
