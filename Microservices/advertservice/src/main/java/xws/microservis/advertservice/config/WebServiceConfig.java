package xws.microservis.advertservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name="rentadvert")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema rentAdvertSchema){

        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RentAdvertPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.baeldung.com/springsoap/gen");
        wsdl11Definition.setSchema(rentAdvertSchema);
        return wsdl11Definition;

    }

    @Bean(name="pricelist")
    public DefaultWsdl11Definition defaultWsdl11DefinitionPriceList(XsdSchema priceListSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PriceListPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.baeldung.com/springsoap/gen");
        wsdl11Definition.setSchema(priceListSchema);
        return wsdl11Definition;

    }


    @Bean(name="car")
    public DefaultWsdl11Definition defaultWsdl11DefinitionCar(XsdSchema carSchema){

        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CarPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.baeldung.com/springsoap/gen");
        wsdl11Definition.setSchema(carSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema priceListSchema(){

        return new SimpleXsdSchema(new ClassPathResource("pricelist.xsd"));
    }

    @Bean
    public XsdSchema carSchema(){

        return  new SimpleXsdSchema(new ClassPathResource("car.xsd"));
    }

    @Bean
    public XsdSchema rentAdvertSchema(){

        return new SimpleXsdSchema(new ClassPathResource("rentadvert.xsd"));
    }

}
