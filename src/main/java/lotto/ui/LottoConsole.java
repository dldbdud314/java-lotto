package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.service.LottoMatch.FIVE_MATCHES;
import static lotto.service.LottoMatch.FIVE_MATCHES_PLUS_BONUS;
import static lotto.service.LottoMatch.FOUR_MATCHES;
import static lotto.service.LottoMatch.SIX_MATCHES;
import static lotto.service.LottoMatch.THREE_MATCHES;

import java.util.EnumMap;
import java.util.List;
import lotto.service.LottoMatch;

public class LottoConsole {

    public LottoConsole() {
    }

    public static String userInput() {
        return readLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR]: " + errorMessage);
    }

    public static void printLottoCount(String lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoResult(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printTotalResult(EnumMap<LottoMatch, Integer> statistics, float profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoMatch> lottoMatches = List
                .of(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, FIVE_MATCHES_PLUS_BONUS, SIX_MATCHES);
        for (LottoMatch lottoMatch : lottoMatches) {
            System.out.println(
                    lottoMatch.getNumberMatchCount() + "개 일치 (" + String.format("%,d", lottoMatch.getProfit()) + "원) - " + statistics
                            .get(lottoMatch) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

}
