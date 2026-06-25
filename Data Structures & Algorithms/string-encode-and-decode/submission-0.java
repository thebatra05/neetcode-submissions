class Solution {

    public String encode(List<String> strs) {
        String encodedVersion = "";
        for (String str : strs) {
            encodedVersion += str.length() + "#" + str;
        }

        return encodedVersion;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            strs.add(str.substring(i, j));
            i = j;
        }

        return strs;
    }

/*

    "Hello", "World"
    5#Hello5#World

*/

    
}
