package com.friendlyhacker;

import static com.friendlyhacker.Core.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Decrypter {

    enum DecrypterStatus {
        NOT_ENCRYPTED_FILE, SUCCESS, WRONG_PASSWORD
    }

    public static DecrypterStatus decrypt(File file, String password)
    throws FileNotFoundException, IOException{

        // hold text data from file
        String line;
        // 3 line hold encrypt information
        int numberOfLinesThatHoldInfo = 3;
        String[] encryptInfo = new String[numberOfLinesThatHoldInfo];
        // FileNotFoundException
        try (BufferedReader bufferedReader = 
            new BufferedReader(new FileReader(file))){
                // get encrypt information when encrypted file
            for(int i = 0; i < numberOfLinesThatHoldInfo; i++){
                if ((line = bufferedReader.readLine()) != null){
                    encryptInfo[i] = line;
                }else {
                    // if file don't have 3 lines
                    // -> it's not encrypted file
                    return DecrypterStatus.NOT_ENCRYPTED_FILE;   
                }
            }
            // check is encrypted file
            if (!encryptInfo[0].equals(generateSpaceEncryptionSign())){
                return DecrypterStatus.NOT_ENCRYPTED_FILE;
            }
            // check is password correct
            // line 2 is encrypted random password
            // turn it into original random password
            String randomPassword = toggleString(
                encryptInfo[1], 
                hashPassword(password));
            // get random password hash code
            // need for decrypt everything #2
            int randomPasswordHash = hashPassword(randomPassword);
            // line 3 is encrypted password
            // turn it to original password, after that
            // compare with input password
            if (!toggleString(encryptInfo[2], randomPasswordHash).equals(password)){
                return DecrypterStatus.WRONG_PASSWORD;
            }
            // config decrypt file
            // format: de.[filename]
            // de: stands for decryption
            String decryptedFilePath = new 
                StringBuilder(file.getParent())
                .append(System.getProperty("file.separator"))
                .append("de.")
                .append(file.getName())
                .toString();
            File decryptedFile = new File(decryptedFilePath);
            decryptedFile.createNewFile();
            // decrypt line by line, write to file via PrintWriter
            try(PrintWriter printWriter = 
                new PrintWriter(new FileWriter(decryptedFile))){
                while((line = bufferedReader.readLine()) != null){
                    printWriter.println(toggleString(line, randomPasswordHash));
                }
                return DecrypterStatus.SUCCESS;
            }
        }
    }
}
