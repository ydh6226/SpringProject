package config;

import com.ydh.SpringProject.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx6 {

    @Bean
    public Client client(){
        Client client=new Client();
        client.setHost("host");
        return client;
    }
}
