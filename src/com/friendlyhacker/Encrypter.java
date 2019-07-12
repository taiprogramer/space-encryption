package com.friendlyhacker;

import static com.friendlyhacker.Core.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Encrypter {

    enum EncryptionStatus {
        ALREADY_ENCRYPTED, SUCCESS
    }

    public static EncryptionStatus encrypt(File file, String password)
    throws FileNotFoundException, IOException {
        // hold data that read from file.
        String line; 
        // FileNotFoundException
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            // check is encrypted file
            // IOException
            if ((line = bufferedReader.readLine()) != null){
                if (line.equals(generateSpaceEncryptionSign())){
                    return EncryptionStatus.ALREADY_ENCRYPTED;
                }
            }else {
                throw new IOException();
            }
            // config encrypted file
            // format: sefh.[filename]
            // sefh: stands for Space Encryption Friendly Hacker
            String encryptedFilePath = new 
                StringBuilder(file.getParent())
                .append(System.getProperty("file.separator"))
                .append("sefh.")
                .append(file.getName())
                .toString();
            File encryptedFile = new File(encryptedFilePath);
            encryptedFile.createNewFile();
            // __Get encrypt information
            String randomPassword = generateRandomPassword();
            // encrypted random password via hash code of password -> #1
            String encryptedRandomPassword = toggleString(randomPassword, hashPassword(password)); 
            // get random password hash for encrypt everything còn lại :D
            // such as: password, content of file -> #2
            int randomPasswordHash = hashPassword(randomPassword);
            // encrypted line by line, write to file via PrintWriter
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(encryptedFile))){
                /* __Write encrypt information
                *  - line 1: Space Encryption Sign to describe this file is encrypted
                *  - line 2: encrypted random password (encryped based on #1)
                *  - line 3: encrypted password (encrypted based on #2)
                */
                printWriter.println(generateSpaceEncryptionSign());
                printWriter.println(encryptedRandomPassword);
                printWriter.println(toggleString(password, randomPasswordHash));

                while((line = bufferedReader.readLine()) != null){
                    printWriter.println(toggleString(line, randomPasswordHash));
                }
                return EncryptionStatus.SUCCESS;
            }
        }
    }
}
