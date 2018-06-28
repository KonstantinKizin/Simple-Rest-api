package by.kizin.konstantin.resttask.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;

@Configuration
@Profile("test")
public class EmbeddedDataSourceConfiguration {

    private EmbeddedDatabaseBuilder builder
            = new EmbeddedDatabaseBuilder();

    @Bean
    public DataSource dataSource(){
        return builder.setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/schema.sql")
                .addScript("db/init-data.sql")
                .build();
    }

}
