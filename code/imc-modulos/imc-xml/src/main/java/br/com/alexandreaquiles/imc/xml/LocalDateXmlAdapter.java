package br.com.alexandreaquiles.imc.xml;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String value) throws Exception {
        return LocalDate.parse(value);
    }

    public String marshal(LocalDate date) throws Exception {
        return date.toString();
    }
}
