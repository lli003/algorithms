package lc;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 * @author lli003
 *
 */
public class SimplifyPath {
  
  public String simplifyPath(String path){
    if (path == null || path.length() == 0)
        return "/";
    
    Stack<String> stack = new Stack<String>();
    for (String s : path.split("/")){
        if (s.length() == 0 || s.equals("."))
            continue;
        else if (s.equals("..")){
            if (!stack.isEmpty())
                stack.pop();
        } else 
            stack.push(s);
    }
    
    if (stack.isEmpty())
        return "/";
    
    StringBuffer sb = new StringBuffer("");
    while (!stack.isEmpty()){
        sb.insert(0, stack.pop());
        sb.insert(0, "/");
    }
    return sb.toString();
  }

}
