//package assignment12Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
    Assignment#: 12
    Name: Chandler Cotton
    StudentID: 1208857308
    Lecture: MWF 12pm
    Description:  Sets the contents such as shapes and colors for the
        beam panel

 */
public class BeamsPanel extends JPanel
{
    private Color color;
    private Timer timer;
    private int delay;
    private int step;
    private int centerX;
    private int centerY;
    private int diameterLimit;
    private int diameter;
    private int beamNum = 8;
    private int angleSize;

    public BeamsPanel(Color  colr, int width)
    {
        this.setBackground(Color.BLACK);
        color = colr;
        delay = 20;
        step = 3;
        centerX = width/2;
        centerY = width/2;
        //diameterLimit = (this.getWidth()-10)/2;
        diameterLimit = (width - 10) / 2;
        diameter = 0;
        beamNum = 8;
        angleSize = 360/(beamNum*2);

        //timer is set with a delay of 20 milliseconds, and each time 20 milliseconds pass, MoveListener is called
        timer = new Timer(delay, new MoveListener());
    }

    //method to resume timer
    public void resume()
    {
        timer.start();
    }

    //method to suspend/stop timer
    public void suspend()
    {
        timer.stop();
    }

    //method is to reset color
    public void changeColor(Color colr)
    {
        color = colr;
    }

   //method is to reset the beam number
    public void setBeamNumber(int beamNumber)
    {
        beamNum = beamNumber;
    }

    //method is to reset the delay
    public void setDelay(int del)
    {
        timer.setDelay(del);
    }

    //pains the shapes of the beams
   public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        g.setColor(color);



        //an arc is bulilt as many times as beamNum states
        for(int i = 0; i < beamNum; i++)
        {
            g.fillArc(centerX-diameter/2, centerY-diameter/2, diameter, diameter,
                    i*(2 * angleSize), angleSize);
        }

        //System.out.println("YES!");
        //System.out.println(color.toString());

    }

    private class MoveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(diameter <= diameterLimit)
            {
                diameter += 3;
            }

            else
            {
                diameter = 0;
            }
            //redraws the beams
            repaint();
        }
    }

}

