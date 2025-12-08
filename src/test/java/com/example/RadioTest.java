package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void shouldCreateDefaultRadio() {
        Radio radio = new Radio();
        assertEquals(9, radio.getMaxStation());
    }

    @Test
    public void shouldCreateRadioWithCustomStationsCount() {
        Radio radio = new Radio(15);
        assertEquals(14, radio.getMaxStation());
    }

    @Test
    public void shouldThrowExceptionForInvalidStationsCount() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));
        assertThrows(IllegalArgumentException.class, () -> new Radio(-5));
    }

    @Test
    public void shouldSwitchToNextStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToZeroAfterMaxStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToPrevStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToMaxAfterZero() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetInvalidStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation()); // текущая станция осталась 0 (по умолчанию)
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAbove100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelow0() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}