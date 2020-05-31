package pl.edu.agh.soa.lab;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/students")
public class App extends Application {
    public App(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest-api/students");
        beanConfig.setResourcePackage("pl.edu.agh.soa.lab");
        beanConfig.setTitle("Student Controller REST API Documentation");
        beanConfig.setScan(true);
    }

}
