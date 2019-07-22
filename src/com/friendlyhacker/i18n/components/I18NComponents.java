package com.friendlyhacker.i18n.components;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class I18NComponents {

    private static final String COMPONENT_LOCATION = "com.friendlyhacker.i18n.components.Components";

    public static void setLanguage(Locale locale, ArrayList<JComponent> components){
        ResourceBundle rbComponents;
        rbComponents = ResourceBundle.getBundle(
                COMPONENT_LOCATION,
                locale
        );
        for(JComponent component : components){
            if (component instanceof JMenu){
                ((JMenu) component).setText(rbComponents.getString(component.getName()));
            } else if (component instanceof JMenuItem){
                ((JMenuItem) component).setText(rbComponents.getString(component.getName()));
            } else if (component instanceof JRadioButtonMenuItem){
                ((JRadioButtonMenuItem) component).setText(rbComponents.getString(component.getName()));
            } else if (component instanceof JButton){
                ((JButton) component).setText(rbComponents.getString(component.getName()));
            } else if (component instanceof JLabel){
                ((JLabel) component).setText(rbComponents.getString(component.getName()));
            }
        }
    }
}
