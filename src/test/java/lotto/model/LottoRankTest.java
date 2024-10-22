package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @DisplayName("getPrizeMoney 메소드는 당첨 갯수를 받아, 수상금을 반환한다.")
    @Test
    void getPrizeMoney_메소드_테스트() {
        List<Long> matchingCount = List.of(1L, 0L, 1L, 0L, 0L, 0L);

        long expected = LottoRank.calculatePrizeMoney(matchingCount);

        assertThat(expected).isEqualTo(2001500000L);
    }

    @DisplayName("calculateCountOfMatches 메소드는 유저 당첨 정보를 받아, 일치 갯수를 반환한다.")
    @Test
    void calculateCountOfMatches_메소드_테스트() {
        LottoRanks lottoRank = new LottoRanks(List.of(LottoRank.FIRST));

        List<Long> expected = LottoRank.calculateCountOfMatches(lottoRank);

        assertThat(expected).isEqualTo(List.of(1L, 0L, 0L, 0L, 0L, 0L));
    }
}
