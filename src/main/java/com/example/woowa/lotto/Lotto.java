package com.example.woowa.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    static int lottoMoney = 0;
    static int amount = 0;
    private final List<Integer> numbers;
    static List<List<Integer>> lottoNumbers = new LinkedList<>();
    static List<Integer> winnerNumber = new LinkedList<>();
    static List<List<Integer>> bonusCheck = new LinkedList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");


        try {
            lottoMoney = scan.nextInt();
            if (lottoMoney % 1000 != 0) {
                throw new Exception("[ERROR]");
            }
            amount = lottoMoney / 1000;
            System.out.println("\n" + amount + "개를 구매 했습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;

        }

        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            System.out.println(numbers);
            lottoNumbers.add(numbers);
        }


        System.out.println("\n당첨 번호를 입력해 주세요.");
        String Number = Console.readLine();


        System.out.println("보너스 번호를 입력해 주세요.");
        int winnerBonus = scan.nextInt();

        for (String splitNum : Number.split(",")) {

            winnerNumber.add(Integer.parseInt(splitNum));

        }

        Collections.sort(winnerNumber);


        for (int i = 0; i < lottoNumbers.size(); i++) {
            int count = 0;
            for (int j = 0; j < lottoNumbers.get(i).size(); j++) {
                if (winnerNumber.get(j).equals(lottoNumbers.get(i).get(j))) {
                    count++;
                }
            }
            if (count == 5) {
                bonusCheck.add(lottoNumbers.get(i));
            }

            if (count >= 3) {
                int value = map.getOrDefault(count, 0);
                map.put(count, value + 1);
            }
        }

        for (int i = 3; i <= 6; i++) {
            map.putIfAbsent(i, 0);

        }


        int count = 0;

        if (map.get(5) >= 1) {
            for (int i = 0; i < bonusCheck.size(); i++) {
                for (int j = 0; j < bonusCheck.get(i).size(); j++) {
                    if (bonusCheck.get(i).get(j).equals(winnerBonus)) {
                        count++;
                    }
                }
            }

        }

        double totalWinnings = (map.get(3) * 5000) + (map.get(4) * 50000) + ((map.get(5) - count) * 1500000) + (count * 30000000) + (map.get(6) * 2000000000);
        double profit = ((totalWinnings - lottoMoney) / lottoMoney) * 100;


        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + map.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + map.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + (map.get(5) - count) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + map.get(6) + "개");
        System.out.println("총 수익률은" + profit + "%입니다.");


    }


}
