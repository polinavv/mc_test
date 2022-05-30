Тесты JUnit+Selenide

Тесты написаны для сайта https://demoqa.com

Список проверок:
отображение элементов,
валидация полей,
проверка результата заполнения полей, проверка ввода пустых полей, проверка максимальной длины полей.

Команда для запуска тестов: mvn test -Dtest=TextBoxTest
Для запуска в другом браузере добавить параметр -Dselenide.browser=firefox (по умолчанию chrome)
Разрешение экрана можно задать параметром -Dselenide.browserSize="1920x1080"


