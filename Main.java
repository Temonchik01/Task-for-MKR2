public class Main {
    public static void main(String[] args) {
        // Створюємо EventManager (Шаблон Одинак - гарантуємо єдиний екземпляр)
        EventManager manager1 = EventManager.getInstance();
        // Спроба створити ще один екземпляр поверне той самий об'єкт:
        EventManager manager2 = EventManager.getInstance();
        System.out.println("manager1 == manager2: " + (manager1 == manager2) + " (Підтвердження Одинака)");

        // Створюємо компоненти-підписники
        AuthModule authModule = new AuthModule(manager1);
        LoggingModule loggingModule = new LoggingModule();
        UserInterfaceModule uiModule = new UserInterfaceModule();

        // Підписуємо модулі на події (Шаблон Спостерігач)
        manager1.subscribe(loggingModule);
        manager1.subscribe(uiModule);
        manager1.subscribe(authModule);

        System.out.println("\n");
        System.out.println("==============ДЕМОНСТРАЦІЯ СИСТЕМИ==============");

        // Компонент генерує подію (Авторизація)
        System.out.println(">>> СЦЕНАРІЙ 1: Успішна авторизація");
        authModule.login("admin");

        // Інша подія
        System.out.println(">>> СЦЕНАРІЙ 2: Вихід користувача");
        authModule.logout("admin");

        // Розсилка події від іншого джерела (наприклад, System)
        System.out.println(">>> СЦЕНАРІЙ 3: Системне сповіщення про помилку");
        manager1.notifyListeners("помилка доступу", "Користувач намагався отримати доступ до /root, доступ заборонено.");
    }
}
