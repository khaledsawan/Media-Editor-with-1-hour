/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author User
 */
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import org.opencv.videoio.Videoio;

public class VE {

    public static void main(String[] args) throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        JFrame jframe = new JFrame("Demo Frame");
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        Button convertbutton;
        Button showvideo;
        Label textfps;
        JTextField textfiled1;
        Label textalpha;
        JTextField textfiled2;
        Label lenghtvideo;
        JTextField textfiled3;
        Label textheight;
        JTextField textfiled4;
        Label textwidth;
        int fps = 60;
        ActionListener listener1 = null;
        ActionListener listener2 = null;

        class OtherButtonListener implements ActionListener {

            JFileChooser fileChooser;
            JTextField tf1;
            String output;
            Label lenghtvideo;
            JLabel label;
            JTextField textfiled3;
            JTextField textfiled4;
            JTextField textfiled2;

            OtherButtonListener(JFileChooser fileChooser, JTextField tf1, String output, Label lenghtvideo, JLabel label, JTextField textfiled2, JTextField textfiled3, JTextField textfiled4) {
                this.fileChooser = fileChooser;
                this.tf1 = tf1;
                this.output = output;
                this.lenghtvideo = lenghtvideo;
                this.label = label;
                this.textfiled2 = textfiled2;
                this.textfiled3 = textfiled3;
                this.textfiled4 = textfiled4;
            }

            public void actionPerformed(ActionEvent event) {
                System.out.println(fileChooser.getSelectedFile().getPath());
                VideoCapture camera = new VideoCapture();
                if (!fileChooser.getSelectedFile().getPath().isEmpty()) {
                    camera.open(fileChooser.getSelectedFile().getPath());
                } else {
                    String filePath = "C:\\Users\\hornet\\Desktop\\we2_Trim.mp4";
                    camera.open(filePath);
                }
                String s1 = tf1.getText();
                int fps = Integer.parseInt(s1);
                String widthS = textfiled2.getText();
                String heightS = textfiled3.getText();
                String alphaS = textfiled4.getText();
                Size framSize = new Size(camera.get(Videoio.CAP_PROP_FRAME_WIDTH), camera.get(Videoio.CAP_PROP_FRAME_HEIGHT));
                VideoWriter videoWriter = new VideoWriter(output, (int) camera.get(Videoio.CAP_PROP_FOURCC), fps, framSize, true);
                int videoLength = (int) camera.get(Videoio.CAP_PROP_FRAME_COUNT);
                int framecount = (int) camera.get(Videoio.CAP_PROP_FRAME_COUNT);
                int mainfps = (int) camera.get(Videoio.CAP_PROP_FPS);
                double duration = Double.valueOf(framecount / mainfps);
                System.out.println("fps is :" + fps);
                System.out.println("///duration of the video " + duration);
                System.out.println("///framecount is " + framecount);
                System.out.println("///main fps is" + mainfps);
                lenghtvideo.setText("video lenght: " + Double.toString(duration));
                System.out.println("///width befor change is " + camera.get(Videoio.CAP_PROP_FRAME_WIDTH));
                System.out.println("///height befor change is " + camera.get(Videoio.CAP_PROP_FRAME_HEIGHT));
                if (camera.isOpened()) {
                    boolean wset = camera.set(4, Double.valueOf(widthS));
                    boolean hset = camera.set(3, Double.valueOf(heightS));
                    System.out.println("///wset change =>" + wset);
                    System.out.println("///hset change =>" + hset);
                    Mat frame = new Mat();
                    double i = 0;
                    while (i <= videoLength) {
                        if (camera.read(frame)) {
                            if (videoWriter.isOpened()) {
                                frame.convertTo(frame, frame.depth(), Double.valueOf(alphaS) / 255);
                                videoWriter.write(frame);
                            }
                            i = i + 4 / Double.valueOf(fps) + 1;
                        }
                        i = i + 4 / Double.valueOf(fps);
                    }
                } else {
                    System.out.println("Error! Camera can't be opened!");
                    return;
                }
                System.out.println("convert end");
                camera.release();
                videoWriter.release();
            }
        }

        class FirstButtonListener implements ActionListener {
            JFileChooser fileChooser;
            FirstButtonListener(JFileChooser fileChooser) {
                this.fileChooser = fileChooser;
            }
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("button bressed////////// run video ");
                try {
                    Khaled khaled = new Khaled();
                    khaled.main(args);
                    // khaled.start(jframe);
                } catch (IOException ex) {
                    Logger.getLogger(VE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        convertbutton = new Button("Convert");
        showvideo = new Button("Run");
        textfiled1 = new JTextField("30");
        textfps = new Label("fps");
        textfiled2 = new JTextField("1080");
        textwidth = new Label("width");
        textfiled3 = new JTextField("720");
        textheight = new Label("height");
        textfiled4 = new JTextField("256");
        textalpha = new Label("alpha");
        textfps.setBounds(48, 33, 150, 20);
        textheight.setBounds(48, 73, 150, 20);
        textwidth.setBounds(48, 110, 150, 20);
        textalpha.setBounds(48, 150, 150, 20);
        lenghtvideo = new Label("video lenght :");
        lenghtvideo.setBounds(48, 200, 150, 20);
        textfiled1.setBounds(50, 50, 150, 20);
        textfiled2.setBounds(50, 89, 150, 20);
        textfiled3.setBounds(50, 125, 150, 20);
        textfiled4.setBounds(50, 165, 150, 20);
        convertbutton.setBounds(220, 50, 75, 20);
        showvideo.setBounds(320, 50, 75, 20);
        JFilePicker filePicker = new JFilePicker("Pick a file", "Browse...");
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".mp4", "MPEG-4 Videos");
        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/Users/hornet/Desktop"));
        jframe.add(textfiled1);
        jframe.add(textfps);
        jframe.add(textfiled2);
        jframe.add(textwidth);
        jframe.add(textfiled3);
        jframe.add(textheight);
        jframe.add(textfiled4);
        jframe.add(textalpha);
        jframe.add(lenghtvideo);
        label.setIcon(new ImageIcon("C:\\new.png"));
        panel.setLayout(new GridBagLayout());
        panel.add(label);
        jframe.add(convertbutton);
        jframe.add(showvideo);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.add(filePicker);
        jframe.setSize(500, 300);
        jframe.setVisible(true);

        String output = System.getProperty("user.home") + "/Desktop" + "/Result.mp4";

        listener1 = new OtherButtonListener(fileChooser, textfiled1, output, lenghtvideo, label, textfiled2, textfiled3, textfiled4);
        convertbutton.addActionListener(listener1);
        listener2 = new FirstButtonListener(fileChooser);
        showvideo.addActionListener(listener2);

    }

}
