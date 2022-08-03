/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author User
 */
import java.awt.GridBagLayout;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.nio.file.Paths;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;
import org.opencv.videoio.Videoio;

public class Khaled {

    public static void main(String[] args) throws IOException {

        JFrame jframe = new JFrame("Demo Frame");
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("E:\\new.png"));
        panel.setLayout(new GridBagLayout());
        panel.add(label);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.add(panel);

        jframe.setSize(500, 300);
        jframe.setVisible(true);

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String filePath = "C:\\Users\\hornet\\Desktop\\30 sec.mp4";
        if (!Paths.get(filePath).toFile().exists()) {
            System.out.println("File " + filePath + " does not exist!");
            return;
        }

        String output = System.getProperty("user.home") + "/Desktop" + "/test.mp4";

        VideoCapture camera = new VideoCapture();
        camera.open(filePath);

        Size framSize = new Size(camera.get(Videoio.CAP_PROP_FRAME_WIDTH), camera.get(Videoio.CAP_PROP_FRAME_HEIGHT));
        VideoWriter videoWriter = new VideoWriter(output, (int) camera.get(Videoio.CAP_PROP_FOURCC),
                (int) camera.get(Videoio.CAP_PROP_FPS), framSize, true);

        int videoLength = (int) camera.get(Videoio.CAP_PROP_FRAME_COUNT);

        MatOfByte mob = new MatOfByte();
        BufferedImage bufferedImage;
        byte ba[];

        if (camera.isOpened()) {
            Mat frame = new Mat();
            int i = 0;
            while (i <= videoLength) {
                if (camera.read(frame)) {
                    if (videoWriter.isOpened()) {
                        videoWriter.write(frame);
                    }
                    Imgcodecs.imencode(".png", frame, mob);
                    ba = mob.toArray();
                    bufferedImage = ImageIO.read(new ByteArrayInputStream(ba));
                    label.setIcon(new ImageIcon(bufferedImage));
                    i++;
                }
              i++;
            }
        } else {
            System.out.println("Error! Camera can't be opened!");
            return;
        }
        camera.release();
        videoWriter.release();
    }

    public void start(JFrame jframe) throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        jframe = new JFrame("video run");
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\new.png"));
        panel.setLayout(new GridBagLayout());
        panel.add(label);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.setSize(500, 300);
        jframe.setVisible(true);
        String filePath = "C:\\Users\\hornet\\Desktop\\we.mp4";
        if (!Paths.get(filePath).toFile().exists()) {
            System.out.println("File " + filePath + " does not exist!");
            return;
        }
        String output = System.getProperty("user.home") + "/Desktop" + "/Result.mp4";
        VideoCapture camera = new VideoCapture();
        camera.open(filePath);

        Size framSize = new Size(camera.get(Videoio.CAP_PROP_FRAME_WIDTH), camera.get(Videoio.CAP_PROP_FRAME_HEIGHT));
        VideoWriter videoWriter = new VideoWriter(output, (int) camera.get(Videoio.CAP_PROP_FOURCC),
                (int) camera.get(Videoio.CAP_PROP_FPS), framSize, true);

        int videoLength = (int) camera.get(Videoio.CAP_PROP_FRAME_COUNT);

        MatOfByte mob = new MatOfByte();
        BufferedImage bufferedImage;
        byte ba[];

        if (camera.isOpened()) {
            Mat frame = new Mat();
            int i = 0;

            while (i <= videoLength) {

                if (camera.read(frame)) {


                    if (videoWriter.isOpened()) {
                        videoWriter.write(frame);
                    }

                    Imgcodecs.imencode(".png", frame, mob);

                    ba = mob.toArray();

                    bufferedImage = ImageIO.read(new ByteArrayInputStream(ba));

                    label.setIcon(new ImageIcon(bufferedImage));

                    i++;
                }

            }
        } else {
            System.out.println("Error! Camera can't be opened!");
            return;
        }

        camera.release();
        videoWriter.release();
    }

    public Khaled() throws IOException {

    }

}
