class GuessGame {
  Player p1;
  Player p2;
  Player p3;

  public void startGame() {
    p1 = new Player();
    p2 = new Player();
    p3 = new Player();

    int guess1 = 0;
    int guess2 = 0;
    int guess3 = 0;

    boolean p1isRight = false;
    boolean p2isRight = false;
    boolean p3isRight = false;

    int targetNum = (int) (Math.random() * 10);

    System.out.println("I'm thinking of a number between 0 and 9");

    while(true) {
      System.out.println("Number to guess is " + targetNum);

      p1.guess();
      p2.guess();
      p3.guess();

      guess1 = p1.number; System.out.println("Player 1 guessed " + guess1);
      guess2 = p2.number; System.out.println("Player 2 guessed " + guess2);
      guess3 = p3.number; System.out.println("Player 3 guessed " + guess3);

      if (guess1 == targetNum) {
        p1isRight = true;
      }
      if (guess2 == targetNum) {
        p2isRight = true;
      }
      if (guess3 == targetNum) {
        p3isRight = true;
      }

      if (p1isRight || p2isRight || p3isRight) {
        System.out.println("We have a winner");
        System.out.println("Player 1 got it right? " + p1isRight);
        System.out.println("Player 2 got it right? " + p2isRight);
        System.out.println("Player 3 got it right? " + p3isRight);
        System.out.println("Game over.");
        break;
      }
      else {
        System.out.println("Nobody guessed it. Try again!");
      }
    }
  }
}
