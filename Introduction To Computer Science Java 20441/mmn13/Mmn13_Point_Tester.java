
public class Mmn13_Point_Tester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("********** Test Q1 Point - Start **********");
        Point p0 = null; // p0=(0,0)
        Point p1 = null; // p1=p2=(3.3,4.4)
        Point p2 = null; // p3=(1.1, 1.1)
        Point p4 = null; // p4=(3.3, 5.2)
        Point p5 = null; // p5=(4.1, 4.4)

        p0 = new Point(0.0, 0.0); // (0, 0)
        p1 = new Point(3.3, 4.4);
        p2 = new Point(p1);
        if (p2.getX() != 3.3 || p2.getY() != 4.4) {
            System.out.println("\t ERROR - copy constructor (other p): expected(3.3, 4.4) ; actual=" + p2);
        } else
            System.out.println("\t OK - copy constructor (other p): expected(3.3, 4.4) ; actual=" + p2);

        p4 = new Point(3.3, 5.2);
        p5 = new Point(4.1, 4.4);

        // check equals
        if (!p1.equals(p2)) { // expect true
            System.out.println("\t ERROR - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
            System.out.println("\t OK - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);

        // check above and under p1 & p5 same high, p4 above
        if (!p4.isAbove(p1)) { // expect true
            System.out.println("\t ERROR - p4.isAbove(p1) expected true ; actual="
                            + p4.isAbove(p1) + ";  p1=" + p1 + " p4=" + p4);
        } else 
            System.out.println("\t OK - p4.isAbove(p1) expected true ; actual="
                    + p4.isAbove(p1) + ";  p1=" + p1 + " p4=" + p4);

        // under
        if (!p1.isUnder(p4)) { // expect true
            System.out.println("\t ERROR - p4.isUnder(p1) expected true ; actual="
                            + p1.isUnder(p4) + ";  p1=" + p1 + " p4=" + p4);
        } else 
            System.out.println("\t OK - p1.isUnder(p4) expected true ; actual="
                    + p1.isUnder(p4) + ";  p1=" + p1 + " p4=" + p4);

        // check left and right p1 & p4 same, p5 right
        if (!p1.isLeft(p5)) { // expect true
            System.out.println("\t ERROR - p1.isLeft(p5) expected true ; actual="
                            + p1.isLeft(p5) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t OK - p1.isLeft(p5) expected true ; actual="
                    + p1.isLeft(p5) + ";  p1=" + p1 + " p5=" + p5);

        // check move
        p0.move(2.1, -1.2); // p0 was (0, 0) expected (2.1, -1.2)
        if (p0.getX() != 2.1 || p0.getY() != -1.2) {
            System.out.println("\t ERROR - p0.move(2.1, -1.2) expected p0(2.1, -1.2); actual="+ p0);
        } else
            System.out.println("\t OK - p0.move(2.1, -1.2) expected p0(2.1, -1.2); actual=" + p0);

        // distance
        p0 = new Point(0.0, 0.0);
        p1 = new Point(0.0, 3.0);
        p2 = new Point(4.0, 3.0);

        if (p0.distance(p1) != 3) {
            System.out.println("\t ERROR - p0.distance(p1) expected 3 ; actual="
                            + p0.distance(p1) + " p0=" + p0 + "; p1=" + p1);
        } else
            System.out.println("\t OK - p0.distance(p1) expected 3 ; actual="
                    + p0.distance(p1) + "p0=" + p0 + "; p1=" + p1);
        // check distance
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("My own tests");
        
        // check equals
        p1 = new Point(6,7);
        p2 = new Point(4.0, 3.0);
        
        if (p1.equals(p2)) { // expect true
            System.out.println("\t ERROR - p1.equals(p2) expected false ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
            System.out.println("\t OK - p1.equals(p2) expected false ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        
        p2 = new Point(p1);
        if (!p1.equals(p2)) { // expect true
            System.out.println("\t ERROR - !p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
            System.out.println("\t OK - !p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        
        p2.move(1, 1);        
        if (p1.equals(p2)) { // expect true
            System.out.println("\t ERROR - p1.equals(p2) expected false ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
            System.out.println("\t OK - p1.equals(p2) expected false ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
      
        p2.move(-1, -1);        
        if (!p1.equals(p2)) { // expect true
            System.out.println("\t ERROR - p1.equals(p2) expected false ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
            System.out.println("\t OK - p1.equals(p2) expected false ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
       
        p2.setY(5);
        if (p1.equals(p2)) { // expect true
            System.out.println("\t ERROR - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
            System.out.println("\t OK - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        
        System.out.println("Equality after editing");
        p1 = new Point(6,7);
        p2 = new Point(4.0, 3.0);
        if (p1.equals(p2)) { // expect true
             System.out.println("\t ERROR - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
            System.out.println("\t OK - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
       
        p1.move(-2, -4);
        if (p1.equals(p2)) { // expect true
            System.out.println("\t OK - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
             System.out.println("\t ERROR - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        p1 = new Point(6,7);
        p1.setX(4);
        p1.setY(3);
        if (p1.equals(p2)) { // expect true
            System.out.println("\t OK - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
        } else 
             System.out.println("\t ERROR - p1.equals(p2) expected true ; actual="+ p1.equals(p2) + ";  p1=" + p1 + " p2=" + p2);
 
        
    
        /// isAbove isUnder
        System.out.println("Equality,  isAbove");
        p1 = new Point(6, 7);
        p4 = new Point(6, 7);

        if (p4.isAbove(p1)) { // expect false
            System.out.println("\t ERROR - p4.isAbove(p1) expected false ; actual="
                            + p4.isAbove(p1) + ";  p1=" + p1 + " p4=" + p4);
        } else 
            System.out.println("\t OK - p4.isAbove(p1) expected false ; actual="
                    + p4.isAbove(p1) + ";  p1=" + p1 + " p4=" + p4);
            
        if (p1.isAbove(p4)) { // expect true
            System.out.println("\t ERROR - p1.isAbove(p4) expected false ; actual="
                            + p1.isAbove(p4) + ";  p1=" + p1 + " p4=" + p4);
        } else 
            System.out.println("\t OK - p1.isAbove(p4) expected false ; actual="
                    + p1.isAbove(p4) + ";  p1=" + p1 + " p4=" + p4);
        
        System.out.println("isUnder");
                
        // under
        if (p1.isUnder(p4)) { // expect true
            System.out.println("\t ERROR - p1.isUnder(p4) expected false ; actual="
                            + p1.isUnder(p4) + ";  p1=" + p1 + " p4=" + p4);
        } else 
            System.out.println("\t OK - p1.isUnder(p4) expected false ; actual="
                    + p1.isUnder(p4) + ";  p1=" + p1 + " p4=" + p4);

        // under
        if (p4.isUnder(p1)) { // expect true
            System.out.println("\t ERROR - p4.isUnder(p1) expected false ; actual="
                            + p4.isUnder(p1)+ ";  p1=" + p1 + " p4=" + p4);
        } else 
            System.out.println("\t OK - p1.isUnder(p4) expected false ; actual="
                    + p1.isUnder(p4) + ";  p1=" + p1 + " p4=" + p4);
         
        p1 = new Point(6, 8);
        p4 = new Point(6, 7);
        
        if (p4.isAbove(p1)) { // expect true
            System.out.println("\t ERROR - p4.isAbove(p1) expected false ; actual="
                            + p4.isAbove(p1) + ";  p1=" + p1 + " p4=" + p4);
        } else 
            System.out.println("\t OK - p4.isAbove(p1) expected false ; actual="
                    + p4.isAbove(p1) + ";  p1=" + p1 + " p4=" + p4);
            
        if (p1.isAbove(p4)) { // expect true
             System.out.println("\t OK - p1.isAbove(p4) expected true ; actual="
                    + p1.isAbove(p4) + ";  p1=" + p1 + " p4=" + p4);
       } else 
             System.out.println("\t ERROR - p1.isAbove(p4) expected true ; actual="
                            + p1.isAbove(p4) + ";  p1=" + p1 + " p4=" + p4);

        p1 = new Point(6, 8);
        p4 = new Point(6, 7);
        if (!p1.isUnder(p4)) { // expect true
            System.out.println("\t OK - p1.isUnder(p4) expected false ; actual="
                    + p1.isUnder(p4) + ";  p1=" + p1 + " p4=" + p4);
        } else 
             System.out.println("\t ERROR - p1.isUnder(p4) expected false ; actual="
                            + p1.isUnder(p4) + ";  p1=" + p1 + " p4=" + p4);
                 
        if (p4.isUnder(p1)) { // expect true
            System.out.println("\t OK - p4.isUnder(p1) expected true ; actual="
                    + p4.isUnder(p1) + ";  p1=" + p1 + " p4=" + p4);
        } else 
            System.out.println("\t ERROR - p4.isUnder(p1) expected true ; actual="
                            + p4.isUnder(p1) + ";  p1=" + p1 + " p4=" + p4);
 
        System.out.println("isLeft isRight");
         p1 = new Point(6, 8);
         p5 = new Point(6, 7);
     
         // check left and right p1 & p4 same, p5 right
        if (p1.isLeft(p5)) { // expect false
            System.out.println("\t ERROR - p1.isLeft(p5) expected false ; actual="
                            + p1.isLeft(p5) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t OK - p1.isLeft(p5) expected false ; actual="
                    + p1.isLeft(p5) + ";  p1=" + p1 + " p5=" + p5);

                            
          if (p5.isLeft(p1)) { // expect false
            System.out.println("\t ERROR - p5.isLeft(p1) expected false ; actual="
                            + p5.isLeft(p1) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t OK - p5.isLeft(p1) expected false ; actual="
                    + p5.isLeft(p1) + ";  p1=" + p1 + " p5=" + p5);
        
         if (p1.isRight(p5)) { // expect false
            System.out.println("\t ERROR - p1.isRight(p5) expected false ; actual="
                            + p1.isRight(p5) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t OK - p1.isRight(p5) expected false ; actual="
                    + p1.isRight(p5) + ";  p1=" + p1 + " p5=" + p5);

                            
          if (p5.isRight(p1)) { // expect false
            System.out.println("\t ERROR - p5.isRight(p1) expected false ; actual="
                            + p5.isLeft(p1) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t OK - p5.isRight(p1) expected false ; actual="
                    + p5.isRight(p1) + ";  p1=" + p1 + " p5=" + p5);

         p1 = new Point(1, 8);
         p5 = new Point(6, 7);
        
         
         if (p1.isLeft(p5)) { // expect true
               System.out.println("\t OK - p1.isLeft(p5) expected true ; actual="
                    + p1.isLeft(p5) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t ERROR - p1.isLeft(p5) expected true ; actual="
                            + p1.isLeft(p5) + ";  p1=" + p1 + " p5=" + p5);

                            
          if (p5.isLeft(p1)) { // expect false
            System.out.println("\t ERROR - p5.isLeft(p1) expected false ; actual="
                            + p5.isLeft(p1) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t OK - p5.isLeft(p1) expected false ; actual="
                    + p5.isLeft(p1) + ";  p1=" + p1 + " p5=" + p5);
          
                    
         p1 = new Point(1, 8);
         p5 = new Point(6, 7);

         if (p1.isRight(p5)) { // expect false
            System.out.println("\t ERROR - p1.isRight(p5) expected false ; actual="
                            + p1.isRight(p5) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t OK - p1.isRight(p5) expected false ; actual="
                    + p1.isRight(p5) + ";  p1=" + p1 + " p5=" + p5);

                            
         if (p5.isRight(p1)) { // expect false
            System.out.println("\t OK - p5.isRight(p1) expected true ; actual="
                    + p5.isRight(p1) + ";  p1=" + p1 + " p5=" + p5);
        } else
            System.out.println("\t ERROR - p5.isRight(p1) expected true ; actual="
                            + p5.isLeft(p1) + ";  p1=" + p1 + " p5=" + p5);

                    
         p1 = new Point(0, 0);
         p5 = new Point(5, 0);
     
         if (p1.distance(p5) != 5) {
            System.out.println("\t ERROR -p1.distance(p5) expected 5 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
        } else
            System.out.println("\t OK - p1.distance(p5) expected 5 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
               
         p5 = new Point(5, 12);                 
         if (p1.distance(p5) != 13) {
            System.out.println("\t ERROR -p1.distance(p5) expected 13 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
        } else
            System.out.println("\t OK - p1.distance(p5) expected 13 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
                           
         p1 = new Point(-3, 0);
         p5 = new Point(0, 4);
         if (p1.distance(p5) != 5) {
            System.out.println("\t ERROR -p1.distance(p5) expected 5 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
        } else
            System.out.println("\t OK - p1.distance(p5) expected 5 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
        
        p1.move(3, 4);
        if (p1.distance(p5) != 0) {
            System.out.println("\t ERROR -p1.distance(p5) expected 0 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
        } else
            System.out.println("\t OK - p1.distance(p5) expected 0 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
   
         p1 = new Point(0, 0);
         p5 = new Point(0, 0);
     
         if (p1.distance(p5) != 0) {
            System.out.println("\t ERROR -p1.distance(p5) expected 0 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
        } else
            System.out.println("\t OK - p1.distance(p5) expected 0 ; actual="
                            + p1.distance(p5) + " p0=" + p0 + "; p1=" + p5);
                        
        System.out.println("********** Test Q1 Point - Finish **********\n");
    }


}
