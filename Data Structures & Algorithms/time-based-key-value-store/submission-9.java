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
        List<Pair> values = map.getOrDefault(key, new ArrayList<>());

        int low = 0, high = values.size() - 1;
        String result = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values.get(mid).timestamp <= timestamp) {
                result = values.get(mid).value;
                low = mid + 1;
            } else high = mid - 1;
        }

        return result;
    }

    /*

        key: (value, timestamp)

    */
}
