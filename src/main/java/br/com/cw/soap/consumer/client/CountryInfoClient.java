package br.com.cw.soap.consumer.client;

import br.com.cw.soap.consumer.domain.CountryISOCode;
import br.com.cw.soap.consumer.domain.CountryISOCodeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class CountryInfoClient {

    private final WebServiceTemplate wsTemplate;
    private static final Logger log = LoggerFactory.getLogger(CountryInfoClient.class);

    public CountryInfoClient(@Qualifier("countryInfo") WebServiceTemplate wsTemplate) {
        this.wsTemplate = wsTemplate;
    }

    public CountryISOCodeResponse getCountryISOCode(String countryIsoCode) {

        var request = new CountryISOCode();
        request.setSCountryName(countryIsoCode);
        return (CountryISOCodeResponse) wsTemplate.marshalSendAndReceive(request);

    }
}
