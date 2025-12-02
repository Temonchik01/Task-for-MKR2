public class AuthModule implements IEventListener {
    private final String name = "AuthModule";
    private final EventManager manager;

    public AuthModule(EventManager manager) {
        this.manager = manager;
    }

    // Функція, що генерує подію
    public void login(String username) {
        String eventType = "користувач авторизувався";
        String message = "Користувач '" + username + "' успішно увійшов у систему.";

        System.out.println(name + " генерує подію: " + eventType);
        // Сповіщаємо всіх підписників через EventManager
        manager.notifyListeners(eventType, message);
    }

    public void logout(String username) {
        String eventType = "користувач вийшов";
        String message = "Користувач '" + username + "' вийшов із системи.";

        System.out.println(name + " генерує подію: " + eventType);
        manager.notifyListeners(eventType, message);
    }

    // Функція, що реагує на подію
    @Override
    public void update(String eventType, String message) {
        if (eventType.equals("доступ заборонено")) {
            System.out.println(name + ": Отримано сповіщення про заборону доступу.");
        }
    }
}
