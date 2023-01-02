/**
 * This file is designed for CSE 8B SP20 PA6. 
 * 
 * @author  CSE8B SP20 PA Team
 */

/**
 * This is a class that is used to visualize and test
 * the different base regions
 */
public class RegionMain {
    
    /**
     * The main method that is used to visualize and test
     * the different base regions
     * @param args Command line arguments not used
     */
    public static void main(String[] args) {
        
        // Visualizing a Circle
        Circle c = new Circle(new Point(8, 8), 5);
        c.printDetails();
        c.fillGrid();
        c.draw();
        
        // Visualizing a Rectangle
        Rectangle r = new Rectangle(new Point(10, 1), 10, 4);
        r.printDetails();
        r.fillGrid();
        r.draw();
        
        // Visualizing the IntersectRegion between a Circle and a Rectangle
        IntersectRegion rectCircleIntersect = new IntersectRegion(
                new Rectangle(new Point(0, 0), 20, 10),
                new Circle(new Point(10, 10), 10)
                );
        rectCircleIntersect.printDetails();
        rectCircleIntersect.fillGrid();
        rectCircleIntersect.draw();
        
        // Visualizing the UnionRegion between two rectangles
        UnionRegion twoRectsUnion = new UnionRegion(
                new Rectangle(new Point(0, 10), 20, 10),
                new Rectangle(new Point(10, 0), 10, 20)
                );
        twoRectsUnion.printDetails();
        twoRectsUnion.fillGrid();
        twoRectsUnion.draw();
        
        // Visualizing the SubtractRegion between a Circle and a Rectangle
        SubtractRegion rectCircleSub = new SubtractRegion(
                new Rectangle(new Point(10, 10), 20, 20),
                new Circle(new Point(20, 20), 8)
                );
        rectCircleSub.printDetails();
        rectCircleSub.fillGrid();
        rectCircleSub.draw();
        
        // Visualizing the NegateRegion of a Circle
        NegateRegion circleNegate = new NegateRegion(
                new Circle(new Point(16, 16), 10)
                );
        circleNegate.printDetails();
        circleNegate.fillGrid();
        circleNegate.draw();
    }

}
