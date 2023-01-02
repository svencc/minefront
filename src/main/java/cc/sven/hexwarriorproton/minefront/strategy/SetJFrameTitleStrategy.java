package cc.sven.hexwarriorproton.minefront.strategy;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

@Builder
@RequiredArgsConstructor
public class SetJFrameTitleStrategy {

    @NonNull
    private final JFrame frame;

    public void execute(@NonNull String newTitle) {
        frame.setTitle(newTitle);
    }

}
