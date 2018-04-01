package validators;

public class Validator {
    private static String regex ="[a-z A-Z]+";
    public static boolean validateName(String name){
            return name.matches(regex);
    }
//    public static boolean validateId()

}
