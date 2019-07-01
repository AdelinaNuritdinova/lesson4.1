import java.util.Random;

public class Main {

    public static int[] health = {700, 250, 250, 250, 250};
    public static int[] hits = {50, 20, 20, 20, 20};
    public static String[] hitTypes = {"Physical", "Physical",
            "Magical", "Mental" , "Medical"};


    public static void main(String[] args) {
        while (!isFinished()) {
            changeBossDefence();
            round();
            printStatistics();
        }
    }

    public static boolean isFinished() {
        if (health[0] <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        if (health[0] <= 0) {
            return true;
        }
        if (health[1] <= 0 && health[2] <= 0 && health[3] <= 0 && health[4] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static void round() {
        for (int i = 1; i <= 4; i++) {
            if (health[0] <= 0) {
                break;
            }
            health[0] = playerHit(i);
        }
        if (health[0] > 0) {
            for (int i = 1; i <= 4; i++) {
                health[i] = bossHit(i);

            if(health[i] > 0 && health[4] > 0 && health[i] != health[4]){
                    health[i] = health[i] + 20;
                }
            }
        }
        }
    public static int playerHit(int playerIndex) {
        Random random = new Random();
        int randomInt = random.nextInt(9) + 2;
        //if("Apple".equals("Orange"))
        if (hitTypes[0].equals(hitTypes[playerIndex])) {
            System.out.println(hitTypes[playerIndex] +
                    " hits " + (hits[playerIndex] * randomInt));
            return health[0] - hits[playerIndex] * randomInt;
        } else {
            return health[0] - hits[playerIndex];
        }
    }

    public static int bossHit(int playerIndex) {
        return health[playerIndex] - hits[0];
    }

    public static void printStatistics() {
        System.out.println("________________________");
        if (health[0] < 0) {
            System.out.println("Boss health: " + 0);
        } else {
            System.out.println("Boss health: " + health[0]);
        }
        System.out.println("Warrior health: " + health[1]);
        System.out.println("Magic health: " + health[2]);
        System.out.println("Kinetic health: " + health[3]);
        System.out.println("Healer health: " + health[4]);
        System.out.println("________________________");
    }

    public static void changeBossDefence(){
        Random random = new Random();
        int randomInt = random.nextInt(4) + 1;
        hitTypes[0] = hitTypes[randomInt];
    }

}

