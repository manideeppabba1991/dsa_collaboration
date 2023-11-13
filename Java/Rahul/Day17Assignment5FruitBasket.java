//https://leetcode.com/problems/fruit-into-baskets/submissions/
//TC = O(n), SC= O(n)

class Solution {
    public int totalFruit(int[] fruits) {
        int max =0;
        int windStart =0;
        int windEnd =0;
        int firstFruit=0 ;
        int secondFruit= 0;
        Map<Integer,Integer> fruitIndex = new HashMap<>();

        while(windEnd<fruits.length){
            if(fruitIndex.size() == 0){
                fruitIndex.put(fruits[windEnd], windEnd);
                firstFruit = fruits[windEnd];
                windEnd++;
                max++;
            }else if(fruitIndex.size() == 1 && !fruitIndex.containsKey(fruits[windEnd])){
                fruitIndex.put(fruits[windEnd], windEnd);
                secondFruit = fruits[windEnd];
                windEnd++;
                max++;
            }
            else if(fruitIndex.size()==2 && !fruitIndex.containsKey(fruits[windEnd])){
                windStart = fruitIndex.remove(firstFruit)+1;
                firstFruit = secondFruit;
                secondFruit = fruits[windEnd];
                fruitIndex.put(fruits[windEnd], windEnd);
                max = Math.max(max, windEnd-windStart);
                windEnd++;
            }else{
                if(fruitIndex.size()==2 && secondFruit != fruits[windEnd]){
                    firstFruit = secondFruit;
                    secondFruit = fruits[windEnd];
                }
                fruitIndex.put(fruits[windEnd], windEnd);
                windEnd++;
                max = Math.max(max, windEnd-windStart);
            }
        }
        return max;
    }
}
