class SimpleDotComGame {
    public static void main (String[] args) {
        int guesses = 0;
        SimpleDotCom dot = new SimpleDotCom();
        int start = (int) (Math.random() * 5);
        int[] locations = {start, start+1, start+2};
        dot.setLocationCells(locations);
        boolean isAlive = true;
        GameHelper helper = new GameHelper();

        while (isAlive == true) {
            // get from stdin
            String guess = helper.getUserInput("Enter a number");
            String result = dot.checkYourself(guess);
            guesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("Number of guesses: " + guesses);
            }
        }
    }
}
