package br.com.cw.soap.consumer.client;

import br.com.cw.soap.consumer.domain.CountryISOCode;
import br.com.cw.soap.consumer.domain.CountryISOCodeResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class CountryInfoClient {

    private final WebServiceTemplate wsTemplate;
    private static final Logger log = LoggerFactory.getLogger(CountryInfoClient.class);

    public CountryInfoClient(WebServiceTemplate wsTemplate) {
        this.wsTemplate = wsTemplate;
    }

    public CountryISOCodeResponse getCountryISOCode(String countryIsoCode) {

        try {
            var request = new CountryISOCode();
            request.setSCountryName(countryIsoCode);
            return (CountryISOCodeResponse) wsTemplate.marshalSendAndReceive(request, new SecurityHeaderCallBack("", wsTemplate));
        } catch (ClassCastException e) {
            log.error("## ERROR TO CAST CLASS: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("## ERROR CALL: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
