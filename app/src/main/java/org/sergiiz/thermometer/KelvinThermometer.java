package org.sergiiz.thermometer;

/**
 * @author Sergii Zhuk
 *         Date: 30.03.2016
 *         Time: 0:37
 */

public class KelvinThermometer implements Thermometer {

	private float kelvinDeg;

	public KelvinThermometer(float celsius) {
		setCelsius(celsius);
	}

	@Override
	public void setCelsius(float celsius) {
		this.kelvinDeg = celsius + 273.15f;
	}

	@Override
	public float getValue() {
		return kelvinDeg;
	}

	@Override
	public String getSign() {
		return "K";
	}

}
