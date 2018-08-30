package effectivejava.chapter6.item40;

import java.util.HashSet;
import java.util.Set;

// Can you spot the bug?  (Page 188)
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    // 没有覆盖equals()，重载了。
//    public boolean equals(Bigram b) {
//        return b.first == first && b.second == second;
//    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bigram)) {
            return false;
        }
        Bigram bigram = (Bigram) obj;
        return this.first == bigram.first && this.second == bigram.second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        System.out.println(s.size());
    }
}
