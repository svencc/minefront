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
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Map;

@EnableConfigurationProperties({
        MetaProperties.class,
        ResolutionProperties.class
})
@SpringBootApplication
public class MinefrontApplication {

    JFrame applicationFrame;

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MinefrontApplication.class)
                .headless(false)
                .run(args);
        ctx.start();
    }

    public static void setEnv(String key, String value) {
        try {
            Map<String, String> env = System.getenv();
            Class<?> cl = env.getClass();
            Field field = cl.getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map<String, String>) field.get(env);
            writableEnv.put(key, value);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to set environment variable", e);
        }
    }

    public static void getEnv(String key, String value) {
        try {
            Map<String, String> env = System.getenv();
            Class<?> cl = env.getClass();
            Field field = cl.getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map<String, String>) field.get(env);
            writableEnv.put(key, value);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to set environment variable", e);
        }
    }

    @Bean
    public CommandLineRunner provideCommandLineRunnerBean(
            @NonNull Game game,
            @NonNull MetaProperties metaProperties,
            @NonNull ResolutionProperties resolutionProperties
    ) {
        return args -> {
//            boolean GAMERUN = Boolean.valueOf(System.getProperty("GAMERUN", "false"));
//            if (!GAMERUN) {
//                System.setProperty("GAMERUN", "true");
//            }

            final JFrame frame = new JFrame();
            applicationFrame = frame;
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