package com.friendlyhacker.i18n.notifications;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NNotifications {

    private static final String NOTIFICATION_LOCATION = "com.friendlyhacker.i18n.notifications.Notifications";
    // declare components text
    public static String pleaseSelectFileText = "";
    public static String encryptSuccessText = "";
    public static String decryptSuccessText = "";
    public static String encryptFailText = "";
    public static String decryptFailText = "";
    public static String encryptingText = "";
    public static String decryptingText = "";
    public static String alreadyEncryptedText = "";
    public static String notEncryptedFileText = "";
    public static String wrongPasswordText = "";
    public static String fileNotFoundText = "";
    public static String aboutAppText = "";

    public static void setLanguage(Locale locale){
        ResourceBundle notifications;
        notifications = ResourceBundle.getBundle(
            NOTIFICATION_LOCATION,
                locale
        );
        pleaseSelectFileText = notifications.getString("pleaseSelectFile");
        encryptSuccessText = notifications.getString("encryptSuccess");
        decryptSuccessText = notifications.getString("decryptSuccess");
        encryptFailText = notifications.getString("encryptFail");
        decryptFailText = notifications.getString("decryptFail");
        encryptingText = notifications.getString("encrypting");
        decryptingText = notifications.getString("decrypting");
        alreadyEncryptedText = notifications.getString("alreadyEncrypted");
        notEncryptedFileText = notifications.getString("notEncryptedFile");
        wrongPasswordText = notifications.getString("wrongPassword");
        fileNotFoundText = notifications.getString("fileNotFound");
        aboutAppText = notifications.getString("aboutApp");
    }
}
