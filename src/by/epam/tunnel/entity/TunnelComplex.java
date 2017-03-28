package by.epam.tunnel.entity;

import by.epam.tunnel.exception.WrongInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

import static org.apache.logging.log4j.Level.INFO;

public class TunnelComplex {
    private static Logger logger = LogManager.getLogger();
    private Tunnel tunnel1;
    private Tunnel tunnel2;

    public TunnelComplex(ArrayList<Integer> data) throws WrongInputException{
        final int PARAMS = 4;

        //input array test
        for (int i = 0; i < 4; i++) {
            if (data.get(i) < 1) {
                throw new WrongInputException();
            }
        }

        setTunnel1(data.get(0), data.get(2), 0);
        setTunnel2(data.get(1), data.get(3), 1);
    }

    public void setTunnel1(int capacity, int arriving, int id) {
        this.tunnel1 = new Tunnel(capacity, arriving, id);
    }

    public void setTunnel2(int capacity, int arriving, int id) {
        this.tunnel2 = new Tunnel(capacity, arriving, id);
    }

    public Tunnel getTunnel1() {
        return tunnel1;
    }

    public Tunnel getTunnel2() {
        return tunnel2;
    }

    public void activate () {
        Thread t1 = new Thread (tunnel1, "Tunnel 1");
        Thread t2 = new Thread (tunnel2, "Tunnel 2");
        t1.start();
        t2.start();
        logger.log(INFO, "Tunnel Complex set online.");
    }
}
