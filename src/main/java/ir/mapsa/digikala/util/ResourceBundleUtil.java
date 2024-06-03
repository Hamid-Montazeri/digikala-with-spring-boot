package ir.mapsa.digikala.util;

import java.util.ResourceBundle;

public class ResourceBundleUtil {

    public static String getExceptionMessage(String key) {
        return ResourceBundle.getBundle("exceptions").getString(key);
    }

}
