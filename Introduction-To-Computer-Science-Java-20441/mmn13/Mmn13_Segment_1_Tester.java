
public class Mmn13_Segment_1_Tester {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("********** Test Q2 Segment1 - Start **********");
        Segment1 seg0 = null; // (0.0,0.0)---(2.0,0.0)
        Segment1 seg2 = null;
        Segment1 seg3 = null; // seg2 = seg3 = (1.0,4.0)---(4.0,4.0)
        // constructor and toString
        seg0 = new Segment1(0.0, 0.0, 2.0, 0.0);
        if (!seg0.getPoLeft().equals(new Point(0.0, 0.0))) {
            System.out.println("\t ERROR - expected seg0.getPoLeft()=(0.0,0.0) ; actual="
                            + seg0.getPoLeft());
        } else
            System.out.println("\t OK - expected seg0.getPoLeft()=(0.0,0.0) ; actual="
                            + seg0.getPoLeft());

        // second constructor Segment1 (Point left, Point right)
        Point pLeft = new Point(1.0, 4.0);
        Point pRight = new Point(4.0, 8.0);
        seg2 = new Segment1(pLeft, pRight);
        if (!seg2.getPoLeft().equals(pLeft) || !seg2.getPoRight().equals(new Point(4.0, 4.0))) {
            System.out.println("\t ERROR - second Constructor - expected (1.0,4.0)---(4.0,4.0) ; actual="
                            + seg2);
        } else
            System.out.println("\t OK - second Constructor - expected (1.0,4.0)---(4.0,4.0) ; actual="
                            + seg2);

        // copy constructor
        seg3 = new Segment1(seg2);
        if (!seg3.getPoLeft().equals(new Point(1.0, 4.0))|| !seg3.getPoRight().equals(new Point(4.0, 4.0))) {
            System.out.println("\t ERROR - 3rd Constructor - expected (1.0,4.0)---(4.0,4.0) ; actual="
                            + seg3);
        } else
            System.out.println("\t OK - 3rd Constructor - expected (1.0,4.0)---(4.0,4.0) ; actual="
                            + seg3);

        // equals

        if (!seg2.equals(seg3)) {
            System.out.println("\t ERROR - equals - seg2.equals(seg3)? - expected true ; actual="
                            + seg2.equals(seg3));
        } else
            System.out.println("\t OK - equals - seg2.equals(seg3)? - expected true ; actual="
                            + seg2.equals(seg3));

        // sizes
        if (seg0.getLength() != 2.0) {
            System.out.println("\t ERROR - seg0.getLength() - expected 2.0 ; actual="
                            + seg0.getLength());
        } else
            System.out.println("\t OK - seg0.getLength() - expected 2.0 ; actual="
                            + seg0.getLength());

        Segment1 s1 = new Segment1(0.0, 0.0, 2.0, 0.0);
        s1.changeSize(3.0);
        if (s1.getLength() != 5.0) {
            System.out.println("\t ERROR - s1.changeSize() - expected length 5.0 ; actual="
                            + s1.getLength());
        } else
            System.out.println("\t OK - s1.getLength() - expected length 5.0 ; actual="
                            + s1.getLength());

        s1 = new Segment1(0.0, 0.0, 2.0, 0.0);
        Segment1 s2 = new Segment1(0.0, 2.0, 4.0, 2.0); // bigger than s1
        if (s1.isBigger(s2)) {
            System.out.println("\t ERROR - s1.isBigger(s2) - expected false ; actual="
                            + s1.isBigger(s2));
        } else
            System.out.println("\t OK - s1.isBigger(s2) - expected false ; actual="
                            + s1.isBigger(s2));

