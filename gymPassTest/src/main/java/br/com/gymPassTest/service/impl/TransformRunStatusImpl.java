package br.com.gymPassTest.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.gymPassTest.service.TransformRunStatus;
import br.com.gymPassTest.vo.RacingStatus;

public class TransformRunStatusImpl implements TransformRunStatus {

	private static final String PATTERN_DATE_HOUR = "yyyy-MM-dd HH:mm:ss.SSS";
	private static final String ANY_DATE = "2019-03-24 "; // i need hour, only :)

	public List<RacingStatus> transform(String[] splitedStatus) {
		List<RacingStatus> runStatus = new ArrayList<RacingStatus>();
		String[] dataTransformed = {};
		DateTimeFormatter dateFormatterForHour = DateTimeFormatter.ofPattern(PATTERN_DATE_HOUR);

		for (int i = 1; i < splitedStatus.length; i++) {
			RacingStatus popStatus = new RacingStatus();

			dataTransformed = splitedStatus[i].split("\\s+");

			popStatus.setHours(LocalDateTime.parse(ANY_DATE + dataTransformed[0], dateFormatterForHour));
			popStatus.setCodPilot(dataTransformed[1]);
			popStatus.setNameOfPilot(dataTransformed[3]);
			popStatus.setNumberOfLaps(Integer.parseInt(dataTransformed[4]));
			popStatus.setLapTime(
					LocalDateTime.parse(ANY_DATE + (insertAt(dataTransformed[5], 0, "00:0")), dateFormatterForHour));
			popStatus.setAverageSpeed(dataTransformed[6]);

			runStatus.add(popStatus);

		}

		return runStatus;
	}

	/**
	 * I confess, i get this code </br>
	 * in
	 * https://stackoverflow.com/questions/5884353/insert-a-character-in-a-string-at-a-certain-position
	 * 
	 * @param target
	 * @param position
	 * @param insert
	 * @return string formatted
	 */
	private static String insertAt(final String target, final int position, final String insert) {
		final int targetLen = target.length();
		if (position < 0 || position > targetLen) {
			throw new IllegalArgumentException("position=" + position);
		}
		if (insert.isEmpty()) {
			return target;
		}
		if (position == 0) {
			return insert.concat(target);
		} else if (position == targetLen) {
			return target.concat(insert);
		}
		final int insertLen = insert.length();
		final char[] buffer = new char[targetLen + insertLen];
		target.getChars(0, position, buffer, 0);
		insert.getChars(0, insertLen, buffer, position);
		target.getChars(position, targetLen, buffer, position + insertLen);
		return new String(buffer);
	}

}