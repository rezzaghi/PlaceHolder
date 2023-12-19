package com.placeholder.mvi

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.placeholder.mvi.data.model.Todos
import com.placeholder.mvi.data.repository.PlaceHolderRepository
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class InstrumentedTests {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repo: PlaceHolderRepository

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testPlaceHolderCall() = runBlocking {
        val todoResult = repo.getTodos().first()
        val todoMock = Todos(
            userId = 1,
            id = 1,
            title = "delectus aut autem",
            completed = false
        )
        assertEquals(todoMock, todoResult)
    }
}