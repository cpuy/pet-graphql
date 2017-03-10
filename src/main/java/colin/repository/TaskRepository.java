package colin.repository;


import java.util.List;

import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceCriterion;
import org.bonitasoft.engine.bpm.flownode.ArchivedActivityInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {

    @Autowired
    private ProcessAPI processAPI;

    public List<ArchivedActivityInstance> getAllArchived(long caseId) {
        return processAPI.getArchivedActivityInstances(caseId, 0, Integer.MAX_VALUE, ActivityInstanceCriterion.DEFAULT);
    }
}
