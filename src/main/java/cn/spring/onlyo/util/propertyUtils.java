package cn.spring.onlyo.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.sun.security.ntlm.Client;

public class propertyUtils {

    private static Properties props = new Properties();
    static {
        try {

            props.load(propertyUtils.class.getClassLoader().getResourceAsStream("cpt.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            return null;
        } else {
            return value;
        }
    }
}