        // under, above, right & left
        s1 = new Segment1(5.0, 0.0, 10.0, 0.0);
        Segment1 s3 = new Segment1(5.0, 3.0, 10.0, 3.0);
        Segment1 s4 = new Segment1(5.0, -3.0, 10.0, -3.0);
        // under
        if (!s1.isUnder(s3)) {
            System.out.println("\t ERROR - s1.isUnder(s3) - expected true ; actual="
                            + s1.isUnder(s3) + " s1=" + s1 + " s3=" + s3);
        } else
            System.out.println("\t OK - s1.isUnder(s3) - expected true ; actual="
                            + s1.isUnder(s3) + " s1=" + s1 + " s3=" + s3);
        // above
        if (!s1.isAbove(s4)) {
            System.out.println("\t ERROR - s1.isAbove(s4) - expected true ; actual="
                            + s1.isAbove(s4) + " s1=" + s1 + " s4=" + s4);
        } else
            System.out.println("\t OK - s1.isAbove(s4) - expected true ; actual="
                            + s1.isAbove(s4) + " s1=" + s1 + " s4=" + s4);

        Segment1 sMid = new Segment1(5.0, 0.0, 10.0, 0.0);
        Segment1 sLeft = new Segment1(0.0, 3.0, 4.0, 3.0);
        Segment1 sRight = new Segment1(11.0, -3.0, 15.0, -3.0);

        // left
        if (!sMid.isRight(sLeft)) {
            System.out.println("\t ERROR - sMid.isRight(sLeft) - expected true ; actual="
                            + sMid.isRight(sLeft)+ " sMid="+ sMid+ " sLeft="+ sLeft);
        } else
            System.out.println("\t OK - sMid.isRight(sLeft) - expected true ; actual="
                            + sMid.isRight(sLeft)+ " sMid="+ sMid+ " sLeft="+ sLeft);
        // right
        if (!sMid.isLeft(sRight)) {
            System.out.println("\t ERROR - sMid.isLeft(sRight) - expected true ; actual="
                            + sMid.isLeft(sRight)+ " sMid="+ sMid+ " sRight=" + sRight);
        } else
            System.out.println("\t OK - sMid.isLeft(sRight) - expected true ; actual="
                            + sMid.isLeft(sRight)+ " sMid="+ sMid+ " sRight=" + sRight);

        // overlap
        if (sMid.overlap(sMid) != 5.0) {
            System.out.println("\t ERROR - sMid.overlap(sMid) - expected 5.0 ; actual="
                            + sMid.overlap(sMid)+ " sMid="+ sMid+ " sMid="+ sMid);
        } else
            System.out.println("\t OK - sMid.overlap(sMid) - expected 5.0 ; actual="
                            + sMid.overlap(sMid)+ " sMid="+ sMid+ " sMid="+ sMid);

        if (sMid.trapezePerimeter(sMid) != 10.0) {
            System.out.println("\t ERROR - sMid.trapezePerimeter(sMid) - expected 10.0 ; actual="
                            + sMid.trapezePerimeter(sMid)+ " sMid="+ sMid+ " sMid=" + sMid);
        } else
            System.out.println("\t OK - sMid.trapezePerimeter(sMid) - expected 10.0 ; actual="
                            + sMid.trapezePerimeter(sMid)+ " sMid="+ sMid+ " sMid=" + sMid);

 		///////////////////////////////////////////////////////////////
       System.out.println("My own tests\n");                  
        
        
        System.out.println("aliasing check");
	    seg0 = new Segment1(5, 3, 7, 3);
	    Point pp1 = seg0.getPoLeft();
	    pp1.setX(13);
	  	pp1.setY(13);
	  	pp1 = seg0.getPoRight();
	    pp1.setX(13);
	    pp1.setY(113);
  
        if (seg0.getLength() != 2 || seg0.getPoLeft().getY() != seg0.getPoRight().getY() || seg0.getPoLeft().getX() != 5 ) {
            System.out.println("\t ERROR - some aliasing problem " +seg0);
        } else
            System.out.println("\t OK -  no point  aliasing problem " +seg0);

