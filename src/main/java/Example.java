import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.bonitasoft.engine.api.APIClient;
import org.bonitasoft.engine.api.ApiAccessType;
import org.bonitasoft.engine.api.LoginAPI;
import org.bonitasoft.engine.api.TenantAPIAccessor;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.util.APITypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {
    

    @RequestMapping("/")
    User home(APIClient apiClient) throws LoginException, UserNotFoundException {
        apiClient.login("install", "install");
        return apiClient.getIdentityAPI().getUser(1);

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

    static {
        Map<String, String> settings = new HashMap<String, String>();
        settings.put("server.url", "http://localhost:15704");
        settings.put("application.name", "bonita");
        APITypeManager.setAPITypeAndParams(ApiAccessType.HTTP, settings);
    }

    @Bean
    public LoginAPI loginAPI() throws BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException {
        return TenantAPIAccessor.getLoginAPI();
    }

    @Bean
    public APIClient apiClient() throws LoginException {
        return new APIClient();
    }


}