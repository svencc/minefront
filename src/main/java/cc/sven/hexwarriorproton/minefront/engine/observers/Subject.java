package cc.sven.hexwarriorproton.minefront.engine.observers;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Subject implements Subjective {

    @NonNull
    private final List<Observing> observersWatchingMe = new ArrayList<>();


    @Override
    public void beObservedBy(final @NonNull Observing observer) {
        observersWatchingMe.add(observer);
    }

    @Override
    public void observationStoppedThrough(final @NonNull Observing observer) {
        observersWatchingMe.remove(observer);
    }

    @Override
    public void notifyObserversWith(@NonNull final Note note) {
        observersWatchingMe.forEach(observer -> observer.takeNotice(this, note));
    }

    @Override
    public void reportMyDeath() {
        observersWatchingMe.forEach(observer -> observer.takeDeadthNoticeFrom(this));
    }

}
