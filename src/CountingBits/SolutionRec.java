package CountingBits;

public class SolutionRec {
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }
        int[] res = new int[num+1];
        f(num,1,1,res);
        return res;
    }

    private void f(int num,int current,int count,int[] res) {
        // base case
        if (current > num) {
            return;
        }
        res[current] = count;
        f(num,current << 1,count,res);
        f(num,(current << 1)+1,count+1,res);
    }
}
