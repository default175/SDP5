import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String message);
}

// Subject class
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    // Method to attach an observer
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Method to detach an observer
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Set the state and notify observers
    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    // Get the current state
    public String getState() {
        return state;
    }

    // Notify all observers of state change
    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// Concrete Observer 1
class ConcreteObserver1 implements Observer {
    public void update(String message) {
        System.out.println("Observer 1 received update: " + message);
    }
}

// Concrete Observer 2
class ConcreteObserver2 implements Observer {
    public void update(String message) {
        System.out.println("Observer 2 received update: " + message);
    }
}

// Demo class to test Observer Pattern
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        // Attach observers to the subject
        subject.attach(observer1);
        subject.attach(observer2);

        // Change the state and notify observers
        subject.setState("New State 1");
        subject.setState("New State 2");
    }
}
