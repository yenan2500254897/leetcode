package JZOffer;

import java.util.Arrays;

public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null || postorder.length==0){
            return false;
        }
        return verify(postorder);
    }

    public boolean verify(int[] postOrder){
        if(postOrder.length == 0){
            return true;
        }
        int head=0;
        int tair=postOrder.length-2;
        int root = postOrder[postOrder.length-1];

        while (head<postOrder.length-1 && postOrder[head]<root){
            head++;
        }
        while (tair>=0 && postOrder[tair]>root){
            tair--;
        }
        if(tair+1!=head){
            return false;
        }
        int[] right = Arrays.copyOfRange(postOrder, head, postOrder.length-1);
        int[] left = Arrays.copyOfRange(postOrder, 0, head);

        return verify(left) && verify(right);
    }
}
