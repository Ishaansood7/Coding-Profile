class Solution {
    public String removeOuterParentheses(String s) {
        int openCnt = 0;
        int closeCnt = 0;

        String valid = "";

        for(int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);

                if(a == '(') {
                    if(openCnt > 0) valid += a;
                    openCnt++;
                }

                else if(openCnt > 0) {
                    openCnt--;
                    if(openCnt > 0) valid += a;
                }
            }
            return valid;
    }
}