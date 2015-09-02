package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

	/**
	 * key is city+countrycode, value is city-ID
	 */
	Hashtable<String, String> citiesAndIDs;

	public MainApplicationController() throws IOException {
		citiesAndIDs = new Hashtable<String, String>();

		// read all the cities and their IDs from city_list.txt file to the
		// citiesAndIDs hashtable.
		readCitiesAndIDsFromFile();
		// take only the cities column from the citiesAndIDs hashtable.
		ArrayList<String> cities = getSortedCitiesList();

		// create view (without showing anything), giving this class as actionlistener + list of cities (for the combobox)
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

		// sort the cities list according to ABC... (mergesort: nlog(n))
		Collections.sort(cities);

		return cities;
	}

	public void control() {
		// only display our main window.
		view.displayMainWindow();
	}

	private void readCitiesAndIDsFromFile() throws IOException {
		Path path = FileSystems.getDefault()
				.getPath("resources\\city_list.txt");
		// read the file into lines
		List<String> lines = Files.readAllLines(path);

		for (Iterator<String> iterator = lines.iterator(); iterator.hasNext();) {
			String line = (String) iterator.next();
			// split each line - seperated by tab
			String[] row = line.split("\t");

			String city = row[1];
			String id = row[0];
			String countryCode = row[4];

			// put the result into our hashtable.
			citiesAndIDs.put(city + "," + countryCode, id);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// check what action happened
			if (e.getActionCommand() == view.GET_WEATHER_COMMAND) {
				// get the current selected city from the view (from the combobox)
				String currentCityAndCountryCode = view.getCurrentCityAndCountryCode();
				// get the city-id by using current city and country code (with hashtable)
				String id = citiesAndIDs.get(currentCityAndCountryCode);

				// get the service from the factory (singleton)
				IWeatherDataService service = WeatherDataServiceFactory
						.getWeatherDataService(WeatherDataServiceFactory.OPEN_WEATHER_MAP);
				// go to the internet and get the weather data (by city-id)
				WeatherData data = service.getWeatherData(new Location(id));
				// display the weather data model on the screen.
				view.displayWeatherData(data);
			}
		} catch (Exception e1) {
			// any exception is shown on screen.
			view.displayError(e1.getMessage());
		}
	}
}
