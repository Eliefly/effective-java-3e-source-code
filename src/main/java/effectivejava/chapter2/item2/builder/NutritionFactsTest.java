package effectivejava.chapter2.item2.builder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NutritionFactsTest
 *
 * @author huangfl
 * @since 2018/8/7
 */
public class NutritionFactsTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test01() {
        NutritionFacts.Builder builder = new NutritionFacts.Builder(1, 2);
        builder.calories(3);
        builder.carbohydrate(4);
        builder.fat(5);
        builder.sodium(6);
        NutritionFacts nutritionFacts = builder.build();
    }

}
