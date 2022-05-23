package encoding;

import org.junit.Test;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class URLs {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    @Test
    public void testUrlEncoding() {
        String s = "https://www.google.com?a=7&b=9";
        String encodedS = URLEncoder.encode(s, DEFAULT_CHARSET);
        assertEquals("https%3A%2F%2Fwww.google.com%3Fa%3D7%26b%3D9", encodedS);

        String decoded = URLDecoder.decode(encodedS, DEFAULT_CHARSET);
        assertEquals("https://www.google.com?a=7&b=9", decoded);
    }

    @Test
    public void testUrlDecoding() {
        String encoded = "RESULT=00&AUTHCODE=12345&MESSAGE=%2800%29%5B+test+system+%5D+AUTHORISED&PASREF=16433662330568511&AVSPOSTCODERESULT=M&AVSADDRESSRESULT=M&CVNRESULT=M&ACCOUNT=internet&MERCHANT_ID=limerickrTEST&ORDER_ID=84a2d6f7-391d-4c0c-875a-e63e59292e21&TIMESTAMP=20220128103620&AMOUNT=1000&MERCHANT_RESPONSE_URL=https%3A%2F%2Fdevqa.digitary.net%2Fapi%2Fpayment%2Fv1%2Fgateway%2Fpayment%2Fasync&pas_uuid=7dae01da-f80e-4112-a61e-47ba313119ba&HPP_CUSTOMER_PHONENUMBER_MOBILE=380%7C501897804&SHIPPING_CODE=6100&SHIPPING_CO=UA&BILLING_CODE=6100&BILLING_CO=UA&CARDTYPE=VISA&CARDNAME=Galyna+Kovbasenko&CARDDIGITS=426397xxxx5262&EXPDATE=1023&SRD=9gtSO1GIgil0wRkx&SHA1HASH=ac87cc5840b05c7c71c52c18df2c57ab357bc6b5&HPP_BILLING_STREET1=13V&HPP_BILLING_STREET2=Valentynivska&HPP_BILLING_STREET3=Kharkiv&HPP_BILLING_CITY=%D0%A5%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2&HPP_BILLING_COUNTRY=804&HPP_BILLING_POSTALCODE=6100&HPP_SHIPPING_FIRSTNAME=Galyna&HPP_SHIPPING_LASTNAME=Kovbasenko&HPP_SHIPPING_PHONE=380%7C501897804&HPP_SHIPPING_STREET1=13V&HPP_SHIPPING_STREET2=Valentynivska&HPP_SHIPPING_STREET3=Kharkiv&HPP_SHIPPING_CITY=%D0%A5%D0%B0%D1%80%D1%8C%D0%BA%D0%BE%D0%B2&HPP_SHIPPING_COUNTRY=804&HPP_SHIPPING_POSTALCODE=6100&HPP_CUSTOMER_FIRSTNAME=Galyna&HPP_CUSTOMER_LASTNAME=Kovbasenko&HPP_CUSTOMER_EMAIL=galina.kovbasenko%40parchment.com&HPP_CHALLENGE_REQUEST_INDICATOR=NO_PREFERENCE&HPP_ADDRESS_MATCH_INDICATOR=true&HPP_FRAUDFILTER_RESULT=NOT_EXECUTED&RESPONSE_URL=https%3A%2F%2Fdevqa.digitary.net%2F%23%2Fpayment&BATCHID=1043427";
        String decoded = URLDecoder.decode(encoded, DEFAULT_CHARSET);
        System.out.println(decoded);
    }

    @Test
    public void testSplitNotFound() {
        String sPresent = "hellosworld";
        String sNotPresent = "helloworld";
        String component = sPresent.split("s")[0];
        assertEquals("hello", component);

        // component = sNotPresent.split("s")[1];  // IndexOutOfBounds Exception
        // System.out.println(component);
    }
}
