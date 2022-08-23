package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.PasswordValidator;

public class PasswordValidatorTest {

	private static PasswordValidator passwordValidator;

	@BeforeClass
	public static void setUp() {
		passwordValidator = new PasswordValidator();
	}

	@Test
	public void validatePasswordValidPassword() throws InfyAcademyException {
		boolean actualPass = passwordValidator.validatePassword("Biswa@123");
		boolean expectedPass = false;
		assertEquals(actualPass, expectedPass);
	}

	@Test
	public void validatePasswordInvalidPassword() throws InfyAcademyException {
		boolean actualPass = passwordValidator.validatePassword("Biswa12");
		boolean expectedPass = false;
		assertEquals(actualPass, expectedPass);
	}

	@Test
	public void validatePasswordInvalidPasswordException() throws InfyAcademyException {
		assertThrows(InfyAcademyException.class,
	            ()->{
	            	passwordValidator.validatePassword(null);
	            });
	
	}

	@ParameterizedTest
	@ValueSource(strings = { "BiswaBhatt","Citiustech","Citiustech@123456","MyPassword@98765" })
	public void validatePasswordParameterizedPassword(String abc) throws InfyAcademyException {
		assertNotNull(abc);
	}

	@AfterClass
	public static void teardown() {
		passwordValidator = null;
	}

}