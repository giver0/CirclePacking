package com.IvanEndorphin;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawShapes extends JFrame {

    private static final long serialVersionUID = 1L;

    public static int BorderWidth = 1000;
    public static int BorderHeight = 500;
    public static int JBorderWidth = BorderWidth+50;
    public static int JBorderHeight = BorderHeight+50;

    public static double CircleD = 100;
    public static int CircleDistanceBetween = 5;

    public static int CircleCount = 0;
    public static int CircleNumber = CircleCount+1;
    public static int NecessaryDistanceToTheBorder = 10;
    List<MyCircle> CircleList = new ArrayList<MyCircle>();



    public DrawShapes() {

        setSize(new Dimension(JBorderWidth, JBorderHeight));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel p = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                Shape rect = new Rectangle(0, 0, BorderWidth, BorderHeight);
                g2.draw(rect);


                CircleList.add(new MyCircle(NecessaryDistanceToTheBorder, NecessaryDistanceToTheBorder, CircleD));
                g2.draw(CircleList.get(0));
                int i = 1;
                double CurrentY = NecessaryDistanceToTheBorder;
                double CurrentX = NecessaryDistanceToTheBorder + CircleD + CircleDistanceBetween;

                boolean XgenGlag = false;


                while (CheckForNextY(CurrentY)){

                    System.out.println("i ="+i+ "; NextY =" +CurrentY+ "; NextX =" + CurrentX   + "; DistToDownBord =" + CircleList.get(i - 1).getDistanceToDownBorderBorder()
                    + " Check :" + CircleList.get(i - 1).CheckForNextY()+"// "+CircleList.get(i-1).y);

                    for (;CheckForNextX(CurrentX);i++, CurrentX += CircleD + CircleDistanceBetween) {

                        CircleList.add(new MyCircle(CurrentX, CurrentY, CircleD));
                        g2.draw(CircleList.get(i));
                        System.out.println("Xtest" + i);

                    }

                    if(XgenGlag){
                        CurrentX = NecessaryDistanceToTheBorder;
                        XgenGlag = false;
                    }
                    else {
                        CurrentX = NecessaryDistanceToTheBorder+(CircleD/2)+(CircleDistanceBetween/2);
                        XgenGlag = true;
                    }
                    System.out.printf("CurrentX = " + CurrentX);


                    CurrentY += (CircleD + CircleDistanceBetween)*0.866;
                    System.out.println("CurrentY = " + CurrentY);




                }


            }
            public boolean CheckForNextX(double x) {
                return BorderWidth-x-CircleD-DrawShapes.NecessaryDistanceToTheBorder>=DrawShapes.NecessaryDistanceToTheBorder;

            }
            public boolean CheckForNextY(double y) {
                return BorderHeight-y-CircleD-DrawShapes.NecessaryDistanceToTheBorder>=DrawShapes.NecessaryDistanceToTheBorder;

            }



        };
        setTitle("My Shapes");
        this.getContentPane().add(p);

    }

    public static void main(String arg[]) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                //TODO Auto-generated method stub

                new DrawShapes();

            }
        });
    }

}