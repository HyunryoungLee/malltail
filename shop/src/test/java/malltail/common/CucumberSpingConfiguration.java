package malltail.common;


import malltail.ShopApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ShopApplication.class })
public class CucumberSpingConfiguration {
    
}
