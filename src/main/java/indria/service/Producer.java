package indria.service;

import indria.entity.Event;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private final BlockingQueue sharedQueue;

    public ArrayList<Event> events;

    public Producer(BlockingQueue sharedQueue, ArrayList<Event> events) {
        this.sharedQueue = sharedQueue;
        this.events = events;
    }

    @Override
    public void run() {
        for(Event event : getEvents() ){
            try {
                System.out.println("User: " + event.getComand());
                sharedQueue.put(event);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ArrayList<Event> getEvents() {
        if (events == null)
            events = new ArrayList<>();
        return events;
    }
}
