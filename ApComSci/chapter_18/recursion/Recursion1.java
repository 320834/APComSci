package recursion;

public class Recursion1
{
    /*
     * Given a string that contains a single pair of parenthesis,
     * compute recursively a new string made of only of the parenthesis
     * and their contents, so "xyz(abc)123" yields "(abc)".
     * 
     * parenBit("xyz(abc)123") -> "(abc)"
     * parenBit("x(hello)") -> "(hello)"
     * parenBit("(xy)1") -> "(xy)"
     */
    public String parenBit(String str)
    {
        if(str.startsWith("(") && str.endsWith(")"))
            return str;
        
        if(str.endsWith(")"))
            return parenBit(str.substring(1));
        else
            return parenBit(str.substring(0, str.length() - 1));
    }
    
    /*
     * Given a string, compute recursively a new string where
     * identical chars that are adjacent in the original string
     * are separated from each other by a "*". 
     * 
     * pairStar("hello") -> "hel*lo"
     * pairStar("xxyy") -> "x*xy*y"
     * pairStar("aaaa") -> "a*a*a*a"
     */
    public String pairStar(String str)
    {
        if(str.length() < 2)
            return str;
        
        String result = "" + str.charAt(0);
        
        if(str.charAt(0) == str.charAt(1))
            result += "*";
        
        result += pairStar(str.substring(1));
        
        return result;
    }
    
    /*
     * Given a string and a non-empty substring sub, compute recursively
     * if at least n copies of sub appear in the string somewhere, possibly
     * with overlapping. N will be non-negative. 
     * 
     * strCopies("catcowcat", "cat", 2) -> true
     * strCopies("catcowcat", "cow", 2) -> false
     * strCopies("catcowcat", "cow", 1) -> true
     */
    public boolean strCopies(String str, String sub, int n)
    {
        if(str.length() < sub.length())
            return n <= 0;
        
        if(str.startsWith(sub))
            n--;
        
        return strCopies(str.substring(1), sub, n);
    }
    
	/*
	 * Given a string, compute recursively (no loops) a new string where all
	 * the lowercase 'x' chars have been replaced with 'y' chars.
	 * 
	 * changeXY("codex") -> "codey"
	 * changeXY("xxhixx") -> "yyhiyy"
	 * changeXY("xhixhix") -> "yhiyhiy"
	 */
	public String changeXY(String str)
	{
		if (str.length() == 0)
			return "";

		if (str.charAt(0) == 'x')
			return "y" + changeXY(str.substring(1));
		else
			return str.substring(0, 1) + changeXY(str.substring(1));
	}

	/*
	 * Given a string, compute recursively a new string where all the lowercase 'x'
	 * chars have been moved to the end of the string.
	 * 
	 * endX("xxre") -> "rexx"
	 * endX("xxhixx") -> "hixxxx"
	 * endX("xhixhix") -> "hihixxx"
	 */
	public String endX(String str)
	{
		if(str.length() == 0)
			return "";
		
		if(str.charAt(0) == 'x')
			return endX(str.substring(1)) + "x";
		
		return str.substring(0,1) + endX(str.substring(1));
	}

	/*
	 * Given an array of ints, compute recursively if the array contains somewhere a value followed
	 * immediately in the array by that value times 10. We'll use the convention of considering only
	 * the part of the array that begins at the given index. In this way, a recursive call can pass
	 * index+1 to move down the array. The initial call will pass in index as 0.
	 * 
	 * array220({1, 2, 20}, 0) -> true
	 * array220({3, 30}, 0) -> true
	 * array220({3}, 0) -> false
	 */
	public boolean array220(int[] nums, int index)
	{
		if (index >= nums.length - 1)
			return false;

		return nums[index] * 10 == nums[index + 1] || array220(nums, index + 1);
	}

	/*
	 * Given a string and a non-empty substring sub, compute recursively the largest substring which
	 * starts and ends with sub and return its length.
	 * 
	 * strDist("catcowcat", "cat") -> 9
	 * strDist("catcowcat", "cow") -> 3
	 * strDist("cccatcowcatxx", "cat") -> 9
	 */
	public int strDist(String str, String sub)
	{
		if (str.length() < sub.length())
			return 0;

		// if starts and ends with, done
		if (str.startsWith(sub) && str.endsWith(sub))
			return str.length();

		// otherwise, return max of stripping beginning or end
		return Math.max(strDist(str.substring(0, str.length() - 1), sub), strDist(str.substring(1), sub));
	}

