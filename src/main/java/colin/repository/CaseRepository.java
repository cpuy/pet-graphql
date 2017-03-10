package colin.repository;

import java.util.HashMap;
import java.util.Map;

import colin.domain.Case;
import org.springframework.stereotype.Component;

@Component
public class CaseRepository {

    private static Map<Long, Case> store = new HashMap<>();

    static {
        store.put(1L, new Case(1, "case 1"));
        store.put(2L, new Case(2, "case 2"));
        store.put(3L, new Case(3, "case 3"));
        store.put(4L, new Case(4, "case 4"));
        store.put(5L, new Case(5, "case 5"));
        store.put(6L, new Case(6, "case 6"));
    }

    public Case get(long id) {
        return store.get(id);
    }
}
