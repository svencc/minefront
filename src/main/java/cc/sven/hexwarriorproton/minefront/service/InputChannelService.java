package cc.sven.hexwarriorproton.minefront.service;

import cc.sven.hexwarriorproton.minefront.engine.observers.HasSubject;
import cc.sven.hexwarriorproton.minefront.engine.observers.Subject;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class InputChannelService implements HasSubject {

    @Getter
    @NonNull
    private Subject subject;

}
