package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoRank 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoRankTest {

    @ParameterizedTest
    @MethodSource("provideMatchCountAndMatchBonus")
    void of_정적_팩토리_메소드는_당첨개수와_보너스당첨_여부가_주어지면_해당_LottoRank를_반환한다(int matchCount, boolean matchBonus, LottoRank expect) {
        Assertions.assertEquals(LottoRank.of(matchCount, matchBonus), expect);
    }

    private static Stream<Arguments> provideMatchCountAndMatchBonus() {
        return Stream.of(
                Arguments.of(3, true, LottoRank.FIFTH),
                Arguments.of(4, true, LottoRank.FOURTH),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(6, false, LottoRank.FIRST)
        );
    }


}