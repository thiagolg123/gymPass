package br.com.gymPassTest.vo;

import java.time.LocalDateTime;

public class RacingStatus {

	private LocalDateTime hours;
	private String codPilot;
	private String nameOfPilot;
	private Integer numberOfLaps;
	private LocalDateTime lapTime;
	private String averageSpeed;

	public LocalDateTime getHours() {
		return hours;
	}

	public void setHours(LocalDateTime hours) {
		this.hours = hours;
	}

	public String getCodPilot() {
		return codPilot;
	}

	public void setCodPilot(String codPilot) {
		this.codPilot = codPilot;
	}

	public Integer getNumberOfLaps() {
		return numberOfLaps;
	}

	public void setNumberOfLaps(Integer numberOfLaps) {
		this.numberOfLaps = numberOfLaps;
	}

	public LocalDateTime getLapTime() {
		return lapTime;
	}

	public void setLapTime(LocalDateTime lapTime) {
		this.lapTime = lapTime;
	}

	public String getNameOfPilot() {
		return nameOfPilot;
	}

	public void setNameOfPilot(String nameOfPilot) {
		this.nameOfPilot = nameOfPilot;
	}

	public String getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(String averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

}
