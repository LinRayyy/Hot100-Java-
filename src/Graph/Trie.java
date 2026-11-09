package Graph;

public class Trie {
    static class TrieNode {
        TrieNode[]children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //插入
    public void insert(String word) {
        //先令cur等于root
        TrieNode cur = root;
        //然后从头开始遍历word所有字符
        for(char c : word.toCharArray()) {
            //如果对应的字符是空，则在该位置新建一个TrieNode
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    //查询
    public boolean search(String word) {
        //先获得root
        TrieNode cur = root;
        //遍历word每个字符，判断是否存在
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        //最后返回isEnd
        return cur.isEnd;
    }
    //查询前缀
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        //只要路径存在，直接返回true
        return true;
    }
}
