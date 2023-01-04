package cc.sven.hexwarriorproton.minefront;

import cc.sven.hexwarriorproton.minefront.engine.GameEngine;
import cc.sven.hexwarriorproton.minefront.property.MetaProperties;
import cc.sven.hexwarriorproton.minefront.property.RendererResolutionProperties;
import cc.sven.hexwarriorproton.minefront.property.TickProperties;
import cc.sven.hexwarriorproton.minefront.strategy.SetJFrameTitleStrategy;
import lombok.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@EnableConfigurationProperties({
        MetaProperties.class,
        RendererResolutionProperties.class,
        TickProperties.class
})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
                .headless(false)
                .run(args);
        ctx.start();
    }

    @Bean
    public CommandLineRunner provideCommandLineRunnerBean(
            @NonNull GameEngine gameEngine,
            @NonNull MetaProperties metaProperties,
            @NonNull RendererResolutionProperties rendererResolutionProperties
    ) {
        return args -> {
            final Frame frame = new Frame();
            frame.setTitle(metaProperties.getName());
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    gameEngine.stop();
                }
            });
            frame.setLocationByPlatform(true);
            frame.setSize(rendererResolutionProperties.getScaledWidth(), rendererResolutionProperties.getScaledHeight());
            frame.setResizable(false);
            frame.add(gameEngine);
            frame.setVisible(true);

            int verticalInset = frame.getInsets().top + frame.getInsets().bottom;
            int horizontalInset = frame.getInsets().left + frame.getInsets().right;
            frame.setSize(rendererResolutionProperties.getScaledWidth() + horizontalInset, rendererResolutionProperties.getScaledHeight() + verticalInset);

            gameEngine.start(SetJFrameTitleStrategy.builder().frame(frame).build());
        };
    }

}