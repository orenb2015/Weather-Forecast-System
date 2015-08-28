package weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
			throw new WeatherDataServiceException("Could not get weather data from openweathermap", ex);
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
		
		JSONObject windObj = jsonObject.getJSONObject("wind");
		weatherData.setWindSpeed(windObj.optDouble("speed"));
		weatherData.setWindDeg(windObj.optDouble("deg"));
		
		JSONObject rainObj = jsonObject.optJSONObject("rain");
		if (rainObj != null)
		{
			double rain3h = rainObj.optDouble("3h");
			if (!Double.isNaN(rain3h))
				weatherData.setRain3h(rain3h);
		}
		
		JSONObject snowObj = jsonObject.optJSONObject("snow");
		if (snowObj != null)
		{
			double snow3h = snowObj.optDouble("3h");
			if (!Double.isNaN(snow3h))
				weatherData.setSnow3h(snow3h);
		}
		
		JSONObject cloudsObj = jsonObject.optJSONObject("clouds");
		if (cloudsObj != null)
		{
			int cloudsAll = cloudsObj.optInt("all");
			if (cloudsAll != 0)
				weatherData.setClouds(cloudsAll);
		}
		
		// date is from UTC (greenwich, england)
		int dt = jsonObject.getInt("dt");
		DateTime timeOfCalculation = new DateTime(dt * 1000L, DateTimeZone.UTC);
		weatherData.setTimeOfCalculation(timeOfCalculation);
		
		JSONObject sysObj = jsonObject.getJSONObject("sys");
		weatherData.setCountryCode(sysObj.getString("country"));
		weatherData.setSunrise(new DateTime(1000L * sysObj.getInt("sunrise"), DateTimeZone.UTC));
		weatherData.setSunset(new DateTime(1000L * sysObj.getInt("sunset"), DateTimeZone.UTC));
		
		weatherData.setCityID(jsonObject.getInt("id"));
		weatherData.setCityName(jsonObject.getString("name"));
		
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