        // sizes
        System.out.println("change size");
        seg0 = new Segment1(5, 3, 7, 3);
        if (seg0.getLength() != 2.0) {
            System.out.println("\t ERROR - seg0.getLength() - expected 2.0 ; actual="
                            + seg0.getLength());
        } else
            System.out.println("\t OK - seg0.getLength() - expected 2.0 ; actual="
                            + seg0.getLength());
        seg0.changeSize(1);
        // sizes
        if (seg0.getLength() != 3.0) {
            System.out.println("\t ERROR - seg0.getLength() - expected 3.0 ; actual="
                            + seg0.getLength());
        } else
            System.out.println("\t OK - seg0.getLength() - expected 3.0 ; actual="
                            + seg0.getLength());

        seg0.changeSize(-1);
        // sizes
        if (seg0.getLength() != 2.0) {
            System.out.println("\t ERROR - seg0.getLength() - expected 2.0 ; actual="
                            + seg0.getLength());
        } else
            System.out.println("\t OK - seg0.getLength() - expected 2.0 ; actual="
                            + seg0.getLength());

        //make invalid size
        seg0.changeSize(-10);
        // sizes
        if (seg0.getLength() != 2.0) {
            System.out.println("\t ERROR - seg0.getLength() - expected 2.0 ; actual="
                            + seg0.getLength() + "(making invalid size doesnt affect result)");
        } else
            System.out.println("\t OK - seg0.getLength() - expected 2.0 ; actual="
                            + seg0.getLength());
       
       //zero size allowed
       seg0 = new Segment1(5, 3, 7, 3);
       seg0.changeSize(-2);
        if (seg0.getLength() != 0) {
            System.out.println("\t ERROR - seg0.getLength() - expected 0 ; actual="
                            + seg0.getLength() + "(making invalid size doesnt affect result)");
        } else
            System.out.println("\t OK - seg0.getLength() - expected 0 ; actual="
                            + seg0.getLength());

        // move                 
        seg0 = new Segment1(5, 3, 7, 3);
        if (seg0.getPoLeft().getX() != 5) {
            System.out.println("\t ERROR - seg0.getPoLeft().getX() - expected 5 ; actual="
                            + seg0.getPoLeft().getX());
        } else
            System.out.println("\t OK - seg0.getP   oLeft().getX() - expected 5 ; actual="
                            + seg0.getPoLeft().getX());
        if (seg0.getPoRight().getX() != 7) {
            System.out.println("\t ERROR - seg0.getPoRight().getX() - expected 7 ; actual="
                            + seg0.getPoRight().getX());
        } else
            System.out.println("\t OK - seg0.getPoRight().getX() - expected 7 ; actual="
                            + seg0.getPoRight().getX());
                            
        System.out.println("move hotizontal");    
        seg0.moveHorisontal(2);
        if (seg0.getPoLeft().getX() != 7) {
            System.out.println("\t ERROR - seg0.getPoLeft().getX() - expected 7 ; actual="
                            + seg0.getPoLeft().getX() + "(after moving horiz.)");
        } else
            System.out.println("\t OK - seg0.getPoLeft().getX() - expected 7 ; actual="
                            + seg0.getPoLeft().getX());
        if (seg0.getPoRight().getX() != 9) {
            System.out.println("\t ERROR - seg0.getPoRight().getX() - expected 9 ; actual="
                            + seg0.getPoRight().getX()+ "(after moving horiz.)");
        } else
            System.out.println("\t OK - seg0.getPoRight().getX() - expected 9 ; actual="
                            + seg0.getPoRight().getX());

                            
        seg0.moveHorisontal(-12);
        if (seg0.getPoLeft().getX() != -5) {
            System.out.println("\t ERROR - seg0.getPoLeft().getX() - expected -5 ; actual="
                            + seg0.getPoLeft().getX()+ "(after moving horiz.)");
        } else
            System.out.println("\t OK - seg0.getPoLeft().getX() - expected -5 ; actual="
                            + seg0.getPoLeft().getX());
        if (seg0.getPoRight().getX() != -3) {
            System.out.println("\t ERROR - seg0.getPoRight().getX() - expected -3 ; actual="
                            + seg0.getPoRight().getX()+ "(after moving horiz.)");
        } else
            System.out.println("\t OK - seg0.getPoRight().getX() - expected -3 ; actual="
                            + seg0.getPoRight().getX());                        
               
