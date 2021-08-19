//package com;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//
//import static java.util.Arrays.asList;
//import static org.junit.Assert.assertEquals;
//
//public class AmazonFreshPromotionTest {
//
//    //Test 1
//    List<List<String>> codeList1 = asList(asList("apple", "apple"), asList("banana", "anything", "banana"));
//    ArrayList<String> shoppingCart1 = new ArrayList<>(asList("orange", "apple", "apple", "banana", "orange", "banana"));
//
//    //Test 2
//    List<List<String>> codeList2 = asList(asList("apple", "apple"), asList("banana", "anything", "banana"));
//    ArrayList<String> shoppingCart2 = new ArrayList<>(asList("banana", "orange", "banana", "apple", "apple"));
//
//    //Test 3
//    List<List<String>> codeList3 = asList(asList("apple", "apple"), asList("banana", "anything", "banana"));
//    ArrayList<String> shoppingCart3 = new ArrayList<>(asList("apple", "banana", "apple", "banana", "orange", "banana"));
//
//    //Test 4
//    List<List<String>> codeList4 = asList(asList("apple", "apple"), asList("apple", "apple", "banana"));
//    ArrayList<String> shoppingCart4 = new ArrayList<>(asList("apple", "apple", "apple", "banana"));
//
//    //Test 5
//    List<List<String>> codeList5 = asList(asList("apple", "apple" ), asList( "banana", "anything", "banana" ));
//    ArrayList<String> shoppingCart5 = new ArrayList<>(asList("orange", "apple", "apple", "banana", "orange", "banana"));
//
//    //Test 6
//    List<List<String>> codeList6 = asList(asList("apple", "apple" ), asList("banana", "anything", "banana" ));
//    ArrayList<String> shoppingCart6 = new ArrayList<>(asList("apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"));
//
//    //Test 7
//    List<List<String>> codeList7= asList(asList("anything", "apple" ), asList( "banana", "anything", "banana" ));
//    ArrayList<String> shoppingCart7 = new ArrayList<>(asList("orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"));
////    String[][] codeList7= {{"anything", "apple" }, { "banana", "anything", "banana" }};
////    String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
//
//
//    //Test 8
//    List<List<String>> codeList8 = asList(asList("apple", "orange"), asList("orange", "banana", "orange"));
//    ArrayList<String> shoppingCart8 = new ArrayList<>(asList("apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"));
//
//    //Test 9
//    List<List<String>> codeList9= asList(asList( "anything", "anything", "anything", "apple"), asList( "banana", "anything", "banana" ));
//    ArrayList<String> shoppingCart9 = new ArrayList<>(asList("orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"));
//
//    AmazonFreshPromotion tester = new AmazonFreshPromotion();
//
//    @Test
//    public void checkWinnerTest() {
//        //Test 1
//        assertEquals(1, tester.checkWinner(codeList1, shoppingCart1));
//        // Test 2
//        assertEquals(0, tester.checkWinner(codeList2, shoppingCart2));
//        // Test 3
//        assertEquals(0, tester.checkWinner(codeList3, shoppingCart3));
//        // Test 4
//        assertEquals(0, tester.checkWinner(codeList4, shoppingCart4));
//        //Test 5
//        assertEquals(1, tester.checkWinner(codeList5, shoppingCart5));
//        // Test 6
//        assertEquals(1, tester.checkWinner(codeList6, shoppingCart6));
//        // Test 7
//        assertEquals(1, tester.checkWinner(codeList7, shoppingCart7));
//        // Test 8
//        assertEquals(1, tester.checkWinner(codeList8, shoppingCart8));
//        // Test 9
//        assertEquals(1, tester.checkWinner(codeList9, shoppingCart9));
//    }
//}
