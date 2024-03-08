import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Window extends JFrame{

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    Window() {
        this.setTitle("Clock");
        ImageIcon bgImage = new ImageIcon("icon.png");
        this.setIconImage(bgImage.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(350,210);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        timeLabel = new JLabel();
        dayLabel = new JLabel();
        dateLabel = new JLabel();

        timeLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50));
        dayLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));
        dateLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35));

        timeLabel.setForeground(Color.CYAN);
        dayLabel.setForeground(Color.CYAN);
        dateLabel.setForeground(Color.CYAN);

        this.add(dayLabel);
        this.add(timeLabel);
        this.add(dateLabel);
        this.setVisible(true);
        checkTime();
    }

    public void checkTime() {

        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            day = dayFormat.format(Calendar.getInstance().getTime());
            date = dateFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            dayLabel.setText(day);
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}