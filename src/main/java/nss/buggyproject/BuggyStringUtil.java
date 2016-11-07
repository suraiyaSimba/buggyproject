/**
 * 
 */
package nss.buggyproject;

/**
 * @author nikhils
 *
 */
public class BuggyStringUtil {

	
	
	public static String replaceString(String s, String sMatch, String sReplace)
    {
        if (sReplace == null)
            sReplace = "";

        if (sMatch == null || "".equals(sMatch) || sMatch.equals(sReplace))
            return s;

        if (s == null || s.equals(""))
        {
            return "";
        }

        int i = 0;
        int j = s.indexOf(sMatch);

        if (j < 0)
        {
            return s;
        }

        //Comemnted to introduce defect
        //StringBuffer sb = new StringBuffer(s.length());  
        StringBuffer sb = new StringBuffer("test"); 
        while (true)
        {
            sb.append(s.substring(i, j));
            sb.append(sReplace);

            i = j + sMatch.length();
            j = s.indexOf(sMatch, i);

            if (j < 0)
            {
                sb.append(s.substring(i));
                break;
            }
        }

        return sb.toString();
    }
	
	
	
	 public static boolean isEmpty(final CharSequence cs) {
		 //Introduce defect
//		         return cs == null || cs.length() == 0;
		 return cs == null && cs.length() == 0;
		     }
	
	 
	  public static String trim(final String str) {
		  // Introduce defect
//		          return str == null ? null : str.trim();
		          
		  return( (str == null) ? null : str.trim());
		      
	  }
		  
}
