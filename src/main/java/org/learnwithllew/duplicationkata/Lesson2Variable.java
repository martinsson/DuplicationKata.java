package org.learnwithllew.duplicationkata;

public class Lesson2Variable extends Song
{

  private int nbBottles;

  public void singBottlesOfBeer()
  {
    nbBottles = 100;
    singCouplet();
    singCouplet();
  }

  private void singCouplet() {
    sing(nbBottles + " bottles of beer on the wall");
    sing(nbBottles + " bottles of beer");
    sing("Take one down, pass it around");
    nbBottles--;
    sing(nbBottles + " bottles of beer on the wall");
  }
}
