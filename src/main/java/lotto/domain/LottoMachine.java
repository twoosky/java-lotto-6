package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final LottoMachine INSTANCE = new LottoMachine();

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        return INSTANCE;
    }

    public List<Lotto> issue(int quantity, LottoIssuePolicy lottoIssuePolicy) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> issueLotto(lottoIssuePolicy))
                .toList();
    }

    private Lotto issueLotto(LottoIssuePolicy lottoIssuePolicy) {
        List<Integer> numbers = lottoIssuePolicy.issue();
        return new Lotto(numbers);
    }
}
