package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoRanks {
    private final List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public long getCountOfMatch(LottoRank rank) {
        return this.lottoRanks.stream()
                .filter(rank::equals)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoRanks)) return false;
        LottoRanks that = (LottoRanks) o;
        return Objects.equals(lottoRanks, that.lottoRanks);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoRanks);
    }
}
