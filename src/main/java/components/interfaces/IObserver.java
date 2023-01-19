package components.interfaces;

import components.abstractions.Subject;

public interface IObserver {
    void update(Subject subject);
}