package cc.sven.hexwarriorproton.minefront.engine.observers;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class ObserverTemplate implements Observing {

    @NonNull
    private final List<Subject> subjects = new ArrayList<>();

    @Override
    public abstract void observe(@NonNull final Subject subject);

    @Override
    public abstract void takeNotice(final @NonNull Subject subject, @NonNull final Note event);

    @Override
    public void takeDeadthNoticeFrom(final @NonNull Subject subject) {
        subjects.remove(subjects);
    }

}
