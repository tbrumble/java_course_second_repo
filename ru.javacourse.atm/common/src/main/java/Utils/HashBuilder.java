package Utils;

import org.apache.commons.codec.digest.DigestUtils;

public class HashBuilder {
    public static String getStringHash(String stringValue) {
        return DigestUtils.md5Hex(stringValue);
    }
}
