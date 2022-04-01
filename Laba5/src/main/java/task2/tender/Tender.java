package task2.tender;

import task2.ask.Ask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Tender {
    
    private ArrayList<Ask> asks;
    private CyclicBarrier barrier;
    public final int ASKS_NUMBER = 5;

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public Tender() {
        asks = new ArrayList<>();
        barrier = new CyclicBarrier(ASKS_NUMBER, new Runnable() {
            @Override
            public void run() {
                Ask winner = defineWinner();
                System.out.println("Seller #" + winner.getIdAsk() + " won, cost: " + winner.getPrice());
            }
        });
    }
    public Ask defineWinner() {
        return Collections.min(asks, new Comparator<Ask>() {
            @Override
            public int compare(Ask o1, Ask o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
    public void addAsk(Ask ask) {
        asks.add(ask);
    }
}
