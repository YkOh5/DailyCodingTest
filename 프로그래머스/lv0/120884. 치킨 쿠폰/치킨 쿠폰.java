class Solution {
    public int solution(int chicken) {
        int servChicken = 0;
        
        while (chicken >= 10) {
            servChicken += chicken / 10;
            chicken = chicken % 10 + chicken / 10;
        }
        
        return servChicken;
    }
}