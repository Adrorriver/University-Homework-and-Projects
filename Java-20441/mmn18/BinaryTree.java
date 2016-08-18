
/**
 *  BinaryTree.
 * 
 * @author (amir dror) 
 * @version (19.06.2012)
 */
public class BinaryTree
{
  // question 1
  public static int maxInTree (Node t)
  {
    if (t == null) return 0;
    if ((t.getLeftSon() == null) && (t.getRightSon() == null)) return t.getNumber();
    if (t.getLeftSon() == null)
    {
           return max (t.getNumber(),maxInTree(t.getRightSon()));
    }
    if (t.getRightSon() == null)
    {
        return max (t.getNumber(),maxInTree(t.getLeftSon()));
    }
    return max ( t.getNumber(), max (maxInTree(t.getLeftSon()),maxInTree(t.getRightSon())));
  }
  
  private static int max (int a, int b)
  {
    if (a > b) return a;
    else return b;
  }

  
  
  
  
   // question 2
  public static int maxInSearchTree (Node root)
  {
    if (root==null) return 0;
    if (root.getRightSon() == null) return root.getNumber();
    else return maxInSearchTree (root.getRightSon());
  }
  
  
  
  
  
   // question 3
  public static int sizeOfTree (Node t)
  {
    if (t == null) return 0;
    return ( 1 + sizeOfTree (t.getLeftSon()) + sizeOfTree (t.getRightSon()));
  }
  
  
  
  
   // question 4
  public static int kElement (Node t, int k)
  {
    if (t == null) return -99999; // for empty tree ,or k < 1 , or k > of the tree element
    
    int sum = k - sizeOfTree (t.getRightSon());
    if (sum == 1) return t.getNumber(); 
    
    if (sum > 1)return (kElement (t.getLeftSon(), sum - 1));
    return (kElement (t.getRightSon(), k ));
  }
  
}