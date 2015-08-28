package weather;

import org.joda.time.DateTimeZone;

public class MainProgram {

	public static void main(String[] args) {
		try {
			IWeatherDataService openWeatherDataService = WeatherDataServiceFactory.getWeatherDataService(WeatherDataServiceFactory.OPEN_WEATHER_MAP);
			WeatherData data = openWeatherDataService.getWeatherData(new Location("281184"));
			
			//System.out.println("Time in Israel: " + data.getTimeOfCalculation().toDateTime(DateTimeZone.forID("Israel")).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
