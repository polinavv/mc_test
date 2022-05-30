package testData;

import java.util.Map;

public class TestData {
    public static Map<String, String> validData = Map.ofEntries(
            Map.entry("Иван Иванович Иванов", "FULL_NAME"),
            Map.entry("Иван Иванов", "FULL_NAME"),
            Map.entry("Алла-Виктория Ивановна Иванова", "FULL_NAME"),
            Map.entry("user@test.ru", "EMAIL"),
            Map.entry("USER@TEST.RU", "EMAIL"),
            Map.entry("user1234@test.ru", "EMAIL"),
            Map.entry("user@test1234.ru", "EMAIL"),
            Map.entry("test-user@domain.ru", "EMAIL"),
            Map.entry("test_user@domain.ru", "EMAIL"),
            Map.entry("user@test_domain.ru", "EMAIL"),
            Map.entry("test.user@domain.ru", "EMAIL"),
            Map.entry("user@test.domain.ru", "EMAIL")
    );

    public static Map<String, String> invalidData = Map.ofEntries(
            Map.entry("123", "FULL_NAME"),
            Map.entry("Иван!", "FULL_NAME"),
            Map.entry("user1234@domainru", "EMAIL"),
            Map.entry("user1234", "EMAIL"),
            Map.entry("test user@domain.ru", "EMAIL"),
            Map.entry("@domain.ru", "EMAIL"),
            Map.entry("user@domain test.ru", "EMAIL"),
            Map.entry("user@domain.r", "EMAIL"),
            Map.entry("test@домен.ru", "EMAIL")
    );
}
