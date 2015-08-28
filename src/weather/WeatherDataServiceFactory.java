package weather;

public class WeatherDataServiceFactory {
	public static final int OPEN_WEATHER_MAP = 0;
	
	private static OpenWeatherMapDataService openWeatherMapInstance = null;
	
	public static IWeatherDataService getWeatherDataService(int type) throws Exception {
		if(type == OPEN_WEATHER_MAP) {
			if (openWeatherMapInstance == null)
			{
				openWeatherMapInstance = new OpenWeatherMapDataService();
			}
			return openWeatherMapInstance;
		}
		
		throw new Exception("Unsupported type");
	}

}