	/*
	 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..)
	 * have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because
	 * they each have a raised foot. Recursively return the number of "ears" in the bunny
	 * line 1, 2, ... n (without loops or multiplication).
	 * 
	 * bunnyEars2(0) -> 0
	 * bunnyEars2(1) -> 2
	 * bunnyEars2(2) -> 5
	 */
	public int bunnyEars2(int bunnies)
	{
		if (bunnies == 0)
			return 0;

		if (bunnies % 2 == 0) // this bunny is even
			return bunnyEars2(bunnies - 1) + 3;
		else // this bunny is odd
			return bunnyEars2(bunnies - 1) + 2;
	}

	/*
	 * Given a string, compute recursively (no loops) a new string where all appearances of "pi"
	 * have been replaced by "3.14".
	 * 
	 * changePi("xpix") -> "x3.14x"
	 * changePi("pipi") -> "3.143.14"
	 * changePi("pip") -> "3.14p"
	 */
	public String changePi(String str)
	{
		if (str.length() == 0)
			return "";

		if (str.startsWith("pi"))
			return "3.14" + changePi(str.substring(2));
		else
			return str.substring(0, 1) + changePi(str.substring(1));
	}

	/*
	 * Given a string, return recursively a "cleaned" string where adjacent chars that are the same
	 * have been reduced to a single char. So "yyzzza" yields "yza".
	 * 
	 * stringClean("yyzzza") -> "yza"
	 * stringClean("abbbcdd") -> "abcd"
	 * stringClean("Hello") -> "Helo"
	 */
	public String stringClean(String str)
	{
		if (str.length() < 2)
			return str;

		if (str.charAt(0) == str.charAt(1))
			return stringClean(str.substring(1));
		else
			return str.substring(0, 1) + stringClean(str.substring(1));
	}

	/*
	 * Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like
	 * "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's
	 * inside them.
	 * 
	 * nestParen("(())") -> true
	 * nestParen("((()))") -> true
	 * nestParen("(((x))") -> false
	 */
	public boolean nestParen(String str)
	{
		if (str.length() == 0)
			return true;

		return str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')'
		    && nestParen(str.substring(1, str.length() - 1));
	}
	
	/*
	 * Given a non-negative int n, compute recursively (no loops) the count of the
	 * occurrences of 8 as a digit, except that an 8 with another 8 immediately to
	 * its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the
	 * rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost
	 * digit (126 / 10 is 12). 
	 * 
	 * count8(8) -> 1
	 * count8(818) -> 2
	 * count8(8818) -> 4
	 */
    public int count8(int n)
    {
        if (n < 10)
            return n == 8 ? 1 : 0;

        int lastDigit = n % 10;
        int secondToLastDigit = n / 10 % 10;

        int eights = 0;

        if (lastDigit == 8)
        {
            eights++;
            if (secondToLastDigit == 8)
                eights++;
        }

        return eights + count8(n / 10);
    }

    /*
     * We'll say that a "pair" in a string is two instances of a char separated
     * by a char. So "AxA" the A's make a pair. Pair's can overlap, so
     * "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the
     * number of pairs in the given string. 
     * 
     * countPairs("axa") -> 1
     * countPairs("axax") -> 2
     * countPairs("axbx") -> 1
     */
    public int countPairs(String str)
    {
        if(str.length() < 3)
            return 0;
        
        int pairs = countPairs(str.substring(1));
        
        if(str.charAt(0) == str.charAt(2))
            pairs++;
        
        return pairs;
    }

    /*
     * Given an array of ints, compute recursively the number of times that the
     * value 11 appears in the array. We'll use the convention of considering only
     * the part of the array that begins at the given index. In this way, a
     * recursive call can pass index+1 to move down the array. The initial call
     * will pass in index as 0. 
     * 
     * array11({1, 2, 11}, 0) -> 1
     * array11({11, 11}, 0) -> 2
     * array11({1, 2, 3, 4}, 0) -> 0
     */
    public int array11(int[] nums, int index)
    {
        if(index >= nums.length)
            return 0;
        
        int times = array11(nums, index + 1);
        
        if(nums[index] == 11)
            times++;
        
        return times;
    }
    
    /*
     * Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns
     * {2, 5, 3, 6}. You may modify and return the given array, or return a new array. 
     * 
     * shiftLeft({6, 2, 5, 3}) -> {2, 5, 3, 6}
     * shiftLeft({1, 2}) -> {2, 1}
     * shiftLeft({1}) -> {1}
     */
    public int[] shiftLeft(int[] nums)
    {
        if(nums.length == 0)
            return nums;
        
        int temp = nums[0];
        
        for(int i = 1; i < nums.length; i++)
            nums[i-1] = nums[i];
        
        nums[nums.length - 1] = temp;
        
        return nums;
    }
}
