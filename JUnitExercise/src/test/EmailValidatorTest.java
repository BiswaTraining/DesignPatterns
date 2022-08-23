package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;


public class EmailValidatorTest {
	
	private EmailValidator emailValidator; 

	@BeforeEach
	public void setUp() {
		emailValidator = new EmailValidator();
	}
	
	@Test
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		
		boolean actualEmail=emailValidator.validateEmailId("hello@infy.com");
		boolean expectedValue=false;
		assertEquals(actualEmail,expectedValue);
	}

	@Test
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		boolean actualEmail=emailValidator.validateEmailId("biswa_bhatt@infy.org");
		boolean expectedValue=false;
		assertEquals(actualEmail,expectedValue);
	}

	@Test
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		 assertThrows(InfyAcademyException.class,
		            ()->{
		            	
		            	boolean actualEmail=emailValidator.validateEmailId(null);
		            });
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "biswa_bhatt","biswa_bhatt@infy.in","Junit_Testcase","BiswaBhatt@infy.com" })
	public void validateEmailIdParamterizedEmailId(String abc) throws InfyAcademyException {
		assertNotNull(abc);
	}
	
	@AfterEach
	public void teardown() {
		emailValidator = null;
	}
}
