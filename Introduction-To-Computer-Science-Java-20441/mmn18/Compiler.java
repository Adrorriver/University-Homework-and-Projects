
/**
 * 
 * 
 * @author (amir dror) 
 * @version (19.6.2012)
 */
public class Compiler
{   
    public static boolean compilation (String s)
    {
        DataStack stack = new DataStack();
        if (s == null || s.length() == 0) return true;
        
        for (int i = 0; i < s.length(); i++)
        {
            if (opener(s.charAt(i))) stack.push(new DataNode (s.charAt(i),null));
            if (closer(s.charAt(i))) 
            {
                if (stack.empty())return false;
                if (!check(stack.pop().getValue(),s.charAt(i))) return false;
            }
        }
        return (stack.empty());
    }
    
    private static boolean opener (char note)
    {
        return (note == '{' || note == '(' || note == '['); 
    }
    
    private static boolean closer (char note)
    {
        return (note == '}' || note == ')' || note == ']'); 
    }
    
    private static boolean check (char open ,char close)
    {
        return (open == '{' && close == '}' ||
                open == '(' && close == ')' ||
                open == '[' && close == ']'); 
    }
    
}
