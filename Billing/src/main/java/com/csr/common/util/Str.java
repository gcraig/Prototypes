package com.csr.common.util;

import java.io.*;
import java.util.*;

public class Str 
{
	public static int toInt(String strValue)  
	{
		return (strValue==null|| strValue.trim().length() < 1 ) ?
			-1: Integer.parseInt(strValue) ;
	}

	public static String normalize(String s) 
	{
		if (s==null || s.trim()=="")
			return "";
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(s.toLowerCase());
		// FIX: exclude stop words: a, to, the
		while (st.hasMoreTokens()) 
		{
			String token = st.nextToken();
			String cap = token.charAt(0) + "";
			sb.append(cap.toUpperCase());
			sb.append(token.substring(1));
			sb.append(" ");
		}
		return sb.toString();
	}

	public static String removeDoubleChar(String s, char c) 
	{
		char ac[] = s.toCharArray();
		int i = ac.length;
		int j = 0;
		Character character = new Character(c);
		String s1 = character.toString() + character.toString();
		do 
		{
			int k = s.indexOf(s1, j);
			if(k == -1)
				return new String(ac, 0, i);
			i--;
			System.arraycopy(ac, k + 1, ac, k, i - k);
			j = k + 1;
		} while(true);
	}

    public static String removeDuplicates(String s, char c) 
	{
		if(s == null || s.length() < 2)
			return s;
		char ac[] = s.toCharArray();
		char ac1[] = new char[ac.length];
		int i = 0;
		boolean flag = false;
		for(int j = 0; j < ac.length; j++) 
		{
			char c1 = ac[j];
			if(c1 == c) 
			{
				if(flag)
				continue;
				flag = true;
			} 
			else 
			{
				flag = false;
			}
			ac1[i++] = c1;
		}
		return new String(ac1, 0, i);
    }

    public static int findSingleChar(String s, int i, int j, char c) {
        boolean flag = false;
        int k = j;
        while(!flag) {
            k = s.indexOf(c, i);
            if(k == -1)
                return j;
            if(s.charAt(k + 1) == c)
                i = k + 2;
            else
                flag = true;
        }
        return k;
    }

    public static String loadFileToString(String s) throws IOException {
        File file = new File(s);
        int i = (int)file.length();
        int j = 0;
        FileInputStream fileinputstream = new FileInputStream(file);
        byte abyte0[] = new byte[i];
        for(; j < i; j += fileinputstream.read(abyte0, j, i - j));
        fileinputstream.close();
        return new String(abyte0);
    }

    public static String[] parseArguments(String s, Character character) {
        int i = 0;
        int j = 0;
        boolean flag = false;
        Vector vector = new Vector();
        char ac[] = s.toCharArray();
        int l = s.length() - 1;
        int k = 0;
        while(!flag) {
            StringBuffer stringbuffer = new StringBuffer(255);
            int i1 = k;
            while(k < l && (i > 0 || j > 0 || ac[k] != ')' && (k == 0 || ac[k] != ',' 
              && ac[k - 1] != '\\'))) {
                if(ac[k] == '\\')
                    k++;
                else
                if(ac[k] == '"')
                    i = 1 - i;
                else
                if(ac[k] == '(')
                    j++;
                else
                if(ac[k] == ')')
                    j--;
                stringbuffer.append(ac[k++]);
            }
            if(k > i1)
            {
                String s1 = stringbuffer.toString().trim();
                if(!s1.equals("") && s1.charAt(0) == '"' && s1.charAt(s1.length() - 1) == '"')
                    s1 = s1.substring(1, s1.length() - 1);
                vector.addElement(s1);
            }
            if(++k >= l)
                flag = true;
        }
        String as[] = new String[vector.size()];
        for(int j1 = 0; j1 < vector.size(); j1++) {
            String s2 = (String)vector.elementAt(j1);
            if(character != null && s2 != null && s2.length() > 1 &&
              s2.charAt(0) == character.charValue())
                s2 = s2.substring(1);
            as[j1] = s2;
        }
        return as;
    }

    public static String databaseQuote(String s, boolean flag) {
        String s1 = "";
        if(flag)
            s1 = "'";
        for(int i = 0; i < s.length(); i++) {
            String s2 = s.substring(i, i + 1);
            if(s2.equals("'"))
                s1 = s1 + "''";
            else
                s1 = s1 + s2;
        }
        if(flag)
            s1 = s1 + "'";
        return s1;
    }

    public static String databaseQuote(String s) {
        return databaseQuote(s, true);
    }

