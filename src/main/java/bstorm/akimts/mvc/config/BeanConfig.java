package bstorm.akimts.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;


@Configuration
public class BeanConfig {

    Logger log = LoggerFactory.getLogger(BeanConfig.class);

    @Bean
    @Qualifier("console")
    public Scanner scanner(@Value("${ma.prop.custom}") String prop){
        log.info( prop );
        return new Scanner(System.in);
    }

}
