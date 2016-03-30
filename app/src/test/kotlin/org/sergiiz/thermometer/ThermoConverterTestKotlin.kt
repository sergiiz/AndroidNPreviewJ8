package org.sergiiz.thermometer

import org.junit.Assert.assertEquals
import org.junit.Test

class ThermoConverterTestKotlin {
    private val ALLOWED_DELTA = 0.01f

    @Test
    fun thermoTestLow() {
        val celsiusValue = -1000f
        val thermoModel = ThermoConverter.getTemperature(celsiusValue)
        assertEquals(celsiusValue, thermoModel.celsius, ALLOWED_DELTA)
        assertEquals(-1768f, thermoModel.fahrenheit, ALLOWED_DELTA)
        assertEquals(-726.85f, thermoModel.kelvin, ALLOWED_DELTA)
    }

    @Test
    fun thermoTestMid() {
        val celsiusValue = 232.778f
        val thermoModel = ThermoConverter.getTemperature(celsiusValue)
        assertEquals(celsiusValue, thermoModel.celsius, ALLOWED_DELTA)
        assertEquals(505.93f, thermoModel.kelvin, ALLOWED_DELTA)
        assertEquals(451f, thermoModel.fahrenheit, ALLOWED_DELTA)
    }

    @Test
    fun thermoTestXHigh() {
        val celsiusValue = 10000009f
        val thermoModel = ThermoConverter.getTemperature(celsiusValue)
        assertEquals(celsiusValue, thermoModel.celsius, ALLOWED_DELTA)
        assertEquals(10000282.15f, thermoModel.kelvin, ALLOWED_DELTA)
        assertEquals(18000048.2f, thermoModel.fahrenheit, ALLOWED_DELTA)
    }

}