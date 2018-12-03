public class Print_ABCABCABC {

    public static void main(String[] args) {
        LetterStatus letterStatus = new LetterStatus("A");

        PrintLetterThread threadA;
        PrintLetterThread threadB;
        PrintLetterThread threadC;

        threadA = new PrintLetterThread("A", "B", letterStatus);
        threadB = new PrintLetterThread("B", "C", letterStatus);
        threadC = new PrintLetterThread("C", "A", letterStatus);

        threadA.start();
        threadB.start();
        threadC.start();
    }

}

// This class describes the current letter value and the number of the letter updates
class LetterStatus {

    private String letter;
    private int updates;
    private int maxUpdates;

    public LetterStatus(String letter) {
        this.updates = 0;
        this.maxUpdates = 9;
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public int getIndex() {
        return updates;
    }

    public int getMaxIndex() {
        return maxUpdates;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setIndex(int updates) {
        this.updates = updates;
    }

}

class PrintLetterThread extends Thread {

    LetterStatus letterStatus;

    private String printLetter;
    private String nextLetter;

    public PrintLetterThread(String printLetter, String nextLetter, LetterStatus letterStatus) {
        this.printLetter = printLetter;
        this.nextLetter = nextLetter;
        this.letterStatus = letterStatus;
    }

    @Override
    public void run() {
        while (letterStatus.getIndex() < letterStatus.getMaxIndex()) {
            synchronized (letterStatus) {
                if (letterStatus.getLetter().equals(printLetter)) {
                    System.out.print(this.printLetter + " ");
                    try {
                        Thread.sleep(250);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    letterStatus.setIndex(letterStatus.getIndex() + 1);
                    letterStatus.setLetter(this.nextLetter);
                    letterStatus.notifyAll();
                } else {
                    try {
                        letterStatus.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

