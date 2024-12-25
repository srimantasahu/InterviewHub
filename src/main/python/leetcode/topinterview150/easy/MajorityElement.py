"""
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

Follow-up: Could you solve the problem in linear time and in O(1) space?
"""
from typing import List


class MajorityElement:

    """
    Approach : Boyer-Moore Voting Algorithm
        This algorithm finds the majority element by maintaining a count, incrementing for the same element, and decrementing for different elements.
    """

    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        candidate = None

        for num in nums:
            if count == 0:
                candidate = num
            count += (1 if num == candidate else -1)

        return candidate


# test code
test = MajorityElement()
ns = [2, 2, 1, 1, 1, 2, 2]
v = test.majorityElement(ns)
print("majority element is: " + str(v))
print("ns list is: " + str(ns))
