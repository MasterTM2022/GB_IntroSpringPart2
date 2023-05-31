package ru.gb.perov.IntroSpringPart2.Security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
@PropertySource("classpath:secret.properties")
public class JwtConfiguration {
}
