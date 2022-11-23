package validators;

import exceptions.InvalidDayException;
import exceptions.InvalidFourDigitsException;
import exceptions.InvalidHourException;
import exceptions.InvalidMonthException;
import exceptions.InvalidNumberException;
import exceptions.InvalidTwoDigitsException;
import exceptions.InvalidYearException;

import java.time.LocalDateTime;
import java.time.Month;



public class DateValidator {
   public Month monthValidator (String month) throws InvalidMonthException {
	   try {
		    Month resultMonth = Month.valueOf(month.toUpperCase());
		    return resultMonth;
	   }
	   catch (Exception e) {
		   throw new InvalidMonthException(month);
	   }
	  
   }
   
   public LocalDateTime dateTimeConverter (Month month, int day, int year, int hour, int minute) {
	   LocalDateTime dateTime = LocalDateTime.of(year, month, day,hour, minute);
	   return dateTime;
   }
   
   public int dayValidator (String value) throws InvalidTwoDigitsException, InvalidDayException, InvalidNumberException {
	   validateTwoDigits(value);
	   int number = convertToNumber(value);
	   if (number > 0 && number <= 31) {
		   return number;
	   }
	   else {
		   throw new InvalidDayException();
	   }
	   
   }
   
   public int hourValidator (String value) throws InvalidTwoDigitsException, InvalidHourException, InvalidNumberException {
	   validateTwoDigits(value);
	   int number = convertToNumber(value);
	   if (number > 0 && number <= 23) {
		   return number;
	   }
	   else {
		   throw new InvalidHourException();
	   }
	   
   }
   
   public int yearValidator (String value) throws InvalidFourDigitsException, InvalidNumberException, InvalidYearException {
	   validateFourDigits(value);
	   int number = convertToNumber(value);
	   if (number > 2000 && number <= 3000) {
		   return number;
	   }
	   else {
		   throw new InvalidYearException();
	   }
	   
   }
   
   public int minuteValidator (String value) throws InvalidTwoDigitsException, InvalidHourException, InvalidNumberException {
	   validateTwoDigits(value);
	   int number = convertToNumber(value);
	   if (number > 0 && number <= 59) {
		   return number;
	   }
	   else {
		   throw new InvalidHourException();
	   }
	   
   }
   
   public int convertToNumber (String value) throws InvalidNumberException {
	    try {
			  return Integer.parseInt(value);
		   }
		   catch (Exception e) {
			   throw new InvalidNumberException();
		   }
		   
   }
   
   
   public void validateTwoDigits(String number) throws InvalidTwoDigitsException {
	   boolean isTwoDigit = number.trim().length() == 2;
	   if (!isTwoDigit) {
		   throw new InvalidTwoDigitsException(number);
	   }
	   
   }
   
   public void validateFourDigits(String number) throws InvalidFourDigitsException {
	   boolean isFourDigits = number.trim().length() == 4;
	   if (!isFourDigits) {
		   throw new InvalidFourDigitsException();
	   }
	   
   }
    
}
