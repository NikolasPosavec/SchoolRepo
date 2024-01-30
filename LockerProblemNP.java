public class LockerProblemNP {
    public static void main(String[] args) {
        
        boolean[] lockers = new boolean[1001];

        for (int student = 1; student <= 1000; student++) {
            for (int locker = student; locker <= 1000; locker += student) {
                lockers[locker] = !lockers[locker];
            }
        }

        System.out.println("Open lockers: ");
        for (int i = 1; i <= 1000; i++) {
            if (lockers[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
