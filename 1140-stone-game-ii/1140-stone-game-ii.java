class Solution {
    private int n;
    private int [][][] t = new int[2][101][101];
    public int stoneGameII(int[] piles) {
        n = piles.length;
        for(int[][] arr2 : t){
            for(int[] arr1 : arr2){
                Arrays.fill(arr1, -1);
            }
        }
        return playGame(piles, 'A', 0, 1);
    }
    private int getPersonIndex(char person) {
        return (person == 'A') ? 0 : 1;
    }
    private int playGame(int[] piles, char person, int i, int M){
        if(i >= n){
            return 0;
        }
        int personIndex = getPersonIndex(person);
        if(t[personIndex][i][M] != -1){
            return t[personIndex][i][M];
        }
        int result = (person == 'A') ? -1 :Integer.MAX_VALUE;
        int stones = 0;
        for(int x = 1; x <= Math.min(2 * M, n - i); x++){
            stones += piles[i + x - 1];
            if(person == 'A'){
                result = Math.max(result, stones + playGame(piles, 'B', i + x, Math.max(M, x)));
            }
            else{
                result = Math.min(result, playGame(piles, 'A', i + x, Math.max(M, x)));
            }
        }
        return t[personIndex][i][M] = result;
    }
}