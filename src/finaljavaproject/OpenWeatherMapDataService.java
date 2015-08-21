package finaljavaproject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalTime;

import org.json.JSONArray;
import org.json.JSONObject;

public class OpenWeatherMapDataService implements IWeatherDataService {
	@Override
	public WeatherData getWeatherData(Location location)
			throws WeatherDataServiceException {
		try {
			String requestURL = "http://api.openweathermap.org/data/2.5/weather?units=metric&id="
					+ location.getId();
			String jsonData = getData(requestURL);
			WeatherData data = generateWeatherDataFromJSON(jsonData);
			return data;
		} catch (Exception ex) {
			throw new WeatherDataServiceException("Something bad happened");
		}
	}

	private WeatherData generateWeatherDataFromJSON(String jsonData) {
		// weatherData that we will return from this function
		WeatherData weatherData = new WeatherData();
		
		// create JSONObject from jsonData.
		JSONObject jsonObject = new JSONObject(jsonData);
		
		// get coord obj
		JSONObject coordObj = jsonObject.getJSONObject("coord");
		// get coord lon
		weatherData.setCoordLon(coordObj.getDouble("lon"));
		weatherData.setCoordLat(coordObj.getDouble("lat"));
		
		JSONArray weatherArray = jsonObject.getJSONArray("weather");
		JSONObject weatherObj = (JSONObject) weatherArray.get(0);
		weatherData.setWeatherDescription(weatherObj.getString("description"));
		weatherData.setWeatherIcon(weatherObj.getString("icon"));
		
		JSONObject mainObj = jsonObject.getJSONObject("main");
		weatherData.setTemp(mainObj.getDouble("temp"));
		weatherData.setPressure(mainObj.getInt("pressure"));
		weatherData.setHumidity(mainObj.getInt("humidity"));
		weatherData.setTempMax(mainObj.getDouble("temp_max"));
		weatherData.setTempMin(mainObj.getDouble("temp_min"));
		//private String cityID;
		//private String cityName;
		//private int clouds;
		//private String countryCode;
		//private int rain3h;
		//private int snow3h;
		//private LocalTime sunrise;
		//private LocalTime sunset;
		//private LocalTime timeOfCalculation;
		//private int windDeg;
		//private int windSpeed;

		
		//weatherData.setWeatherDescription(weatherDescription);
		
		return weatherData;
	}

	String getData(String address) throws Exception {
		URL page = new URL(address);
		StringBuffer text = new StringBuffer();
		HttpURLConnection conn = (HttpURLConnection) page.openConnection();
		conn.connect();
		InputStreamReader in = new InputStreamReader(
				(InputStream) conn.getContent());
		BufferedReader buff = new BufferedReader(in);
		String line;
		do {
			line = buff.readLine();
			text.append(line);
		} while (line != null);

		return text.toString();
	}
}
