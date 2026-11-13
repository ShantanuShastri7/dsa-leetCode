int maxSubArray(int* nums, int numsSize) {
    int maxSum = -9999999;
    int currentSum = 0;
    bool hasValue = false;
    if(numsSize==1) return nums[0];

    for(int i=0; i<numsSize; i++){
        currentSum+=nums[i];
        if(currentSum>maxSum) maxSum=currentSum;

        if(currentSum<0){
            currentSum=0;
        }
    }
    return maxSum;
}