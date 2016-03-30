package org.sergiiz.thermometer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Locale;

import static android.widget.Toast.makeText;
import static org.sergiiz.thermometer.Constants.FORMAT_TEMPERATURE;

public class MainActivity extends AppCompatActivity {

	private SeekBar seekBar;

	float currentCelsius = 0;
	final Thermometer kelvinThermometer = new KelvinThermometer(currentCelsius);
	final Thermometer fahrenheitThermometer = new FahrenheitThermometer(currentCelsius);

	private static final int TEMPERATURE_MAX_VALUE_CELSIUS = 250; // min value will be 0 in this case

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EditText editCelsius = (EditText) findViewById(R.id.input_celsius);
		Button buttonFahrenheit = (Button) findViewById(R.id.button_fahrenheit);
		Button buttonKelvin = (Button) findViewById(R.id.button_kelvin);


		seekBar = (SeekBar) findViewById(R.id.seekbar);
		seekBar.setMax(TEMPERATURE_MAX_VALUE_CELSIUS);
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				currentCelsius = progress;
				editCelsius.setText(String.format(Locale.getDefault(), FORMAT_TEMPERATURE, currentCelsius));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				//empty
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				//empty
			}
		});

		seekBar.setProgress(TEMPERATURE_MAX_VALUE_CELSIUS / 2);

		buttonFahrenheit.setOnClickListener(view1 -> {
			fahrenheitThermometer.setCelsius(currentCelsius);
			String text = fahrenheitThermometer.getFormattedValue();
			makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
		});

		buttonKelvin.setOnClickListener(view1 -> {
			kelvinThermometer.setCelsius(currentCelsius);
			makeText(MainActivity.this, kelvinThermometer.getFormattedValue(), Toast.LENGTH_SHORT).show();
		});

	}
}
