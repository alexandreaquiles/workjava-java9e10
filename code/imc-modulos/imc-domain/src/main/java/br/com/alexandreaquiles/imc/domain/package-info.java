@XmlJavaTypeAdapters(
		@XmlJavaTypeAdapter(type=LocalDate.class, value=LocalDateXmlAdapter.class)
)
package br.com.alexandreaquiles.imc.domain;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import br.com.alexandreaquiles.imc.xml.LocalDateXmlAdapter;