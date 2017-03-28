package by.epam.tunnel.entity;


import by.epam.tunnel.logic.Traffic;
import org.apache.logging.log4j.Level;

import java.util.concurrent.Semaphore;

import static org.apache.logging.log4j.FormatterLoggerManualExample.logger;

public class Train implements Runnable{
    private boolean isHeadingNorth; //direction
    private int tunnelId;
    private Semaphore sem;

    public Train(boolean isHeadingNorth, Semaphore sem, int tunnelId) {
        this.isHeadingNorth = isHeadingNorth;
        this.sem = sem;
        this.tunnelId = tunnelId;
    }

    public boolean isHeadingNorth() {
        return isHeadingNorth;
    }

    public void setHeadingNorth(boolean headingNorth) {
        isHeadingNorth = headingNorth;
    }

    public Semaphore getSem() {
        return sem;
    }

    public void setSem(Semaphore sem) {
        this.sem = sem;
    }

    public int getTunnelId() {
        return tunnelId;
    }

    public void setTunnelId(int tunnelId) {
        this.tunnelId = tunnelId;
    }

    @Override
    public void run() {
        final int RUN_COUNTER = 100_000; //ticking while train goes
        Traffic traffic = Traffic.INSTANCE;
        String name = Thread.currentThread().getName();

        try {
            System.out.println(name + " has arrived");
            sem.acquire();
            System.out.println(name + " enters the tunnel");
            traffic.setLastTrainHeadsNorth(isHeadingNorth, tunnelId);
            for (int i = 0; i < RUN_COUNTER; i++) {
                if (i % 10_000 == 0 && this.isHeadingNorth) {
                    System.out.println(name + " is going through the tunnel heading North");
                }
                if (i % 10_000 == 0 && !this.isHeadingNorth) {
                    System.out.println(name + " is going through the tunnel heading South");
                }

            }

            traffic.modifyTrafficCounter();
            sem.release();
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Caught interrupted exception.");
        }
    }
}
