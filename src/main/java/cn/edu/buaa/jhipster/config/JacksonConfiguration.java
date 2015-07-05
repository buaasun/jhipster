package cn.edu.buaa.jhipster.config;

import com.google.common.collect.ImmutableList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import com.fasterxml.jackson.datatype.joda.ser.JacksonJodaFormat;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class JacksonConfiguration {

    @Bean
    public JodaModule jacksonJodaModule() {
        JodaModule module = new JodaModule();
        DateTimeFormatterFactory formatterFactory = new DateTimeFormatterFactory();
        formatterFactory.setIso(DateTimeFormat.ISO.DATE);
        module.addSerializer(DateTime.class, new DateTimeSerializer(
            new JacksonJodaFormat(formatterFactory.createDateTimeFormatter()
                                      .withZoneUTC())));
        return module;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter
                    jsonConverter =
                    (MappingJackson2HttpMessageConverter) converter;
                jsonConverter.setObjectMapper(new ObjectMapper());
                jsonConverter.setSupportedMediaTypes(ImmutableList
                                                         .of(new MediaType("application", "json",
                                                                           MappingJackson2HttpMessageConverter.DEFAULT_CHARSET),new MediaType("text", "plain",
                                                                                                                                              MappingJackson2HttpMessageConverter.DEFAULT_CHARSET),
                                                             new MediaType("text", "javascript",
                                                                           MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));
            }
        }
        return restTemplate;
    }
}
