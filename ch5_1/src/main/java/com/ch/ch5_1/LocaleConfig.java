package com.ch.ch5_1;
import java.util.Locale;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Configuration
@EnableAutoConfiguration
public class LocaleConfig implements WebMvcConfigurer {
	/**
	 *根据用户本次会话过程中的语义设定语言区域
	 *（如用户进入首页时选择的语言种类）
	 * @return
	 */
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //默认语言
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }
	/**
	 * 使用SessionLocaleResolver存储语言区域时，
	 * 必须配置localeChangeInterceptor拦截器
	 * @return
	 */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        //选择语言的参数名
        lci.setParamName("locale");
        return lci;
    }
    /**
         * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
