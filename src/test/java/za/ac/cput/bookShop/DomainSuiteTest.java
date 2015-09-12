package za.ac.cput.bookShop;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import za.ac.cput.bookShop.Domain.*;

/**
 * Created by Abel on 2015-09-12.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({AuthorFactoryTest.class,
        BookFactoryTest.class,
        CustomerFactoryTest.class,
        OrderFactoryTest.class,
        PublisherFactoryTest.class,
        UserAddressFactoryTest .class,
        UserAddressFactoryTest.class,
        })
public class DomainSuiteTest {


}
