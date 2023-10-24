public class Radio {
    private int currentVolume;
    private int currentRadioStation;
    private int numberStation = 10;
    private int minStation = 0;
    private int maxStation = numberStation - 1;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio(int numberStation) {
        this.maxStation = numberStation - 1;
    }

    public Radio() {
    }

    public int getCurrentStation() {
        return currentRadioStation;
    }

    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < minStation) {
            return;
        }
        if (newCurrentStation > maxStation) {
            return;
        }
        currentRadioStation = newCurrentStation;
    }

    public void nextStation() {
        if (currentRadioStation < maxStation) {
            currentRadioStation = currentRadioStation + 1;
        } else {
            currentRadioStation = minStation; // переход счетчика после 9 на 0
        }
    }


    public void prevStation() {
        if (currentRadioStation > minStation) {
            currentRadioStation = currentRadioStation - 1;
        } else {
            currentRadioStation = maxStation; // переход счетчика после 0 на 9
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) { // указываем границы диапазона
        if (newCurrentVolume < minVolume) {
            return;
        }
        if (newCurrentVolume > maxVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }


    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        } else {
            currentVolume = maxVolume;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        } else {
            currentVolume = minVolume;
        }
    }
}