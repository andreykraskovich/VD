public class MyThread implements Runnable{

    private final int count;

    public MyThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            synchronized (Main.FILE) {
                Main.FILE.notifyAll();
                int intFromFile = IO.readInt(Main.FILE);
                int newInt = intFromFile + 1;
                IO.writeInt(Main.FILE, newInt);
                System.out.printf("Поток: %s, старое значение: %d, новое значение: %d\n", Thread.currentThread().getName(), intFromFile, newInt);
                try {
                    Main.FILE.wait(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
