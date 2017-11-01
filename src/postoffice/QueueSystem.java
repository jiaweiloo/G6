package postoffice;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.*;
import javax.swing.border.*;
import postoffice.Service;

public class QueueSystem extends JFrame {

  private JButton[] jbtCounterArr = new JButton[5];
  private JTextField[] jtfCallNumbersArr = new JTextField[4];
  private String callString = " --> Counter ";
  private JButton[] jbtButtonArr = new JButton[2];
  private String[] buttonStr = {"Pay Bills", "Misc. Transactions"};
  private JTextField jtfSlip = new JTextField(15);
  private JTextField jtfCurrentNo = new JTextField(15);
  // private JTextArea jtaSpace = new JTextArea(5, 20);
  private JButton jbtReport = new JButton("Print Analysis Report");
  private ArrayList<AudioClip> audioClips = new ArrayList<AudioClip>();
  private static int nextNo = 1201;
  private static int currentNo = nextNo - 1;
  private Queue<Service> q = new ArrayBlockingQueue<Service>(100);
  private String counterStr = "Counter ";
  private int counterNoIndex = counterStr.length();
  private ArrayList<Service> serviceList = new ArrayList<Service>();

  public QueueSystem() {
    initializeAudio();

    // North Panel: Buttons representing Counters
    Font counterFont = new Font("Arial", Font.BOLD, 20);
    JPanel counterPanel = new JPanel();
    CounterListener counterListener = new CounterListener();
    for (int i = 0; i < jbtCounterArr.length; ++i) {
      jbtCounterArr[i] = new JButton(counterStr + (i + 1));
      jbtCounterArr[i].setFont(counterFont);
      counterPanel.add(jbtCounterArr[i]);
      jbtCounterArr[i].addActionListener(counterListener);
    }
    add(counterPanel, BorderLayout.NORTH);

    // Center Panel: Textfields representing display of called numbers
    Font callFont = new Font("Arial", Font.BOLD, 24);
    LineBorder lineBorder = new LineBorder(Color.BLUE, 2, true);
    JPanel callPanel = new JPanel(new GridLayout(4, 1));
    callPanel.setBorder(lineBorder);
    for (int i = 0; i < jtfCallNumbersArr.length; ++i) {
      jtfCallNumbersArr[i] = new JTextField(80);
      jtfCallNumbersArr[i].setFont(callFont);
      jtfCallNumbersArr[i].setEditable(false);
      jtfCallNumbersArr[i].setHorizontalAlignment(SwingConstants.CENTER);
      callPanel.add(jtfCallNumbersArr[i]);
    }
    add(callPanel);

    Font labelFont = new Font("Cambria", Font.ITALIC, 30);

    JLabel jlblWaitingArea = new JLabel("Waiting Area");
    jlblWaitingArea.setFont(labelFont);
    jlblWaitingArea.setForeground(Color.LIGHT_GRAY);
    add(jlblWaitingArea, BorderLayout.WEST);

    JLabel jlblEntranceArea = new JLabel("Waiting Area");
    jlblEntranceArea.setFont(labelFont);
    jlblEntranceArea.setForeground(Color.LIGHT_GRAY);
    add(jlblEntranceArea, BorderLayout.EAST);

    JPanel southPanel = new JPanel(new BorderLayout());

    // Subpanel of southPanel: Buttons to press to get number
    JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
    Font buttonFont = new Font("Arial", Font.BOLD, 20);
    ButtonListener buttonListener = new ButtonListener();
    for (int i = 0; i < jbtButtonArr.length; ++i) {
      jbtButtonArr[i] = new JButton(buttonStr[i]);
      jbtButtonArr[i].setFont(buttonFont);

      jbtButtonArr[i].addActionListener(buttonListener);
      buttonPanel.add(jbtButtonArr[i]);
    }
    southPanel.add(buttonPanel);

    jbtReport.setFont(buttonFont);
    ReportListener reportListener = new ReportListener();
    jbtReport.addActionListener(reportListener);
    southPanel.add(jbtReport, BorderLayout.WEST);

    // Slip panel: to display the number after customer presses the button
    Color purple = new Color(100, 0, 255);
    jtfSlip.setForeground(purple);
    Font slipFont = new Font("Sans Serif", Font.BOLD + Font.ITALIC, 18);
    jtfSlip.setFont(slipFont);
    jtfSlip.setHorizontalAlignment(SwingConstants.CENTER);
    Font currentNoFont = new Font("Sans Serif", Font.PLAIN, 18);
    jtfCurrentNo.setFont(currentNoFont);
    jtfCurrentNo.setHorizontalAlignment(SwingConstants.CENTER);
    JPanel slipPanel = new JPanel(new GridLayout(2, 1));
    slipPanel.add(jtfSlip);
    slipPanel.add(jtfCurrentNo);
    southPanel.add(slipPanel, BorderLayout.EAST);

    add(southPanel, BorderLayout.SOUTH);

    setSize(750, 350);
    setTitle("Post Office Simulation");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void initializeAudio() {
    for (int i = 0; i <= 9; ++i) {
      String url = "sounds/" + i + ".wav";
      audioClips.add(Applet.newAudioClip(this.getClass().getResource(url)));
      /* 
       System.out.println(url);
       audioClips.get(i).play();
       Thread.sleep(500);
       */
    }
    String url = "sounds/counter.wav";
    audioClips.add(Applet.newAudioClip(this.getClass().getResource(url)));
  }

  private void announceNumber(Service s) {
    String numStr = String.valueOf(s.getSeqNo());
    try {
      for (int i = 0; i < numStr.length(); ++i) {
        Thread.sleep(600);
        int num = numStr.charAt(i) - '0';
        audioClips.get(num).play();
      }

      Thread.sleep(600);
      audioClips.get(audioClips.size() - 1).play();
      Thread.sleep(600);
      audioClips.get(s.getCounter()).play();
    } catch (Exception ex) {
    }
  }

  private void updateDisplay(Service s) {
    jtfCallNumbersArr[0].setForeground(Color.BLACK);
    for (int i = jtfCallNumbersArr.length - 1; i > 0; i--) {
      jtfCallNumbersArr[i].setText(jtfCallNumbersArr[i - 1].getText());
    }
    jtfCallNumbersArr[0].setForeground(Color.RED);
    jtfCallNumbersArr[0].setText(s.getSeqNo() + callString + s.getCounter());
    currentNo++;
    announceNumber(s);
  }

  private class CounterListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      /******************************************/
      
      // Complete the code for this section
     
      /******************************************/
    }

  }

  private class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      /******************************************/
      
      // Complete the code for this section
     
      /******************************************/
    }
  }

  private class ReportListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      JTextArea jtaReport = new JTextArea(50, 200);
      String str = String.format("%70s\n", "Service Analysis Report");
      str += String.format("%-5s %-10s %-20s %-20s %-15s %-15s\n",
              "No", "Seq. No", "Arr. Time (ms)", "Serve Time(ms)", "Counter", "Waiting Time(s)");
      
      /******************************************/
      
      // Complete the code for this section
     
      /******************************************/
             
      Font reportFont = new Font("Arial", Font.BOLD, 14);
      jtaReport.setText(str);
      jtaReport.setEditable(false);
      jtaReport.setFont(reportFont);
      JFrame reportFrame = new JFrame();
      reportFrame.add(jtaReport);
      reportFrame.setSize(600, 800);
      reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      reportFrame.setVisible(true);

    }
  }

  public static void main(String[] args) {
    new QueueSystem();
  }
}
