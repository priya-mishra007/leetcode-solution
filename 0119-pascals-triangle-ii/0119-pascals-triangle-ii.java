class Solution {
    public List<Integer> getRow(int rowIndex) {
        List <List <Integer>> arr= new ArrayList<>();
        for(int i = 0 ; i <= rowIndex ; i++){
            List <Integer> arr1= new ArrayList<>();
            for(int j = 0 ; j <= i ; j++){
                if(j == 0 || i == j ){
                    arr1.add(1);
                }
                else{
                    int value = arr.get(i-1).get(j-1) +arr.get(i-1).get(j);
                    arr1.add(value);
                }
            }
            arr.add(arr1);
        }
        return arr.get(rowIndex);
    }
}