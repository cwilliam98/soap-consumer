package br.com.cw.soap.consumer.client;

import br.com.cw.soap.consumer.domain.SecurityHeader;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import java.io.IOException;

public class SecurityHeaderCallBack implements WebServiceMessageCallback {
    private final String token;
    private final WebServiceTemplate wsTemplate;

    public SecurityHeaderCallBack(String token, WebServiceTemplate wsTemplate) {
        this.token = token;
        this.wsTemplate = wsTemplate;
    }

    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException {
        var securityHeader = new SecurityHeader();
        securityHeader.setToken(token);
        SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();

        wsTemplate.getMarshaller().marshal(securityHeader, soapHeader.getResult());
    }
}
