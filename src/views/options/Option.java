package views.options;

import views.MainScreen;

import javax.swing.*;

public class Option {

    public static void showInformationMessage(String message, String title) {
        JOptionPane.showMessageDialog(MainScreen.getInstance(), message,
                title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(MainScreen.getInstance(), message,
                title, JOptionPane.ERROR_MESSAGE);
    }

    public static int showConfirmDialog(String message, String title) {
        return JOptionPane.showConfirmDialog(MainScreen.getInstance(), message,
                title, JOptionPane.YES_NO_OPTION);
    }
}
