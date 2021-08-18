package com;

import java.util.ArrayList;
import java.util.List;

public class AmazonFreshPromotion {

//    public int checkWinner(List<List<String>> codeList, ArrayList<String> shoppingCart) {
//        int codeListSize = codeList.size();
//        int currCodeListOuterItr = 0;
//        int currCodeListInnerItr = 0;
//        for (int i = 0; i < shoppingCart.size(); i++) {
//            if (matchFruit(shoppingCart.get(i), codeList.get(currCodeListOuterItr).get(currCodeListInnerItr))) {
//                // check currCodeListInnerItr must be less than current size of currCodeListOuterItr
//                if (currCodeListOuterItr == codeListSize - 1 && currCodeListInnerItr == codeList.get(currCodeListOuterItr).size() - 1)
//                    return 1;
//                else if (currCodeListInnerItr < codeList.get(currCodeListOuterItr).size() - 1)
//                    // increment currCodeListInnerItr
//                    currCodeListInnerItr++;
//                else {
//                    // else if currCodeListOuterItr is less than total number of pattern increase it and currCodeListOuterItr 0
//                    // increase to next item of codeList is present
//                    currCodeListOuterItr++;
//                    currCodeListInnerItr = 0;
//                }
//            }else{
//                if(!codeList.get(currCodeListOuterItr).get(currCodeListInnerItr).equals("anything"))
//                    currCodeListInnerItr = 0;
//            }
//        }
//        return 0;
//    }
//
//    private boolean matchFruit(String cartItem, String codeListItem) {
//        if (codeListItem.equals("anything"))
//            return true;
//        return cartItem.equals(codeListItem);
//    }

    public static int checkWinner(List<List<String>> codes, ArrayList<String> shoppingCart){
        StringBuilder regex = new StringBuilder(".*");

        for(List<String> code : codes){
            for(String str : code){
                regex.append(str.equals("anything") ? ".+" : str);
            }
            regex.append(".*");
        }

        StringBuilder cart = new StringBuilder();

        for(String str : shoppingCart){
            cart.append(str);
        }
//        System.out.println(cart);
//        System.out.println(regex);
        return cart.toString().matches(regex.toString()) ? 1 : 0;
    }
}
