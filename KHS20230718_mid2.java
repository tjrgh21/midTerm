import java.util.Random;
import java.util.Scanner;

public class KHS20230718_mid2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"가위", "바위", "보"};
        int userMoney = 10000;

        System.out.println("가위바위보 게임을 시작합니다! 현재 잔고: " + userMoney + "원");

        while (userMoney > 0) {
            System.out.println("\n배팅할 금액을 입력하세요 (종료하려면 0 입력): ");
            int betAmount;

            while (true) {
                try {
                    betAmount = Integer.parseInt(scanner.nextLine());
                    if (betAmount < 0) {
                        System.out.println("음수를 입력할 수 없습니다. 다시 입력하세요.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력하세요.");
                }
            }

            if (betAmount == 0) {
                System.out.println("게임을 종료합니다. 최종 잔고: " + userMoney + "원");
                break;
            }

            if (betAmount > userMoney) {
                System.out.println("잔고가 부족합니다. 다시 입력하세요.");
                continue;
            }

            String userChoice;
            int userIndex;
            int computerIndex;
            int result;

            do {
                System.out.println("가위, 바위, 보 중 선택하세요: ");
                userChoice = scanner.nextLine();
                userIndex = getIndex(userChoice);

                if (userIndex == -1) {
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                }
            } while (userIndex == -1);

            computerIndex = random.nextInt(3);

            System.out.println("사용자: " + options[userIndex]);
            System.out.println("컴퓨터: " + options[computerIndex]);

            result = compareChoices(userIndex, computerIndex);

            if (result == 0) {
                System.out.println("무승부입니다! 돈을 돌려받습니다.");
            } else if (result == 1) {
                System.out.println("사용자가 이겼습니다! 배당금을 받습니다.");
                userMoney += betAmount;
            } else {
                System.out.println("컴퓨터가 이겼습니다! 배팅한 금액을 잃습니다.");
                userMoney -= betAmount;
            }

            System.out.println("현재 잔고: " + userMoney + "원");
        }

        if (userMoney == 0) {
            System.out.println("돈이 모두 소진되었습니다. 게임 종료!");
        }

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
