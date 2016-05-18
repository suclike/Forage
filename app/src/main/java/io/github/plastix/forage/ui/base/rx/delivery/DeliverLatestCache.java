package io.github.plastix.forage.ui.base.rx.delivery;

import rx.Observable;

/**
 * From https://github.com/alapshin/arctor
 */
public class DeliverLatestCache<T> implements Observable.Transformer<T, T> {

    private final Observable<Boolean> view;

    public DeliverLatestCache(Observable<Boolean> view) {
        this.view = view;
    }

    @Override
    public Observable<T> call(Observable<T> observable) {
        return Observable
                .combineLatest(
                        view,
                        observable
                                .materialize()
                                .filter(notification -> !notification.isOnCompleted()),
                        (flag, notification) -> flag ? notification : null)
                .filter(notification -> notification != null)
                .dematerialize();
    }
}