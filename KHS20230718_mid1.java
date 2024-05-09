import java.util.Random;
import java.util.Scanner;

public class KHS20230718_mid1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"가위", "바위", "보"};

        System.out.println("가위바위보 게임을 시작합니다!");
        System.out.println("가위, 바위, 보 중 하나를 선택하세요.");

        String userChoice;
        int userIndex;
        int computerIndex;
        int result = 0;

        do {
            userChoice = scanner.nextLine();
            userIndex = getIndex(userChoice);

            if (userIndex == -1) {
                System.out.println("잘못된 선택입니다. 가위, 바위, 보 중에서 선택하세요.");
                continue;
            }

            computerIndex = random.nextInt(3);

            System.out.println("사용자: " + options[userIndex]);
            System.out.println("컴퓨터: " + options[computerIndex]);

            result = compareChoices(userIndex, computerIndex);

            if (result == 0) {
                System.out.println("무승부입니다! 다시 선택하세요.");
            } else if (result == 1) {
                System.out.println("사용자가 이겼습니다!");
            } else {
                System.out.println("컴퓨터가 이겼습니다!");
            }
        } while (result == 0);

        scanner.close();
    }

    private static int compareChoices(int userIndex, int computerIndex) {
        if ((userIndex == 0 && computerIndex == 2) ||
            (userIndex == 1 && computerIndex == 0) ||
            (userIndex == 2 && computerIndex == 1)) {
            return 1;
        } else if ((computerIndex == 0 && userIndex == 2) ||
                   (computerIndex == 1 && userIndex == 0) ||
                   (computerIndex == 2 && userIndex == 1)) {
            return -1;
        } else {
            return 0;
        }
    }

    private static int getIndex(String choice) {
        switch (choice) {
            case "가위":
                return 0;
            case "바위":
                return 1;
            case "보":
                return 2;
            default:
                return -1;
        }
    }
}
