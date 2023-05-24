class Solution {
    public int solution(int slice, int n) {
        return (n + slice - 1) / slice;
    }
}


// class Solution {
//     public int solution(int slice, int n) {
//         int cnt;
//         for (cnt = 1; cnt * slice < n; cnt++);
        
//         return cnt;
//     }
// }