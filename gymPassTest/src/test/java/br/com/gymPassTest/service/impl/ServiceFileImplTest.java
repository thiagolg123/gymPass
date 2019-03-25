package br.com.gymPassTest.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.gymPassTest.contants.FileConstants;
import br.com.gymPassTest.service.ServiceFile;

public class ServiceFileImplTest {

	private ServiceFile serviceFile;

	@Before
	public void setUp() throws Exception {
		serviceFile = new ServiceFileImpl();
	}

	@Test
	public void testRead() throws Exception {
		System.out.println(serviceFile.read(FileConstants.PATH_OF_FILE));
		assertTrue(serviceFile.read(FileConstants.PATH_OF_FILE) != null);
	}

	@Test(expected = NullPointerException.class)
	public void testReadExpt() throws Exception {
		serviceFile.read(FileConstants.PATH_OF_FILE.concat("error"));
	}

}
