package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRanksTest {

    @Test
    void create() {
        LottoRanks lottoRanks = new LottoRanks(List.of(LottoRank.FIRST));
        assertThat(lottoRanks).isEqualTo(new LottoRanks(List.of(LottoRank.FIRST)));
    }

    @Test
    void _1등_갯수_찾기() {
        LottoRanks lottoRanks = new LottoRanks(List.of(LottoRank.FIRST, LottoRank.FIRST, LottoRank.FIRST));
        LottoRank wantedRank = LottoRank.FIRST;

        long expected = lottoRanks.getCountOfMatch(wantedRank);

        assertThat(expected).isEqualTo(3);
    }

    @Test
    void _2등_갯수_찾기() {
        LottoRanks lottoRanks = new LottoRanks(List.of(LottoRank.SECOND, LottoRank.FIRST, LottoRank.SECOND));
        LottoRank wantedRank = LottoRank.SECOND;

        long expected = lottoRanks.getCountOfMatch(wantedRank);

        assertThat(expected).isEqualTo(2);
    }
}
