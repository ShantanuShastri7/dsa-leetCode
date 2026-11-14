void helper(int *nums, int index, int *previousMin, int numsSize){
    if(index == numsSize) return;
    for(int i=index-1; i>=0; i--){
        if(previousMin[i]!=100000 && previousMin[i]+1<previousMin[index]){
            if(nums[i]>=index-i){
                previousMin[index] = previousMin[i]+1;
            }
        }
    }

    helper(nums, index+1, previousMin, numsSize);
}

int jump(int* nums, int numsSize) {
    int previousMin[numsSize];
    previousMin[0]=0;
    for(int i=1; i<numsSize; i++){
        previousMin[i]=100000;
    }

    helper(nums, 1, previousMin, numsSize);

    return previousMin[numsSize-1];
}