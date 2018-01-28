package dbdemo.mysql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
//EnableJpaRepositories: Enabled by default, block it if you don't want to specify a basePackage
@EnableJpaRepositories(basePackages = "dbdemo.**.repository")
//@EntityScan(basePackages = "dbdemo.**.entity")//No more EntityScan
//EnableJpaAuditing: update createDate, laseModifiedDate and so on automatically.
@EnableJpaAuditing
public class JpaConfiguration {

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
