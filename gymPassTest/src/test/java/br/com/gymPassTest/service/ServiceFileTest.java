package br.com.gymPassTest.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.gymPassTest.contants.FileConstants;
import br.com.gymPassTest.service.impl.ServiceFileImpl;

public class ServiceFileTest {

	private ServiceFile serviceFile;

	@Before
	public void setUp() throws Exception {
		serviceFile = new ServiceFileImpl();
	}

	@Test
	public void testSplit() {
		String[] splited = serviceFile.split(serviceFile.read(FileConstants.PATH_OF_FILE));

		assertTrue(splited[1] != null);
	}

}
