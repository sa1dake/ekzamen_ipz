public class RealWeatherService implements WeatherService {
    @Override
    public String getWeatherData() {
        // Імітація запиту до мережі
        return "Температура: 22°C, Вологість: 60%";
    }
}