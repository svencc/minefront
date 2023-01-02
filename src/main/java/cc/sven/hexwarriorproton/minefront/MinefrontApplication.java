package cc.sven.hexwarriorproton.minefront;

import cc.sven.hexwarriorproton.minefront.engine.Game;
import cc.sven.hexwarriorproton.minefront.property.MetaProperties;
import cc.sven.hexwarriorproton.minefront.property.ResolutionProperties;
import cc.sven.hexwarriorproton.minefront.strategy.SetJFrameTitleStrategy;
import lombok.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;

@EnableConfigurationProperties({
        MetaProperties.class,
        ResolutionProperties.class
})
@SpringBootApplication
public class MinefrontApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new SpringApplicationBuilder(MinefrontApplication.class)
                .headless(false)
                .run(args);
    }

    @Bean
    public CommandLineRunner provideCommandLineRunnerBean(
            @NonNull Game game,
            @NonNull MetaProperties metaProperties,
            @NonNull ResolutionProperties resolutionProperties
    ) {
        return args -> {
            final JFrame frame = new JFrame();
            frame.setTitle(metaProperties.getName());
            frame.add(game);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setSize(resolutionProperties.getWidth(), resolutionProperties.getHeight());
            frame.setResizable(false);
            frame.setVisible(true);

            game.start(SetJFrameTitleStrategy.builder().frame(frame).build());
        };
    }

}