package ru.atom.geometry;

public class Bar implements Collider{
    private int firstCornerX, firstCornerY, secondCornerX, secondCornerY;

    Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY){
        if(firstCornerX <= secondCornerX) {
            this.firstCornerX = firstCornerX;
            this.secondCornerX = secondCornerX;
        }
        else{
            this.firstCornerX = secondCornerX;
            this.secondCornerX = firstCornerX;
        }

        if(firstCornerY <= secondCornerY) {
            this.firstCornerY = firstCornerY;
            this.secondCornerY = secondCornerY;
        }
        else{
            this.firstCornerY = secondCornerY;
            this.secondCornerY = firstCornerY;
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        return firstCornerX == bar.firstCornerX && firstCornerY == bar.firstCornerY &&
        secondCornerX == bar.secondCornerX && secondCornerY == bar.secondCornerY;
    }

    @Override
    public boolean isColliding(Collider other) {
        if(other instanceof Bar){
            Bar otherBar = (Bar)other;
            double centerOfBarX = (secondCornerX + firstCornerX) / 2;
            double centerOfBarY = (secondCornerY + firstCornerY) / 2;
            double centerOfOtherBarX = (otherBar.secondCornerX + otherBar.firstCornerX) / 2;
            double centerOfOtherBarY = (otherBar.secondCornerY + otherBar.firstCornerY) / 2;
            double distanceBtwCentersX = Math.abs(centerOfOtherBarX - centerOfBarX);
            double distanceBtwCentersY = Math.abs(centerOfOtherBarY - centerOfBarY);

            if(distanceBtwCentersX <= ((double)secondCornerX - firstCornerX) / 2 + ((double)otherBar.secondCornerX - otherBar.firstCornerX) / 2
                    && distanceBtwCentersY <= ((double)secondCornerY - firstCornerY) / 2 + ((double)otherBar.secondCornerY - otherBar.firstCornerY) / 2)
                return true;
        }
        if(other instanceof Point){
            Point point = (Point)other;
            return point.getX() >= firstCornerX && point.getX() <= secondCornerX &&
                    point.getY() >= firstCornerY && point.getY() <= secondCornerY;
        }
        return false;
    }
}
