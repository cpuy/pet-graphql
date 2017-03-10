package colin.repository;

import org.bonitasoft.engine.api.APIClient;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaseRepository {

    @Autowired
    private APIClient apiClient;

    public ProcessInstance get(long id)  {
        try {
            apiClient.login("install", "install");
            return apiClient.getProcessAPI().getProcessInstance(id);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
}
