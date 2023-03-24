package classes;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AppFrame extends JFrame {
    private TitleBar titleBar;
    private List list;
    private ButtonPanel buttonPanel; 
    private JButton addTask;
    private JButton clear;

    //Constructor
    AppFrame() {
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        titleBar = new TitleBar();
        list = new List();
        buttonPanel = new ButtonPanel();
        this.add(titleBar, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(list, BorderLayout.CENTER);

        addTask = buttonPanel.getNewTask();
        clear = buttonPanel.getClear();
        addListeners();
    }

public void addListeners() {
    addTask.addMouseListener(new MouseAdapter() {
       @Override
       public void mousePressed(MouseEvent e) {
        Task task = new Task();
        list.add(task);
        // list.updateNumbers();
        task.getTaskName().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                task.getTaskName().setText("");
            }
        
            @Override
            public void focusLost(FocusEvent e) {
                // Do nothing
            }
        });
        task.getDone().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                task.changeState();
            }
        });
        revalidate();
       } 
    });

    clear.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            list.removeCompleted();
            repaint();
        }
    });
}
}

