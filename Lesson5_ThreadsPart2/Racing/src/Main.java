import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Distance distance = new Distance(3000, 2000, 4000, 2);
        final int CARS_COUNT = 5;

        final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        final Semaphore semaphore = new Semaphore(distance.getCarsInTunnel());

        for (int i = 0; i < CARS_COUNT; i++) {
            new Car(i,countDownLatch,semaphore,distance);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Distance {

    private int s1; // distance before tunnel in km
    private int sT; // distance in the tunnel in km
    private int s2; // distance after tunnel in km
    private boolean winner;
    private int carsInTunnel;

    public Distance(int s1, int sT, int s2, int carsInTunnel) {
        this.s1 = s1;
        this.sT = sT;
        this.s2 = s2;
        this.carsInTunnel = carsInTunnel;
        this.winner = false;
    }

    public int get_s1() {
        return s1;
    }

    public int get_sT() {
        return sT;
    }

    public int get_S2() {
        return s2;
    }

    public int getCarsInTunnel() {
        return carsInTunnel;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner() {
        this.winner = true;
    }
}

class Car extends Thread {

    private int id;
    CountDownLatch countDownLatch;
    Semaphore semaphore;
    Thread thread;
    Distance distance;
    int speed;
    int prepareTime;
    Random rand = new Random();

    public Car(int id, CountDownLatch countDownLatch, Semaphore semaphore, Distance distance) {
        this.id = id;
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        this.distance = distance;
        this.speed = 60 + rand.nextInt(30);
        //prepare time in milliseconds
        this.prepareTime = 100 + rand.nextInt(200);
        thread = new Thread(() -> {
            try {
                Thread.sleep(prepareTime);
                countDownLatch.countDown();
                System.out.printf("Car #%d is ready \n", id);
                countDownLatch.await();
                Thread.sleep(distance.get_s1() / speed);
                System.out.printf("Car #%d drove the 1st stage \n", id);
                semaphore.acquire();
                Thread.sleep(distance.get_sT() / speed);
                System.out.printf("Car #%d drove the tunnel \n", id);
                semaphore.release();
                Thread.sleep(distance.get_S2() / speed);
                synchronized (distance) {
                    if (!distance.isWinner()) {
                        System.out.printf("Car #%d is a winner! \n", id);
                        distance.setWinner();
                    } else {
                        System.out.printf("Car #%d finished \n", id);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
