package colin.infra;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.bonitasoft.engine.api.APIClient;
import org.bonitasoft.engine.api.ApiAccessType;
import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.util.APITypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BonitaClientConfig {

    @Autowired
    private APIClient apiClient;

    public BonitaClientConfig(@Value("${bonita.server.url}") String url) {
        Map<String, String> settings = new HashMap<>();
        settings.put("server.url", url);
        settings.put("application.name", "bonita");
        APITypeManager.setAPITypeAndParams(ApiAccessType.HTTP, settings);
    }

    @Bean
    public ProcessAPI processAPI() {
        return apiClient.getProcessAPI();
    }

    @Bean
    public IdentityAPI identityAPI() {
        return apiClient.getIdentityAPI();
    }

    @PostConstruct
    private void login() throws LoginException {
        apiClient.login("install", "install");
    }

}
