/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.friendlyhacker;

/**
 *
 * @author HuynhVanTai
 */
import java.util.Random;

public class Core {

    private static final String CHARACTER_LIST = " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\t";
    private static final int LENGTH_OF_CHARACTER_LIST = CHARACTER_LIST.length();

    /**
     * Turn original char to encrypted char and vice versa
     */
    protected static char toggle_char(char input_char, int hash_code) {
        int index = CHARACTER_LIST.indexOf(input_char);
        return CHARACTER_LIST.charAt((hash_code - index) % LENGTH_OF_CHARACTER_LIST);
    }

    /**
     * Generate random string password
     */
    protected static String generate_random_password() {
        String output = "";
        int password_length = 34;
        for (int i = 0; i < password_length; i++) {
            int random_index = new Random().nextInt(LENGTH_OF_CHARACTER_LIST);
            output += CHARACTER_LIST.charAt(random_index);
        }
        return output;
    }

    /**
     * Hash string password
     * @return hashcode in range(max_index(CHARACTER_LIST); max_index(CHARACTER_LIST) * 2)
     */
    protected static int hash_password(String password) {
        int hash_code, sum = 0;
        for (int i = 0; i < password.length(); i++) {
            sum += password.charAt(i);
        }
        hash_code = (sum % LENGTH_OF_CHARACTER_LIST) + LENGTH_OF_CHARACTER_LIST - 1;
        return hash_code;
    }

    /**
     * Turn original string to encrypted string and vice versa
     */
    protected static String toggle_string(String input_str, int hash_code) {
        String output = "";
        for (int i = 0; i < input_str.length(); i++) {
            output += toggle_char(input_str.charAt(i), hash_code);
        }
        return output;
    }

    /**
     * Generate Space Encryption Sign 
     * - place on top of file to decribe it's encrypted file
     */
    protected static String generate_space_encryption_sign() {
        String space_encryption = "Space Encryption - Friendly Hacker";
        return toggle_string(space_encryption, hash_password(space_encryption));
    }
}
