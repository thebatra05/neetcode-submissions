class RandomizedSet {
    Map<Integer, Integer> indexMap;
    List<Integer> nums;

    public RandomizedSet() {
        this.indexMap = new HashMap<>();
        this.nums = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) return false;
        nums.add(val);
        indexMap.put(val, nums.size() - 1);

        return true;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) return false;

        int idx1 = indexMap.get(val);
        int lastIdx = nums.size() - 1;
        nums.set(idx1, nums.get(lastIdx));
        indexMap.put(nums.get(lastIdx), idx1);
        indexMap.remove(val);
        nums.remove(nums.size() - 1);

        return true;
    }
    
    public int getRandom() {
        int idx = (int)(Math.random() * nums.size());

        return nums.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */