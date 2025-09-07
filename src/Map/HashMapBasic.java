package Map;


import java.util.HashMap;
import java.util.Map;

public class HashMapBasic {
    public static void main(String[] args) {
        // 创建一个 HashMap，key=String, value=Integer
        Map<String, Integer> scores = new HashMap<>();

        // put(key, value) —— 添加或更新
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);
        System.out.println("After put: " + scores);

        // get(key) —— 根据 key 获取值，不存在返回 null
        System.out.println("Alice's score: " + scores.get("Alice"));

        // getOrDefault(key, defaultValue) —— 获取值，如果不存在返回默认值
        System.out.println("Tom's score (default 0): " + scores.getOrDefault("Tom", 0));

        // containsKey(key) —— 判断是否有某个 key
        System.out.println("Has Bob? " + scores.containsKey("Bob"));

        // containsValue(value) —— 判断是否有某个 value
        System.out.println("Has score 95? " + scores.containsValue(95));

        // putIfAbsent(key, value) —— 只有当 key 不存在时才添加
        scores.putIfAbsent("Alice", 100); // Alice 已经存在，不会更新
        scores.putIfAbsent("Tom", 70);    // Tom 不存在，会添加
        System.out.println("After putIfAbsent: " + scores);

        // remove(key) —— 删除某个 key
        scores.remove("Bob");
        System.out.println("After remove Bob: " + scores);

        // remove(key, value) —— 只有当 key 和 value 同时匹配时才删除
        boolean removed = scores.remove("Tom", 80); // value 不匹配，不会删除
        System.out.println("Remove Tom with wrong value? " + removed);
        scores.remove("Tom", 70); // key=Tom, value=70 正确 → 删除
        System.out.println("After remove Tom correctly: " + scores);

        // replace(key, value) —— 替换已有 key 的值
        scores.replace("Alice", 95);
        System.out.println("After replace Alice's score: " + scores);

        // replace(key, oldValue, newValue) —— 只有当旧值匹配时才替换
        boolean replaced = scores.replace("Alice", 100, 99); // 不成功
        System.out.println("Replace Alice with wrong old value? " + replaced);
        replaced = scores.replace("Alice", 95, 100); // 成功
        System.out.println("Replace Alice correctly? " + replaced);
        System.out.println("After replace Alice again: " + scores);

        // merge(key, value, remappingFunction) —— 如果 key 不存在则添加，如果存在则合并
        scores.merge("Charlie", 5, Integer::sum); // Charlie 已存在，做 95 + 5
        scores.merge("David", 80, Integer::sum); // David 不存在 → 添加 80
        System.out.println("After merge: " + scores);

        // computeIfAbsent(key, mappingFunction) —— 如果 key 不存在则计算并添加
        scores.computeIfAbsent("Eve", k -> 75);
        System.out.println("After computeIfAbsent Eve: " + scores);

        // computeIfPresent(key, remappingFunction) —— 如果 key 存在则更新
        scores.computeIfPresent("Alice", (k, v) -> v + 10); // Alice 分数 +10
        System.out.println("After computeIfPresent Alice: " + scores);

        // replaceAll(function) —— 对所有 entry 的 value 进行统一替换
        scores.replaceAll((k, v) -> v + 1); // 每个人的分数都 +1
        System.out.println("After replaceAll (+1): " + scores);

        // forEach(action) —— 遍历 map
        scores.forEach((k, v) -> System.out.println(k + " => " + v));

        // clear() —— 清空所有数据
        scores.clear();
        System.out.println("After clear: " + scores);
    }
}
