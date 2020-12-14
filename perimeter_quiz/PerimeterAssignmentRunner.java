import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int pointCount = 0;;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            pointCount += 1;
        }
        return pointCount;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length = getPerimeter(s);
        double pointCount = (double) getNumPoints(s);
        double averageLength = length / pointCount;
        return averageLength;
    }
    
    public void testAverageLength () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double average = getAverageLength(s);
        System.out.println("datetest4 average length = " + average);
    }
    

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist > largestSide) {
                largestSide = currDist;
            }
            prevPt = currPt;
        }
        return largestSide;
    }
    
    public void testLongestLength () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double average = getLargestSide(s);
        System.out.println("datetest4 largest length = " + average);
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
   
        for (Point currPt : s.getPoints()) {
            double currX = currPt.getX();
            if(currX > largestX) {
                largestX = currX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0.0;   
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fs = new FileResource(f);
            Shape s = new Shape(fs);
            double length = getPerimeter(s);
            if(length > largestPerimeter) {
                largestPerimeter = length;
            }
            
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double largestPerimeter = 0.0;   
        String largestFile = "";
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fs = new FileResource(f);
            Shape s = new Shape(fs);
            double length = getPerimeter(s);
            if(length > largestPerimeter) {
                largestPerimeter = length;
                largestFile = f.getName();
            }
            
        }
        return largestFile;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        //double points = getNumPoints(s);
        
        System.out.println("datatest4  length" + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double result = getLargestPerimeterMultipleFiles();
        System.out.println(result);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String result = getFileWithLargestPerimeter();
        System.out.println(result);

    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testFileWithLargestPerimeter();
        //pr.testPerimeterMultipleFiles();
        //System.out.println("datatest1 perimeter");
        //pr.testPerimeter();
        //pr.testAverageLength();
        pr.testLongestLength();
        
    }
}
