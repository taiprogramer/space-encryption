package com.friendlyhacker.i18n.components;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NComponents {

    private static final String COMPONENT_LOCATION = "com.friendlyhacker.i18n.components.Components";
    // declare components text
    public static String jMenuFileText = "";
    public static String jMenuItemChooseFileText = "";
    public static String jMenuLanguageText = "";
    public static String jRadioButtonMenuItemVietnameseText = "";
    public static String jRadioButtonMenuItemEnglishText = "";
    public static String jMenuAboutText = "";
    public static String jLabelPasswordText = "";
    public static String jLabelStatusLabelText = "";
    public static String jButtonChooseFileText = "";
    public static String jButtonEncryptText = "";
    public static String jButtonDecryptText = "";

    public static void setLanguage(Locale locale){
        ResourceBundle components;
        components = ResourceBundle.getBundle(
                COMPONENT_LOCATION,
                locale
        );
        jMenuFileText = components.getString("jMenuFile");
        jMenuItemChooseFileText = components.getString("jMenuItemChooseFile");
        jMenuLanguageText = components.getString("jMenuLanguage");
        jRadioButtonMenuItemVietnameseText = components.getString("jRadioButtonMenuItemVietnamese");
        jRadioButtonMenuItemEnglishText = components.getString("jRadioButtonMenuItemEnglish");
        jMenuAboutText = components.getString("jMenuAbout");
        jLabelPasswordText = components.getString("jLabelPassword");
        jLabelStatusLabelText = components.getString("jLabelStatusLabel");
        jButtonChooseFileText = components.getString("jButtonChooseFile");
        jButtonEncryptText = components.getString("jButtonEncrypt");
        jButtonDecryptText = components.getString("jButtonDecrypt");
    }
}
