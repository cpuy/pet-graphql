package colin.repository;

import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.process.ProcessInstance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CaseRepository {

    final static Logger logger = LoggerFactory.getLogger(CaseRepository.class);

    @Autowired
    private ProcessAPI processAPI;

    public ProcessInstance get(long id)  {
        try {
            logger.info("Fetching process instance from bonita engine");
            return processAPI.getProcessInstance(id);
        } catch (Exception e) {
            return null;
        }
    }
}
