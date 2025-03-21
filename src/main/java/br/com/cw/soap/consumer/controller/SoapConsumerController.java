package br.com.cw.soap.consumer.controller;

import br.com.cw.soap.consumer.client.CountryInfoClient;
import br.com.cw.soap.consumer.domain.CountryISOCodeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("soap-consumer")
public class SoapConsumerController {

    private final CountryInfoClient countryInfoClient;

    public SoapConsumerController(CountryInfoClient countryInfoClient) {
        this.countryInfoClient = countryInfoClient;
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<CountryISOCodeResponse> getCountryIsoCode(@PathVariable(name = "countryCode") String countryCode) {
        return ResponseEntity.ok().body(countryInfoClient.getCountryISOCode(countryCode));
    }
}
