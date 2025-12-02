public class UserInterfaceModule implements IEventListener {
    private final String name = "UserInterfaceModule";

    // Функція, що реагує на подію
    @Override
    public void update(String eventType, String message) {
        String displayMessage = "";
        switch (eventType) {
            case "користувач авторизувався":
                displayMessage = "Ласкаво просимо!";
                break;
            case "користувач вийшов":
                displayMessage = "До побачення. Приходьте ще!";
                break;
            case "помилка доступу":
                displayMessage = "Помилка! Доступ заборонено.";
                break;
            default:
                // Ігнорувати інші події
                return;
        }
        System.out.println(name + ": [INTERFACE] Відображення: " + displayMessage);
    }
}
