package br.com.gymPassTest.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.gymPassTest.service.OrganizedResult;
import br.com.gymPassTest.vo.RacingResult;
import br.com.gymPassTest.vo.RacingStatus;
/*
 * A partir de um input de um arquivo de log do formato acima, montar o
 * resultado da corrida com as seguintes informações: Posição Chegada, Código
 * Piloto, Nome Piloto, Qtde Voltas Completadas e Tempo Total de Prova.
 * 
 * A corrida termina quando o primeiro colocado completa 4 voltas - OK
 * 
 */

public class OrganizedResultImpl implements OrganizedResult {

	@Override
	public List<RacingResult> organizeAsList(List<RacingStatus> listRunStatus) {
		// if needed all laps
		List<RacingStatus> organazedRacingStatus = new ArrayList<RacingStatus>();
		List<RacingResult> racingResult = new ArrayList<RacingResult>();

		for (int laps = 4; laps >= 1; laps--) {
			int desCapslaps = laps;
			organazedRacingStatus.addAll(listRunStatus.stream()
					.filter(result -> result.getNumberOfLaps().intValue() == desCapslaps).collect(Collectors.toList()));
		}

		List<RacingStatus> listOfRSClassify = sortListClassify(organazedRacingStatus);

		int numberPosition = 1;
		for (RacingStatus racingStatus : listOfRSClassify) {
			RacingResult rr = new RacingResult();

			rr.setPosition(String.valueOf(numberPosition).concat("- ")); // ugly :(
			rr.setPilotCode(racingStatus.getCodPilot());
			rr.setPilotName(racingStatus.getNameOfPilot());
			rr.setFullLaps(String.valueOf(racingStatus.getNumberOfLaps()));
			rr.setTotalTime(racingStatus.getLapTime().toString());
			numberPosition++;
			racingResult.add(rr);
		}

		return racingResult;

	}

	private List<RacingStatus> sortListClassify(List<RacingStatus> organazedRacingStatus) {
		List<RacingStatus> listOfRSClassify = organazedRacingStatus.stream().filter(ors -> ors.getNumberOfLaps() == 4)
				.collect(Collectors.toList());

		listOfRSClassify.add(getLastPosition(organazedRacingStatus).get());
		listOfRSClassify.sort((RacingStatus o1, RacingStatus o2) -> o1.getHours().compareTo(o2.getHours()));
		return listOfRSClassify;
	}

	private Optional<RacingStatus> getLastPosition(List<RacingStatus> organazedRacingStatus) {
		List<RacingStatus> listOfRSTreeLaps = organazedRacingStatus.stream().filter(ors -> ors.getNumberOfLaps() == 3)
				.collect(Collectors.toList());
		List<LocalDateTime> listOfTimes = new ArrayList<LocalDateTime>();

		for (RacingStatus racingStatus : listOfRSTreeLaps) {
			listOfTimes.add(racingStatus.getHours());
		}

		// data of last position
		Optional<RacingStatus> lastPosition = organazedRacingStatus.stream()
				.filter(ors -> ors.getHours().isEqual(listOfTimes.stream().max(LocalDateTime::compareTo).get()))
				.findFirst();

		return lastPosition;
	}
}
