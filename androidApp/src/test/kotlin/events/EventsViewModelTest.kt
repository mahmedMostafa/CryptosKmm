package events

import MainCoroutineRule
import com.mohamed.mostafa.cryptocurrencies.android.presentation.events.EventsViewModel
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEventTypes
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEvents
import factories.eventTypes
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class EventsViewModelTest {


}