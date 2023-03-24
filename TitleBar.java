package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class TitleBar extends JPanel {

    //Constructor 
    TitleBar() {
        this.setPreferredSize(new DimensionUIResource(400, 80));

        JLabel titleText = new JLabel("To Do List");
        titleText.setPreferredSize(new Dimension(200, 80));
        titleText.setFont(new Font("Sanes-serif", Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleText);
    }
    
}
