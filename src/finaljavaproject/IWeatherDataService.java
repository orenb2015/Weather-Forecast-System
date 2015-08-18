package finaljavaproject;

public interface IWeatherDataService {
	public WeatherData getWeatherData(int locationId) throws WeatherDataServiceException;
}
