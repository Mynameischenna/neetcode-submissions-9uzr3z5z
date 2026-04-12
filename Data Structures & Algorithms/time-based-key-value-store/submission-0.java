class TimeMap {
    Map<String, List<Time>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) 
            map.put(key, new ArrayList<>());
        map.get(key).add(new Time(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (map.get(key) == null) return "";
        // find the timestamp <= given timestamp
        List<Time> list = map.get(key);
        int l = 0, h = list.size() - 1;
        int index = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (list.get(mid).timeStamp <= timestamp) {
                index = mid;
                l = mid + 1;
            } else h = mid - 1;
        }
        System.out.println(index);
        if (index == -1) return "";
        else return list.get(index).value;
    }
    class Time{
        String value;
        int timeStamp;

        Time(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }
}
