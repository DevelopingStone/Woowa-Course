package lotto;

public class Application {

    public static void main(String[] args) {
        Lotto lotto = Lotto.INSTANCE; // 로또는 싱글턴임을 보장한다.

        InputView input = new InputView();
        Validate validate = new Validate();
        Extract extract = new Extract();
        OutputView output = new OutputView();
        Compare compare = new Compare();
        Profit profit = new Profit();


        input.Money(lotto); validate.moneyValue(lotto.money);
        extract.LottoNumbers(lotto);
        output.lottery(lotto.lottery);
        input.LotteryNumbers(lotto);
        validate.lotteryNumberSize(lotto.selectNumber);
        input.BonusNumber(lotto);
        validate.lotteryNumberValue(lotto.selectNumber , lotto.bonusNumber);
        compare.Number(lotto);
        profit.getProfitRate(lotto.lottoPrize, lotto.money);
        output.result(lotto.lottoPrize , profit.rate);
    }
}

/** 로또 진행 과정
 * 1. 돈을 입력받는다.
 * 2. 돈의 값을 검사한다.
 * 3. 복권를 구매하고 번호를 추첨한다.
 * 4. 추첨된 복권을 출력한다.
 * 5. 당첨번호를 입력한다.
 * 6. 당첨번호의 개수를 검사한다.
 * 7. 보너스 번호를 입력한다.
 * 8. 당첨번호와 보너스 번호의 범위를 검사한다.
 * 9. 복권과 당첨번호를 비교한다.
 * 10. 수익률을 계산한다.
 * 11. 결과를 출력한다.
 *
 */