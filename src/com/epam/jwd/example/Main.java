package com.epam.jwd.example;

import com.epam.jwd.example.model.FigureFactory;
import com.epam.jwd.example.model.Line;
import com.epam.jwd.example.model.MultiAngleFigure;
import com.epam.jwd.example.model.Point;
import com.epam.jwd.example.model.Square;
import com.epam.jwd.example.model.SquareFactory;
import com.epam.jwd.example.model.Triangle;
import com.epam.jwd.example.model.TriangleFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    private final static Point[] FIRST_ARR = new Point[4];
    private final static Line[] SECOND_ARR = new Line[2];
    private final static Triangle[] THIRD_ARR = new Triangle[2];
    private final static Square[] FOURTH_ARR = new Square[1];
    private final static MultiAngleFigure[] FIFTH_ARR = new MultiAngleFigure[2];

    public static void main(String[] args) {
        declaration();
        getInfo();
    }

    public static boolean samePoints(Point[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void getInfo() {
        getInfoAboutPoints();

        for (Line arr : SECOND_ARR) {
            getInfoAboutLines(arr);
        }

        for (Triangle arr : THIRD_ARR) {
            if (arr != null) {
                getInfoAboutTriangles(arr);
            }
        }

        for (Square arr : FOURTH_ARR) {
            if (arr != null) {
                getInfoAboutSquare(arr);
            }
        }

        for (MultiAngleFigure arr : FIFTH_ARR) {
            getInfoAboutMultiAngle(arr);
        }
    }

    public static void declaration() {
        for (int i = 0; i < 4; i++) {
            FIRST_ARR[i] = new Point();
        }

        for (int i = 0; i < 2; i++) {
            SECOND_ARR[i] = new Line();
            THIRD_ARR[i] = new TriangleFactory().createFigure(new Point[]{new Point(), new Point(), new Point()});
        }

        FOURTH_ARR[0] = new SquareFactory().createFigure(new Point[]{new Point(), new Point(), new Point(), new Point()});

        FIFTH_ARR[0] = new FigureFactory().createFigure(new Point[]{new Point(0, 0), new Point(3, 2),
                new Point(0, 5), new Point(5, 5), new Point(3, -1)});
        FIFTH_ARR[1] = new FigureFactory().createFigure(new Point[]{new Point(2, 0), new Point(4, 0),
                new Point(6, 2), new Point(6, 4), new Point(4, 6), new Point(2, 6),
                new Point(0, 4), new Point(0, 2)});

    }

    public static void getInfoAboutPoints() {
        int i = 0;
        do {
            LOGGER.log(Level.INFO, FIRST_ARR[i].toString());
            i++;
        } while (i < 4);
    }

    public static void getInfoAboutLines(Line arr) {
        if (!samePoints(arr.getArray())) {
            LOGGER.log(Level.INFO, arr.toString());
        } else {
            LOGGER.log(Level.ERROR, "Объект Line не является фигурой <<Линия>>");
        }
    }

    public static void getInfoAboutTriangles(Triangle arr) {
        Point[] array = arr.getArray();
        if (!samePoints(array)) {
            LOGGER.log(Level.INFO, arr.toString());
            LOGGER.log(Level.INFO, String.format("Периметр равен %1$.3f",
                    arr.getFigurePropertiesStrategy().perimeter(array)));
            LOGGER.log(Level.INFO, String.format("Площадь равна %1$.3f",
                    arr.getFigurePropertiesStrategy().square(array)));
        } else {
            LOGGER.log(Level.ERROR, "Объект Triangle не является фигурой <<Треугольник>>");
        }
    }

    public static void getInfoAboutSquare(Square arr) {
        Point[] array = arr.getArray();
        if (!samePoints(array)) {
            LOGGER.log(Level.INFO, arr.toString());
            LOGGER.log(Level.INFO, String.format("Периметр равен %1$.3f",
                    arr.getFigurePropertiesStrategy().perimeter(array)));
            LOGGER.log(Level.INFO, String.format("Площадь равна %1$.3f",
                    arr.getFigurePropertiesStrategy().square(array)));
        } else {
            LOGGER.log(Level.ERROR, "Объект Square не является фигурой <<Квадрат>>");
        }
    }

    public static void getInfoAboutMultiAngle(MultiAngleFigure arr) {
        Point[] array = arr.getArray();
        if (!samePoints(array)) {
            LOGGER.log(Level.INFO, arr.toString());
            LOGGER.log(Level.INFO, String.format("Периметр равен %1$.3f",
                    arr.getFigurePropertiesStrategy().perimeter(array)));
            LOGGER.log(Level.INFO, String.format("Площадь равна %1$.3f",
                    arr.getFigurePropertiesStrategy().square(array)));
        } else {
            LOGGER.log(Level.ERROR, "В объекте MultiAngleFigure есть одинаковые точки");
        }
    }
}