import indria.service.Consumer;
import indria.service.Producer;
import indria.utils.PrepareData;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class App {
    public static void main(String[] args)  {

        BlockingQueue sharedQueue = new LinkedBlockingQueue();
        Thread prodThread = new Thread(new Producer(sharedQueue, PrepareData.eventsListZadanie()));
        prodThread.start();

        Thread consThread = new Thread(new Consumer(sharedQueue));
        consThread.start();
    }
}



