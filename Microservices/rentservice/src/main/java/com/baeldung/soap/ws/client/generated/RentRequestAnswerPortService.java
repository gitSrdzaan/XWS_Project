
package com.baeldung.soap.ws.client.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "rentRequestAnswerPortService", targetNamespace = "http://www.baeldung.com/springsoap/gen", wsdlLocation = "http://localhost:8080/ws/rentrequestanswer.wsdl")
public class RentRequestAnswerPortService
    extends Service
{

    private final static URL RENTREQUESTANSWERPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException RENTREQUESTANSWERPORTSERVICE_EXCEPTION;
    private final static QName RENTREQUESTANSWERPORTSERVICE_QNAME = new QName("http://www.baeldung.com/springsoap/gen", "rentRequestAnswerPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ws/rentrequestanswer.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RENTREQUESTANSWERPORTSERVICE_WSDL_LOCATION = url;
        RENTREQUESTANSWERPORTSERVICE_EXCEPTION = e;
    }

    public RentRequestAnswerPortService() {
        super(__getWsdlLocation(), RENTREQUESTANSWERPORTSERVICE_QNAME);
    }

    public RentRequestAnswerPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RENTREQUESTANSWERPORTSERVICE_QNAME, features);
    }

    public RentRequestAnswerPortService(URL wsdlLocation) {
        super(wsdlLocation, RENTREQUESTANSWERPORTSERVICE_QNAME);
    }

    public RentRequestAnswerPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RENTREQUESTANSWERPORTSERVICE_QNAME, features);
    }

    public RentRequestAnswerPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RentRequestAnswerPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RentRequestAnswerPort
     */
    @WebEndpoint(name = "rentRequestAnswerPortSoap11")
    public RentRequestAnswerPort getRentRequestAnswerPortSoap11() {
        return super.getPort(new QName("http://www.baeldung.com/springsoap/gen", "rentRequestAnswerPortSoap11"), RentRequestAnswerPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RentRequestAnswerPort
     */
    @WebEndpoint(name = "rentRequestAnswerPortSoap11")
    public RentRequestAnswerPort getRentRequestAnswerPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.baeldung.com/springsoap/gen", "rentRequestAnswerPortSoap11"), RentRequestAnswerPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RENTREQUESTANSWERPORTSERVICE_EXCEPTION!= null) {
            throw RENTREQUESTANSWERPORTSERVICE_EXCEPTION;
        }
        return RENTREQUESTANSWERPORTSERVICE_WSDL_LOCATION;
    }

}
