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

    protected static char toggle_char(char input_char, int hash_code) {
        /**
         * If you pass original char, it becomes encrypted char and vice versa.
         */
        int index = CHARACTER_LIST.indexOf(input_char);
        return CHARACTER_LIST.charAt((hash_code - index) % LENGTH_OF_CHARACTER_LIST);
    }

    protected static String generate_random_password() {
        /**
         * Generate string password based on CHARACTER_LIST.
         */
        String output = "";
        int password_length = 34;
        for (int i = 0; i < password_length; i++) {
            int random_index = new Random().nextInt(LENGTH_OF_CHARACTER_LIST);
            output += CHARACTER_LIST.charAt(random_index);
        }
        return output;
    }

    protected static int hash_password(String password) {
        /**
         * Output: an integer in between [max_index(CHARACTER_LIST) and
         * max_index(CHARACTER_LIST) * 2].
         *
         */
        int hash_code, sum = 0;
        for (int i = 0; i < password.length(); i++) {
            sum += password.charAt(i);
        }
        hash_code = (sum % LENGTH_OF_CHARACTER_LIST) + LENGTH_OF_CHARACTER_LIST - 1;
        return hash_code;
    }

    protected static String toggle_string(String input_str, int hash_code) {
        /**
         * If you pass original string, it becomes encrypted string and vice
         * versa.
         */
        String output = "";
        for (int i = 0; i < input_str.length(); i++) {
            output += toggle_char(input_str.charAt(i), hash_code);
        }
        return output;
    }

    protected static String generate_space_encryption_hash() {
        /**
         * Content appear at the top of file to describe this file is encrypted
         * by Space Encryption.
         */
        String space_encryption = "Space Encryption - Friendly Hacker";
        return toggle_string(space_encryption, hash_password(space_encryption));
    }
}
