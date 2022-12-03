package com.example.myapplication

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses


@RunWith(Suite::class)
@SuiteClasses(
    MainActivityTest1::class,
    MainActivityTest2::class,
)
class MainActivityTestSuite() {}

