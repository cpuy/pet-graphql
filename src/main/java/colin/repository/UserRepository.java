package colin.repository;


import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.identity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    final static Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private IdentityAPI identityAPI;

    public User get(long id)  {
        try {
            logger.info("Fetching user from bonita engine");
            return identityAPI.getUser(id);
        } catch (Exception e) {
            return null;
        }
    }

}
