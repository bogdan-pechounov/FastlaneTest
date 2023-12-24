package com.test.fastlane

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.test.fastlane.ui.MainScreen
import com.test.fastlane.ui.theme.FastlaneTestTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ScreenshotTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun init() {
        Screengrab
            .setDefaultScreenshotStrategy(
                UiAutomatorScreenshotStrategy()
            )
    }

    @Test
    fun useAppContext() {
        Screengrab.screenshot("before");

        composeTestRule.setContent {
            FastlaneTestTheme {
                MainScreen()
            }
        }

        Screengrab.screenshot("after");
    }
}