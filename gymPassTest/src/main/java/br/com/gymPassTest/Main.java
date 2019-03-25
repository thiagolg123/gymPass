package br.com.gymPassTest;

import java.util.List;

import br.com.gymPassTest.contants.FileConstants;
import br.com.gymPassTest.service.OrganizedResult;
import br.com.gymPassTest.service.ServiceFile;
import br.com.gymPassTest.service.TransformRunStatus;
import br.com.gymPassTest.service.impl.OrganizedResultImpl;
import br.com.gymPassTest.service.impl.ServiceFileImpl;
import br.com.gymPassTest.service.impl.TransformRunStatusImpl;
import br.com.gymPassTest.vo.RacingResult;
import br.com.gymPassTest.vo.RacingStatus;

public class Main {

	public static void main(String[] args) {
		ServiceFile serviceFile = new ServiceFileImpl();
		TransformRunStatus transformRunStatus = new TransformRunStatusImpl();
		OrganizedResult organizedResult = new OrganizedResultImpl();

		String contentFile = serviceFile.read(FileConstants.PATH_OF_FILE);
		String[] slitedStatus = serviceFile.split(contentFile);

		List<RacingStatus> listRunStatus = transformRunStatus.transform(slitedStatus);

		List<RacingResult> racingResult = organizedResult.organizeAsList(listRunStatus);

		for (RacingResult rr : racingResult) {
			System.out.print("Posição Chegada: " + rr.getPosition());
			System.out.print("Codigo do piloto: " + rr.getPilotCode());
			System.out.print(" Nome do piloto: " + rr.getPilotName());
			System.out.print(" Total de voltas: " + rr.getFullLaps());
			// falta somar os tempos e formatar, acabei ficando sem tempo :s
			System.out.println(" Total de voltas: " + rr.getTotalTime());
		}
	}
}