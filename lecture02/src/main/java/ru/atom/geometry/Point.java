package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider/* super class and interfaces here if necessary */ {
    // fields
    // and methods
    private int x, y;

    public Point(){
        this(0, 0);
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){return x;}
    int getY(){return y;}

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;

        // your code here
        return x == point.x && y == point.y;
    }

    @Override
    public boolean isColliding(Collider other) {
        if(other instanceof Point){
            return x == ((Point) other).x && y == ((Point) other).y;
        }
        if(other instanceof Bar){
            Bar bar = (Bar) other;
            return bar.isColliding(this);
        }
        return false;
    }
}
