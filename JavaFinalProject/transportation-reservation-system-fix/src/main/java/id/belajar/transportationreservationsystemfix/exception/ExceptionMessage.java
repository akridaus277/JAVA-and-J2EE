package id.belajar.transportationreservationsystemfix.exception;



public class ExceptionMessage extends Exception {
	
//	public static RuntimeException throwException(String messageTemplate, String... args) {
//        return new RuntimeException(format(messageTemplate, args));
//    }
//	
	public ExceptionMessage(String template, String... args) {
		super(String.format(template, (Object[]) args));
	}
	
	public static String format(String template, String ... args) {

        return String.format(template, (Object[]) args);
    }
}
