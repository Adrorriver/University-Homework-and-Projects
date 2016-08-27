
public class Mmn13Test2
{
    public static void main(String [] args)
    {
        
       Point po1 = new Point(3,4);
       Point po2 = new Point(5,6);
       String ans1 = "The correct answer:";
       String ans2 = " | Your answer:";
       
       sepLine();
       System.out.println("check the first constructor and toString method");
       Segment1 seg = new Segment1(po1,po2);
       System.out.println(ans1 + "(3.0,4.0)---(5.0,4.0)" + ans2 + seg.toString());
       
       sepLine();
       System.out.println("check the second constructor");
       Segment1 seg2 = new Segment1(3.5,2.5,4.5,3.5);
       System.out.println(ans1 + "(3.5,2.5)---(4.5,2.5)" + ans2 + seg2.toString());
       
       sepLine();
       System.out.println("check the third constructor");
       Segment1 seg3 = new Segment1(seg);
       System.out.println(ans1 + "(3.0,4.0)---(5.0,4.0)" + ans2 + seg3.toString());
       
       sepLine();
       System.out.println("check the getPoLeft method");
       System.out.println(ans1 + "(3.5,2.5)" + ans2 + seg2.getPoLeft().toString());
       
       sepLine();
       System.out.println("check the getPoRight method");
       System.out.println(ans1 + "(4.5,2.5)" + ans2 + seg2.getPoRight().toString());
       
       sepLine();
       System.out.println("check the getLength method");
       System.out.println(ans1 + "1.0" + ans2 + seg2.getLength());
       seg2 = new Segment1(seg2.getPoRight(),seg2.getPoRight());
       System.out.println(ans1 + "0.0" + ans2 + seg2.getLength());
       
       
       sepLine();
       System.out.println("check the equals method");
       System.out.println(ans1 + "true" + ans2 + seg.equals(seg3));
       seg = new Segment1(seg.getPoRight(),seg.getPoRight());
       System.out.println(ans1 + "false" + ans2 + seg.equals(seg3));
       
       sepLine();
       System.out.println("check the isAbove method");
       System.out.println(ans1 + "true" + ans2 + seg.isAbove(seg2));
       System.out.println(ans1 + "false" + ans2 + seg.isAbove(seg3));
       
       sepLine();
       System.out.println("check the isUnder method");
       System.out.println(ans1 + "false" + ans2 + seg.isUnder(seg2));
       System.out.println(ans1 + "false" + ans2 + seg.isUnder(seg3));
       
       sepLine();
       System.out.println("check the isLeft method");
       System.out.println(ans1 + "true" + ans2 + seg2.isLeft(seg));
       System.out.println(ans1 + "false" + ans2 + seg3.isLeft(seg));
       
       sepLine();
       System.out.println("check the isRight method");
       System.out.println(ans1 + "true" + ans2 + seg.isRight(seg2));
       System.out.println(ans1 + "false" + ans2 + seg3.isRight(seg));
       
       sepLine();
       System.out.println("check the moveHorizontal method");
       seg.moveHorisontal(20);
       System.out.println(ans1 + "(25.0,4.0)---(25.0,4.0)" + ans2 + seg.toString());
       seg.moveHorisontal(-30);
       System.out.println(ans1 + "(-5.0,4.0)---(-5.0,4.0)" + ans2 + seg.toString());
       
       sepLine();
       System.out.println("check the moveVertical method");
       seg.moveVertical(20);
       System.out.println(ans1 + "(-5.0,24.0)---(-5.0,24.0)" + ans2 + seg.toString());
       seg.moveVertical(-30);
       System.out.println(ans1 + "(-5.0,-6.0)---(-5.0,-6.0)" + ans2 + seg.toString());
       
       sepLine();
       System.out.println("check the changeSize method");
       seg.changeSize(-1);
       System.out.println(ans1 + "(-5.0,-6.0)---(-5.0,-6.0)" + ans2 + seg.toString());
       seg.changeSize(5);
       System.out.println(ans1 + "(-5.0,-6.0)---(0.0,-6.0)" + ans2 + seg.toString());
       
       sepLine();
       System.out.println("check the pointOnSegment method");
       Point p = new Point(-3,-6);
       System.out.println(ans1 + "true" + ans2 + seg.pointOnSegment(p));
       p.setX(1);
       System.out.println(ans1 + "false" + ans2 + seg.pointOnSegment(p));
       p = new Point(-3,0);
       System.out.println(ans1 + "false" + ans2 + seg.pointOnSegment(p));
       
       sepLine();
       System.out.println("check the isBigger method");
       System.out.println(ans1 + "false" + ans2 + seg3.isBigger(seg));
       System.out.println(ans1 + "true" + ans2 + seg3.isBigger(seg2)); 
       
       sepLine();
       System.out.println("check the overlap method");
       seg = new Segment1(0,0,5,0);
       seg2 = new Segment1(6,0,10,0);
       seg3 = new Segment1(2,0,8,0);
       System.out.println(ans1 + "3.0" + ans2 + seg3.overlap(seg));
       System.out.println(ans1 + "2.0" + ans2 + seg3.overlap(seg2));
       System.out.println(ans1 + "6.0" + ans2 + seg3.overlap(seg3));
       System.out.println(ans1 + "0.0" + ans2 + seg2.overlap(seg));
       System.out.println(ans1 + "4.0" + ans2 + seg2.overlap(seg2));
       System.out.println(ans1 + "2.0" + ans2 + seg2.overlap(seg3));
       
       sepLine();
       System.out.println("check the trapezePerimeter method");
       seg = new Segment1(0,0,5,0);
       seg2 = new Segment1(0,5,5,5);
       System.out.println(ans1 + "20.0" + ans2 + seg.trapezePerimeter(seg2));
       seg = new Segment1(0,0,5,0);
       seg2 = new Segment1(-4,3,9,3);
       System.out.println(ans1 + "28.0" + ans2 + seg.trapezePerimeter(seg2));
       
    }
    
    private static void sepLine()
    {
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------");
    }
}
