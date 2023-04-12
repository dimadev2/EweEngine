package Engine.Runnable;

import Engine.Core.World;

public class WorldRunnable implements Runnable{
    Engine.Core.World World;
    public Thread Thread;
    private int WaitTime;
    public WorldRunnable(String name, World w, int wt) {
        WaitTime = wt;
        World = w;
        Thread = new Thread(this, name);
        Thread.start();
    }
    public void run() {
        try {
            World.MainLoop(WaitTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
