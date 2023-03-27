class Solution {
    public int solution(int[][] sizes) {
        int widthWallet = 0;   // 지갑의 가로 길이
        int lengthWallet = 0;   // 지갑의 세로 길이
        
        for (int i = 0; i < sizes.length; i++) {
            // 각 명함의 가로와 세로의 길이 중 더 긴 쪽을 지갑의 가로 방향으로 넣고, 
            widthWallet = Math.max(widthWallet, Math.max(sizes[i][0], sizes[i][1]));
            // 더 짧은 쪽을 지갑의 세로 방향으로 넣으면 지갑의 크기를 최소화 할 수 있다
            lengthWallet = Math.max(lengthWallet, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return widthWallet * lengthWallet;
    }
}