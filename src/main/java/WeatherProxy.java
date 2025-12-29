public class WeatherProxy implements WeatherService {
    private RealWeatherService realService;
    private String cachedData;
    private long lastUpdate;
    private static final long CACHE_DURATION = 5000; // 5 секунд

    public WeatherProxy() {
        this.realService = new RealWeatherService();
    }

    @Override
    public String getWeatherData() {
        long currentTime = System.currentTimeMillis();

        if (cachedData == null || (currentTime - lastUpdate) > CACHE_DURATION) {
            System.out.println("[Proxy] Кеш застарів або порожній. Запит до джерела...");
            cachedData = realService.getWeatherData();
            lastUpdate = currentTime;
        } else {
            System.out.println("[Proxy] Повернення даних з кешу (актуально ще " +
                    (CACHE_DURATION - (currentTime - lastUpdate)) + " мс).");
        }
        return cachedData;
    }
}