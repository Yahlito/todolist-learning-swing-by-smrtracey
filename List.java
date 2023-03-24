package classes;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;  
import java.awt.Component;
public class List extends JPanel {

    //Constructor 
    List() {
        GridLayout layout = new GridLayout(10, 0);
        layout.setVgap(5);

        this.setLayout(layout);

    }
    // public void updateNumbers() {
    //     Component[] listItems = this.getComponents();
    // }

    //     for (int i=0;i<listItems.length; i++) {
    //         if (listItems[i] instanceof Task) {
    //             ((Task)listItems[i]).changeIndex(i+1);
    //         }
    //     }
    // }

    public void removeCompleted() {
        for (Component c : getComponents()) {
            if (c instanceof Task) {
                if (((Task)c).getState()) {
                    remove(c);
                    revalidate();
                }
            }
        }
    }
}
    
