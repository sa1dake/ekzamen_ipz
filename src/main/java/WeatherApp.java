public class WeatherApp implements Observer {
    private String appName;

    public WeatherApp(String name) { this.appName = name; }

    @Override
    public void update(float temp, float hum) {
        System.out.println("Сповіщення для [" + appName + "]: Нова погода -> " + temp + "°C, " + hum + "%");
    }
}