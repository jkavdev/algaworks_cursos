package br.com.jkavdev.algaworks.spring.wine.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	// Redirecionando para página não encontrada
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404")));
	}

	// Converter do Spring data com o mvc, ao invpes de passarmos um id
	// para buscar uma entidade, o spring data fará isso automaticamente
	public DomainClassConverter<FormattingConversionService> domainClassConverter(
			FormattingConversionService conversionService) {
		return new DomainClassConverter<FormattingConversionService>(conversionService);
	}

}
