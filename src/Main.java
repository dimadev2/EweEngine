import Engine.Geometry.Shapes.Rectangle;
import Engine.Runnable.WorldRunnable;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyWorld1 w = new MyWorld1();

        WorldRunnable wr = new WorldRunnable("WorldRunnable", w, 30);
        //MyGraphic g = new MyGraphic("Graphic", 720, 1080, 30, w);
        SquareAnimation sq = new SquareAnimation((Rectangle) w.ColliderList.get(0).Shape, (Rectangle)w.ColliderList.get(1).Shape);

        sq.thread.join();
        //g.thread.join();
        wr.Thread.join();
    }
}
