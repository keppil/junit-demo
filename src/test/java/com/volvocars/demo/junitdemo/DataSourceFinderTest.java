package com.volvocars.demo.junitdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

public class DataSourceFinderTest {
    private DataSourceFinder dataSourceFinder;
    private DataSourceMock dataSource;

    @Before
    public void setUp() throws Exception {
        dataSourceFinder = new DataSourceFinder();
        SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
        builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
        dataSource = new DataSourceMock();
        builder.bind("java:comp/env/jdbc/de", this.dataSource);
    }

    @Test
    public void findDataSourceReturnsTheDataSourceBoundToTheProvidedMarket() {
        DataSource foundDataSource = this.dataSourceFinder.findDataSource("DE");
        assertEquals(this.dataSource, foundDataSource);
    }

    @Test
    public void findDataSourceReturnsNullIfJNDIBindingIsntFound() {
        DataSource foundDataSource = this.dataSourceFinder.findDataSource("ES");
        assertNull(foundDataSource);
    }

    @Test(expected = NullPointerException.class)
    public void findDataSourceThrowsNullPointerExceptionForNullInput() {
        this.dataSourceFinder.findDataSource(null);
    }
}
