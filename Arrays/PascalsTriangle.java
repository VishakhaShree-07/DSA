import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer>rw=new ArrayList<>();
            long val = 1;
            for(int j=0;j<=i;j++){
                rw.add((int)val);
                val=val*(i-j)/(j+1);
            }
            res.add(rw);
        }
        return res;
        
    }
}