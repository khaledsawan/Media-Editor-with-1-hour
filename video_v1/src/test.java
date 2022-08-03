/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hornet
 */
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class test {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception, IOException {
//     Khaled khaled=new Khaled();
//     khaled.start();
    }

    public test() throws IOException {
//        Khaled khaled=new Khaled();
//     khaled.start();
runvideo();
    }
    public void runvideo() throws IOException{
  Mat frame = new Mat();
    //0; default video device id
    VideoCapture camera = new VideoCapture("C:\\Users\\hornet\\Desktop\\we.mp4");
    JFrame jframe = new JFrame("Title");
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel vidpanel = new JLabel();
    jframe.setContentPane(vidpanel);
    jframe.setVisible(true);
  MatOfByte mob = new MatOfByte();
     BufferedImage bufferedImage;
  byte ba[];
    while (true) {
        if (camera.read(frame)) {
            Imgcodecs.imencode(".png", frame, mob);
              ba = mob.toArray();
               bufferedImage =ImageIO.read(new ByteArrayInputStream(ba));
          
            vidpanel.setIcon(new ImageIcon(bufferedImage));
            vidpanel.repaint();

        }
    }
    }

}
