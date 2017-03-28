package by.epam.tunnel.entity;

import by.epam.tunnel.logic.Traffic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

import static org.apache.logging.log4j.Level.INFO;

public class Tunnel implements Runnable {
    private static Logger logger = LogManager.getLogger();
    private int capacity; //maximum trains passing through
    private int arriving; //number of trains arriving
    private int id; //tunnel id

    public Tunnel(int capacity, int arriving, int id) {
        this.setCapacity(capacity);
        this.setArriving(arriving);
        this.setId(id);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getArriving() {
        return arriving;
    }

    public void setArriving(int arriving) {
        this.arriving = arriving;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run () {
        Traffic traffic = Traffic.INSTANCE;
        Semaphore sem = new Semaphore(capacity, false);
        Thread[] t = new Thread[arriving];

        //trains arrive
        for (int i = 0; i < arriving; i++) {
            boolean northCourse = Math.random() < 0.5;
            boolean lastTrainCourse = traffic.getLastTrainHeadsNorth(id);
            String name = "Train " + id + "-" + i;

            t[i] = new Thread(new Train(northCourse, sem, id), name);

            //same direction priority switch
            if (northCourse = lastTrainCourse) {
                t[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                t[i].setPriority(Thread.MIN_PRIORITY);
            }

            t[i].start();
        }
        logger.log(INFO, id + " tunnel train initialization complete.");
    }
}
