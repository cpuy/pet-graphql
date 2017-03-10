package colin.repository;


import org.bonitasoft.engine.api.APIClient;
import org.bonitasoft.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private APIClient apiClient;

    public User get(long id)  {
        try {
            apiClient.login("install", "install");
            return apiClient.getIdentityAPI().getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
