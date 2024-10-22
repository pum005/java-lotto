package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 생성자_테스트() {
        Lottos lottos = new Lottos(List.of(new Lotto(1,2,3,4,5,6), new Lotto(1,2,3,4,5,6)));

        assertThat(lottos).isEqualTo(new Lottos(List.of(new Lotto(1,2,3,4,5,6), new Lotto(1,2,3,4,5,6))));
    }

    @DisplayName("match 메소드는 유저의 로또와 당첨 로또를 비교해, 입력 갯수만큼 일치하는 로또의 갯수를 반환한다.")
    @Test
    void match_메소드_테스트() {
        Lottos userLottos = new Lottos(List.of(new Lotto(1,2,3,4,5,6), new Lotto(1,2,3,4,5,7), new Lotto(1,2,3,4,5,8)));
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);

        LottoRanks expected = userLottos.match(winningLotto);

        assertThat(expected).isEqualTo(new LottoRanks(List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD)));
    }
}
