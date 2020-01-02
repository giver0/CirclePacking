package com.IvanEndorphin;

import java.awt.geom.Ellipse2D;

public class MyCircle extends Ellipse2D.Double{
    double distanceToLeftBorder;
    double distanceToRighttBorder;
    double distanceToUpBorder;
    double distanceToDownBorder;
    double Diametr;





    public MyCircle(double x, double y, double D) {
        this.x = x;
        this.y = y;
        this.width = D;
        this.height = D;

        this.Diametr = D;

        this.distanceToLeftBorder = x;
        this.distanceToRighttBorder = DrawShapes.BorderWidth-(x+D);
        this.distanceToUpBorder = y;
        this.distanceToDownBorder = DrawShapes.BorderHeight-y+D;


    }

    public void setFrame(double x, double y, double D) {
    }

    public void setDistanceBorder(double x, double y, double D) {
          }

    public double getDistanceToRighttBorder() {
        return distanceToRighttBorder;
    }
    public double getDistanceToDownBorderBorder() {
        return distanceToDownBorder;
    }

    public boolean CheckForNextX() {
        return distanceToRighttBorder-Diametr-DrawShapes.NecessaryDistanceToTheBorder>=DrawShapes.NecessaryDistanceToTheBorder;

    }
    public boolean CheckForNextY() {
        return distanceToDownBorder-Diametr-DrawShapes.NecessaryDistanceToTheBorder>=DrawShapes.NecessaryDistanceToTheBorder;

    }
}
