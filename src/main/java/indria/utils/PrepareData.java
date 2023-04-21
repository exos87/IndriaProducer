package indria.utils;

import indria.entity.Event;
import indria.entity.User;

import java.util.ArrayList;

public class PrepareData {

    public static ArrayList<Event> eventsListZadanie(){
        ArrayList<Event> eventsList =  new ArrayList<Event>();
        eventsList.add(new Event(Comands.ADD,new User(1, "a1", "Robert")));
        eventsList.add(new Event(Comands.ADD,new User(2, "a2", "Martin")));
        eventsList.add(new Event(Comands.PRINT_ALL));
        eventsList.add(new Event(Comands.DELETE_ALL));
        eventsList.add(new Event(Comands.PRINT_ALL));
        return eventsList;
    }


}
