package Graph;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // 测试1：插入 apple
        trie.insert("apple");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true

        // 测试2：插入 app
        trie.insert("app");
        System.out.println(trie.search("app"));     // true

        System.out.println("=====分叉案例 car / cat =====");
        trie.insert("car");
        trie.insert("cat");
        System.out.println(trie.search("car"));     // true
        System.out.println(trie.search("cat"));     // true
        System.out.println(trie.startsWith("ca"));   // true
        System.out.println(trie.search("cap"));      // false
    }
}
