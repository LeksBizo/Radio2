import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class RadioTest {
        Radio radio = new Radio();
        @Test // Повышаем громкость
        public void increaseVolume() {
            radio.setCurrentVolume(5);
            radio.volumeUp();

            int expected = 6;
            int actual = radio.getCurrentVolume();

            Assertions.assertEquals(expected, actual);
        }

        @Test // Повышение громкости MAX +
        public void increaseVolumeMoreMax() {
            radio.setCurrentVolume(10);
            radio.volumeUp();

            int expected = 10;
            int actual = radio.getCurrentVolume();

            Assertions.assertEquals(expected, actual);
        }

        @Test //уменьшаем громкость
        public void decreaseVolume() {
            radio.setCurrentVolume(4);
            radio.volumeDown();

            int expected = 3;
            int actual = radio.getCurrentVolume();

            Assertions.assertEquals(expected, actual);
        }

        @Test // уменьшение громкости меньше 0
        public void decreaseVolumeLessMin() {
            radio.setCurrentVolume(0);
            radio.volumeDown();

            int expected = 0;
            int actual = radio.getCurrentVolume();

            Assertions.assertEquals(expected, actual);
        }

        @Test // обычный выбор станции
        public void setStation() {
            radio.setCurrentRadioStation(8);

            int expected = 8;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }

        @Test // станция больше MAX
        public void setStationMoreMax() {
            radio.setCurrentRadioStation(10);

            int expected = 0;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }

        @Test //Выбор станции меньше MIN
        public void setStationLessMin() {
            radio.setCurrentRadioStation(-1);

            int expected = 0;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }

        @Test // сл. станция
        public void nextStation() {
            radio.setCurrentRadioStation(3);
            radio.next();

            int expected = 4;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }
        @Test // следущая станция после максимума
        public void nextStationAfterMax() {
            radio.setCurrentRadioStation(9);
            radio.next();

            int expected = 0;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }
        @Test //предыдущая станция
        public void prevStation() {
            radio.setCurrentRadioStation(3);
            radio.prev();

            int expected = 2;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }
        @Test //предыдущая станция MIN
        public void prevStationAfterMin() {
            radio.setCurrentRadioStation(0);
            radio.prev();

            int expected = 9;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }
    }
