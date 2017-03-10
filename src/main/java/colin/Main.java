package colin;

import org.bonitasoft.engine.api.APIClient;
import org.bonitasoft.engine.platform.LoginException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public APIClient apiClient() throws LoginException {
        return new APIClient();
    }

}
