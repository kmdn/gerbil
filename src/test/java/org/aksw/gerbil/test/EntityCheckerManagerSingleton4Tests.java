/**
 * This file is part of General Entity Annotator Benchmark.
 *
 * General Entity Annotator Benchmark is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * General Entity Annotator Benchmark is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with General Entity Annotator Benchmark.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.aksw.gerbil.test;

import org.aksw.gerbil.dataset.check.EntityCheckerManager;
import org.aksw.gerbil.dataset.check.impl.FileBasedCachingEntityCheckerManager;
import org.aksw.gerbil.web.config.RootConfig;
import org.junit.Ignore;

/**
 * This class is used to perform the JUnit tests faster by letting them share a
 * single {@link EntityCheckerManager} instance. The instance is created by
 * calling the {@link RootConfig#getEntityCheckerManager()} method.
 * 
 * @author Michael R&ouml;der (roeder@informatik.uni-leipzig.de)
 *
 */
@Ignore
public class EntityCheckerManagerSingleton4Tests {

    private static EntityCheckerManager instance = null;

    public synchronized static EntityCheckerManager getInstance() {
        if (instance == null) {
            instance = RootConfig.getEntityCheckerManager();
        }
        return instance;
    }

    public synchronized static void storeCache() {
        if (instance != null) {
            if (instance instanceof FileBasedCachingEntityCheckerManager) {
                ((FileBasedCachingEntityCheckerManager) instance).storeCache();
            }
        }
    }

}
