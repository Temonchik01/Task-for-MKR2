import java.util.ArrayList;
import java.util.List;

public class EventManager {
    // Реалізація Шаблону Singleton
    private static EventManager instance;

    /**
     * Приватний конструктор, щоб запобігти створенню нових екземплярів.
     */
    private EventManager() {}

    /**
     * Повертає єдиний екземпляр EventManager.
     */
    public static EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
            System.out.println("EventManager: Створено єдиний екземпляр.");
        }
        return instance;
    }

    // Реалізація Шаблону Observer
    private final List<IEventListener> listeners = new ArrayList<>();

    /**
     * Додає підписника до списку.
     */
    public void subscribe(IEventListener listener) {
        listeners.add(listener);
        System.out.println(listener.getClass().getSimpleName() + " підписано.");
    }

    /**
     * Видаляє підписника зі списку.
     */
    public void unsubscribe(IEventListener listener) {
        listeners.remove(listener);
        System.out.println(listener.getClass().getSimpleName() + " відписано.");
    }

    /**
     * Сповіщає всіх підписників про нову подію.
     */
    public void notifyListeners(String eventType, String message) {
        System.out.println("\n--- EventManager: РОЗСИЛКА ---");
        System.out.println("Подія: " + eventType);
        for (IEventListener listener : listeners) {
            listener.update(eventType, message);
        }
        System.out.println("----------------------------\n");
    }
}
