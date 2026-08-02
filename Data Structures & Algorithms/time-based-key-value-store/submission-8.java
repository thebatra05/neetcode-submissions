class Pair {
    String value;
    int timestamp;
    Pair(String val, int time) {
        this.value = val;
        this.timestamp = time;
    }
}
class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        List<Pair> values = map.get(key);
        if (timestamp < values.get(0).timestamp) return "";

        int low = 0, high = values.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (timestamp == values.get(mid).timestamp) 
                return values.get(mid).value;
            else if (timestamp > values.get(mid).timestamp)
                low = mid + 1;
            else high = mid - 1;
        }

        return values.get(high).value;
    }

    /*

        key: (value, timestamp)

    */
}
