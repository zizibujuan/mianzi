package com.zizibujuan.mianzi.tests.tag;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.zizibujuan.mianzi.tests.tag.container.BodyTagTests;
import com.zizibujuan.mianzi.tests.tag.container.LinearLayoutTagTests;
import com.zizibujuan.mianzi.tests.tag.form.ButtonTagTests;
import com.zizibujuan.mianzi.tests.tag.form.CheckboxTagTests;
import com.zizibujuan.mianzi.tests.tag.form.ComboboxTagTests;

/**
 * 测试用例套件
 * 
 * @author jinzw
 * @since 0.0.1
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({
	BodyTagTests.class,
	LinearLayoutTagTests.class,
	ButtonTagTests.class,
	CheckboxTagTests.class,
	ComboboxTagTests.class
})
public class AllTests {

}
