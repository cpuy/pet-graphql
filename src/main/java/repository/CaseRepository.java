package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import domain.Case;
import org.springframework.stereotype.Component;

@Component
public class CaseRepository {

    private Map<UUID, Case> store = new HashMap<>();

    public Case create(Case aCase) {
        aCase.setId(UUID.randomUUID());
        store.put(aCase.getId(), aCase);
        return aCase;
    }

    public Case get(UUID uuid) {
        return store.get(uuid);
    }
}
