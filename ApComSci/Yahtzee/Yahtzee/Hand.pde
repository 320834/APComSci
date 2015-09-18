class Hand {
  private Die[] hand= {
    new Die(), new Die(), new Die(), new Die(), new Die()
    };

  /**
  *  Returns the hand 
  *  @return the hand of five diece
  */
  public Die[] getHand() {
    return hand;
  }

  /**
  * Rolls all the unlocked dice
  */
  public void roll() {
    for (Die d : hand)
      if (!d.getLockStatus())
        d.roll();
  }

  /**
  * unlocks or locks the indicated dice
  * @param - index of the die (indices from 0 - 4)
  */
  public void changeLockDie(int die) {
    hand[die].changeLock();
  }
}

