import java.util.Scanner;
public class BombDefuser {





        private volatile boolean isDefused = false;

        public void startCountdown() {
            Thread countdownThread = new Thread(this::countdown);
            countdownThread.start();
        }

        private void countdown() {
            for (int i = 40; i >= 0; i--) {
                if (isDefused) {
                    System.out.println("Bomb defused!");
                    return;
                }
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Bomb exploded!");
        }

        public void defuse() {
            isDefused = true;
        }

        public static void main(String[] args) {
            BombDefuser bombDefuser = new BombDefuser();
            bombDefuser.startCountdown();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the code:");
            int code = scanner.nextInt();
            if (code == 456) {
                bombDefuser.defuse();
                System.out.println("The bomb has been defused!");
            } else {
                System.out.println("Wrong code!");
                System.out.println("system has been locked ");
            }
        }

}
