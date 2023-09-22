// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.
// Example: Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
/*
  @param {number[]} nums
  @param {number} target
  @return {number[]}
 */
var twoSum = function(nums, target) {
    var i = 0, j=0, index = [];
    while(i < nums.length) {
        j = i + 1;
        while(j < nums.length) {
            if(nums[i] + nums[j] === target) {
                index.push(i);
                index.push(j);
                return index;
            }
            j++;
        }
        i++;
    }    
};
