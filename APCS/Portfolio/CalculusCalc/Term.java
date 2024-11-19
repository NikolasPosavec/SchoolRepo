package Portfolio.CalculusCalc;
import java.util.*;

public class Term
{
    public String TopOfFunct;
    public String BotOfFunct;
    public String OutsideOp;

    public Term()
    {
        TopOfFunct = "";
        BotOfFunct = "";
        OutsideOp = "";
    }
    public Term(String T, String B)
    {
        TopOfFunct = T;
        BotOfFunct = B;
    }
    
}
