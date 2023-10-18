import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RadioTest {
    Radio radio = new Radio();

    //-----------------------------------------
    //Тесты на ГРОМКОСТЬ
    //-----------------------------------------

    @Test  // Прибавляем громкость с 4 на 5.
    public void increaseVolumeNormal() {
        radio.setCurrentVolume(4);
        radio.volumeUp();

        int expected = 5;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test // Уменьшаем громкость с 5 до 4
    public void decreaseVolumeNormal() {
        radio.setCurrentVolume(5);
        radio.volumeDown();

        int expected = 4;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test // громкость увеличиваем больше 100
    public void increaseVolumeTurnMax() {
        radio.setCurrentVolume(100);
        radio.volumeUp();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test // уменьшение громкости ниже 0
    public void decreaseVolumeMinTurn() {
        radio.setCurrentVolume(0);
        radio.volumeDown();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    //-----------------------------------------
    //Тесты на Станции
    //-----------------------------------------

    @Test // Установка станции на 9 канале
    public void setStationCurrent() {
        radio.setCurrentRadioStation(9);

        int expected = 9;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test //выставление станции больше максимума
    public void setStationOverMax() {
        radio.setCurrentRadioStation(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test //выставление станции меньше минимума
    public void setStationOverMin() {
        radio.setCurrentRadioStation(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test // переключение станции на одну вперед
    public void nextStation() {
        radio.setCurrentRadioStation(8);

        radio.next();

        int expected = 9;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }
    @Test // переключение станции на одну вперед при достижении максимального канала
    public void nextStationOverMax() {
        radio.setCurrentRadioStation(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }
    @Test // переключение на предыдущую станцию
    public void prevStation() {
        radio.setCurrentRadioStation(3);

        radio.prev();

        int expected = 2;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }
    @Test // переключение на предыдущую станцию после минимального значения
    public void prevStationOverMin() {
        radio.setCurrentRadioStation(0);

        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }
}
