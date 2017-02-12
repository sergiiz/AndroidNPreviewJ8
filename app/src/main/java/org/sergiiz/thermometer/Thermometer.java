package org.sergiiz.thermometer;

import java.util.Locale;

/**
 * @author Sergii Zhuk
 *         Date: 30.03.2016
 *         Time: 0:22
 */

interface Thermometer {

	void setCelsius(final float celsiusValue);

	float getValue();

	String getSign();

	default String getFormattedValue(){
		return String.format(Locale.getDefault(),
				"The temperature is %.2f %s",
				getValue(), getSign());
	}
}
