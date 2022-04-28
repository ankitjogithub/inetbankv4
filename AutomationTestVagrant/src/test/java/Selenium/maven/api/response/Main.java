package Selenium.maven.api.response;

public class Main {

private Float temp;
private Integer pressure;
private Integer humidity;
private Float tempMin;
private Float tempMax;

/**
* No args constructor for use in serialization
*
*/
public Main() {
}

/**
*
* @param tempMax
* @param temp
* @param humidity
* @param pressure
* @param tempMin
*/
public Main(Float temp, Integer pressure, Integer humidity, Float tempMin, Float tempMax) {
super();
this.temp = temp;
this.pressure = pressure;
this.humidity = humidity;
this.tempMin = tempMin;
this.tempMax = tempMax;
}

public Float getTemp() {
return temp;
}

public void setTemp(Float temp) {
this.temp = temp;
}

public Integer getPressure() {
return pressure;
}

public void setPressure(Integer pressure) {
this.pressure = pressure;
}

public Integer getHumidity() {
return humidity;
}

public void setHumidity(Integer humidity) {
this.humidity = humidity;
}

public Float getTempMin() {
return tempMin;
}

public void setTempMin(Float tempMin) {
this.tempMin = tempMin;
}

public Float getTempMax() {
return tempMax;
}

public void setTempMax(Float tempMax) {
this.tempMax = tempMax;
}

}