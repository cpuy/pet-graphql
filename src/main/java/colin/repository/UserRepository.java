package colin.repository;


import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private IdentityAPI identityAPI;

    public User get(long id)  {
        try {
            return identityAPI.getUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
