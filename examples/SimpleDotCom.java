public class SimpleDotCom {
    private ArrayList<String> locationCells;
    int numOfHits = 0;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourself (String stringGuess) {
        // Default to miss
        String result = "miss";

        // Check if we hit - if not, index will be -1
        int index = locationCells.indexOf(stringGuess);
        if (index >= 0) {
            // Remove what we hit
            locationCells.remove(index);
            // Check if the hit resulted in a kill
            if (locationCells.isEmpty()) {
                result = "kill";
            }
            else {
                result = "hit";
            }
        }

        System.out.println(result);
        return result;
    }
}
