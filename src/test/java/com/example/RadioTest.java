package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldNotSetStationAboveNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToZeroFromNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void shouldSwitchToNineFromZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldSetValidVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolumeBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(-1);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void shouldNotSetVolumeAbove100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.setCurrentVolume(101);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolumeAbove100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolumeBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void shouldHandleBoundaryStations() {
        Radio radio = new Radio();

        // Test from 0 to 9
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());

        // Test switching from 9 to 0
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());

        // Test switching from 0 to 9
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void shouldHandleBoundaryVolumes() {
        Radio radio = new Radio();

        // Test min and max volume
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());

        radio.setCurrentVolume(100);
        assertEquals(100, radio.getCurrentVolume());

        // Test that volume doesn't go below 0
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());

        // Test that volume doesn't go above 100
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldMaintainStateAfterMultipleOperations() {
        Radio radio = new Radio();

        // Set initial state
        radio.setCurrentStation(5);
        radio.setCurrentVolume(50);

        // Perform multiple operations
        radio.nextStation();
        radio.increaseVolume();
        radio.increaseVolume();
        radio.nextStation();
        radio.decreaseVolume();

        assertEquals(7, radio.getCurrentStation());
        assertEquals(51, radio.getCurrentVolume());
    }
}