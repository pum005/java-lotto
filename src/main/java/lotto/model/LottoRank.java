package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum LottoRank {
    FIRST(6, 2_000_000_000) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getCountOfMatch() == countOfLottoMatch;
        }
    },
    SECOND(5, 30_000_000) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getCountOfMatch() == countOfLottoMatch && countOfBonusMatch == 1;
        }
    },
    THIRD(5, 1_500_000) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getCountOfMatch() == countOfLottoMatch && countOfBonusMatch == 0;
        }
    },
    FOUR(4, 50_000){
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getCountOfMatch() == countOfLottoMatch;
        }
    },
    FIFTH(3, 5_000) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getCountOfMatch() == countOfLottoMatch;
        }
    },
    MISS(0, 0) {
        public boolean isMatch(long countOfLottoMatch, long countOfBonusMatch) {
            return getCountOfMatch() == countOfLottoMatch;
        }
    };

    private final int countOfMatch;
    private final int prizeMoney;

    LottoRank(int countOfMatch, int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank of(long countOfLottoMatch, long countOfBonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(countOfLottoMatch, countOfBonusMatch) )
                .findFirst()
                .orElse(MISS);
    }

    public static List<Long> calculateCountOfMatches(LottoRanks lottoRanks) {
        return Arrays.stream(values())
                .map(rank -> lottoRanks.getCountOfMatch(rank))
                .collect(Collectors.toList());
    }

    public static long calculatePrizeMoney(List<Long> matchingCount) {
        return Arrays.stream(values())
                .mapToLong(rank -> matchingCount.get(rank.ordinal()) * rank.prizeMoney)
                .sum();
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }


    public abstract boolean isMatch(long countOfLottoMatch, long countOfBonusMatch);
}
