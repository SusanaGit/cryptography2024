package com.susanafigueroa;

public class Util {

    public static String bytesToHex(byte[] hashBytes) {
        StringBuilder sb = new StringBuilder();
        for (byte hashByte : hashBytes) {
            sb.append(String.format("%02X", hashByte));
        }
        return sb.toString();
    }
}
