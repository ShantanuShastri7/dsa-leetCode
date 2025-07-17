Print Longest Increasing Subsequence
Difficulty: MediumAccuracy: 51.81%Submissions: 40K+Points: 4Average Time: 20m
You are given an array of integers arr[], return the Longest Increasing Subsequence (LIS) of the given array.
LIS is the longest subsequence where each element is strictly greater than the previous one.
Note: If multiple LIS of the same maximum length exist, return the one that appears first based on the lexicographical order of their indices (i.e., the earliest combination of positions from the original sequence).

Examples:

Input: arr[] = [10, 20, 3, 40]
Output: [10, 20, 40]
Explanation: [10, 20, 40] is the longest subsequence where each number is greater than the previous one, maintaining the original order.
Input: arr[] = [10, 22, 9, 33, 21, 50, 41, 60, 80]
Output: [10, 22, 33, 50, 60, 80]
Explanation: There are multiple longest Increasing subsequence of length 6, that is [10, 22, 33, 50, 60, 80] and [10 22 33 41 60 80]. The first one has lexicographic smallest order of indices.
Constraint:
1 <= n < = 5*103
0 <= arr[i] <= 109
