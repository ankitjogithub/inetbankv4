package Selenium.maven.api.response;

import java.util.List;

public class PositiveResponseWeatherDTO {

	private Coord coord;
	private List<Weather> weather = null;
	private String base;
	private Main main;
	private Integer visibility;
	private Wind wind;
	private Clouds clouds;
	private Integer dt;
	private Sys sys;
	private Integer id;
	private String name;
	private Integer cod;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public PositiveResponseWeatherDTO() {
	}

	/**
	 *
	 * @param dt
	 * @param coord
	 * @param visibility
	 * @param weather
	 * @param name
	 * @param cod
	 * @param main
	 * @param clouds
	 * @param id
	 * @param sys
	 * @param base
	 * @param wind
	 */
	public PositiveResponseWeatherDTO(Coord coord, List<Weather> weather, String base, Main main, Integer visibility,
			Wind wind, Clouds clouds, Integer dt, Sys sys, Integer id, String name, Integer cod) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.base = base;
		this.main = main;
		this.visibility = visibility;
		this.wind = wind;
		this.clouds = clouds;
		this.dt = dt;
		this.sys = sys;
		this.id = id;
		this.name = name;
		this.cod = cod;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Integer getDt() {
		return dt;
	}

	public void setDt(Integer dt) {
		this.dt = dt;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

}