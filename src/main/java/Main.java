public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- ТЕСТУВАННЯ OBSERVER ---");
        WeatherStation station = new WeatherStation();
        WeatherApp mobile = new WeatherApp("Mobile App");
        WeatherApp web = new WeatherApp("Web Dashboard");

        station.registerObserver(mobile);
        station.registerObserver(web);

        station.setMeasurements(24.0f, 40.0f);

        System.out.println("\n--- ТЕСТУВАННЯ PROXY ---");
        WeatherService service = new WeatherProxy();

        System.out.println("Результат: " + service.getWeatherData()); // Перший запит
        System.out.println("Результат: " + service.getWeatherData()); // З кешу

        System.out.println("\nЧекаємо 6 секунд...");
        Thread.sleep(6000);

        System.out.println("Результат: " + service.getWeatherData()); // Знову запит до джерела
    }
}