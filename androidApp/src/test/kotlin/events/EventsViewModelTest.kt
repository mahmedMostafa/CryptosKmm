package events

import MainCoroutineRule
import app.cash.turbine.test
import com.mohamed.mostafa.cryptocurrencies.android.presentation.events.EventsViewModel
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEventTypes
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEvents
import factories.eventTypes
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class EventsViewModelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @MockK
    private lateinit var getEventsUseCase: GetEvents

    @MockK
    private lateinit var getEventTypesUseCase: GetEventTypes

    private lateinit var viewModel: EventsViewModel


    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)

    }


    @Test
    fun `getting event types set list with success`(): Unit = runBlocking {
        //Given
        givenEventTypes()

        //When
        whenInitializingViewModel()

        //Then
        assertEquals(viewModel.eventTypes.value, eventTypes)
    }

    @Test
    fun `getting event types set loading state to ture then false`(): Unit = runBlocking {
            //Given
            givenEventTypes()

            //When
            whenInitializingViewModel()

            //Then
            coVerify {
                viewModel.getEventsTypes()
            }
        }

    @Test
    fun `when changing the selected type the events are set`() = runBlocking {

    }

    private fun givenEventTypes() {
        coEvery { getEventTypesUseCase.invoke() }.returns(flowOf(eventTypes))
    }

    private fun whenInitializingViewModel() {
        viewModel = EventsViewModel(
            getEvents = getEventsUseCase,
            getEventsTypes = getEventTypesUseCase,
        )
    }
}