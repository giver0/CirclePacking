package Test;

import com.IvanEndorphin.MyCircle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IvanEndorphin on 02.01.2020.
 */
public class Test {
    public static void main(String[] args) {
        List<MyCircle> CircleList = new ArrayList<MyCircle>();
        for (int i = 10, y=0; i < 1000; i+=100,y++) {


            CircleList.add(new MyCircle(i, 10, 100));
            System.out.println(i + " " + CircleList.get(y).getDistanceToRighttBorder());

        }

    }
}
