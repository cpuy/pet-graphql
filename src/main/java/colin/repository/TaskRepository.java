package colin.repository;


import java.util.List;

import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceCriterion;
import org.bonitasoft.engine.bpm.flownode.ArchivedActivityInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {

    final static Logger logger = LoggerFactory.getLogger(TaskRepository.class);

    @Autowired
    private ProcessAPI processAPI;

    public List<ArchivedActivityInstance> getAllArchived(long caseId) {
        logger.info("Fetching archived activity instances from bonita engine");
        return processAPI.getArchivedActivityInstances(caseId, 0, Integer.MAX_VALUE, ActivityInstanceCriterion.DEFAULT);
    }
}
