package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import domain.dao.JpaUtilUnitTest;
import domain.dao.UserDaoImplFlawsUnitTest;
import domain.dao.UserDaoImplSuccessUnitTest;
import domain.service.UserServiceFlawsUnitTest;
import domain.service.UserServiceSuccessUnitTest;

@RunWith(Suite.class)
@SuiteClasses({ JpaUtilUnitTest.class, UserDaoImplSuccessUnitTest.class, UserDaoImplFlawsUnitTest.class,
		UserServiceSuccessUnitTest.class, UserServiceFlawsUnitTest.class })
public class SuiteTest {

}
