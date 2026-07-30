class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            result += str.length() + "#" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int len = Integer.valueOf(str.substring(i, j));
            String res = str.substring(j + 1, j + len + 1);
            result.add(res);
            i = j + len + 1;
        }

        return result;
    }
}
