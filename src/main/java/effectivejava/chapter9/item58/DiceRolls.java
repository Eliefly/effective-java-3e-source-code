package effectivejava.chapter9.item58;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

// Same bug as NestIteration.java (but different symptom)!! - Page 213
public class DiceRolls {
    enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}

    public static void main(String[] args) {
        // Same bug, different symptom!
        Collection<Face> faces = EnumSet.allOf(Face.class);

        for (Face face : faces) {
            for (Iterator<Face> j = faces.iterator(); j.hasNext(); ) {
                System.out.println(face + " " + j.next());
            }
        }

        System.out.println("***************************");

        for (Face f1 : faces) {
            for (Face f2 : faces) {
                System.out.println(f1 + " " + f2);
            }
        }
    }
}
