package indria.service;

import indria.entity.Event;
import indria.utils.Comands;
import org.hibernate.Session;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import indria.entity.User;

public class Consumer implements Runnable{

    private final BlockingQueue sharedQueue;

    public Consumer (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(!sharedQueue.isEmpty()){
            try {
                Event event = (Event) sharedQueue.take();
                System.out.println("Event: "+ event.getComand());
                switch (event.getComand()){

                    case ADD:   HibernateApi.add(event.getUser());
                    break;

                    case DELETE_ALL:    HibernateApi.deleteAll();
                    break;

                    case PRINT_ALL:
                        List<User> users = HibernateApi.printAll(User.class);
                        if (!users.isEmpty()) {
                            users.forEach(s -> System.out.println("Users #" + s.getUserId() + ", " + s.getUserGuid() + ", " + s.getUserName()));
                        }
                        break;

                    default:     Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, "Neznama operacia");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}