package colin.repository;

import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CaseRepository {

    @Autowired
    private ProcessAPI processAPI;

    public ProcessInstance get(long id)  {
        try {
            return processAPI.getProcessInstance(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
