package com.github.anno4j.querying;

import com.github.anno4j.Anno4j;
import org.junit.Before;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.config.RepositoryConfigException;

/**
 * The QuerySetup abstract class bundles Services and processes that are
 * needed to write tests for the Anno4j QueryService.
 */
public abstract class QuerySetup {
    protected QueryService queryService = null;
    protected Anno4j anno4j;

    /**
     * Setting up the test environment. It will initialize Anno4j and its QueryService. Besides that,
     * a default test namespace will be set ("ex", "http://www.example.com/schema#") and at the end,
     * it triggers the persistTestData function of the particular test method.
     *
     * @throws RepositoryConfigException
     * @throws RepositoryException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Before
    public void setupUpQueryTest() throws RepositoryConfigException, RepositoryException, IllegalAccessException, InstantiationException {
        anno4j = new Anno4j();
        queryService = anno4j.createQueryService().addPrefix("ex", "http://www.example.com/schema#");
        this.persistTestData();
    }

    /**
     * Persists the test data which will be querried from the particular
     * test classes. This method has to be implemented by the actual test class.
     *
     * @throws RepositoryException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public abstract void persistTestData() throws RepositoryException, InstantiationException, IllegalAccessException;
}
