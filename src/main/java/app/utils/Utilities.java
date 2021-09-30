package app.utils;

public class Utilities {

    public static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";

    public static String capitalizeString(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static String generateRandomPassword(int n) {

        StringBuilder passwordBuilder = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int randomIndex = (int) (ALPHANUMERIC_STRING.length() * Math.random());
            passwordBuilder.append(ALPHANUMERIC_STRING.charAt(randomIndex));
        }

        return passwordBuilder.toString();
    }
}
