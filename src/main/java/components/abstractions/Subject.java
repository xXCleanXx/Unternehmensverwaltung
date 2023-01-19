package components.abstractions;

import components.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private final List<IObserver> _observers = new ArrayList<>();

    protected Subject() { }

    public void notifyObservers() {
        for (IObserver item : this._observers) {
            item.update(this);
        }
    }

    public void addObserver(IObserver observer) {
        if (observer == null) throw new IllegalArgumentException("Observer cannot be null!");
        if (_observers.contains(observer)) throw new IllegalArgumentException("Observer already added!");
    }

    public void removeObserver(IObserver observer) {
        if (observer == null) throw new IllegalArgumentException("Observer cannot be null!");

        this._observers.remove(observer);
    }
}