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
public class TestBase extends Base {

    private static final String PASSWORD_FOR_TEST = "9mfkF.YU7=}:";
    private static final String CHARACTER_LIST = " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\t";

    /* ============== Test Methods Goes Here ============== */
    public static void testToggleChar() {
        System.out.println("toggle_char: Start test");
        boolean is_passed = true;
        int hash_code = hash_password(PASSWORD_FOR_TEST);
        for (int i = 0; i < CHARACTER_LIST.length(); i++) {
            char encrypted_char = toggle_char(CHARACTER_LIST.charAt(i), hash_code);
            char original_char = toggle_char(encrypted_char, hash_code);
            if (original_char == CHARACTER_LIST.charAt(i)); else {
                is_passed = false;
                System.out.printf("%d - %d\n",
                        CHARACTER_LIST.indexOf(original_char), i);
            }
        }
        if (is_passed) {
            System.out.println("toggle_char: End test -> Passed.");
        }
    }

    public static void testToggleString() {
        System.out.println("toggle_string: Start test");
        boolean is_passed = true;
        int hash_code = hash_password(PASSWORD_FOR_TEST);
        String source = "Republic of Viet Nam - Viet Nam Cong Hoa";
        String encrypted_string;
        encrypted_string = toggle_string(source, hash_code);
        encrypted_string = toggle_string(encrypted_string, hash_code);
        if (encrypted_string.equals(source)); else {
            System.out.printf("%s - %s\n", source, encrypted_string);
        }
        if (is_passed) {
            System.out.println("toggle_string: End test -> Passed.");
        }
    }

}
