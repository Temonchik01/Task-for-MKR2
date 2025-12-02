public class LoggingModule implements IEventListener {
    private final String name = "LoggingModule";

    // Функція, що реагує на подію
    @Override
    public void update(String eventType, String message) {
        // Записуємо подію до консолі
        System.out.println(name + ": [LOG] Подія: " + eventType + ". Деталі: " + message);
    }
}
