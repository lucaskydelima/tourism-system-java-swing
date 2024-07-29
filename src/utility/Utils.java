package utility;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Utils {

    private static final Font FONT = new Font("SansSerif", Font.BOLD, 20);
    private static final Color COLOR = Color.GRAY;

    public static TitledBorder createBorder(String title) {
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(COLOR, 1),
                String.format(" %s ", title), TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FONT, COLOR);
    }
}
