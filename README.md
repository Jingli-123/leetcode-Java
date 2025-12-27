# leetcode-Java
I am starting a 60-day challenge to solve 150 LeetCode problems and record my progress on this blog. 
### Day 2 - Array Part 02
### Day 3 - ListNode Part 01
### Day 4 - ListNode Part 02
### Day 5 - Hash Part 01
### Day 6 - String Part 02
### Day 7 - Hash Part 02 -- Not Start Yet
### Day 8 - String Part 02
### Day 9 - Stack and Queue Part 01
### Day 11 - Stack and Queue Part 02
### Day 12 - Binary tree part 01-1
### Day 13 - Binary tree part 01-2
### Day 14 - Binary tree part 02
### Day 15 - Binary tree part 03 & 04 
### Day 16 - Binary tree part 05
### Day 17 - Binary tree part 06 & 07
### Day 18 - Binary tree part 08
### Day 19 - Backtracking Algorithm part 01

**Note**
- **Recursion**: 
1. Determine the parameters and return value of a recursive function。
2. Determine the base case.
3. Determian the logic of a single recursion layer.

-**前中后序历遍**
1. 前序历遍：中左右；
2. 中序历遍：左中右；
3. 后序历遍：左右中；

-**Note**-
Todo List
1. Leetcode - 531
2. Leetcode - 98

-**Backtracking Algorithm**-
伪代码：
void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果
    }
}