package com.icefrog.strollit.baseframework.util;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {

    /**
     * Base64解码
     */
    public static byte[] decode(String str) {
        Base64 base64 = new Base64();
        return base64.decode(str.getBytes());
    }

    /**
     * Base64解码
     */
    public static String decodeString(String str) {
        Base64 base64 = new Base64();
        return new String(base64.decode(str.getBytes()));
    }

    /**
     * Base64编码
     */
    public static String encode(byte[] b) {
        Base64 base64 = new Base64();
        return new String(base64.encode(b));
    }

    /**
     * Base64编码
     */
    public static byte[] encodeByte(byte[] b) {
        Base64 base64 = new Base64();
        return base64.encode(b);
    }
}
