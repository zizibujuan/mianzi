package com.zizibujuan.mianzi.tests.tag;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.zizibujuan.mianzi.tests.tag.container.BodyTagTests;
import com.zizibujuan.mianzi.tests.tag.container.HeadTagTests;
import com.zizibujuan.mianzi.tests.tag.container.LinearLayoutTagTests;
import com.zizibujuan.mianzi.tests.tag.container.PageTagTests;
import com.zizibujuan.mianzi.tests.tag.form.ButtonTagTests;
import com.zizibujuan.mianzi.tests.tag.form.CheckboxTagTests;
import com.zizibujuan.mianzi.tests.tag.form.ComboboxTagTests;
import com.zizibujuan.mianzi.tests.tag.form.SelectTagTests;
import com.zizibujuan.mianzi.tests.tag.form.StoreTagTests;

/**
 * 测试用例套件
 * 
 * @author jinzw
 * @since 0.0.1
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({
	HeadTagTests.class,
	BodyTagTests.class,
	PageTagTests.class,
	StoreTagTests.class,
	LinearLayoutTagTests.class,
	ButtonTagTests.class,
	CheckboxTagTests.class,
	ComboboxTagTests.class,
	SelectTagTests.class
})
public class AllTests {

}
