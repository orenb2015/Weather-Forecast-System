package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import weather.IWeatherDataService;
import weather.Location;
import weather.WeatherData;
import weather.WeatherDataServiceFactory;

public class MainApplicationController implements ActionListener {
	MainApplicationView view;

	Hashtable<String, String> citiesAndIDs;

	public MainApplicationController() throws IOException {
		citiesAndIDs = new Hashtable<String, String>();

		// read all the cities and their IDs to the citiesAndIDs hashtable.
		readCitiesAndIDsFromFile();
		// take only the cities column from the citiesAndIDs hashtable.
		ArrayList<String> cities = getSortedCitiesList();

		view = new MainApplicationView(this, cities);
	}

	private ArrayList<String> getSortedCitiesList() {
		ArrayList<String> cities = new ArrayList<String>();

		// get iterator for cities and IDs
		Iterator<Map.Entry<String, String>> it = citiesAndIDs.entrySet()
				.iterator();

		// asking if the cities and IDs have another row.
		while (it.hasNext()) {
			// get the next row.
			Map.Entry<String, String> entry = it.next();

			cities.add(entry.getKey());
		}

		// sort
		Collections.sort(cities);

		return cities;
	}

	public void control() {
		view.displayMainWindow();
	}

	private void readCitiesAndIDsFromFile() throws IOException {
		Path path = FileSystems.getDefault()
				.getPath("resources\\city_list.txt");
		List<String> lines = Files.readAllLines(path);

		for (Iterator iterator = lines.iterator(); iterator.hasNext();) {
			String line = (String) iterator.next();
			String[] row = line.split("\t");

			String city = row[1];
			String id = row[0];
			String countryCode = row[4];

			citiesAndIDs.put(city + "," + countryCode, id);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == view.GET_WEATHER_COMMAND) {
			String currentCityAndCountryCode = view
					.getCurrentCityAndCountryCode();
			String id = citiesAndIDs.get(currentCityAndCountryCode);

			try {
				IWeatherDataService service = WeatherDataServiceFactory
						.getWeatherDataService(WeatherDataServiceFactory.OPEN_WEATHER_MAP);
				WeatherData data = service.getWeatherData(new Location(id));
				view.DisplayWeatherData(data);
			} catch (Exception e1) {
				view.displayError(e1.getMessage());
			}

		}
	}
}
