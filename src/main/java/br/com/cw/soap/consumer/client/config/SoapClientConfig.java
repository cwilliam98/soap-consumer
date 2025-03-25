package br.com.cw.soap.consumer.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {
    private static final String MODEL_COUNTRY_INFO =
            "br.com.cw.soap.consumer.domain";

    @Value("${country-info.uri}")
    private String uri;

    @Bean("countryInfo")
    public WebServiceTemplate countryInfo() {
        WebServiceTemplate wst = new WebServiceTemplate(createJaxbMarshaller());
        wst.setDefaultUri(uri);
        return wst;
    }

    @Bean
    public Jaxb2Marshaller createJaxbMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(MODEL_COUNTRY_INFO);
        return marshaller;
    }
}
