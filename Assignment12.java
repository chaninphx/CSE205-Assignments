//package assignment12Package;

// Assignment #: 12
//         Name: Chandler Cotton
//    StudentID: 1208857308
//      Lecture: M W F 12pm
//  Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.

import javax.swing.*;

public class Assignment12 extends JApplet
{
    private final int WIDTH = 450 *3;
    private final int HEIGHT = 340 * 3;

    public void init()
    {
        ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
        getContentPane().add(panel);
        setSize(WIDTH,HEIGHT);
    }
}
