public interface IEventListener {
    /**
     * Обробляє подію, що надійшла від EventManager.
     * @param eventType Тип події.
     * @param message Повідомлення, пов'язане з подією.
     */
    void update(String eventType, String message);
}
