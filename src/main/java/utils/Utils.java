package utils;

import java.util.regex.Pattern;

public class Utils {

    private static final Pattern EMAIL_RE =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");


    public static boolean isEmail(String email) {
        return EMAIL_RE.matcher(email).matches();
    }

}
