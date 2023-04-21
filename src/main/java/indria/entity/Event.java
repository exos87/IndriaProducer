package indria.entity;

import indria.utils.Comands;

public class Event {
    Comands comand;
    User user;

    public Event() {
    }

    public Event(Comands comand, User user) {
        this.comand = comand;
        this.user = user;
    }

    public Event(Comands comand) {
        this.comand = comand;
    }

    public Comands getComand() {
        return comand;
    }

    public void setComand(Comands comand) {
        this.comand = comand;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