        System.out.println("vertical");
        // vertical      
		if (seg0.getPoLeft().getY() != 3) {
			System.out.println("\t ERROR - seg0.getPoLeft().getY() - expected 3 ; actual="
							+ seg0.getPoLeft().getY()+ "(check vertical gap  right point)");
		} else
			System.out.println("\t OK - seg0.getPoLeft().getY() - expected 3 ; actual="
							+ seg0.getPoLeft().getY());
		if (seg0.getPoRight().getY() != 3) {
			System.out.println("\t ERROR - seg0.getPoRight().getY() - expected 3  ; actual="
							+ seg0.getPoRight().getY()+ "(check vertical gap right point)");
		} else
			System.out.println("\t OK - seg0.getPoRight().getY() - expected 3 ; actual="
							+ seg0.getPoRight().getY());
                            
        seg0.moveVertical(-3);
     	if (seg0.getPoLeft().getY() != 0) {
			System.out.println("\t ERROR - seg0.getPoLeft().getY() - expected 0 ; actual="
							+ seg0.getPoLeft().getY()+ "(after vertical shift)");
		} else
			System.out.println("\t OK - seg0.getPoLeft().getY() - expected 0 ; actual="
							+ seg0.getPoLeft().getY());
							
		if (seg0.getPoRight().getY() != 0) {
			System.out.println("\t ERROR - seg0.getPoRight().getY() - expected 0  ; actual="
							+ seg0.getPoRight().getY()+ "(after vertical shift)");
		} else
			System.out.println("\t OK - seg0.getPoRight().getY() - expected 0 ; actual="
							+ seg0.getPoRight().getY());
    
		seg0.moveVertical(2);
     	if (seg0.getPoLeft().getY() != 2) {
			System.out.println("\t ERROR - seg0.getPoLeft().getY() - expected 2 ; actual="
							+ seg0.getPoLeft().getY()+ "(after vertical shift)");
		} else
			System.out.println("\t OK - seg0.getPoLeft().getY() - expected 2 ; actual="
							+ seg0.getPoLeft().getY());
							
		if (seg0.getPoRight().getY() != 2) {
			System.out.println("\t ERROR - seg0.getPoRight().getY() - expected 2  ; actual="
							+ seg0.getPoRight().getY()+ "(after vertical shift)");
		} else
			System.out.println("\t OK - seg0.getPoRight().getY() - expected 2 ; actual="
							+ seg0.getPoRight().getY());
					
	    System.out.println("point on segment");
	    Point pt = new Point(4,2);
		seg0 = new Segment1(1,2,5,2);
		
		if (seg0.pointOnSegment(pt)) {
			System.out.println("\t OK - seg0.pointOnSegment(pt)  - expected true ; actual="
							+ seg0.pointOnSegment(pt)+ " Point "+ pt + " Segment " + seg0);
		} else
			System.out.println("\t ERROR - seg0.pointOnSegment(pt) - expected true ; actual="
							+ seg0.pointOnSegment(pt) + " Point "+ pt + " Segment " + seg0);
							
		seg0.moveHorisontal(10);
		if (!seg0.pointOnSegment(pt)) {
			System.out.println("\t OK - seg0.pointOnSegment(pt)  - expected true ; actual="
							+ !seg0.pointOnSegment(pt)+ " Point "+ pt + " Segment " + seg0);
		} else
			System.out.println("\t ERROR - seg0.pointOnSegment(pt) - expected true ; actual="
							+ !seg0.pointOnSegment(pt) + " Point "+ pt + " Segment " + seg0 + "(after horz shift)");

