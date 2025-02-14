package dev.idee.cicdandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var viewModel: MainActivityViewModel
    private val list = ArrayList<MovieModel>()
    @get:Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MainActivityViewModel()
    }

    @Test
    fun testWhenLiveDataIsUpdated_NewValueTakesEffect() {
        list.add(MovieModel("","",""))
        viewModel.setMovieLiveData(list)
        Assert.assertEquals(viewModel.getMovieLiveData().value?.size,1)
    }

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }


}