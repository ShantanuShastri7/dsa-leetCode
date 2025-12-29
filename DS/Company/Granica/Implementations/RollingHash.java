public class RollingHash{
    private int mod;
    private int windowSize;
    private long hashValue;

    public RollingHash(int mod, int, windowSize){
        this.mod = mod;
        this.windowSize = windowSize;
        this.hashValue=0;
    }

    public void append(Character c){
        this.hashValue=this.hashValue*mod + ((int)c - 'a');
    }

    public void skip(Character c){
        this.hashValue -= ((int)c - 'a') * Math.pow(mod, windowSize - 1);
    }

    public long getHashValue(){
        return this.hashValue;
    }
}