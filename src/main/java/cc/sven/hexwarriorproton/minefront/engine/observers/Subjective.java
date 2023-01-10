package cc.sven.hexwarriorproton.minefront.engine.observers;

import lombok.NonNull;

public interface Subjective {

    void beObservedBy(@NonNull final Observing observer);

    void observationStoppedThrough(@NonNull final Observing observer);

    void notifyObserversWith(@NonNull final Note note);

    void reportMyDeath();

}
