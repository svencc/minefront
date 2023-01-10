package cc.sven.hexwarriorproton.minefront.engine.observers;

import lombok.NonNull;

public interface Observing {

    void observe(@NonNull final Subject subject);

    void takeNotice(@NonNull final Subject subject, @NonNull final Note note);

    void takeDeadthNoticeFrom(@NonNull final Subject subject);
}
