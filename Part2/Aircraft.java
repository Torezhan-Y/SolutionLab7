package Part2;

public abstract class Aircraft {
    protected String id;

    public abstract void receive(String msg);

    public void send(String msg, TowerMediator m) {
        m.broadcast(msg, this);
    }
}

