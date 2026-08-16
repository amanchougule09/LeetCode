class Solution {
    public String intToRoman(int num) {

        StringBuilder roman=new StringBuilder();

        TreeMap<Integer,String> stored=new TreeMap<>(Collections.reverseOrder());
        stored.put(1000, "M");
        stored.put(900, "CM"); 
        stored.put(500, "D");
        stored.put(400, "CD"); 
        stored.put(100, "C");
        stored.put(90, "XC");   
        stored.put(50, "L");
        stored.put(40, "XL"); 
        stored.put(10, "X");
        stored.put(9, "IX");    
        stored.put(5, "V");
        stored.put(4, "IV");    
        stored.put(1, "I");

        for(Map.Entry<Integer,String> entry : stored.entrySet()){

            if(num == 0){
                break;
            }

            int count = num / entry.getKey();

            for(int i=0; i<count; i++){
                roman.append(entry.getValue());
            }

            num %= entry.getKey();

        }
        return roman.toString();
    }
}