		seg0.moveHorisontal(-8);
		if (seg0.pointOnSegment(pt)) {
			System.out.println("\t OK - seg0.pointOnSegment(pt)  - expected true ; actual="
							+ seg0.pointOnSegment(pt)+ " Point "+ pt + " Segment " + seg0);
		} else
			System.out.println("\t ERROR - seg0.pointOnSegment(pt) - expected true ; actual="
							+ seg0.pointOnSegment(pt) + " Point "+ pt + " Segment " + seg0+ "(after horz shift)");

		
		seg0 = new Segment1(1,2,5,2);
		pt = new Point(1,2);
		if (seg0.pointOnSegment(pt)) {
			System.out.println("\t OK - seg0.pointOnSegment(pt)  - expected true ; actual="
							+ seg0.pointOnSegment(pt)+ " Point "+ pt + " Segment " + seg0);
		} else
			System.out.println("\t ERROR - seg0.pointOnSegment(pt) - expected true ; actual="
							+ seg0.pointOnSegment(pt) + " Point "+ pt + " Segment " + seg0 + "(on segments\' edge)");
	
		pt = new Point(5,2);
		if (seg0.pointOnSegment(pt)) {
			System.out.println("\t OK - seg0.pointOnSegment(pt)  - expected true ; actual="
							+ seg0.pointOnSegment(pt)+ " Point "+ pt + " Segment " + seg0);
		} else
			System.out.println("\t ERROR - seg0.pointOnSegment(pt) - expected true ; actual="
							+ seg0.pointOnSegment(pt) + " Point "+ pt + " Segment " + seg0+ "(on segments\' edge)");
							
		pt = new Point(5,3);
		if (!seg0.pointOnSegment(pt)) {
			System.out.println("\t OK - !seg0.pointOnSegment(pt)  - expected true ; actual="
							+ !seg0.pointOnSegment(pt)+ " Point "+ pt + " Segment " + seg0);
		} else
			System.out.println("\t ERROR - seg0.pointOnSegment(pt) - expected true ; actual="
							+ !seg0.pointOnSegment(pt) + " Point "+ pt + " Segment " + seg0 + "(different Y)");
				
		pt = new Point(-222,13);
		if (!seg0.pointOnSegment(pt)) {
			System.out.println("\t OK - !seg0.pointOnSegment(pt)  - expected true ; actual="
							+ !seg0.pointOnSegment(pt)+ " Point "+ pt + " Segment " + seg0);
		} else
			System.out.println("\t ERROR - seg0.pointOnSegment(pt) - expected true ; actual="
							+ !seg0.pointOnSegment(pt) + " Point "+ pt + " Segment " + seg0);
				
		System.out.println("is bigger");
		
