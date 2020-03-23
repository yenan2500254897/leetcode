package JZOffer;

public class isMatch {
    public boolean isMatch(String s, String p) {

        int lenOfStr = s.length();
        int lenOfPattern = p.length();

        boolean[][] assistant = new boolean[lenOfStr+1][lenOfPattern+1];
        for(int outter =0;outter<=lenOfStr;outter++){
            for(int inner =0;inner<=lenOfPattern;inner++){
                if(inner==0){
                    assistant[outter][inner] = outter==0;
                }else {
                    if(p.charAt(inner-1)!='*'){
                        if(outter>0 && (s.charAt(outter-1)==p.charAt(inner-1) || p.charAt(inner-1)=='.')){
                            assistant[outter][inner] = assistant[outter-1][inner-1];
                        }
                    }else {
                        //看
                        if(outter>0 && inner>=2 && (s.charAt(outter-1) == p.charAt(inner-2) || p.charAt(inner-2)=='.')){
                            assistant[outter][inner] |= assistant[outter-1][inner];
                        }
                        //不看
                        if(inner>=2){
                            assistant[outter][inner] |= assistant[outter][inner-2];
                        }



                    }
                }
            }
        }
        return assistant[lenOfStr][lenOfPattern];
    }
}
