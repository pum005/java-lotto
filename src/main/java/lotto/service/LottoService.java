package lotto.service;

import lotto.model.*;
import lotto.strategy.NumberGenerateStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {

    private final NumberGenerateStrategy numberGenerateStrategy;

    public LottoService(NumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public Lottos generateLottos(Price price) {
        return price.generateLottos(numberGenerateStrategy);
    }

    public Statistics generateStatistics(Lottos lottos, WinningLotto winningLotto, Price price) {

        LottoRanks lottoRanks = lottos.match(winningLotto);

        List<Long> matchingCounts = LottoRank.calculateCountOfMatches(lottoRanks);

        long prizeMoney = LottoRank.calculatePrizeMoney(matchingCounts);

        double rateOfProfit = price.calculateRateOfProfit(prizeMoney);

        List<Long> normalizedMatchingCount = matchingCounts.stream()
                .sorted(Comparator.reverseOrder())
                .limit(matchingCounts.size() - 1)
                .collect(Collectors.toList());

        return new Statistics(normalizedMatchingCount, rateOfProfit);
    }

}
