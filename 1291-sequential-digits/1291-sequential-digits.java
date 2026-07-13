class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        String s = "123456789";
        int l = String.valueOf(low).length();
        int h = String.valueOf(high).length();
        for(int i = l; i <= h; i++){
            for(int j = 0; i+j < 10; j++){
                int dig = Integer.parseInt(s.substring(j,i+j));
                if(dig>=low && dig<=high){
                    ans.add(dig);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}