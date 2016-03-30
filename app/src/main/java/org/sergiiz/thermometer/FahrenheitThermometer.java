package org.sergiiz.thermometer;

import static org.sergiiz.thermometer.Constants.DEGREE;

/**
 * @author Sergii Zhuk
 *         Date: 30.03.2016
 *         Time: 0:42
 */

public class FahrenheitThermometer implements Thermometer {

	private float fahrenheitDeg;

	public FahrenheitThermometer(float celsius) {
		setCelsius(celsius);
	}

	@Override
	public void setCelsius(float celsius) {
		fahrenheitDeg = celsius * 9 / 5 + 32f;
	}

	@Override
	public float getValue() {
		return fahrenheitDeg;
	}

	@Override
	public String getSign() {
		return DEGREE + "F";
	}
}