/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moduledefault.clustering.distancias;

import org.apache.commons.math3.stat.inference.TestUtils;

/**
 *
 * @author Mateus
 */
public class PValue {

    public static boolean getPValue(double d1, double d2) {
        double[] observed = {d1, d2};
        double mu = 2.5d;
        return TestUtils.tTest(mu, observed, 0.05);
    }
}
