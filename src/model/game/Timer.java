package model.game;

import controller.Game;

public class Timer extends Thread {

    private int time;

    public Timer(int difficulte) {
        if (difficulte == Game.DIFFICULTE_FACILE) {
            this.time = 300;
        } else if (difficulte == Game.DIFFICULTE_NORMALE) {
            this.time = 200;
        } else {
            this.time = 100;
        }
    }

    public void run () {
        while (this.time > 0) {
            this.time -= 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addTime (int time) {
        this.time += time;
    }

    public int getTime () {
        return this.time;
    }

}
