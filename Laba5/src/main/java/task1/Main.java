package task1;

import task1.shower.Shower;
import task1.shower.ShowerVisitor;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ShowerVisitor showerVisitor = new ShowerVisitor(new Shower(5));

        int i =0;
        while (i<10)
        {
            Thread.sleep(new Random().nextInt(2000) + 1000);
            new Thread(showerVisitor).start();
            i++;
        }
    }
}
