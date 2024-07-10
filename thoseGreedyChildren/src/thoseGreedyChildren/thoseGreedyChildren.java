package thoseGreedyChildren;

public class thoseGreedyChildren {
    public static void main(String[] args) {
        // Example 1:
        // Input: g = [1,2,3], s = [1,1]
        // Output: 1
        // Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
        // And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
        // You need to output 1.

        int[] g = {1, 2, 3}; // Greed Factor
        int[] s = {1, 1}; // Cookie Jar Size

        int maxContentChildren = findMaxContentChildren(g, s); // call function findMaxContentChildren in main
        System.out.println("For Example 1, the maximum number of content children is " + maxContentChildren);

        // Example 2:
        // Input: g = [1,2], s = [1,2,3]
        // Output: 2
        // Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
        // You have 3 cookies and their sizes are big enough to gratify all the children,
        // You need to output 2.

        g = new int[]{1, 2}; // reinitialize for second ex
        s = new int[]{1, 2, 3}; // reinitialize for second ex

        maxContentChildren = findMaxContentChildren(g, s);
        System.out.println("For Example 2, the maximum number of content children is " + maxContentChildren);
    }

    public static int findMaxContentChildren(int[] g, int[] s) { // create function findMaxContentChildren

        int i = 0; // # of children @ start
        int j = 0; // # of cookies @ start
        int maxContentChildren = 0; // # of max amount of content children @ start

        while (i < g.length && j < s.length) { // while loop into an if statement to continually find the max
            if (s[j] >= g[i]) {                // if the size of the jar is greater or equal to the greed factor of the children, then
                maxContentChildren++;          // increase the number of children in the var
                i++;                           // increase i until the while statement fails
            }
            j++;                               // increase j until the while statement fails
        }

        return maxContentChildren; // returns the final number of children in the var
        // after the while and if statements fail
    }
}
