class Scoresheet {

  public Integer[] upperScores = {
    null, null, null, null, null, null
  };
  public Integer[] lowerScores = {
    null, null, null, null, null, null, null
  };

  /**
  * Indicates whether there is a bonus
  * @return true if there is a bonus, false otherwise
  */
  public boolean bonus() {
    if (getUpperTotal() >= 63)
      return true;
    else 
      return false;
  }

  /**
  * Gets the totalScore
  * @return totalScore
  */
  public int getTotalScore() {
    int ret = 0;

    ret += getUpperTotal();

    if (bonus())
      ret+=35;

    ret += getLowerTotal();
    return ret;
  }

  /**
  *  Gets the lower total
  *  @return the lowerTotal
  */
  public int getLowerTotal() {
    int ret = 0;

    for (int x = 0; x<lowerScores.length; x++) {
      if (lowerScores[x] == null)
        ret+=0;
      else
        ret+=lowerScores[x];
    }

    return ret;
  }

  /**
  *  Gets the upper total
  *  @return the upper Total
  */
  public int getUpperTotal() {
    int ret = 0;

    for (int x = 0; x<upperScores.length; x++) {
      if (upperScores[x] == null)
        ret+=0;
      else
        ret+=upperScores[x];
    }

    return ret;
  }

  /**
  *  Enters confirmed score into the array
  *  @param score - confirmed score to be inputed
  *  @param side - if side is true then the score goes into upperScores, lowerScores otherwise
  *  @param index - index of where the confirmed score goes
  */
  public void enterScore(int score, boolean side, int index) {
    if (side && upperScores[index] == null)
      upperScores[index] = score;
    else if (!side && lowerScores[index] == null)
      lowerScores[index] = score;
  }

  /**
  *  Returns the preview value for the sections in UpperCount (1 - 6)
  *  @return the hypothetical value
  */
  public int upperCount(int x, Hand h) {
    int sum = 0;
    for (Die d : h.getHand ())
      if (d.getValue() == x)
        sum += x;
    return sum;
  }

  /**
  *  Returns the preview value for the threeOfAkind, fourOfAKind, and Yahtzee
  *  @return the hypothetical value
  */
  public int ofKind(int y, Hand h) {
    int[] numCount = new int[6];
    boolean ofKind = false;

    for (Die d : h.getHand ())
      if (d.getValue() == 0)
        return 0;
      else
        numCount[d.getValue() - 1]++;

    for (int x : numCount)
      if (x >= y)
        ofKind = true;
    if (ofKind && y == 5)
      return 50;

    if (ofKind)
      return chance(h);

    return 0;
  }

  /**
  *  Returns the value if a fullHouse were chosen
  *  @return the hypothetical value
  */
  public int fullHouse(Hand h) {
    int[] numCount = new int[6];
    boolean triple = false, pair = false;
    for (Die d : h.getHand ())
      if (d.getValue() == 0)
        return 0;
      else
        numCount[d.getValue() - 1]++;

    for (int x : numCount) {
      if (x == 3)
        triple = true;
      else if (x == 2)
        pair = true;
    }    

    if (triple && pair)
      return 25;

    return 0;
  }
  
  /**
  *  Returns the value if a chance were chosen
  *  @return the hypothetical value
  */
  public int chance(Hand h) {
    int sum = 0;
    for (Die d : h.getHand ())
      sum += d.getValue();
    return sum;
  }

  /**
  *  Returns the value if a smallStraight were chosen
  *  @return the hypothetical value
  */
  public int smallStraight(Hand h) {
    int[] numCount = new int[6];
    for (Die d : h.getHand ())
      if (d.getValue() == 0)
        return 0;
      else
        numCount[d.getValue() - 1]++;

    if ((numCount[0] >= 1 && numCount[1] >= 1 && numCount[2] >= 1 && numCount[3] >= 1) || (numCount[1] >= 1 && numCount[2] >= 1 && numCount[3] >= 1 && numCount[4] >= 1) || (numCount[2] >= 1 && numCount[3] >= 1 && numCount[4] >= 1 && numCount[5] >= 1))  
      return 30;

    return 0;
  }

  /**
  *  Returns the value if a largeStraight were chosen
  *  @return the hypothetical value
  */
  public int largeStraight(Hand h) {
    int[] numCount = new int[6];
    for (Die d : h.getHand ())
      if (d.getValue() == 0)
        return 0;
      else
        numCount[d.getValue() - 1]++;

    if ((numCount[0] == 1 && numCount[1] == 1 && numCount[2] == 1 && numCount[3] == 1 && numCount[4] == 1) || (numCount[1] == 1 && numCount[2] == 1 && numCount[3] == 1 && numCount[4] == 1 && numCount[5] == 1))  
      return 40;

    return 0;
  }
}
