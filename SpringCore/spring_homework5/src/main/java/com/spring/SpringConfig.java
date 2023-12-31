package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:musicPlayer.properties")

public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusicBean () {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusicBean () {
        return new RockMusic();
    }

    @Bean
    public MusicPlayer musicPlayerBean () {
        return new MusicPlayer(classicalMusicBean(), rockMusicBean());
    }

}
