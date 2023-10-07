package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Ctrl+Alt+L = 자동코드 정리

enum Prize {
    ZERO(0), ONE(0), TWO(0), THREE(5000), FOUR(50_000), FIVE(1_500_000), SIX(
        2_000_000_000), FIVE_AND_BONUS(
        30_000_000);

    private final int lottoPrizeValue;

    Prize(int lottoPrizeValue) {
        this.lottoPrizeValue = lottoPrizeValue;
    }

    public int getValue() {
        return lottoPrizeValue;
    }
}

public class Lotto {

    public static final Lotto INSTANCE = new Lotto(); // 로또 클래스는 싱글턴임을 보장한다.



    int[] lottoPrize = new int[Prize.values().length]; // 초기값은 0 , Prize 의 개수만큼 배열크기를 유연하게 할당한다.
    List<List<Integer>> lottery = new ArrayList<>(); // 구매한 로또
    List<Integer> selectNumber = new ArrayList<>(); // 선택번호
    int money; // 구매금액
    int bonusNumber; // 보너스번호

}

class Validate {

    public void lotteryNumberSize(List<Integer> selectNumber) {
        if (selectNumber.size() != 6) {
            System.out.println("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void lotteryNumberValue(List<Integer> selectNumber, int bonusNumber) {
        for (Integer integer : selectNumber) {
            if (integer < 0 || integer > 45 || bonusNumber < 0 || bonusNumber > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }

    }

    public void moneyValue(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 금액은 천원 단위이어야 합니다.");
            throw new IllegalArgumentException();
        }
        System.out.printf("%d개를 구매했습니다.\n", money / 1000);
    }
}

class Compare {

    int correctNumberCount;

    public void Number(Lotto lotto) {
        for (List<Integer> eachLotto : lotto.lottery) {
            checkNumber(lotto.selectNumber, eachLotto, lotto.bonusNumber, lotto.lottoPrize);
        }
    }

    private boolean correctFiveAndBonus(int bonusNumber,
        List<Integer> eachLotto) {
        return correctNumberCount == 5 && eachLotto.contains(bonusNumber);
    }

    private void checkNumber(List<Integer> selectNumber, List<Integer> eachLotto, int bonusNumber,
        int[] lottoPrize) {

        correctNumberCount = (int) eachLotto.stream().filter(selectNumber::contains).count();

        if (correctFiveAndBonus(bonusNumber, eachLotto)) {
            lottoPrize[Prize.FIVE_AND_BONUS.ordinal()]++;
            return;
        }
        lottoPrize[correctNumberCount]++;
    }
}

class Extract {
    public void LottoNumbers(Lotto lotto) {
        for (int i = 0; i < lotto.money / 1000; i++) {
            lotto.lottery.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }
}

class Profit {

    float rate = 0; // 수익률

    public void getProfitRate(int[] lottoPrize, int money) {
        for (int i = 0; i < lottoPrize.length; i++) {
            int finalI = i;
            rate += lottoPrize[i] * Arrays.stream(Prize.values())
                .filter(prize -> prize.ordinal() == finalI).collect(Collectors.toList()).get(0)
                .getValue();
            // public getter 를 사용할 수 없으므로 인덱스값을 직접 구해서 enum 변수의 값을 찾는다.
        }

        rate /= money;
        rate *= 100;
    }

}


class InputView {

    public void Money(Lotto lotto) {
        System.out.println("구입금액을 입력해 주세요.");
        lotto.money = Integer.parseInt(Console.readLine()); // 금액 입력
    }

    public void LotteryNumbers(Lotto lotto) {
        System.out.println("당첨 번호를 입력해 주세요.");
        lotto.selectNumber.addAll(
            Arrays.stream(Console.readLine().split(",")).map(Integer::parseInt).collect(
                Collectors.toList()));
    }

    public void BonusNumber(Lotto lotto) {
        System.out.println("보너스 번호를 입력해 주세요.");
        lotto.bonusNumber = (Integer.parseInt(Console.readLine()));
    }
}

class OutputView {

    public void lottery(List<List<Integer>> lottery) {
        for (List<Integer> lotto : lottery) {
            System.out.println(lotto);
        }
    }

    public void result(int[] lottoPrize, float rate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoPrize[Prize.THREE.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoPrize[Prize.FOUR.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoPrize[Prize.FIVE.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            lottoPrize[Prize.FIVE_AND_BONUS.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoPrize[Prize.SIX.ordinal()]);
        System.out.printf("총 수익률은 %.1f", rate);
        System.out.print("%입니다.");

    }
}