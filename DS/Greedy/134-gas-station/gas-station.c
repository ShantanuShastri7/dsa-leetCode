int canCompleteCircuit(int* gas, int gasSize, int* cost, int costSize) {
    int totalCostOfGoingAround=0;
    int totalGas=0;
    int n = gasSize;
    for(int i=0; i<n; i++){
        totalCostOfGoingAround+=cost[i];
        totalGas+=gas[i];
    }

    if(totalCostOfGoingAround>totalGas) return -1;

    int i=0; 

    while(i<n){
        int gasInTank = gas[i];
        int left=n;
        int index=i;
        while(left>0){
            if(gasInTank<cost[index]) break;
            gasInTank-=cost[index];
            index=(index+1)%n;
            gasInTank+=gas[index];
            left--;
        }
        if(left==0) return i;
        else{
            i=index+1;
        }
    }
    return -1;
}