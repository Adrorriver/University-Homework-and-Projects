
/**
 * Tester
 * 
 *
 */
public class TestClass
{
    public static void main (String [] args)
    {
        Set set = new Set();
        set.addToSet(1);
        set.addToSet(15);
        set.addToSet(37);
        set.addToSet(5);
        set.addToSet(13);
        set.addToSet(101);
        
        Set set1 = new Set();
        set1.addToSet(3);
        set1.addToSet(15);
        set1.addToSet(25);
        set1.addToSet(5);
        set1.addToSet(13);
        set1.addToSet(19);
        set1.addToSet(81);
        set1.addToSet(51);
        System.out.print (set.toString()+"        ");
        System.out.println (set1.toString()+"\n\n");
        System.out.println (set.intersection (set1));
        System.out.println (set.union (set1));
        System.out.println (set.difference (set1));
        System.out.println (set1.difference (set));
    }
    
}
