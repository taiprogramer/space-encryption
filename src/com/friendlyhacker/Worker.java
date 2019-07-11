/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.friendlyhacker;

import static com.friendlyhacker.Core.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HuynhVanTai
 */
public class Worker {

    public static boolean isEncryptedFile(File file) {
        boolean output = false;
        String line;
        String space_encryption_hash = generateSpaceEncryptionSign();
        try {
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(new FileReader(file));

            if ((line = bufferedReader.readLine()) != null && line.equals(space_encryption_hash)) {
                output = true;
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + file + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + file + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        return output;
    }

    public static boolean startEncrypt(File file, String password) {
        /* Configuration */
        String space_encryption_hash = generateSpaceEncryptionSign();
        String random_password = generateRandomPassword();
        String encrypted_random_password, encrypted_password;
        int password_hash = hashPassword(password); // #1
        int random_password_hash = hashPassword(random_password); // #2

        encrypted_random_password = toggleString(random_password, password_hash);
        encrypted_password = toggleString(password, random_password_hash);

        String file_separator = System.getProperty("file.separator");
        String encrypted_file_path = file.getParent()
                .concat(file_separator)
                .concat("sefh.")
                .concat(file.getName());
        // sefh stands for Space Encryption Friendly Hacker

        File encrypted_file = new File(encrypted_file_path);
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        /* Start encrypting & writting content to file */
        try {
            String line; // line reading from file
            String encrypted_line;
            encrypted_file.createNewFile();
            printWriter = new PrintWriter(new FileWriter(encrypted_file));
            bufferedReader = new BufferedReader(new FileReader(file));

            // write information to output file
            printWriter.println(space_encryption_hash);
            printWriter.println(encrypted_random_password);
            printWriter.println(encrypted_password);

            while ((line = bufferedReader.readLine()) != null) {
                encrypted_line = toggleString(line, random_password_hash);
                printWriter.println(encrypted_line);
            }

            printWriter.close();
            bufferedReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean isPasswordCorrect(File file, String user_password) {
        boolean output = false;
        String encrypted_random_password;
        String original_random_password;
        String encrypted_password;
        String original_password;
        int user_password_hash = hashPassword(user_password); // #1
        int random_password_hash; // #2

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            // first line is Space Encryption Hash
            bufferedReader.readLine();
            encrypted_random_password = bufferedReader.readLine();
            encrypted_password = bufferedReader.readLine();

            original_random_password = toggleString(
                    encrypted_random_password,
                    user_password_hash
            );
            random_password_hash = hashPassword(original_random_password);

            original_password = toggleString(
                    encrypted_password,
                    random_password_hash
            );
            if (original_password.equals(user_password)) {
                output = true;
            };
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    public static boolean startDecrypt(File file, String password) {
        /* Configuration */
        String encrypted_random_password, original_random_password;
        int password_hash = hashPassword(password); // #1
        int random_password_hash; // #2
        String decrypted_file_path = file.getPath();
        decrypted_file_path = decrypted_file_path.replaceAll("sefh", "de");

        File decrypted_file = new File(decrypted_file_path);
        PrintWriter printWriter;
        BufferedReader bufferedReader;

        try {
            String line;
            decrypted_file.createNewFile();
            bufferedReader = new BufferedReader(new FileReader(file));
            printWriter = new PrintWriter(new FileWriter(decrypted_file));
            // first line is Space Encryption Hash
            bufferedReader.readLine();
            encrypted_random_password = bufferedReader.readLine();
            bufferedReader.readLine(); // this is password line
            original_random_password = toggleString(
                    encrypted_random_password,
                    password_hash
            );
            random_password_hash = hashPassword(original_random_password);
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(toggleString(line, random_password_hash));
            }
            printWriter.close();
            bufferedReader.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