		seg0 = new Segment1(1,2,5,2);
		Segment1 seg1 = new Segment1(8,7,9,7);
		if (seg0.isBigger(seg1)) {
			System.out.println("\t OK - seg0.isBigger(seg1)  - expected true ; actual="
							+ seg0.isBigger(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t ERROR - seg0.isBigger(seg1) - expected true ; actual="
							+ seg0.isBigger(seg1) +  " seg0 "+ seg0 + " seg1 " + seg1);

		if (!seg1.isBigger(seg0)) {
			System.out.println("\t OK - !seg1.isBigger(seg0)  - expected true ; actual="
							+ !seg1.isBigger(seg0)+ " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t ERROR - !seg1.isBigger(seg0) - expected true ; actual="
							+ !seg1.isBigger(seg0) +  " seg0 "+ seg0 + " seg1 " + seg1);
	
		//equal segments
		seg0 = new Segment1(1,2,5,2);
		seg1 = new Segment1(8,7,12,7);
		if (!seg0.isBigger(seg1)) {
			System.out.println("\t OK - !seg0.isBigger(seg1)  - expected true ; actual="
							+ !seg0.isBigger(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t ERROR - !seg0.isBigger(seg1) - expected true ; actual="
							+ seg0.isBigger(seg1) +  " seg0 "+ seg0 + " seg1 " + seg1 + "(same size)");

		if (!seg1.isBigger(seg0)) {
			System.out.println("\t OK - !seg1.isBigger(seg0)  - expected true ; actual="
							+ !seg1.isBigger(seg0)+ " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t ERROR - !seg1.isBigger(seg0) - expected true ; actual="
							+ !seg1.isBigger(seg0) +  " seg0 "+ seg0 + " seg1 " + seg1+ "(same size)");

		System.out.println("above / under");
		seg0 = new Segment1(1,7,5,7);
		seg1 = new Segment1(8,2,11,2);

		if (seg0.isAbove(seg1)) {
			System.out.println("\t OK - seg0.isAbove(seg1)  - expected true ; actual="
							+ seg0.isAbove(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t ERROR - seg0.isAbove(seg1) - expected true ; actual="
							+ seg0.isAbove(seg1) +  " seg0 "+ seg0 + " seg1 " + seg1);

		if (seg0.isUnder(seg1)) {
			System.out.println("\t ERROR - seg0.isUnder(seg1) - expected false ; actual="
							+ seg0.isUnder(seg1) +  " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t OK - seg0.isUnder(seg1)  - expected false ; actual="
							+ seg0.isUnder(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);
							
		if (!seg1.isAbove(seg0)) {
			System.out.println("\t OK - !seg1.isAbove(seg0) - expected true ; actual="
							+ !seg1.isAbove(seg0)+ " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t ERROR - !seg1.isAbove(seg0) - expected true ; actual="
							+ !seg1.isAbove(seg0) +  " seg0 "+ seg0 + " seg1 " + seg1);
					
		seg1.moveVertical(1000);
		if (seg1.isAbove(seg0)) {
			System.out.println("\t OK - seg1.isAbove(seg0) - expected true ; actual="
							+ seg1.isAbove(seg0)+ " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t ERROR - seg1.isAbove(seg0) - expected true ; actual="
							+ seg1.isAbove(seg0) +  " seg0 "+ seg0 + " seg1 " + seg1+ "(after move vert)");
	
		seg0 = new Segment1(1,7,5,7);
		seg1 = new Segment1(8,7,11,7);
		if (seg0.isUnder(seg1)) {
			System.out.println("\t ERROR - seg0.isUnder(seg1) - expected false ; actual="
							+ seg0.isUnder(seg1) +  " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t OK - seg0.isUnder(seg1)  - expected false ; actual="
							+ seg0.isUnder(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);
							
		if (seg0.isAbove(seg1)) {
			System.out.println("\t ERROR - seg0.isAbove(seg1) - expected false ; actual="
							+ seg0.isAbove(seg1) +  " seg0 "+ seg0 + " seg1 " + seg1);
		} else
			System.out.println("\t OK - seg0.isAbove(seg1)  - expected false ; actual="
							+ seg0.isAbove(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);

		System.out.println("overlap");				
	
		seg0 = new Segment1(1,7,5,7);
		seg1 = new Segment1(8,7,11,7);
		if (seg0.overlap(seg1) == 0) {
            System.out.println("\t OK - seg0.overlap(seg1) - expected 0 ; actual="
                            + seg0.overlap(seg1) + " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR -seg0.overlap(seg1) - expected 0 ; actual="
                            + seg0.overlap(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);
		
        seg1 = new Segment1(2,7,11,7);
		if (seg0.overlap(seg1) == 3) {
            System.out.println("\t OK - seg0.overlap(seg1) - expected 3 ; actual="
                            + seg0.overlap(seg1) + " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR -seg0.overlap(seg1) - expected 3 ; actual="
                            + seg0.overlap(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);

		seg1.moveHorisontal(2);
		if (seg0.overlap(seg1) == 1) {
            System.out.println("\t OK - seg0.overlap(seg1) - expected 1 ; actual="
                            + seg0.overlap(seg1) + " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR -seg0.overlap(seg1) - expected 1 ; actual="
                            + seg0.overlap(seg1)+ " seg0 "+ seg0 + " seg1 " + seg1);
        seg1.moveVertical(2);
		if (seg0.overlap(seg1) == 1) {
            System.out.println("\t OK - seg0.overlap(seg1) - expected 0 ; actual="
                            + seg0.overlap(seg1) + " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR -seg0.overlap(seg1) - expected 0 ; actual="
                            + seg0.overlap(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1 + "(after vertical move don't affect overlap)");

        System.out.println("isLeft isRight");	
        seg0 = new Segment1(1,7,5,7);
		seg1 = new Segment1(8,7,11,7);

        if (seg1.isRight(seg0)) {
            System.out.println("\t OK - seg1.isRight(seg0) - expected true ; actual="
                            + seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR - seg1.isRight(seg0) - expected true ; actual="
                            + seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1);

        if (seg0.isLeft(seg1)) {
            System.out.println("\t OK -seg0.isLeft(seg1) - expected true ; actual="
                            +seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR - seg0.isLeft(seg1) - expected true ; actual="
                            + seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1);
		
        //overlap
        seg1 = new Segment1(2,7,11,7);
		if (!seg1.isRight(seg0)) {
            System.out.println("\t OK - !seg1.isRight(seg0) - expected true ; actual="
                            + !seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR - !seg1.isRight(seg0) - expected true ; actual="
                            + !seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1 + "(segments overlap)");

        if (!seg0.isLeft(seg1)) {
            System.out.println("\t OK -!seg0.isLeft(seg1) - expected true ; actual="
                            +!seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR - !seg0.isLeft(seg1) - expected true ; actual="
                            + !seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1+ "(segments overlap)");

        // different Y axes do overlap              
 	    seg0 = new Segment1(1,7,5,7);
        seg1 = new Segment1(2,9,11,9);
	    if (!seg1.isRight(seg0)) {
            System.out.println("\t OK - !seg1.isRight(seg0) - expected true ; actual="
                            + !seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR - !seg1.isRight(seg0) - expected true ; actual="
                            + !seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1+ "(different Y axes)");

        if (!seg0.isLeft(seg1)) {
            System.out.println("\t OK -!seg0.isLeft(seg1) - expected true ; actual="
                            +!seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR - !seg0.isLeft(seg1) - expected true ; actual="
                            + !seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1+ "(different Y axes)");
       
        // different Y axes dont overlap
        seg0 = new Segment1(1,7,5,7);
        seg1 = new Segment1(20,9,22,9);
	    if (seg1.isRight(seg0)) {
            System.out.println("\t OK - seg1.isRight(seg0) - expected true ; actual="
                            + seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR - seg1.isRight(seg0) - expected true ; actual="
                            + seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1+ "( different Y axes dont overlap)");

        if (seg0.isLeft(seg1)) {
            System.out.println("\t OK - seg0.isLeft(seg1) - expected true ; actual="
                            + seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t ERROR - seg0.isLeft(seg1) - expected true ; actual="
                            + seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1+ "( different Y axes dont overlap)");

        //single point ovelap                    
        seg0 = new Segment1(1,7,5,7);
		seg1 = new Segment1(5,7,11,7);

        if (seg1.isRight(seg0)) {
            System.out.println("\t ERROR - seg1.isRight(seg0) - expected false ; actual="
                            + seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t OK - seg1.isRight(seg0) - expected false ; actual="
                            + seg1.isRight(seg0)+  " seg0 "+ seg0 + " seg1 " + seg1);

        if (seg0.isLeft(seg1)) {
            System.out.println("\t ERROR - seg0.isLeft(seg1) - expected false ; actual="
                            + seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t OK -seg0.isLeft(seg1) - expected false ; actual="
                            +seg0.isLeft(seg1)+  " seg0 "+ seg0 + " seg1 " + seg1);
    
        System.out.println("trapeze");
        seg0 = new Segment1(10,7,20,7);
		seg1 = new Segment1(13,11,17,11);
        if (seg0.trapezePerimeter(seg1) != 24) {
            System.out.println("\t ERROR -seg0.trapezePerimeter(seg1) - expected 24.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(pitagoras 3-4-5)X2");
        } else
            System.out.println("\t OK -seg0.trapezePerimeter(seg1) - expected 24.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);

         if (seg1.trapezePerimeter(seg0) != 24) {
            System.out.println("\t ERROR - seg1.trapezePerimeter(seg0) - expected 24.0 ; actual="
                            + seg1.trapezePerimeter(seg0)+" seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t OK - seg1.trapezePerimeter(seg0) - expected 24.0 ; actual="
                            + seg1.trapezePerimeter(seg0)+" seg0 "+ seg0 + " seg1 " + seg1);

        //degenerated trapeze  
        seg0 = new Segment1(10,7,20,7);
		seg1 = new Segment1(13,7,17,7);
        if (seg0.trapezePerimeter(seg1) != 20) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 20.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(pitagoras 3-4-5)X2");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 20.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);

         if (seg1.trapezePerimeter(seg0) != 20) {
            System.out.println("\t ERROR - seg1.trapezePerimeter(seg0) - expected 20.0 ; actual="
                            + seg1.trapezePerimeter(seg0)+" seg0 "+ seg0 + " seg1 " + seg1);
        } else
            System.out.println("\t OK - seg1.trapezePerimeter(seg0) - expected 20.0 ; actual="
                            + seg1.trapezePerimeter(seg0)+" seg0 "+ seg0 + " seg1 " + seg1);
         //rectangle
        seg0 = new Segment1(10,7,20,7);
		seg1 = new Segment1(10,10,20,10);
        if (seg0.trapezePerimeter(seg1) != 26) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 26.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(rectangle");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 26.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);
        //degenerated rectangle
        seg0 = new Segment1(10,10,20,10);
		seg1 = new Segment1(10,10,20,10);
        if (seg0.trapezePerimeter(seg1) != 20) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 20.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(degenerated rectangle");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 20.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);


        //Parallelogram
        seg0 = new Segment1(13,6,23,6);
		seg1 = new Segment1(10,10,20,10);
        if (seg0.trapezePerimeter(seg1) != 30) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 30.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(Parallelogram");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 30.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);
         
        //square
        seg0 = new Segment1(5, 5, 10, 5);
		seg1 = new Segment1(5, 10, 10, 10);
        if (seg0.trapezePerimeter(seg1) != 20) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 20.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(square)");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 20.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);
      
         //square
        seg0 = new Segment1(5, 5, 10, 5);
		seg1 = new Segment1(5, 10, 10, 10);
        if (seg0.trapezePerimeter(seg1) != 20) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 20.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(square)");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 20.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);

        //degenerated square
        seg0 = new Segment1(5, 10, 10, 10);
		seg1 = new Segment1(5, 10, 10, 10);
        if (seg0.trapezePerimeter(seg1) != 10) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 10.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(degenerated square)");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 10.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);

        //trapeze with 90 anle between side and base
        seg0 = new Segment1(10,7,20,7);
		seg1 = new Segment1(10,10,24,10);
        if (seg0.trapezePerimeter(seg1) != 32) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 32.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(trapeze with 90 anle between side and base");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 32.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);
 
        //triangle (one degenerated segment)
        seg0 = new Segment1(14,6,14,6);
		seg1 = new Segment1(11,10,17,10);
        if (seg0.trapezePerimeter(seg1) != 16) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 16.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(triangle (one degenerated segment)");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 16.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);
     
        //triangle (one degenerated segment)
        seg1 = new Segment1(14,7,14,7);
		seg0 = new Segment1(10,10,18,10);
        if (seg0.trapezePerimeter(seg1) != 18) {
            System.out.println("\t ERROR - seg0.trapezePerimeter(seg1) - expected 18.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1 + "(triangle (one degenerated segment)");
        } else
            System.out.println("\t OK - seg0.trapezePerimeter(seg1) - expected 18.0 ; actual="
                            + seg0.trapezePerimeter(seg1)+" seg0 "+ seg0 + " seg1 " + seg1);
   
        System.out.println("********** Test Q2 Segment1 - Finish **********\n");

    }

}
