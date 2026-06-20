class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        boolean[] isVisible = new boolean[lights.length];
        int[] diff = new int[n+1];

        for(int i=0; i<n; i++){
            if(lights[i]>0){
                int start = Math.max(0, i-lights[i]);
                int end = Math.min(n-1, i+lights[i]);

                diff[start]+=1;
                diff[end+1]-=1;
            }
        }

        int current =0;
        for(int i=0; i<n; i++){
            current+=diff[i];

            if(current>0){
                isVisible[i]=true;
            }
        }
        

        int addedLights=0;
        int i=0;

        while(i<n){
            if(isVisible[i]==false){
                addedLights++;
                i+=3;
            } else{
                i++;
            }
        }
        

        return addedLights;
    }
}
