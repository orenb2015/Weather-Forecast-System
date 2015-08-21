package finaljavaproject;

public class MainProgram {

	public static void main(String[] args) {
		try {
			IWeatherDataService openWeatherDataService = WeatherDataServiceFactory.getWeatherDataService(WeatherDataServiceFactory.OPEN_WEATHER_MAP);
			WeatherData data = openWeatherDataService.getWeatherData(new Location(281184));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
