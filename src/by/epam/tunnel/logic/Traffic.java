package by.epam.tunnel.logic;

/**
 * Thread-safe singleton
 */
public enum Traffic {
    INSTANCE;
    private int trafficCounter; //total trains passed
    private boolean[] lastTrainHeadsNorth = new boolean[2];

    public void setLastTrainHeadsNorth(boolean isHeadingNorth, int id) {
        this.lastTrainHeadsNorth[id] = isHeadingNorth;
    }

    public boolean getLastTrainHeadsNorth(int id) {
        return lastTrainHeadsNorth[id];
    }

    public int getTrafficCounter() {
        return trafficCounter;
    }

    public void setTrafficCounter(int trafficCounter) {
        this.trafficCounter = trafficCounter;
    }

    public void modifyTrafficCounter () {
        trafficCounter++;
        if (trafficCounter > 1) {
            System.out.println(trafficCounter + " trains passed");
        } else {
            System.out.println(trafficCounter + " train passed");
        }
    }
}
