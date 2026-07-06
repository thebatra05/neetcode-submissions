class Pair {
    int timestamp;
    String value;
    Pair(int t, String val) {
        this.timestamp = t;
        this.value = val;
    }
}

class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        List<Pair> array = map.get(key);
        int firstTimestamp = array.get(0).timestamp;        
        if (timestamp < firstTimestamp) return "";

        int idx = binarySearch(array, timestamp);

        return map.get(key).get(idx).value;
    }

    private int binarySearch(List<Pair> array, int timestamp) {
        int low = 0, high = array.size() - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (array.get(mid).timestamp == timestamp) return mid;
            else if (array.get(mid).timestamp < timestamp) low = mid + 1;
            else high = mid - 1;
        }

        return high;
    }

    /*

        "check": [5, "one"], [10, "two"]

        0   1   2       low = 0, high = 2, mid = 1
                        low = 2
        "test": [10, "one"], [20, "two"], [30, "three"]


        "key1": [10, "value1"]
         |  
        low
        high

        Case 1: high = mid, low = mid + 1
        Case 2: high = mid - 1, low = mid 
        
        String: List<Pair>
        key: [[timestamp_1, value_1], [timestamp_2, value_2]....[timestamp_n, value_n]]

    */
}