    public static String escapeQuotes(String s) {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        for(int j = s.length(); i < j; i++) {
            char c = s.charAt(i);
            if(c == '"')
                stringbuffer.append("\\\"");
            else
                stringbuffer.append(c);
        }
        return stringbuffer.toString();
    }

    public static boolean matchString(String s, String s1, char c) {
        if(s == null || s1 == null)
            return false;
        int i = 0;
        do  {
            int j = 0;
            do {
                boolean flag = j >= s1.length();
                boolean flag1 = i >= s.length() || s.charAt(i) == c;
                if(flag && flag1)
                    return true;
                if(flag || flag1)
                    break;
                if(s.charAt(i) != '?') {
                    if(s.charAt(i) == '*') {
                        i++;
                        for(int k = s1.length(); k >= j; k--)
                            if(matchString(s.substring(i), s1.substring(k)))
                                return true;
                        break;
                    }
                    if(s.charAt(i) != s1.charAt(j))
                        break;
                }
                i++;
                j++;
            } while(true);
            i = s.indexOf(c, i);
            if(i == -1)
                return false;
            i++;
        } while(true);
    }

    public static boolean matchString(String s, String s1) {
        return matchString(s, s1, '|');
    }

    public static void sortStrings(String as[]) {
        for(int i = 0; i < as.length - 1; i++) {
            for(int j = i + 1; j < as.length; j++)
                if(as[i].compareTo(as[j]) > 0) {
                    String s = as[i];
                    as[i] = as[j];
                    as[j] = s;
                }
        }
    }

    public static String leftPad(String s, int i) {
        if(s == null)
            return null;
        if(s.length() >= i)
            return s;
        int j = i - s.length();
        for(int k = 0; k < j; k++)
            s = " " + s;
        return s;
    }

    public static String substitute(String s, String s1, String s2) {
        if(s1 == null || s1.equals("") || s2 == null)
            return s;
        int i = s.indexOf(s1);
        if(i == -1)
            return s;
        StringBuffer stringbuffer = new StringBuffer(s.length());
        int j = 0;
        for(; i != -1; i = s.indexOf(s1, j)) {
            stringbuffer.append(s.substring(j, i));
            stringbuffer.append(s2);
            j = i + s1.length();
        }
        stringbuffer.append(s.substring(j));
        return stringbuffer.toString();
    }

    public static String getHeaderParameter(String s, String s1) {
        return getHeaderParameter(s, s1, null);
    }

    public static String getHeaderParameter(String s, String s1, String s2) {
        if(s == null || s1 == null)
            return s2;
        int i = s.indexOf(s1);
        if(i == -1)
            return s2;
        int j = s.indexOf(61, i) + 1;
        int k = s.indexOf(59, j);
        if(k == -1)
            return s.substring(j).trim();
        else
            return s.substring(j, k).trim();
    }

    public static String stripParamsFromHeader(String s) {
        if(s == null)
            return null;
        int i = s.indexOf(59);
        if(i == -1)
            return s;
        else
            return s.substring(0, i).trim();
    }

    public static boolean isJavaEscape(char c) {
        return 
          c == 'b' || c == 't' || c == 'n' || c == 'f' || c == 'r' || c == '"' ||
          c == '\'' || c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || 
          c == '5' || c == '6' || c == '7' || c == '\\' || c == 'u';
    }

    public static int occurrences(String s, char c) {
        char ac[] = s.toCharArray();
        int i = 0;
        for(int j = 0; j < ac.length; j++)
            if(ac[j] == c)
                i++;
        return i;
    }

    public static String arrayToString(String as[], char c) {
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < as.length; i++) {
            stringbuffer.append(as[i]);
            stringbuffer.append(c);
        }
        return stringbuffer.toString();
    }

    public static String entitizeHtml(String s) {
        if(s == null)
            return s;
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
            case 62: // '>'
                stringbuffer.append("&gt;");
                break;

            case 60: // '<'
                stringbuffer.append("&lt;");
                break;

            default:
                stringbuffer.append(c);
                break;
            }
        }
        return stringbuffer.toString();
    }

	public static String cleanPath(String s) {
		// use regular expressions
		return s.replace('\\', '/');
	}

	/*
	public String replace(String fromStr, String toStr, File file) {
		String s = null;
		String line = null;
		PrintStream output = null;
		DataInputStream input = null;
		StringBuffer result = new StringBuffer();
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			// BufferedWriter out = new BufferedWriter(FileWriter(file));
			while ((s = in.readLine()) != null) {
				if (re.match(fromStr, toStr)) {
					re.substitute(result, "s/" + fromStr + "/" + toStr, input);
				} 
			}
			in.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace(); // fix
		}
		 input = ""; //input string from file
		return result.toString();
	}
	*/
}